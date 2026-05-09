import os
import json

colors = [
    "white", "light_gray", "gray", "black", "brown", "orange",
    "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple",
    "magenta", "pink"
]

models_dir = r"d:\Desktop\Files\Projects\Mods\Colored Redstone Reborn\Colored Redstone Reborn 1.21.11 NeoForge\src\main\resources\assets\coloredredstonereborn\models\block"

def update_model(filename, new_parent):
    filepath = os.path.join(models_dir, filename)
    if not os.path.exists(filepath):
        print(f"Warning: {filepath} not found")
        return
        
    with open(filepath, "r", encoding="utf-8") as f:
        data = json.load(f)
        
    data["parent"] = new_parent
    
    with open(filepath, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=4)

for color in colors:
    # Lit standing torch
    update_model(f"{color}_redstone_torch.json", "minecraft:block/template_redstone_torch")
    # Lit wall torch
    update_model(f"{color}_redstone_wall_torch.json", "minecraft:block/template_redstone_torch_wall")
    # Unlit standing torch
    update_model(f"{color}_redstone_torch_off.json", "minecraft:block/template_torch_unlit")
    # Unlit wall torch
    update_model(f"{color}_redstone_wall_torch_off.json", "minecraft:block/template_torch_wall_unlit")

print("Finished updating block models.")
