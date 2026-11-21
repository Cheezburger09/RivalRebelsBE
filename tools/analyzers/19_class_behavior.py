#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import defaultdict

ROOT = Path(__file__).resolve().parents[2]
FIELDS = ROOT / "intermediate/analysis/registrations/resolved_fields.json"
JAVA_ROOT = ROOT / "decompiled"
OUT = ROOT / "intermediate/analysis/classes"
OUT.mkdir(parents=True, exist_ok=True)

def main():
    fields = json.loads(FIELDS.read_text(encoding="utf-8"))

    classes = sorted(set(item["class"] for item in fields))
    files = list(JAVA_ROOT.rglob("*.java"))

    results = []
    missing = []

    for class_name in classes:
        found = False

        for path in files:
            source = path.read_text(encoding="utf-8", errors="replace")

            declaration = re.search(
                r"\bclass\s+" + re.escape(class_name) + r"\b"
                r"(?:\s+extends\s+([\w.$]+))?"
                r"(?:\s+implements\s+([^{]+))?",
                source
            )

            if not declaration:
                continue

            found = True

            methods = []
            for match in re.finditer(
                r"(?m)^\s*(?:(?:public|protected|private|static|final|"
                r"synchronized|abstract|native)\s+)*"
                r"[\w.$<>\[\], ?]+\s+(\w+)\s*\(",
                source
            ):
                methods.append(match.group(1))

            texture_strings = sorted(set(
                re.findall(
                    r'"([^"\n]*(?:textures|\.png|\.jpg)[^"\n]*)"',
                    source,
                    re.IGNORECASE
                )
            ))

            results.append({
                "class": class_name,
                "file": str(path.relative_to(JAVA_ROOT)),
                "superclass": declaration.group(1),
                "interfaces": (
                    declaration.group(2).strip()
                    if declaration.group(2) else None
                ),
                "methods": sorted(set(methods)),
                "textures": texture_strings,
            })
            break

        if not found:
            missing.append(class_name)

    destination = OUT / "class_behavior.json"
    destination.write_text(
        json.dumps(results, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== ANÁLISE DE COMPORTAMENTO ===")
    print(f"Classes solicitadas: {len(classes)}")
    print(f"Classes encontradas: {len(results)}")
    print(f"Classes não encontradas: {len(missing)}")

    print("\n=== CLASSES E MÉTODOS ===")

    for item in results:
        print(f'\n{item["class"]}')
        print(f'  Arquivo: {item["file"]}')
        print(f'  Superclasse: {item["superclass"]}')

        if item["interfaces"]:
            print(f'  Interfaces: {item["interfaces"]}')

        print(f'  Métodos: {len(item["methods"])}')
        print(f'  Texturas referenciadas: {len(item["textures"])}')

        important = [
            method for method in item["methods"]
            if any(term in method.lower() for term in (
                "icon", "texture", "activate", "update", "tick",
                "placed", "broken", "collision", "entity",
                "render", "damage", "drop", "inventory",
                "neighbor", "power", "explosion"
            ))
        ]

        if important:
            print("  Métodos relevantes: " + ", ".join(important[:20]))

    if missing:
        print("\nClasses não encontradas:")
        for name in missing:
            print(f"  {name}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
