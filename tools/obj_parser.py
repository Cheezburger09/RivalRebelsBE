import json
import sys
from pathlib import Path

def parse_obj(filename):
    path = Path(filename)

    vertices = []
    uvs = []
    normals = []
    faces = []
    objects = []
    materials = []

    current_object = None
    current_material = None

    def resolve_index(value, collection):
        index = int(value)
        return index - 1 if index > 0 else len(collection) + index

    for line_number, line in enumerate(
        path.read_text(errors="replace").splitlines(), 1
    ):
        parts = line.split()

        if not parts or parts[0].startswith("#"):
            continue

        command, values = parts[0], parts[1:]

        try:
            if command == "v":
                vertices.append([float(x) for x in values[:3]])

            elif command == "vt":
                uvs.append([float(x) for x in values[:2]])

            elif command == "vn":
                normals.append([float(x) for x in values[:3]])

            elif command in ("o", "g"):
                current_object = " ".join(values)
                if current_object not in objects:
                    objects.append(current_object)

            elif command == "usemtl":
                current_material = " ".join(values)
                if current_material not in materials:
                    materials.append(current_material)

            elif command == "mtllib":
                materials.append({"library": " ".join(values)})

            elif command == "f":
                corners = []

                for value in values:
                    indices = value.split("/")

                    vertex = resolve_index(indices[0], vertices)
                    uv = (
                        resolve_index(indices[1], uvs)
                        if len(indices) > 1 and indices[1]
                        else None
                    )
                    normal = (
                        resolve_index(indices[2], normals)
                        if len(indices) > 2 and indices[2]
                        else None
                    )

                    if not 0 <= vertex < len(vertices):
                        raise ValueError("Índice de vértice inválido")

                    if uv is not None and not 0 <= uv < len(uvs):
                        raise ValueError("Índice UV inválido")

                    if normal is not None and not 0 <= normal < len(normals):
                        raise ValueError("Índice de normal inválido")

                    corners.append({
                        "vertex": vertex,
                        "uv": uv,
                        "normal": normal
                    })

                # Triangulação por leque para polígonos com mais de 3 lados.
                for i in range(1, len(corners) - 1):
                    faces.append({
                        "corners": [corners[0], corners[i], corners[i + 1]],
                        "object": current_object,
                        "material": current_material
                    })

        except (ValueError, IndexError) as error:
            raise ValueError(
                f"{path}:{line_number}: {error}"
            ) from error

    if not vertices or not faces:
        raise ValueError("OBJ sem vértices ou faces válidas")

    bounds = {
        "min": [min(v[i] for v in vertices) for i in range(3)],
        "max": [max(v[i] for v in vertices) for i in range(3)]
    }

    return {
        "format": "J2B-MESH",
        "version": 1,
        "source": path.name,
        "vertices": vertices,
        "uvs": uvs,
        "normals": normals,
        "faces": faces,
        "objects": objects,
        "materials": materials,
        "bounds": bounds
    }

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Uso: python obj_parser.py entrada.obj saida.json")
        sys.exit(2)

    result = parse_obj(sys.argv[1])
    output = Path(sys.argv[2])
    output.parent.mkdir(parents=True, exist_ok=True)
    output.write_text(json.dumps(result, indent=2))

    print("Conversão concluída!")
    print(f"Vértices: {len(result['vertices'])}")
    print(f"UVs: {len(result['uvs'])}")
    print(f"Normais: {len(result['normals'])}")
    print(f"Triângulos: {len(result['faces'])}")
    print(f"Saída: {output}")
