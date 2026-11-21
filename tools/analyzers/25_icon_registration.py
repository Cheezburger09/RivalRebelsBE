#!/usr/bin/env python3

import json
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled/assets/rivalrebels"
OUT = ROOT / "intermediate/analysis/textures"
OUT.mkdir(parents=True, exist_ok=True)

METHODS = {
    "item": "func_94581_a",
    "block": "func_149651_a",
}

CALL = re.compile(
    r'(\w+)\s*\.\s*'
    r'(func_94245_a|registerIcon)\s*\(\s*"([^"]+)"\s*\)'
)

def extract_method(text, method):
    pattern = re.compile(
        r'\b' + re.escape(method) +
        r'\s*\([^)]*\)\s*\{'
    )

    results = []

    for match in pattern.finditer(text):
        start = match.end()
        depth = 1
        pos = start

        while pos < len(text) and depth:
            if text[pos] == "{":
                depth += 1
            elif text[pos] == "}":
                depth -= 1
            pos += 1

        if depth == 0:
            results.append(text[start:pos - 1])

    return results

def main():
    registrations = []
    methods_found = 0

    for file in JAVA_ROOT.rglob("*.java"):
        try:
            text = file.read_text(encoding="utf-8", errors="replace")
        except OSError:
            continue

        for category, method in METHODS.items():
            bodies = extract_method(text, method)

            for body in bodies:
                methods_found += 1

                for match in CALL.finditer(body):
                    registrations.append({
                        "category": category,
                        "class": file.stem,
                        "file": str(file.relative_to(ROOT)),
                        "receiver": match.group(1),
                        "method": match.group(2),
                        "icon": match.group(3),
                    })

    destination = OUT / "icon_registrations.json"
    destination.write_text(
        json.dumps(registrations, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== REGISTRO DE ÍCONES ===")
    print(f"Métodos encontrados: {methods_found}")
    print(f"Registros encontrados: {len(registrations)}")

    for category in ("block", "item"):
        entries = [r for r in registrations if r["category"] == category]
        print(f"\n=== {category.upper()} ({len(entries)}) ===")

        for entry in entries:
            print(
                f'{entry["class"]}: '
                f'{entry["receiver"]} -> {entry["icon"]}'
            )

    print(f"\nRelatório: {destination}")

if __name__ == "__main__":
    main()
