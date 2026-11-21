import json
from pathlib import Path
from collections import Counter

ROOT = Path(".")
ANALYSIS = ROOT / "intermediate/analysis/textures"
FACE_FILE = ANALYSIS / "block_face_selection.json"
MAPPING_FILE = ANALYSIS / "icon_texture_mapping.json"

OUT_JSON = ANALYSIS / "consolidated_block_textures.json"
OUT_MD = ANALYSIS / "consolidated_block_textures.md"

blocks = json.loads(FACE_FILE.read_text())
mappings = json.loads(MAPPING_FILE.read_text())

# Índice de arquivos PNG por classe e identificador de textura.
texture_index = {}
for item in mappings:
    if item.get("category") != "block":
        continue

    key = (item.get("class"), item.get("icon"))
    texture_index.setdefault(key, set()).update(item.get("texture_files", []))

report = []

for block in sorted(blocks, key=lambda x: x["class"]):
    registered = {}

    for field, info in block.get("registered_textures", {}).items():
        texture = info.get("literal_texture")
        files = []

        if texture:
            files = sorted(
                path for path in texture_index.get((block["class"], texture), [])
                if path.startswith("textures/blocks/")
            )

        registered[field] = {
            **info,
            "texture_files": files,
            "texture_files_found": bool(files),
        }

    report.append({
        "class": block["class"],
        "source_file": block["file"],
        "classification": block["classification"],
        "selection_method": block["selection_method"],
        "returns": block.get("returns", []),
        "used_icon_fields": block.get("used_icon_fields", []),
        "registered_textures": registered,
        "dynamic_icon_fields": block.get("dynamic_icon_fields", []),
        "unresolved_icon_fields": block.get("unresolved_icon_fields", []),
    })

summary = {
    "total_blocks": len(report),
    "classifications": dict(Counter(x["classification"] for x in report)),
    "blocks_with_dynamic_textures": sum(bool(x["dynamic_icon_fields"]) for x in report),
    "blocks_with_unresolved_fields": sum(bool(x["unresolved_icon_fields"]) for x in report),
    "blocks": report,
}

OUT_JSON.write_text(json.dumps(summary, indent=2, ensure_ascii=False) + "\n")

md = [
    "# Mapeamento consolidado de texturas dos blocos",
    "",
    f"- Blocos analisados: **{len(report)}**",
    f"- Classificações: `{json.dumps(summary['classifications'], ensure_ascii=False)}`",
    f"- Blocos com campos dinâmicos: **{summary['blocks_with_dynamic_textures']}**",
    f"- Blocos com campos não resolvidos: **{summary['blocks_with_unresolved_fields']}**",
    "",
    "> A seleção original foi preservada. Os números das faces seguem a convenção do código Java; a orientação equivalente no Bedrock ainda precisa ser validada.",
    "",
]

for block in report:
    md.extend([
        "---",
        "",
        f"## {block['class']}",
        "",
        f"- **Arquivo:** `{block['source_file']}`",
        f"- **Classificação:** `{block['classification']}`",
        "",
        "### Texturas registradas",
        "",
        "| Campo | Expressão Java | Textura literal | Arquivos encontrados |",
        "|---|---|---|---|",
    ])

    if block["registered_textures"]:
        for field, info in block["registered_textures"].items():
            expression = info.get("expression") or ""
            literal = info.get("literal_texture") or "Dinâmica"
            files = ", ".join(f"`{x}`" for x in info["texture_files"]) or "—"
            md.append(f"| `{field}` | `{expression}` | `{literal}` | {files} |")
    else:
        md.append("| — | — | — | — |")

    md.extend([
        "",
        "### Lógica original de seleção",
        "",
        "```java",
        block["selection_method"],
        "```",
        "",
        f"**Campos utilizados:** {', '.join(f'`{x}`' for x in block['used_icon_fields']) or 'Nenhum'}",
        "",
    ])

    if block["dynamic_icon_fields"]:
        md.append(
            "**Campos dinâmicos:** "
            + ", ".join(f"`{x}`" for x in block["dynamic_icon_fields"])
        )
        md.append("")

    if block["unresolved_icon_fields"]:
        md.append(
            "**Campos não resolvidos:** "
            + ", ".join(f"`{x}`" for x in block["unresolved_icon_fields"])
        )
        md.append("")

OUT_MD.write_text("\n".join(md) + "\n")

print("=== RELATÓRIO CONSOLIDADO ===")
print("Blocos:", summary["total_blocks"])
print("Classificações:", summary["classifications"])
print("Com campos dinâmicos:", summary["blocks_with_dynamic_textures"])
print("Com campos não resolvidos:", summary["blocks_with_unresolved_fields"])
print("JSON:", OUT_JSON)
print("Markdown:", OUT_MD)
