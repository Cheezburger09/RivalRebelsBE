#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
OUTPUT = ROOT / "intermediate/analysis/recipes"
OUTPUT.mkdir(parents=True, exist_ok=True)

KEYWORDS = re.compile(
    r"recipe|smelt|craft|fuel",
    re.IGNORECASE
)

CALL_PATTERN = re.compile(
    r"\b([A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*)\s*\("
)


def mask_comments_and_strings(text):
    """Substitui comentários e strings por espaços, preservando posições."""
    result = list(text)
    i = 0
    state = "normal"

    while i < len(text):
        c = text[i]
        nxt = text[i + 1] if i + 1 < len(text) else ""

        if state == "normal":
            if c == "/" and nxt == "/":
                result[i] = result[i + 1] = " "
                i += 2
                state = "line_comment"
                continue
            if c == "/" and nxt == "*":
                result[i] = result[i + 1] = " "
                i += 2
                state = "block_comment"
                continue
            if c == '"':
                result[i] = " "
                state = "string"
            elif c == "'":
                result[i] = " "
                state = "char"

        elif state == "line_comment":
            if c == "\n":
                state = "normal"
            else:
                result[i] = " "

        elif state == "block_comment":
            result[i] = " "
            if c == "*" and nxt == "/":
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

    for match in CALL_PATTERN.finditer(masked):
        name = match.group(1)

        if not KEYWORDS.search(name):
            continue

        open_pos = masked.find("(", match.start())
        depth = 0
        close_pos = None

        for pos in range(open_pos, len(masked)):
            if masked[pos] == "(":
                depth += 1
            elif masked[pos] == ")":
                depth -= 1
                if depth == 0:
                    close_pos = pos
                    break

        if close_pos is None:
            continue

        line = text.count("\n", 0, match.start()) + 1
        source = text[match.start():close_pos + 1]

        calls.append({
            "name": name,
            "line": line,
            "arguments_preview": source[:1200],
            "truncated": len(source) > 1200,
        })

    return calls


def main():
    java_files = sorted(JAVA_ROOT.rglob("*.java"))

    all_calls = []
    related_classes = []
    keyword_files = []

    for path in java_files:
        try:
            text = path.read_text(encoding="utf-8", errors="replace")
        except OSError:
            continue

        relative = str(path.relative_to(JAVA_ROOT))
        calls = extract_calls(text)

        if calls:
            for call in calls:
                call["file"] = relative
                all_calls.append(call)

        if KEYWORDS.search(path.stem):
            related_classes.append(relative)

        lines = []
        for number, line in enumerate(text.splitlines(), 1):
            if KEYWORDS.search(line):
                lines.append({
                    "line": number,
                    "text": line.strip()[:300]
                })

        if lines:
            keyword_files.append({
                "file": relative,
                "matches": lines[:100]
            })

    call_counts = Counter(call["name"] for call in all_calls)

    report = {
        "section": "recipes",
        "java_files_scanned": len(java_files),
        "recipe_related_classes": related_classes,
        "calls_found": len(all_calls),
        "call_counts": dict(call_counts.most_common()),
        "calls": all_calls,
        "keyword_files": keyword_files,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: RECIPE ANALYZER ===")
    print(f"Arquivos Java examinados: {len(java_files)}")
    print(f"Classes com nomes relacionados: {len(related_classes)}")
    print(f"Chamadas relacionadas encontradas: {len(all_calls)}")

    print("\nTipos de chamadas:")
    for name, count in call_counts.most_common():
        print(f"  {name}: {count}")

    print(f"\nArquivos com ocorrências: {len(keyword_files)}")
    print(f"Relatório: {destination}")


if __name__ == "__main__":
    main()
