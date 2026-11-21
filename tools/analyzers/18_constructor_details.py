#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter, defaultdict

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / "intermediate/analysis/registrations/resolved_fields.json"
OUT = ROOT / "intermediate/analysis/registrations"
OUT.mkdir(parents=True, exist_ok=True)


def extract_call(text, start):
    opening = text.find("(", start)
    if opening < 0:
        return None, opening

    depth = 0
    quote = None
    escaped = False

    for i in range(opening, len(text)):
        char = text[i]

        if quote:
            if escaped:
                escaped = False
            elif char == "\\":
                escaped = True
            elif char == quote:
                quote = None
            continue

        if char in ('"', "'"):
            quote = char
        elif char == "(":
            depth += 1
        elif char == ")":
            depth -= 1
            if depth == 0:
                return text[opening + 1:i], i + 1

    return None, -1


def split_args(text):
    if not text.strip():
        return []

    args = []
    start = 0
    depth = 0
    quote = None
    escaped = False

    for i, char in enumerate(text):
        if quote:
            if escaped:
                escaped = False
            elif char == "\\":
                escaped = True
            elif char == quote:
                quote = None
            continue

        if char in ('"', "'"):
            quote = char
        elif char in "([{":
            depth += 1
        elif char in ")]}":
            depth -= 1
        elif char == "," and depth == 0:
            args.append(text[start:i].strip())
            start = i + 1

    args.append(text[start:].strip())
    return args


def analyze(item):
    expression = item["expression"]

    constructor = re.search(r"\bnew\s+([\w.$]+)\s*\(", expression)
    if not constructor:
        return None

    args_text, end = extract_call(expression, constructor.start())
    if args_text is None:
        return None

    methods = []
    position = end

    while position < len(expression):
        match = re.match(r"\s*\.\s*([\w$]+)\s*\(", expression[position:])
        if not match:
            break

        method_name = match.group(1)
        call_start = position + match.start()
        args, call_end = extract_call(expression, call_start)

        if args is None:
            break

        methods.append({
            "method": method_name,
            "arguments": split_args(args)
        })
        position = call_end

    return {
        **item,
        "constructor_arguments": split_args(args_text),
        "chained_methods": methods
    }


def main():
    fields = json.loads(SOURCE.read_text(encoding="utf-8"))
    results = []

    for item in fields:
        result = analyze(item)
        if result:
            results.append(result)

    class_counts = Counter(item["class"] for item in results)
    class_variants = defaultdict(list)

    for item in results:
        class_variants[item["class"]].append(item)

    destination = OUT / "constructor_details.json"
    destination.write_text(
        json.dumps(results, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== DETALHES DOS CONSTRUTORES ===")
    print(f"Instanciações analisadas: {len(results)}")
    print(f"Classes diferentes: {len(class_counts)}")

    print("\n=== CLASSES E QUANTIDADES ===")
    for class_name, count in class_counts.most_common():
        print(f"{class_name}: {count}")

    print("\n=== ARGUMENTOS E MÉTODOS ===")
    for item in results:
        args = ", ".join(item["constructor_arguments"]) or "(sem argumentos)"

        methods = []
        for method in item["chained_methods"]:
            values = ", ".join(method["arguments"])
            methods.append(f'.{method["method"]}({values})')

        chain = "".join(methods) or "(sem métodos encadeados)"

        print(f'\n{item["name"]} -> {item["class"]}')
        print(f"  Construtor: {args}")
        print(f"  Configuração: {chain[:350]}")

    print(f"\nRelatório completo: {destination}")


if __name__ == "__main__":
    main()
