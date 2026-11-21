#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
BLOCK_ROOT = JAVA_ROOT / "assets/rivalrebels/common/block"
OUTPUT = ROOT / "intermediate/analysis/blocks"
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


def analyze_class(path):
    source = path.read_text(encoding="utf-8", errors="replace")

    package = re.search(r'^\s*package\s+([\w.]+)\s*;', source, re.M)
    declaration = CLASS_RE.search(source)

    if not declaration:
        return None

    class_name = declaration.group(1)
    superclass = declaration.group(2)
    interfaces = declaration.group(3)

    methods = sorted(set(METHOD_RE.findall(source)))

    references = []
    for other in JAVA_ROOT.rglob("*.java"):
        if other == path:
            continue

        try:
            text = other.read_text(encoding="utf-8", errors="replace")
        except OSError:
            continue

        if re.search(r'\b' + re.escape(class_name) + r'\b', text):
            references.append(str(other.relative_to(JAVA_ROOT)))

    return {
        "class": class_name,
        "package": package.group(1) if package else None,
        "file": str(path.relative_to(JAVA_ROOT)),
        "superclass": superclass,
        "interfaces": [
            item.strip() for item in interfaces.split(",")
        ] if interfaces else [],
        "methods": methods,
        "references": references,
        "reference_count": len(references),
    }


def main():
    if not BLOCK_ROOT.exists():
        raise SystemExit(f"Diretório não encontrado: {BLOCK_ROOT}")

    java_files = sorted(BLOCK_ROOT.rglob("*.java"))
    classes = [
        result for path in java_files
        if (result := analyze_class(path)) is not None
    ]

    superclass_counts = Counter(
        item["superclass"] or "[sem superclass]"
        for item in classes
    )

    report = {
        "section": "blocks",
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

    print("=== RIVAL REBELS: BLOCK ANALYZER ===")
    print(f"Arquivos Java: {len(java_files)}")
    print(f"Classes analisadas: {len(classes)}")
    print("\nSuperclasses:")
    for name, count in superclass_counts.most_common():
        print(f"  {name}: {count}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
