package win.korowin;

import net.neoforged.neoforge.registries.DeferredRegister;
import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) {
        for (Method m : DeferredRegister.Blocks.class.getDeclaredMethods()) {
            System.out.println(m.toString());
        }
    }
}
