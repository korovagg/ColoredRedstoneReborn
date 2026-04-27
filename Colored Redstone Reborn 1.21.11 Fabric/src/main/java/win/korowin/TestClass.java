package win.korowin;

import net.minecraft.item.Item;
import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) {
        for (Method m : Item.Settings.class.getMethods()) {
            if (m.getName().toLowerCase().contains("translation") || m.getName().toLowerCase().contains("key") || m.getName().toLowerCase().contains("block")) {
                System.out.println(m.toString());
            }
        }
    }
}
