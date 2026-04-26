package win.korowin.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import win.korowin.coloredredstonereborn;

/**
 * Class for creative mode tabs in 1.16.5.
 */
public class ModCreativeTabs {
    public static final ItemGroup COLORED_REDSTONE_TAB = new ItemGroup(coloredredstonereborn.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CYAN_REDSTONE.get());
        }
    };
}
