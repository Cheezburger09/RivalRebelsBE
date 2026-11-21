#!/usr/bin/env python3

import json
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
CATALOG = ROOT / "intermediate/analysis/registrations/registration_catalog.json"
JAVA = ROOT / "decompiled/assets/rivalrebels/RivalRebels.java"
OUT = ROOT / "intermediate/analysis/registrations"

def main():
    catalog = json.loads(CATALOG.read_text(encoding="utf-8"))
    source = JAVA.read_text(encoding="utf-8")

    targets = {}

    for entry in catalog:
        if entry["method"] not in ("registerBlock", "registerItem"):
            continue
        args = entry["arguments"]
        if args and re.fullmatch(r"[A-Za-z_$][\w$]*", args[0]):
            targets[args[0]] = entry["method"]

    results = []

    for name, method in targets.items():
        pattern = re.compile(
            r"\b" + re.escape(name) +
            r"\s*=\s*new\s+([\w.$]+)\s*\("
        )

        for match in pattern.finditer(source):
            # Captura a expressão completa até o ponto e vírgula.
            end = source.find(";", match.start())
            if end == -1:
                continue

            expression = source[match.start():end + 1].strip()
            class_name = match.group(1)

            results.append({
                "name": name,
                "registration": method,
                "class": class_name,
                "expression": expression,
                "line": source.count("\n", 0, match.start()) + 1,
            })

    results.sort(key=lambda x: (x["registration"], x["name"]))

    destination = OUT / "resolved_fields.json"
    destination.write_text(
        json.dumps(results, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    found = {item["name"] for item in results}
    missing = sorted(set(targets) - found)

    print("=== RESOLUÇÃO DE CAMPOS ===")
    print(f"Campos registrados: {len(targets)}")
    print(f"Instanciações encontradas: {len(found)}")
    print(f"Sem instanciação encontrada: {len(missing)}")

    for method in ("registerBlock", "registerItem"):
        print(f"\n--- {method} ---")
        for item in results:
            if item["registration"] == method:
                print(
                    f'{item["name"]} -> {item["class"]} '
                    f'(linha {item["line"]})'
                )

    if missing:
        print("\nCampos sem instanciação:")
        for name in missing:
            print(f"  {name}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
