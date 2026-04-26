package win.korowin.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import win.korowin.coloredredstonereborn;

/**
 * Class for creative mode tabs in 1.18.2.
 */
public class ModCreativeTabs {
    public static final CreativeModeTab COLORED_REDSTONE_TAB = new CreativeModeTab(coloredredstonereborn.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CYAN_REDSTONE.get());
        }
    };
}
