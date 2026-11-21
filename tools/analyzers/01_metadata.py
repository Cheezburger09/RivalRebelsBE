#!/usr/bin/env python3

import json
import hashlib
from pathlib import Path
from collections import Counter, defaultdict

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / "source"
OUTPUT = ROOT / "intermediate/analysis/metadata"
OUTPUT.mkdir(parents=True, exist_ok=True)


def sha256(path):
    digest = hashlib.sha256()
    with path.open("rb") as file:
        for chunk in iter(lambda: file.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


def main():
    files = sorted(p for p in SOURCE.rglob("*") if p.is_file())

    extensions = Counter()
    directories = Counter()
    sizes = Counter()
    hashes = defaultdict(list)

    for path in files:
        relative = path.relative_to(SOURCE)
        extension = path.suffix.lower() or "[sem extensão]"

        extensions[extension] += 1
        directories[str(relative.parent)] += 1
        sizes[extension] += path.stat().st_size
        hashes[sha256(path)].append(str(relative))

    metadata_file = SOURCE / "mcmod.info"
    metadata = None

    if metadata_file.exists():
        try:
            metadata = json.loads(metadata_file.read_text(
                encoding="utf-8"
            ))
        except Exception as error:
            metadata = {"error": str(error)}

    duplicates = [
        paths for paths in hashes.values()
        if len(paths) > 1
    ]

    report = {
        "project": "Rival Rebels",
        "source": str(SOURCE),
        "total_files": len(files),
        "total_size_bytes": sum(p.stat().st_size for p in files),
        "java_decompiled_files": len(
            list((ROOT / "decompiled").rglob("*.java"))
        ),
        "extensions": dict(extensions.most_common()),
        "directories": dict(directories.most_common()),
        "size_by_extension": dict(sizes.most_common()),
        "duplicate_files": duplicates,
        "mcmod_info": metadata,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: METADATA ANALYZER ===")
    print(f"Arquivos: {len(files)}")
    print(f"Espaço total: {report['total_size_bytes']:,} bytes")
    print(f"Extensões encontradas: {len(extensions)}")
    print(f"Grupos de arquivos duplicados: {len(duplicates)}")
    print(f"Relatório: {destination}")


if __name__ == "__main__":
    main()
