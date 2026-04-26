package win.korowin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mod configuration class for Fabric.
 * Uses a simple JSON file to store configuration.
 */
public class Config {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("coloredredstonereborn.json").toFile();

    public static boolean logDirtBlock = true;
    public static int magicNumber = 42;
    public static String magicNumberIntroduction = "The magic number is... ";
    public static List<String> itemStrings = Collections.singletonList("minecraft:iron_ingot");
    public static Set<Item> items = Collections.emptySet();

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                ConfigData data = GSON.fromJson(reader, ConfigData.class);
                if (data != null) {
                    logDirtBlock = data.logDirtBlock;
                    magicNumber = data.magicNumber;
                    magicNumberIntroduction = data.magicNumberIntroduction;
                    itemStrings = data.itemStrings;
                }
            } catch (IOException e) {
                ColoredRedstoneFabric.LOGGER.error("Failed to load config!", e);
            }
        } else {
            save();
        }

        // Convert the list of strings into a set of items
        items = itemStrings.stream()
                .map(itemName -> Registries.ITEM.get(new Identifier(itemName)))
                .collect(Collectors.toSet());
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            ConfigData data = new ConfigData();
            data.logDirtBlock = logDirtBlock;
            data.magicNumber = magicNumber;
            data.magicNumberIntroduction = magicNumberIntroduction;
            data.itemStrings = itemStrings;
            GSON.toJson(data, writer);
        } catch (IOException e) {
            ColoredRedstoneFabric.LOGGER.error("Failed to save config!", e);
        }
    }

    private static class ConfigData {
        boolean logDirtBlock = true;
        int magicNumber = 42;
        String magicNumberIntroduction = "The magic number is... ";
        List<String> itemStrings = Collections.singletonList("minecraft:iron_ingot");
    }
}
