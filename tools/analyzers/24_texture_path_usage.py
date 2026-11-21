#!/usr/bin/env python3

import json
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
ASSET_ROOT = ROOT / "source/assets/rivalrebels"
SCAN_ROOTS = [ROOT / "source", ROOT / "decompiled"]
OUT = ROOT / "intermediate/analysis/textures"
OUT.mkdir(parents=True, exist_ok=True)

TEXT_EXTENSIONS = {
    ".java", ".json", ".obj", ".mtl", ".txt", ".properties",
    ".xml", ".cfg", ".fsh", ".vsh", ".glsl", ".lang",
    ".mcmeta", ".csv", ".yaml", ".yml"
}

def main():
    pngs = sorted(ASSET_ROOT.rglob("*.png"))

    textures = {
        path.relative_to(ASSET_ROOT).as_posix().lower(): {
            "path": path.relative_to(ASSET_ROOT).as_posix(),
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
                normalized = line.replace("\\", "/").lower()

                for relpath, data in textures.items():
                    if relpath in normalized:
                        data["matches"].append({
                            "file": str(file.relative_to(ROOT)),
                            "line": number,
                            "context": line.strip()[:300]
                        })

    results = list(textures.values())

    for item in results:
        unique = {
            (m["file"], m["line"]): m
            for m in item["matches"]
        }
        item["matches"] = list(unique.values())

    used = [item for item in results if item["matches"]]
    unused = [item for item in results if not item["matches"]]

    destination = OUT / "path_usage.json"
    destination.write_text(
        json.dumps(results, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== REFERÊNCIAS POR CAMINHO COMPLETO ===")
    print(f"PNGs analisados: {len(results)}")
    print(f"Com referências: {len(used)}")
    print(f"Sem referências textuais: {len(unused)}")
    print(f"Arquivos analisados: {len(scanned)}")

    print("\n=== TEXTURAS REFERENCIADAS ===")
    for item in used:
        print(f'\n{item["path"]}')
        for match in item["matches"][:4]:
            print(f'  {match["file"]}:{match["line"]}')
            print(f'    {match["context"][:180]}')

    print("\n=== TEXTURAS SEM REFERÊNCIAS TEXTUAIS ===")
    for item in unused:
        print(item["path"])

    print(f"\nRelatório: {destination}")

if __name__ == "__main__":
    main()
