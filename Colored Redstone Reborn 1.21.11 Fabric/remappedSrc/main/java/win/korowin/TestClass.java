package win.korowin;

import java.lang.reflect.Method;
import net.minecraft.world.item.Item;

public class TestClass {
    public static void main(String[] args) {
        for (Method m : Item.Properties.class.getMethods()) {
            if (m.getName().toLowerCase().contains("translation") || m.getName().toLowerCase().contains("key") || m.getName().toLowerCase().contains("block")) {
                System.out.println(m.toString());
            }
        }
    }
}
