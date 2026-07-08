package win.korowin;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import win.korowin.init.ModBlocks;
import win.korowin.init.ModCreativeTabs;
import win.korowin.init.ModItems;

/**
 * Main entry point for Colored Redstone Reborn on Fabric.
 */
public class ColoredRedstoneFabric implements ModInitializer {
    public static final String MODID = "coloredredstonereborn";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Colored Redstone Reborn for Fabric!");

        // Load configuration
        Config.load();

        // Register blocks and items
        ModBlocks.register();
        ModItems.register();
        
        // Register creative tabs
        ModCreativeTabs.register();
    }
}
