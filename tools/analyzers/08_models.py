#!/usr/bin/env python3

import json
from pathlib import Path
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / "source"
OUTPUT = ROOT / "intermediate/analysis/models"
OUTPUT.mkdir(parents=True, exist_ok=True)


def analyze_obj(path):
    vertices = []
    uv_count = 0
    normal_count = 0
    faces = []
    objects = []
    groups = []
    materials = []
    material_libraries = []
    missing_uv_faces = 0
    missing_uv_corners = 0
    invalid_indices = []

    for line_number, line in enumerate(
        path.read_text(encoding="utf-8", errors="replace").splitlines(),
        1
    ):
        parts = line.strip().split()
        if not parts or parts[0].startswith("#"):
            continue

        command = parts[0]
        values = parts[1:]

        if command == "v" and len(values) >= 3:
            try:
                vertices.append(tuple(float(v) for v in values[:3]))
            except ValueError:
                pass

        elif command == "vt":
            uv_count += 1

        elif command == "vn":
            normal_count += 1

        elif command == "f":
            corners = values
            faces.append(len(corners))

            face_missing_uv = False

            for corner in corners:
                indices = corner.split("/")

                try:
                    vertex_index = int(indices[0])
                    if vertex_index == 0 or abs(vertex_index) > len(vertices):
                        invalid_indices.append({
                            "line": line_number,
                            "type": "vertex",
                            "value": vertex_index
                        })
                except (ValueError, IndexError):
                    invalid_indices.append({
                        "line": line_number,
                        "type": "vertex",
                        "value": corner
                    })

                if len(indices) < 2 or not indices[1]:
                    face_missing_uv = True
                    missing_uv_corners += 1
                else:
                    try:
                        uv_index = int(indices[1])
                        if uv_index == 0 or abs(uv_index) > uv_count:
                            invalid_indices.append({
                                "line": line_number,
                                "type": "uv",
                                "value": uv_index
                            })
                    except ValueError:
                        invalid_indices.append({
                            "line": line_number,
                            "type": "uv",
                            "value": corner
                        })

            if face_missing_uv:
                missing_uv_faces += 1

        elif command == "o":
            objects.append(" ".join(values))

        elif command == "g":
            groups.append(" ".join(values))

        elif command == "usemtl":
            materials.append(" ".join(values))

        elif command == "mtllib":
            material_libraries.extend(values)

    triangle_count = sum(
        max(0, count - 2) for count in faces
    )

    bounds = None
    if vertices:
        bounds = {
            "min": [
                min(v[i] for v in vertices) for i in range(3)
            ],
            "max": [
                max(v[i] for v in vertices) for i in range(3)
            ]
        }

    return {
        "file": str(path.relative_to(SOURCE)),
        "vertices": len(vertices),
        "uv_coordinates": uv_count,
        "normals": normal_count,
        "faces": len(faces),
        "triangles_after_fan_triangulation": triangle_count,
        "face_sizes": dict(Counter(faces)),
        "objects": objects,
        "groups": groups,
        "materials": sorted(set(materials)),
        "material_libraries": material_libraries,
        "faces_missing_uv": missing_uv_faces,
        "corners_missing_uv": missing_uv_corners,
        "invalid_indices": invalid_indices,
        "bounds": bounds
    }


def analyze_mtl(path):
    materials = []
    current = None

    for line in path.read_text(
        encoding="utf-8", errors="replace"
    ).splitlines():
        parts = line.strip().split()
        if not parts or parts[0].startswith("#"):
            continue

        if parts[0] == "newmtl":
            current = {
                "name": " ".join(parts[1:]),
                "properties": []
            }
            materials.append(current)
        elif current:
            current["properties"].append({
                "property": parts[0],
                "values": parts[1:]
            })

    return {
        "file": str(path.relative_to(SOURCE)),
        "materials": materials,
        "material_count": len(materials)
    }


def main():
    obj_files = sorted(SOURCE.rglob("*.obj"))
    mtl_files = sorted(SOURCE.rglob("*.mtl"))

    models = [analyze_obj(path) for path in obj_files]
    material_files = [analyze_mtl(path) for path in mtl_files]

    report = {
        "section": "models",
        "obj_files_found": len(obj_files),
        "mtl_files_found": len(mtl_files),
        "total_vertices": sum(m["vertices"] for m in models),
        "total_faces": sum(m["faces"] for m in models),
        "total_triangles": sum(
            m["triangles_after_fan_triangulation"] for m in models
        ),
        "models_without_uv": [
            m["file"] for m in models
            if m["faces"] and m["faces_missing_uv"] == m["faces"]
        ],
        "models_with_missing_uv": [
            m["file"] for m in models if m["faces_missing_uv"] > 0
        ],
        "models_with_invalid_indices": [
            m["file"] for m in models if m["invalid_indices"]
        ],
        "models": models,
        "material_files": material_files
    }

    destination = OUTPUT / "report.json"
    destination.write_text(
        json.dumps(report, indent=2, ensure_ascii=False),
        encoding="utf-8"
    )

    print("=== RIVAL REBELS: MODEL ANALYZER ===")
    print(f"Arquivos OBJ: {len(obj_files)}")
    print(f"Arquivos MTL: {len(mtl_files)}")
    print(f"Vértices: {report['total_vertices']}")
    print(f"Faces: {report['total_faces']}")
    print(f"Triângulos: {report['total_triangles']}")
    print(f"Modelos sem UV: {len(report['models_without_uv'])}")
    print(f"Modelos com UV incompleto: {len(report['models_with_missing_uv'])}")
    print(f"Modelos com índices inválidos: {len(report['models_with_invalid_indices'])}")
    print(f"\nRelatório: {destination}")


if __name__ == "__main__":
    main()
