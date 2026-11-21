#!/usr/bin/env python3

import json
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled/assets/rivalrebels/common/block"
OUT = ROOT / "intermediate/analysis/textures"
OUT.mkdir(parents=True, exist_ok=True)

METHOD = "func_149691_a"

# Captura tanto strings literais quanto expressões dinâmicas.
ICON_REGISTER = re.compile(
    r'this\.(\w+)\s*=\s*\w+\s*\.\s*'
    r'(?:func_94245_a|registerIcon)\s*\((.*?)\)\s*;',
    re.DOTALL
)

RETURN = re.compile(r'\breturn\s+(.+?);', re.DOTALL)


def normalize(expression):
    return re.sub(r'\s+', ' ', expression).strip()


def extract_methods(text, method):
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


def classify(body):
    if re.search(r'\bswitch\s*\(', body):
        return "switch"

    if re.search(r'\bmeta\s*(==|!=|>=|<=|>|<)', body):
        if re.search(r'\bside\s*(==|!=|>=|<=|>|<)', body):
            return "metadata_and_side"
        return "metadata"

    if re.search(r'\bside\s*(==|!=|>=|<=|>|<)', body):
        return "side"

    if re.search(r'\breturn\s+this\.\w+\s*;', body):
        return "fixed_or_conditional"

    return "other"


def extract_registrations(text):
    registrations = {}

    for match in ICON_REGISTER.finditer(text):
        field = match.group(1)
        expression = normalize(match.group(2))

        literal = re.fullmatch(r'"([^"]+)"', expression)

        registrations[field] = {
            "expression": expression,
            "literal_texture": literal.group(1) if literal else None,
            "dynamic": literal is None,
        }

    return registrations


def main():
    blocks = []
    total_methods = 0
    missing_fields = 0
    dynamic_fields = 0

    for file in sorted(JAVA_ROOT.rglob("*.java")):
        try:
            text = file.read_text(encoding="utf-8", errors="replace")
        except OSError:
            continue

        methods = extract_methods(text, METHOD)
        if not methods:
            continue

        registrations = extract_registrations(text)

        for body in methods:
            total_methods += 1

            fields = sorted(set(re.findall(r'\bthis\.(\w+)', body)))

            used_icons = [
                field for field in fields
                if field.startswith("icon")
                or field.startswith("icontop")
            ]

            unresolved = [
                field for field in used_icons
                if field not in registrations
            ]

            dynamic = [
                field for field in used_icons
                if field in registrations
                and registrations[field]["dynamic"]
            ]

            missing_fields += len(unresolved)
            dynamic_fields += len(dynamic)

            returns = [
                normalize(match.group(1))
                for match in RETURN.finditer(body)
            ]

            blocks.append({
                "class": file.stem,
                "file": str(file.relative_to(ROOT)),
                "classification": classify(body),
                "selection_method": body.strip(),
                "returns": returns,
                "used_icon_fields": used_icons,
                "registered_textures": {
                    field: registrations[field]
                    for field in used_icons
                    if field in registrations
                },
                "dynamic_icon_fields": dynamic,
                "unresolved_icon_fields": unresolved,
            })

    destination = OUT / "block_face_selection.json"
    destination.write_text(
        json.dumps(blocks, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== SELEÇÃO DE TEXTURAS POR FACE ===")
    print(f"Blocos com método de seleção: {len(blocks)}")
    print(f"Métodos analisados: {total_methods}")
    print(f"Campos com textura dinâmica: {dynamic_fields}")
    print(f"Referências sem registro encontrado: {missing_fields}")

    print("\n=== CLASSIFICAÇÃO ===")
    for category in sorted({b["classification"] for b in blocks}):
        entries = [
            b for b in blocks
            if b["classification"] == category
        ]
        print(f"{category}: {len(entries)}")

    print("\n=== TEXTURAS DINÂMICAS ===")
    for block in blocks:
        if block["dynamic_icon_fields"]:
            print(
                f'{block["class"]}: '
                f'{", ".join(block["dynamic_icon_fields"])}'
            )

    print("\n=== CAMPOS NÃO RESOLVIDOS ===")
    unresolved_blocks = [
        b for b in blocks if b["unresolved_icon_fields"]
    ]

    for block in unresolved_blocks:
        print(
            f'{block["class"]}: '
            f'{", ".join(block["unresolved_icon_fields"])}'
        )

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
