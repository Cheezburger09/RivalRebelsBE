import json
from pathlib import Path
from collections import defaultdict

ROOT = Path(".")
INPUT = ROOT / "intermediate/analysis/textures/consolidated_block_textures.json"
OUT_DIR = ROOT / "intermediate/analysis/textures"

OUT_JSON = OUT_DIR / "shared_block_textures.json"
OUT_MD = OUT_DIR / "shared_block_textures.md"

data = json.loads(INPUT.read_text())
owners = defaultdict(set)

for block in data["blocks"]:
    for info in block["registered_textures"].values():
        for path in info["texture_files"]:
            if path.startswith("textures/blocks/"):
                owners[path].add(block["class"])

shared = [
    {
        "texture": path,
        "block_count": len(classes),
        "blocks": sorted(classes),
    }
    for path, classes in sorted(owners.items())
    if len(classes) > 1
]

result = {
    "total_shared_textures": len(shared),
    "total_blocks_using_shared_textures": len({
        block
        for texture in shared
        for block in texture["blocks"]
    }),
    "textures": shared,
}

OUT_JSON.write_text(
    json.dumps(result, indent=2, ensure_ascii=False) + "\n"
)

md = [
    "# Texturas compartilhadas entre blocos",
    "",
    f"- Texturas compartilhadas: **{result['total_shared_textures']}**",
    f"- Blocos envolvidos: **{result['total_blocks_using_shared_textures']}**",
    "",
]

for item in shared:
    md.extend([
        f"## `{item['texture']}`",
        "",
        f"**Blocos associados:** {item['block_count']}",
        "",
    ])
    md.extend(f"- `{name}`" for name in item["blocks"])
    md.append("")

OUT_MD.write_text("\n".join(md) + "\n")

print("=== TEXTURAS COMPARTILHADAS ===")
print("Texturas:", result["total_shared_textures"])
print("Blocos envolvidos:", result["total_blocks_using_shared_textures"])
print("JSON:", OUT_JSON)
print("Markdown:", OUT_MD)
