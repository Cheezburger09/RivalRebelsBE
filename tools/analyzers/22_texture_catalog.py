#!/usr/bin/env python3

import re
import json
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
ASSET_ROOT = ROOT / "source/assets/rivalrebels"
OUT = ROOT / "intermediate/analysis/textures"
OUT.mkdir(parents=True, exist_ok=True)

catalog = {}

def add(identifier, path, origin, line=None):
    path = path.replace("\\", "/").lstrip("/")

    if path.startswith("rivalrebels:"):
        path = path.split(":", 1)[1]

    if not path.startswith("textures/"):
        return

    key = (identifier, path)

    catalog[key] = {
        "identifier": identifier,
        "path": path,
        "origin": origin,
        "line": line,
        "exists": (ASSET_ROOT / path).is_file()
    }

def main():
    main_file = JAVA_ROOT / "assets/rivalrebels/RivalRebels.java"
    lines = main_file.read_text(
        encoding="utf-8", errors="replace"
    ).splitlines()

    assignment = re.compile(
        r"\b(\w+)\s*=\s*new\s+ResourceLocation\s*\(\s*"
        r'"rivalrebels:([^"]+)"'
    )

    for number, line in enumerate(lines, 1):
        match = assignment.search(line)
        if match:
            add(match.group(1), match.group(2),
                "RivalRebels.java", number)

    armor_file = (
        JAVA_ROOT / "assets/rivalrebels/common/item/ItemClassArmor.java"
    )

    if armor_file.exists():
        armor_lines = armor_file.read_text(
            encoding="utf-8", errors="replace"
        ).splitlines()

        for number, line in enumerate(armor_lines, 1):
            for path in re.findall(
                r'"rivalrebels:(textures/[^"]+)"', line
            ):
                add("ItemClassArmor", path,
                    "ItemClassArmor.java", number)

    for path in JAVA_ROOT.rglob("*.java"):
        relative = str(path.relative_to(JAVA_ROOT))

        if relative.endswith("RivalRebels.java"):
            continue

        source_lines = path.read_text(
            encoding="utf-8", errors="replace"
        ).splitlines()

        for number, line in enumerate(source_lines, 1):
            for texture in re.findall(
                r'"rivalrebels:(textures/[^"]+)"', line
            ):
                add(path.stem, texture, relative, number)

    entries = sorted(
        catalog.values(),
        key=lambda item: (item["path"], item["identifier"])
    )

    destination = OUT / "texture_catalog.json"
    destination.write_text(
        json.dumps(entries, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    all_textures = sorted(
        str(path.relative_to(ASSET_ROOT)).replace("\\", "/")
        for path in ASSET_ROOT.rglob("*")
        if path.is_file() and path.suffix.lower() == ".png"
    )

    referenced = {item["path"] for item in entries}
    missing = [item for item in entries if not item["exists"]]
    unused = [
        path for path in all_textures
        if path not in referenced
    ]

    print("=== CATÁLOGO DE TEXTURAS ===")
    print(f"Referências únicas: {len(entries)}")
    print(f"Arquivos PNG existentes: {len(all_textures)}")
    print(f"Referências com arquivo encontrado: "
          f"{sum(item['exists'] for item in entries)}")
    print(f"Referências sem arquivo: {len(missing)}")
    print(f"PNG sem referência direta: {len(unused)}")

    print("\n=== TEXTURAS POR CATEGORIA ===")
    categories = Counter(
        item["path"].split("/")[1]
        for item in entries
    )
    for category, count in categories.most_common():
        print(f"{category}: {count}")

    if missing:
        print("\n=== ARQUIVOS NÃO ENCONTRADOS ===")
        for item in missing:
            print(f'{item["identifier"]}: {item["path"]}')

    print("\n=== TEXTURAS SEM REFERÊNCIA DIRETA ===")
    for path in unused[:40]:
        print(path)

    if len(unused) > 40:
        print(f"... e mais {len(unused) - 40}")

    print(f"\nRelatório: {destination}")

if __name__ == "__main__":
    main()
