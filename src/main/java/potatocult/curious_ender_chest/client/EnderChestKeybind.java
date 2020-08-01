package potatocult.curious_ender_chest.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Items;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.NetworkHooks;
import org.lwjgl.glfw.GLFW;
import potatocult.curious_ender_chest.networking.EnderChestPacket;
import potatocult.curious_ender_chest.networking.NetworkLoader;
import top.theillusivec4.curios.api.CuriosAPI;

public class EnderChestKeybind {

    public static KeyBinding OPEN_ENDERCHEST = new KeyBinding("key.curious_ender_chest.open_enderchest.desc", GLFW.GLFW_KEY_X, "key.categories.gameplay");

    public static void OpenEnderChestGUI(ServerPlayerEntity entity) {
            if (CuriosAPI.getCurioEquipped(Items.ENDER_CHEST, entity).isPresent()) {
                NetworkHooks.openGui(entity, new SimpleNamedContainerProvider((id, playerInventory, player) -> ChestContainer.createGeneric9X3(id, playerInventory, entity.getInventoryEnderChest()), new TranslationTextComponent("container.enderchest")));
            }
    }

    @SubscribeEvent
    public void HandleKey(InputEvent.KeyInputEvent event) {
        if (OPEN_ENDERCHEST.isKeyDown()) {
            NetworkLoader.INSTANCE.sendToServer(new EnderChestPacket());
        }
    }
}
