#!/usr/bin/env python3

import json
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / "decompiled/assets/rivalrebels/common/core/RivalRebelsRecipes.java"
OUTPUT = ROOT / "intermediate/analysis/recipes"
OUTPUT.mkdir(parents=True, exist_ok=True)


def mask_comments_and_strings(text):
    result = list(text)
    i = 0
    state = "normal"

    while i < len(text):
        c = text[i]
        n = text[i + 1] if i + 1 < len(text) else ""

        if state == "normal":
            if c == "/" and n == "/":
                result[i] = result[i + 1] = " "
                i += 2
                state = "line"
                continue
            if c == "/" and n == "*":
                result[i] = result[i + 1] = " "
                i += 2
                state = "block"
                continue
            if c == '"':
                result[i] = " "
                state = "string"
            elif c == "'":
                result[i] = " "
                state = "char"

        elif state == "line":
            if c == "\n":
                state = "normal"
            else:
                result[i] = " "

        elif state == "block":
            result[i] = " "
            if c == "*" and n == "/":
                result[i + 1] = " "
                i += 2
                state = "normal"
                continue

        elif state in ("string", "char"):
            result[i] = " "
            if c == "\\" and i + 1 < len(text):
                result[i + 1] = " "
                i += 2
                continue
            if (state == "string" and c == '"') or (
                state == "char" and c == "'"
            ):
                state = "normal"

        i += 1

    return "".join(result)


def extract_calls(text):
    masked = mask_comments_and_strings(text)
    calls = []
    pattern = re.compile(r"\bGameRegistry\.addRecipe\s*\(")

    for match in pattern.finditer(masked):
        start = masked.find("(", match.start())
        depth = 0
        end = None

        for i in range(start, len(masked)):
            if masked[i] == "(":
                depth += 1
            elif masked[i] == ")":
                depth -= 1
                if depth == 0:
                    end = i
                    break

        if end is None:
            continue

        raw = text[match.start():end + 1]
        result = re.search(r"new\s+ItemStack\s*\((.*?)\)", raw, re.S)
        patterns = re.findall(r'"([^"]*)"', raw)

        calls.append({
            "index": len(calls) + 1,
            "line": text.count("\n", 0, match.start()) + 1,
            "result_expression": result.group(1).strip() if result else None,
            "pattern_rows": patterns,
            "raw_call": raw,
        })

    return calls


def main():
    text = SOURCE.read_text(encoding="utf-8", errors="replace")
    recipes = extract_calls(text)

    destination = OUTPUT / "detailed_recipes.json"
    destination.write_text(
        json.dumps(recipes, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RECIPE DETAILS ===")
    print(f"Receitas extraídas: {len(recipes)}")
    print(f"Receitas com resultado identificado: {sum(r['result_expression'] is not None for r in recipes)}")
    print(f"Receitas com padrão identificado: {sum(bool(r['pattern_rows']) for r in recipes)}")

    print("\nPrimeiras 10 receitas:")
    for recipe in recipes[:10]:
        print(
            f"{recipe['index']:02d}. Linha {recipe['line']} | "
            f"{recipe['result_expression']} | "
            f"Padrão: {' / '.join(recipe['pattern_rows'])}"
        )

    print(f"\nRelatório completo: {destination}")


if __name__ == "__main__":
    main()
