package potatocult.curious_ender_chest.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;
import potatocult.curious_ender_chest.networking.EnderChestPacket;
import potatocult.curious_ender_chest.networking.NetworkLoader;

public class EnderChestKeybind {

    public static KeyBinding OPEN_ENDERCHEST = new KeyBinding("key.curious_ender_chest.open_enderchest.desc", GLFW.GLFW_KEY_X, "key.categories.gameplay");

    @SubscribeEvent
    public void HandleKey(InputEvent.KeyInputEvent event) {
        if (OPEN_ENDERCHEST.isKeyDown()) {
            NetworkLoader.INSTANCE.sendToServer(new EnderChestPacket());
        }
    }
}
