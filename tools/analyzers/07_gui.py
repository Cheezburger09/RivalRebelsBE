#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
GUI_ROOT = JAVA_ROOT / "assets/rivalrebels/client/gui"
HELPER_ROOT = JAVA_ROOT / "assets/rivalrebels/client/guihelper"
OUTPUT = ROOT / "intermediate/analysis/gui"
OUTPUT.mkdir(parents=True, exist_ok=True)

CLASS_RE = re.compile(
    r'\b(?:public\s+)?(?:abstract\s+)?(?:final\s+)?'
    r'class\s+(\w+)'
    r'(?:\s+extends\s+([\w.]+))?'
    r'(?:\s+implements\s+([\w.,\s]+))?'
)

RESOURCE_RE = re.compile(
    r'new\s+ResourceLocation\s*\(\s*([^;]+?)\s*\)'
)

TEXTURE_RE = re.compile(
    r'(?:textures/[^"\']+|guit[a-zA-Z0-9_]+)'
)

DIMENSION_RE = re.compile(
    r'field_147000_g\s*=\s*(\d+)'
    r'|field_146999_f\s*=\s*(\d+)'
)

DRAW_RE = re.compile(
    r'func_73729_b\s*\(([^;]+?)\)'
)

BUTTON_RE = re.compile(
    r'new\s+GuiButton\s*\(([^;]+?)\)'
)

CONTAINER_RE = re.compile(
    r'new\s+(\w*Container\w*)\s*\('
)


def read_class(path, category):
    source = path.read_text(encoding="utf-8", errors="replace")
    declaration = CLASS_RE.search(source)

    if not declaration:
        return None

    textures = sorted(set(TEXTURE_RE.findall(source)))
    resources = sorted(set(
        match.group(1).strip()
        for match in RESOURCE_RE.finditer(source)
    ))

    dimensions = []
    for match in DIMENSION_RE.finditer(source):
        if match.group(1):
            dimensions.append({
                "property": "height",
                "value": int(match.group(1))
            })
        elif match.group(2):
            dimensions.append({
                "property": "width",
                "value": int(match.group(2))
            })

    buttons = [
        match.group(1).strip()
        for match in BUTTON_RE.finditer(source)
    ]

    draw_calls = [
        match.group(1).strip()
        for match in DRAW_RE.finditer(source)
    ]

    containers = sorted(set(
        match.group(1)
        for match in CONTAINER_RE.finditer(source)
    ))

    return {
        "class": declaration.group(1),
        "superclass": declaration.group(2),
        "interfaces": [
            item.strip()
            for item in declaration.group(3).split(",")
        ] if declaration.group(3) else [],
        "category": category,
        "file": str(path.relative_to(JAVA_ROOT)),
        "textures": textures,
        "resource_locations": resources,
        "dimensions": dimensions,
        "buttons": buttons,
        "button_count": len(buttons),
        "draw_calls": draw_calls,
        "draw_call_count": len(draw_calls),
        "containers": containers,
    }


def main():
    classes = []

    for directory, category in (
        (GUI_ROOT, "gui"),
        (HELPER_ROOT, "guihelper"),
    ):
        if not directory.exists():
            continue

        for path in sorted(directory.rglob("*.java")):
            result = read_class(path, category)
            if result:
                classes.append(result)

    categories = Counter(item["category"] for item in classes)
    superclasses = Counter(
        item["superclass"] or "[sem superclass]"
        for item in classes
    )

    report = {
        "section": "gui",
        "classes_analyzed": len(classes),
        "categories": dict(categories),
        "superclasses": dict(superclasses),
        "total_buttons": sum(
            item["button_count"] for item in classes
        ),
        "total_draw_calls": sum(
            item["draw_call_count"] for item in classes
        ),
        "classes": classes,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: GUI ANALYZER ===")
    print(f"Classes analisadas: {len(classes)}")
    print(f"Interfaces e helpers: {dict(categories)}")
    print(f"Botões detectados: {report['total_buttons']}")
    print(f"Chamadas de desenho: {report['total_draw_calls']}")
    print("\nSuperclasses:")

    for name, count in superclasses.most_common():
        print(f"  {name}: {count}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
