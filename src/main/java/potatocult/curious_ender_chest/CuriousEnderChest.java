package potatocult.curious_ender_chest;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosAPI;


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
        //Todo: fix dat ClassCastException
        if(CuriousEnderChest.OPEN_ENDERCHEST.isKeyDown()){
            PlayerEntity player_entity = Minecraft.getInstance().player;
            if (CuriosAPI.getCurioEquipped(Item.getItemFromBlock(Blocks.ENDER_CHEST), (LivingEntity) player_entity).isPresent()) {
                    ServerPlayerEntity player_ec = (ServerPlayerEntity) player_entity;
                    NetworkHooks.openGui(player_ec, new SimpleNamedContainerProvider((id, playerInventory, player) -> {
                        return ChestContainer.createGeneric9X3(id, playerInventory, player_ec.getInventoryEnderChest());
                    }, new TranslationTextComponent("container.enderchest")));
            }
        }
    }
}
