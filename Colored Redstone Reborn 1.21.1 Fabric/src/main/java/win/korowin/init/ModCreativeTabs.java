package win.korowin.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import win.korowin.ColoredRedstoneFabric;

/**
 * Class for initializing and registering creative mode tabs on Fabric.
 */
public class ModCreativeTabs {
    public static final ItemGroup COLORED_REDSTONE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.CYAN_REDSTONE))
            .displayName(Text.translatable("itemGroup.coloredredstonereborn"))
            .entries((displayContext, entries) -> {
                ModItems.ALL_ITEMS.forEach(entries::add);
            })
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(ColoredRedstoneFabric.MODID, "tab"), COLORED_REDSTONE_TAB);
    }
}
