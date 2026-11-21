#!/usr/bin/env python3

import json
import hashlib
import struct
from pathlib import Path
from collections import Counter, defaultdict

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / "source"
OUTPUT = ROOT / "intermediate/analysis/sounds"
OUTPUT.mkdir(parents=True, exist_ok=True)


def sha256(data):
    return hashlib.sha256(data).hexdigest()


def analyze_ogg(path):
    data = path.read_bytes()

    result = {
        "file": str(path.relative_to(SOURCE)),
        "size_bytes": len(data),
        "sha256": sha256(data),
        "valid_ogg": data.startswith(b"OggS"),
        "codec": "Unknown",
        "sample_rate": None,
        "channels": None,
        "pages": 0,
        "duration_seconds_estimate": None,
        "serials": [],
    }

    if not result["valid_ogg"]:
        return result

    offset = 0
    max_granule = 0
    serials = set()
    first_packet = bytearray()
    first_packet_complete = False

    while offset + 27 <= len(data):
        if data[offset:offset + 4] != b"OggS":
            break

        header = data[offset:offset + 27]

        try:
            granule = struct.unpack("<Q", header[6:14])[0]
            serial = struct.unpack("<I", header[14:18])[0]
            segment_count = header[26]
        except struct.error:
            break

        lacing_start = offset + 27
        lacing_end = lacing_start + segment_count

        if lacing_end > len(data):
            break

        lacing = data[lacing_start:lacing_end]
        body_start = lacing_end
        body_size = sum(lacing)
        body_end = body_start + body_size

        if body_end > len(data):
            break

        result["pages"] += 1
        serials.add(serial)

        if granule != 0xFFFFFFFFFFFFFFFF:
            max_granule = max(max_granule, granule)

        if not first_packet_complete:
            position = body_start

            for segment_size in lacing:
                segment = data[position:position + segment_size]
                first_packet.extend(segment)
                position += segment_size

                if segment_size < 255:
                    first_packet_complete = True
                    break

        offset = body_end

    result["serials"] = sorted(serials)

    packet = bytes(first_packet)

    if packet.startswith(b"\x01vorbis") and len(packet) >= 30:
        result["codec"] = "Vorbis"
        result["channels"] = packet[11]
        result["sample_rate"] = struct.unpack("<I", packet[12:16])[0]

    elif packet.startswith(b"OpusHead") and len(packet) >= 19:
        result["codec"] = "Opus"
        result["channels"] = packet[9]
        result["sample_rate"] = 48000

    if result["sample_rate"]:
        result["duration_seconds_estimate"] = round(
            max_granule / result["sample_rate"], 3
        )

    return result


def main():
    files = sorted(
        path for path in SOURCE.rglob("*")
        if path.is_file() and path.suffix.lower() == ".ogg"
    )

    sounds = [analyze_ogg(path) for path in files]

    codecs = Counter(
        item["codec"] for item in sounds
    )

    sample_rates = Counter(
        str(item["sample_rate"])
        for item in sounds if item["sample_rate"]
    )

    hashes = defaultdict(list)

    for item in sounds:
        hashes[item["sha256"]].append(item["file"])

    duplicates = [
        paths for paths in hashes.values()
        if len(paths) > 1
    ]

    report = {
        "section": "sounds",
        "files_found": len(files),
        "valid_ogg_files": sum(item["valid_ogg"] for item in sounds),
        "invalid_ogg_files": sum(not item["valid_ogg"] for item in sounds),
        "total_size_bytes": sum(item["size_bytes"] for item in sounds),
        "codecs": dict(codecs.most_common()),
        "sample_rates": dict(sample_rates.most_common()),
        "duplicate_groups": duplicates,
        "sounds": sounds,
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    durations = [
        item["duration_seconds_estimate"]
        for item in sounds
        if item["duration_seconds_estimate"] is not None
    ]

    print("=== RIVAL REBELS: SOUND ANALYZER ===")
    print(f"Arquivos OGG: {len(files)}")
    print(f"Arquivos OGG válidos: {report['valid_ogg_files']}")
    print(f"Codecs: {dict(codecs)}")
    print(f"Taxas de amostragem: {dict(sample_rates)}")
    print(f"Grupos de duplicatas: {len(duplicates)}")

    if durations:
        print(f"Duração total estimada: {sum(durations):.2f} segundos")
        print(f"Menor duração: {min(durations):.2f} segundos")
        print(f"Maior duração: {max(durations):.2f} segundos")

    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
