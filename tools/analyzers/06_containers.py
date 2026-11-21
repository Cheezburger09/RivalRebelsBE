#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
CONTAINER_ROOT = JAVA_ROOT / "assets/rivalrebels/common/container"
OUTPUT = ROOT / "intermediate/analysis/containers"
OUTPUT.mkdir(parents=True, exist_ok=True)

CLASS_RE = re.compile(
    r'\b(?:public\s+)?(?:abstract\s+)?(?:final\s+)?'
    r'class\s+(\w+)'
    r'(?:\s+extends\s+([\w.]+))?'
    r'(?:\s+implements\s+([\w.,\s]+))?'
)

SLOT_RE = re.compile(r'\bnew\s+(\w*Slot\w*)\s*\(')


def extract_arguments(source, start):
    """Extrai argumentos respeitando parênteses e strings."""
    args = []
    current = []
    depth = 0
    quote = None
    escaped = False

    for char in source[start:]:
        if quote:
            current.append(char)
            if escaped:
                escaped = False
            elif char == "\\":
                escaped = True
            elif char == quote:
                quote = None
            continue

        if char in ('"', "'"):
            quote = char
            current.append(char)
        elif char == '(':
            depth += 1
            current.append(char)
        elif char == ')':
            if depth == 0:
                value = ''.join(current).strip()
                if value:
                    args.append(value)
                return args
            depth -= 1
            current.append(char)
        elif char == ',' and depth == 0:
            args.append(''.join(current).strip())
            current = []
        else:
            current.append(char)

    return args


def analyze_file(path):
    source = path.read_text(encoding="utf-8", errors="replace")
    declaration = CLASS_RE.search(source)

    if not declaration:
        return None

    slots = []

    for match in SLOT_RE.finditer(source):
        arguments = extract_arguments(source, match.end())

        slots.append({
            "slot_class": match.group(1),
            "arguments": arguments,
            "source_line": source.count("\n", 0, match.start()) + 1,
        })

    return {
        "class": declaration.group(1),
        "superclass": declaration.group(2),
        "interfaces": [
            item.strip()
            for item in declaration.group(3).split(",")
        ] if declaration.group(3) else [],
        "file": str(path.relative_to(JAVA_ROOT)),
        "slots": slots,
        "slot_count": len(slots),
        "uses_player_inventory": bool(re.search(
            r'InventoryPlayer|bindPlayerInventory', source
        )),
        "uses_can_interact": bool(re.search(
            r'func_75145_c|canInteractWith', source
        )),
    }


def main():
    if not CONTAINER_ROOT.exists():
        raise SystemExit(f"Diretório não encontrado: {CONTAINER_ROOT}")

    files = sorted(CONTAINER_ROOT.rglob("*.java"))
    containers = [
        result for path in files
        if (result := analyze_file(path)) is not None
    ]

    slot_types = Counter(
        slot["slot_class"]
        for container in containers
        for slot in container["slots"]
    )

    report = {
        "section": "containers",
        "java_files_found": len(files),
        "classes_analyzed": len(containers),
        "total_slots_detected": sum(
            item["slot_count"] for item in containers
        ),
        "slot_types": dict(slot_types.most_common()),
        "containers": containers,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: CONTAINER ANALYZER ===")
    print(f"Arquivos Java: {len(files)}")
    print(f"Containers analisados: {len(containers)}")
    print(f"Slots detectados: {report['total_slots_detected']}")
    print("\nTipos de slots:")

    for name, count in slot_types.most_common():
        print(f"  {name}: {count}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
