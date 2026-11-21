#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
OUTPUT = ROOT / "intermediate/analysis/registrations"
OUTPUT.mkdir(parents=True, exist_ok=True)

METHODS = {
    "registerBlock",
    "registerItem",
    "registerModEntity",
    "registerEntity",
    "registerTileEntity",
    "registerGuiHandler",
    "registerMessage",
    "registerItemRenderer",
    "registerEntityRenderingHandler",
    "registerWorldGenerator",
    "registerFuelHandler",
}

PATTERN = re.compile(
    r"\b(" + "|".join(sorted(METHODS)) + r")\s*\("
)


def mask_comments(text):
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


def extract(text, filename):
    masked = mask_comments(text)
    results = []

    for match in PATTERN.finditer(masked):
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

        results.append({
            "method": match.group(1),
            "file": filename,
            "line": text.count("\n", 0, match.start()) + 1,
            "call": text[match.start():end + 1],
        })

    return results


def main():
    calls = []

    for path in sorted(JAVA_ROOT.rglob("*.java")):
        text = path.read_text(encoding="utf-8", errors="replace")
        relative = str(path.relative_to(JAVA_ROOT))
        calls.extend(extract(text, relative))

    counts = Counter(item["method"] for item in calls)

    report = {
        "section": "registration_details",
        "calls_found": len(calls),
        "method_counts": dict(counts.most_common()),
        "calls": calls,
    }

    destination = OUTPUT / "detailed_registrations.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== REGISTRATION DETAILS ===")
    print(f"Chamadas encontradas: {len(calls)}")

    print("\nPor método:")
    for method, count in counts.most_common():
        print(f"  {method}: {count}")

    print("\nArquivos com chamadas:")
    for filename in sorted(set(c["file"] for c in calls)):
        print(f"  {filename}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
