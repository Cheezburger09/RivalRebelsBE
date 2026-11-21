#!/usr/bin/env python3

import re
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled/assets/rivalrebels"
OUT = ROOT / "intermediate/analysis/textures"
OUT.mkdir(parents=True, exist_ok=True)

TARGETS = [
    "RivalRebels.java",
    "common/item/ItemClassArmor.java",
    "common/item/ItemArmorCamo.java",
    "common/item/ItemTrollHelmet.java",
]

PATTERN = re.compile(
    r"registerIcon|registerBlockIcons|setTextureName|"
    r"setBlockTextureName|ResourceLocation|getArmorTexture|"
    r"getIcon|texture",
    re.IGNORECASE
)

def main():
    results = []

    for relative in TARGETS:
        path = JAVA_ROOT / relative

        if not path.exists():
            continue

        lines = path.read_text(
            encoding="utf-8", errors="replace"
        ).splitlines()

        for index, line in enumerate(lines):
            if not PATTERN.search(line):
                continue

            results.append({
                "file": relative,
                "line": index + 1,
                "code": line.strip()
            })

    destination = OUT / "texture_context.json"
    destination.write_text(
        json.dumps(results, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== CONTEXTO DOS REGISTROS DE TEXTURA ===")
    print(f"Referências encontradas: {len(results)}")

    for item in results:
        print(
            f'\n[{item["file"]}:{item["line"]}]'
            f'\n{item["code"]}'
        )

    print(f"\nRelatório: {destination}")

if __name__ == "__main__":
    main()
