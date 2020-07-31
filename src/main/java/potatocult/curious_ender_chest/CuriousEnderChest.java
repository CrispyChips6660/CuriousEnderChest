package potatocult.curious_ender_chest;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Items;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;
import potatocult.curious_ender_chest.networking.EnderChestPacket;
import potatocult.curious_ender_chest.networking.NetworkLoader;
import top.theillusivec4.curios.api.CuriosAPI;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_F;

/***
 * @author crispy_chips1234
 */
@Mod("curious_ender_chest")
public class CuriousEnderChest {
    public static void main(String[] args) {
    }

    public static KeyBinding OPEN_ENDERCHEST = new KeyBinding("key.curious_ender_chest.open_enderchest.desc", GLFW_KEY_F, "key.categories.gameplay");

    public CuriousEnderChest() {
        MinecraftForge.EVENT_BUS.register(this);
        ClientRegistry.registerKeyBinding(OPEN_ENDERCHEST);

        NetworkLoader.registerMessages();
    }

    @SubscribeEvent
    public void HandleKey(InputEvent.KeyInputEvent event) {
        NetworkLoader.INSTANCE.sendToServer(new EnderChestPacket());
    }

    public static void OpenEnderChestGUI(ServerPlayerEntity entity) {
        if (CuriousEnderChest.OPEN_ENDERCHEST.isKeyDown()) {
            if (CuriosAPI.getCurioEquipped(Items.ENDER_CHEST, entity).isPresent()) {
                NetworkHooks.openGui(entity, new SimpleNamedContainerProvider((id, playerInventory, player) -> ChestContainer.createGeneric9X3(id, playerInventory, entity.getInventoryEnderChest()), new TranslationTextComponent("container.enderchest")));
            }
        }
    }
}
