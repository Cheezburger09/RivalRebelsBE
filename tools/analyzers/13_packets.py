#!/usr/bin/env python3

import json
import re
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
JAVA_ROOT = ROOT / "decompiled"
OUTPUT = ROOT / "intermediate/analysis/packets"
OUTPUT.mkdir(parents=True, exist_ok=True)

TERMS = [
    "IMessage",
    "IMessageHandler",
    "ByteBuf",
    "SimpleNetworkWrapper",
    "registerMessage",
    "sendToServer",
    "sendToAll",
    "sendTo",
    "sendToDimension",
    "sendToAllAround",
    "Packet",
]

CLASS_PATTERN = re.compile(
    r"\b(class|interface|enum)\s+(\w+)"
    r"(?:\s+extends\s+([\w.$]+))?"
    r"(?:\s+implements\s+([^{]+))?"
)


def analyze_file(path):
    text = path.read_text(encoding="utf-8", errors="replace")
    relative = str(path.relative_to(JAVA_ROOT))

    declarations = []

    for match in CLASS_PATTERN.finditer(text):
        declarations.append({
            "kind": match.group(1),
            "name": match.group(2),
            "extends": match.group(3),
            "implements": (
                match.group(4).strip() if match.group(4) else None
            ),
        })

    occurrences = []

    for number, line in enumerate(text.splitlines(), 1):
        found = [term for term in TERMS if term in line]

        if found:
            occurrences.append({
                "line": number,
                "terms": found,
                "text": line.strip()[:400],
            })

    path_related = (
        "packet" in relative.lower()
        or "message" in relative.lower()
        or "network" in relative.lower()
    )

    name_related = any(
        re.search(r"packet|message|network", item["name"], re.I)
        for item in declarations
    )

    if not occurrences and not path_related and not name_related:
        return None

    return {
        "file": relative,
        "declarations": declarations,
        "path_related": path_related,
        "name_related": name_related,
        "occurrences": occurrences,
    }


def main():
    java_files = sorted(JAVA_ROOT.rglob("*.java"))
    results = []

    for path in java_files:
        result = analyze_file(path)
        if result:
            results.append(result)

    term_counts = Counter()
    for result in results:
        for occurrence in result["occurrences"]:
            term_counts.update(occurrence["terms"])

    report = {
        "section": "packets",
        "java_files_scanned": len(java_files),
        "related_files": len(results),
        "path_related_files": sum(r["path_related"] for r in results),
        "name_related_files": sum(r["name_related"] for r in results),
        "term_counts": dict(term_counts.most_common()),
        "files": results,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: PACKET ANALYZER ===")
    print(f"Arquivos Java examinados: {len(java_files)}")
    print(f"Arquivos relacionados: {len(results)}")
    print(f"Arquivos em pastas de rede/pacotes: {report['path_related_files']}")
    print(f"Classes com nomes relacionados: {report['name_related_files']}")

    print("\nOcorrências por termo:")
    for term, count in term_counts.most_common():
        print(f"  {term}: {count}")

    print("\nArquivos encontrados:")
    for result in results:
        print(f"  {result['file']}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
