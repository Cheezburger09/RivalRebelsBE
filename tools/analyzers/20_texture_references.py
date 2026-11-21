#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled/assets/rivalrebels"
OUT = ROOT / "intermediate/analysis/textures"
OUT.mkdir(parents=True, exist_ok=True)

PATTERNS = {
    "register_icon": r"\bregisterIcon\s*\(",
    "register_block_icon": r"\bregisterBlockIcons\s*\(",
    "get_icon": r"\bgetIcon\s*\(",
    "get_block_texture": r"\bgetBlockTexture\s*\(",
    "get_item_icon": r"\bgetItemIcon\s*\(",
    "texture_string": r'"([^"\n]*(?:\.png|textures/)[^"\n]*)"',
    "icon_string": r'"([^"\n]*(?:icon|block|item|texture)[^"\n]*)"',
    "resource_location": r'new\s+ResourceLocation\s*\(',
}

def main():
    results = []
    totals = Counter()

    for path in JAVA_ROOT.rglob("*.java"):
        source = path.read_text(encoding="utf-8", errors="replace")
        relative = str(path.relative_to(JAVA_ROOT))

        matches = {}

        for name, pattern in PATTERNS.items():
            found = re.findall(pattern, source, re.IGNORECASE)
            if found:
                matches[name] = found
                totals[name] += len(found)

        if matches:
            results.append({
                "file": relative,
                "matches": matches
            })

    destination = OUT / "texture_references.json"
    destination.write_text(
        json.dumps(results, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== REFERÊNCIAS DE TEXTURAS ===")
    print(f"Arquivos analisados: {len(list(JAVA_ROOT.rglob('*.java')))}")
    print(f"Arquivos com referências: {len(results)}")

    print("\n=== TIPOS DE REFERÊNCIA ===")
    for name, count in totals.most_common():
        print(f"{name}: {count}")

    print("\n=== ARQUIVOS MAIS RELEVANTES ===")
    for item in sorted(
        results,
        key=lambda x: sum(len(v) for v in x["matches"].values()),
        reverse=True
    )[:30]:
        count = sum(len(v) for v in item["matches"].values())
        print(f'{item["file"]}: {count} referências')

    print(f"\nRelatório: {destination}")

if __name__ == "__main__":
    main()
