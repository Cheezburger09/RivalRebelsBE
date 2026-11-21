#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
ITEM_ROOT = JAVA_ROOT / "assets/rivalrebels/common/item"
OUTPUT = ROOT / "intermediate/analysis/items"
OUTPUT.mkdir(parents=True, exist_ok=True)

CLASS_RE = re.compile(
    r'\b(?:public\s+)?(?:abstract\s+)?(?:final\s+)?'
    r'class\s+(\w+)'
    r'(?:\s+extends\s+([\w.]+))?'
    r'(?:\s+implements\s+([\w.,\s]+))?'
)

METHOD_RE = re.compile(
    r'^\s*(?:public|protected|private)\s+'
    r'(?:(?:static|final|abstract|synchronized)\s+)*'
    r'[\w<>\[\].?, ]+\s+(\w+)\s*\(',
    re.MULTILINE
)


def main():
    if not ITEM_ROOT.exists():
        raise SystemExit(f"Diretório não encontrado: {ITEM_ROOT}")

    java_files = sorted(ITEM_ROOT.rglob("*.java"))

    # Lê cada arquivo uma única vez.
    sources = {
        path: path.read_text(encoding="utf-8", errors="replace")
        for path in JAVA_ROOT.rglob("*.java")
    }

    classes = []

    for path in java_files:
        source = sources[path]
        declaration = CLASS_RE.search(source)

        if not declaration:
            continue

        name = declaration.group(1)
        superclass = declaration.group(2)
        interfaces = declaration.group(3)

        references = [
            str(other.relative_to(JAVA_ROOT))
            for other, other_source in sources.items()
            if other != path
            and re.search(r'\b' + re.escape(name) + r'\b', other_source)
        ]

        classes.append({
            "class": name,
            "file": str(path.relative_to(JAVA_ROOT)),
            "superclass": superclass,
            "interfaces": [
                item.strip() for item in interfaces.split(",")
            ] if interfaces else [],
            "methods": sorted(set(METHOD_RE.findall(source))),
            "references": references,
            "reference_count": len(references),
        })

    superclass_counts = Counter(
        item["superclass"] or "[sem superclass]"
        for item in classes
    )

    report = {
        "section": "items",
        "java_files_found": len(java_files),
        "classes_analyzed": len(classes),
        "superclasses": dict(superclass_counts),
        "classes": classes,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: ITEM ANALYZER ===")
    print(f"Arquivos Java: {len(java_files)}")
    print(f"Classes analisadas: {len(classes)}")
    print("\nSuperclasses:")

    for name, count in superclass_counts.most_common():
        print(f"  {name}: {count}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
