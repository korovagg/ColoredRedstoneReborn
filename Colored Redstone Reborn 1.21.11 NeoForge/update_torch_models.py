import os
import json

colors = [
    "white", "light_gray", "gray", "black", "brown", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink"
]

# Update Item Models
item_models_dir = r"d:\Desktop\Files\Projects\Mods\Colored Redstone Reborn\Colored Redstone Reborn 1.21.11 NeoForge\src\main\resources\assets\coloredredstonereborn\models\item"
for color in colors:
    item_model_path = os.path.join(item_models_dir, f"{color}_redstone_torch.json")
    item_model_data = {
        "parent": "minecraft:item/generated",
        "textures": {
            "layer0": f"coloredredstonereborn:block/{color}_redstone_torch"
        }
    }
    with open(item_model_path, 'w', encoding='utf-8') as f:
        json.dump(item_model_data, f, indent=4)

print("Item models updated.")
