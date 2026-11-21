#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter, defaultdict

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
OUTPUT = ROOT / "intermediate/analysis/registrations"
OUTPUT.mkdir(parents=True, exist_ok=True)

TERMS = [
    "registerBlock",
    "registerItem",
    "registerEntity",
    "registerModEntity",
    "registerTileEntity",
    "registerGui",
    "registerWorldGenerator",
    "registerFuelHandler",
    "registerRenderer",
    "registerItemRenderer",
    "registerEntityRenderingHandler",
    "registerMessage",
    "register",
    "GameRegistry",
    "EntityRegistry",
    "RenderingRegistry",
]

IMPORTANT_FILES = [
    "assets/rivalrebels/RivalRebels.java",
    "assets/rivalrebels/client/ClientProxy.java",
    "assets/rivalrebels/common/CommonProxy.java",
]


def analyze(path):
    text = path.read_text(encoding="utf-8", errors="replace")
    relative = str(path.relative_to(JAVA_ROOT))
    occurrences = []

    for number, line in enumerate(text.splitlines(), 1):
        matches = [term for term in TERMS if term in line]

        if matches:
            occurrences.append({
                "line": number,
                "terms": matches,
                "text": line.strip()[:500],
            })

    return {
        "file": relative,
        "important_file": relative in IMPORTANT_FILES,
        "occurrences": occurrences,
    }


def main():
    files = sorted(JAVA_ROOT.rglob("*.java"))
    results = []

    for path in files:
        result = analyze(path)

        if result["occurrences"] or result["important_file"]:
            results.append(result)

    counts = Counter()
    for result in results:
        for occurrence in result["occurrences"]:
            counts.update(occurrence["terms"])

    report = {
        "section": "registrations",
        "java_files_scanned": len(files),
        "related_files": len(results),
        "term_counts": dict(counts.most_common()),
        "files": results,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: REGISTRATION ANALYZER ===")
    print(f"Arquivos Java examinados: {len(files)}")
    print(f"Arquivos com registros ou referências: {len(results)}")

    print("\nOcorrências por termo:")
    for term, count in counts.most_common():
        print(f"  {term}: {count}")

    print("\nArquivos principais:")
    for result in results:
        if result["important_file"]:
            print(f"  {result['file']}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
