#!/usr/bin/env python3

import json
from pathlib import Path
from collections import defaultdict

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / "intermediate/analysis/registrations/detailed_registrations.json"
OUTPUT = ROOT / "intermediate/analysis/registrations"

def split_args(call):
    start = call.find("(") + 1
    content = call[start:-1]

    args = []
    current = []
    depth = 0
    quote = None
    escaped = False

    for char in content:
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
        elif char in "([{":
            depth += 1
            current.append(char)
        elif char in ")]}":
            depth -= 1
            current.append(char)
        elif char == "," and depth == 0:
            args.append("".join(current).strip())
            current = []
        else:
            current.append(char)

    if current:
        args.append("".join(current).strip())

    return args


def main():
    data = json.loads(SOURCE.read_text(encoding="utf-8"))
    groups = defaultdict(list)

    for entry in data["calls"]:
        groups[(entry["file"], entry["method"])].append(entry)

    catalog = []

    for (filename, method), entries in sorted(groups.items()):
        for entry in entries:
            args = split_args(entry["call"])

            catalog.append({
                "file": filename,
                "method": method,
                "line": entry["line"],
                "arguments": args,
            })

    destination = OUTPUT / "registration_catalog.json"
    destination.write_text(
        json.dumps(catalog, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== CATÁLOGO DE REGISTROS ===")

    for (filename, method), entries in sorted(groups.items()):
        print(f"\n{filename} — {method}: {len(entries)}")

        for entry in entries:
            args = split_args(entry["call"])
            preview = " | ".join(args[:3])
            print(f"  L{entry['line']}: {preview[:220]}")

    print(f"\nCatálogo completo: {destination}")


if __name__ == "__main__":
    main()
