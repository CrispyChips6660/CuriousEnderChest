package potatocult.curious_ender_chest;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Items;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkHooks;
import top.theillusivec4.curios.api.CuriosAPI;

public class ModUtils {

    public static void OpenGUI(ServerPlayerEntity entity, String guiname) {
        if (CuriosAPI.getCurioEquipped(Items.ENDER_CHEST, entity).isPresent()) {
            NetworkHooks.openGui(entity, new SimpleNamedContainerProvider((id, playerInventory, player) -> ChestContainer.createGeneric9X3(id, playerInventory, entity.getInventoryEnderChest()), new TranslationTextComponent(guiname)));
        }
    }
}
