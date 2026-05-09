import os

colors = [
    "white", "light_gray", "gray", "black", "brown", "red", "orange",
    "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple",
    "magenta", "pink"
]
# Note: red is vanilla, but maybe we shouldn't touch it. Let's see which colors we have.
colors = [
    "white", "light_gray", "gray", "black", "brown", "orange",
    "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple",
    "magenta", "pink"
]

items_dir = r"d:\Desktop\Files\Projects\Mods\Colored Redstone Reborn\Colored Redstone Reborn 1.21.11 NeoForge\src\main\resources\assets\coloredredstonereborn\items"

if not os.path.exists(items_dir):
    os.makedirs(items_dir)

for color in colors:
    filename = os.path.join(items_dir, f"{color}_redstone_torch.json")
    content = f'{{ "model": {{ "type": "minecraft:model", "model": "coloredredstonereborn:item/{color}_redstone_torch" }} }}'
    with open(filename, "w", encoding="utf-8") as f:
        f.write(content)
        
print("Generated item definitions.")
