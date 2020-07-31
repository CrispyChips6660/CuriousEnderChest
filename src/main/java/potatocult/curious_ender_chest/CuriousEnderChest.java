package potatocult.curious_ender_chest;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static org.lwjgl.glfw.GLFW.GLFW_KEY_F;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("curious_ender_chest")
public class CuriousEnderChest {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static KeyBinding OPEN_ENDERCHEST = new KeyBinding("key.curious_ender_chest.open_enderchest.desc", GLFW_KEY_F, "key.categories.gameplay");

    public CuriousEnderChest() {
        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
        ClientRegistry.registerKeyBinding(OPEN_ENDERCHEST);
    }

    @SubscribeEvent
    public void EnderchestKeyDetection(InputEvent.KeyInputEvent event){

    }
}
