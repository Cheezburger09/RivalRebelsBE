#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import defaultdict

ROOT = Path(__file__).resolve().parents[2]
ASSET_ROOT = ROOT / "source/assets/rivalrebels"
SCAN_ROOTS = [
    ROOT / "source",
    ROOT / "decompiled",
]
OUT = ROOT / "intermediate/analysis/textures"
OUT.mkdir(parents=True, exist_ok=True)

TEXT_EXTENSIONS = {
    ".java", ".json", ".obj", ".mtl", ".txt", ".properties",
    ".xml", ".cfg", ".fsh", ".vsh", ".glsl", ".lang",
    ".mcmeta", ".csv", ".yaml", ".yml"
}

def main():
    pngs = sorted(
        path for path in ASSET_ROOT.rglob("*.png")
        if path.is_file()
    )

    references = {
        path.name.lower(): {
            "path": str(path.relative_to(ASSET_ROOT)),
            "matches": []
        }
        for path in pngs
    }

    scanned = set()

    for scan_root in SCAN_ROOTS:
        if not scan_root.exists():
            continue

        for file in scan_root.rglob("*"):
            if not file.is_file() or file.suffix.lower() not in TEXT_EXTENSIONS:
                continue

            if file in scanned:
                continue
            scanned.add(file)

            try:
                lines = file.read_text(
                    encoding="utf-8", errors="replace"
                ).splitlines()
            except OSError:
                continue

            for number, line in enumerate(lines, 1):
                lowered = line.lower()

                for filename, data in references.items():
                    if filename in lowered:
                        data["matches"].append({
                            "file": str(file.relative_to(ROOT)),
                            "line": number,
                            "context": line.strip()[:300]
                        })

    results = list(references.values())

    for item in results:
        item["matches"] = list({
            (match["file"], match["line"]): match
            for match in item["matches"]
        }.values())

    used = [item for item in results if item["matches"]]
    unused = [item for item in results if not item["matches"]]

    destination = OUT / "indirect_texture_usage.json"
    destination.write_text(
        json.dumps(results, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== USO INDIRETO DE TEXTURAS ===")
    print(f"PNG analisados: {len(results)}")
    print(f"PNG com referência textual: {len(used)}")
    print(f"PNG sem referência textual: {len(unused)}")
    print(f"Arquivos de texto analisados: {len(scanned)}")

    print("\n=== TEXTURAS COM REFERÊNCIAS ===")
    for item in used:
        print(f'\n{item["path"]}')
        for match in item["matches"][:5]:
            print(f'  {match["file"]}:{match["line"]}')
            print(f'    {match["context"]}')

        if len(item["matches"]) > 5:
            print(f'  ... e mais {len(item["matches"]) - 5} referências')

    print("\n=== TEXTURAS AINDA NÃO LOCALIZADAS ===")
    for item in unused:
        print(item["path"])

    print(f"\nRelatório: {destination}")

if __name__ == "__main__":
    main()
