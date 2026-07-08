package win.korowin.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import win.korowin.ColoredRedstoneFabric;

/**
 * Class for initializing and registering creative mode tabs on Fabric.
 */
public class ModCreativeTabs {
    public static final CreativeModeTab COLORED_REDSTONE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.CYAN_REDSTONE))
            .title(Component.translatable("itemGroup.coloredredstonereborn"))
            .displayItems((displayContext, entries) -> {
                ModItems.ALL_ITEMS.forEach(entries::accept);
            })
            .build();

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(ColoredRedstoneFabric.MODID, "tab"), COLORED_REDSTONE_TAB);
    }
}
