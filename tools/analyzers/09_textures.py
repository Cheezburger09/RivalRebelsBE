#!/usr/bin/env python3

import json
import hashlib
import struct
from pathlib import Path
from collections import Counter, defaultdict

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / "source"
OUTPUT = ROOT / "intermediate/analysis/textures"
OUTPUT.mkdir(parents=True, exist_ok=True)

PNG_SIGNATURE = b"\x89PNG\r\n\x1a\n"

COLOR_TYPES = {
    0: "Grayscale",
    2: "RGB",
    3: "Indexed",
    4: "Grayscale + Alpha",
    6: "RGBA"
}


def sha256(path):
    digest = hashlib.sha256()

    with path.open("rb") as file:
        for chunk in iter(lambda: file.read(1024 * 1024), b""):
            digest.update(chunk)

    return digest.hexdigest()


def analyze_png(path):
    with path.open("rb") as file:
        header = file.read(29)

    if len(header) < 29 or header[:8] != PNG_SIGNATURE:
        return {
            "file": str(path.relative_to(SOURCE)),
            "valid_png_header": False
        }

    width, height, bit_depth, color_type, compression, filtering, interlace = (
        struct.unpack(">IIBBBBB", header[16:29])
    )

    return {
        "file": str(path.relative_to(SOURCE)),
        "valid_png_header": True,
        "width": width,
        "height": height,
        "dimensions": f"{width}x{height}",
        "bit_depth": bit_depth,
        "color_type": COLOR_TYPES.get(color_type, f"Unknown ({color_type})"),
        "has_alpha_channel": color_type in (4, 6),
        "uses_palette": color_type == 3,
        "interlaced": bool(interlace),
        "size_bytes": path.stat().st_size,
        "sha256": sha256(path)
    }


def main():
    files = sorted(
        path for path in SOURCE.rglob("*")
        if path.is_file() and path.suffix.lower() == ".png"
    )

    textures = [analyze_png(path) for path in files]

    valid = [
        item for item in textures
        if item["valid_png_header"]
    ]

    dimensions = Counter(
        item["dimensions"] for item in valid
    )

    color_types = Counter(
        item["color_type"] for item in valid
    )

    folders = Counter(
        str(Path(item["file"]).parent)
        for item in valid
    )

    hashes = defaultdict(list)

    for item in valid:
        hashes[item["sha256"]].append(item["file"])

    duplicates = [
        paths for paths in hashes.values()
        if len(paths) > 1
    ]

    report = {
        "section": "textures",
        "files_found": len(files),
        "valid_png_headers": len(valid),
        "invalid_png_headers": len(files) - len(valid),
        "total_size_bytes": sum(
            item["size_bytes"] for item in valid
        ),
        "dimensions": dict(dimensions.most_common()),
        "color_types": dict(color_types.most_common()),
        "folders": dict(folders.most_common()),
        "textures_with_alpha_channel": sum(
            item["has_alpha_channel"] for item in valid
        ),
        "interlaced_textures": sum(
            item["interlaced"] for item in valid
        ),
        "duplicate_groups": duplicates,
        "textures": textures
    }

    destination = OUTPUT / "report.json"

    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: TEXTURE ANALYZER ===")
    print(f"Arquivos PNG: {len(files)}")
    print(f"Cabeçalhos PNG válidos: {len(valid)}")
    print(f"Texturas com canal alpha: {report['textures_with_alpha_channel']}")
    print(f"Dimensões diferentes: {len(dimensions)}")
    print(f"Grupos de duplicatas: {len(duplicates)}")

    print("\nDimensões mais comuns:")

    for dimension, count in dimensions.most_common(15):
        print(f"  {dimension}: {count}")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
