package potatocult.curious_ender_chest;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import potatocult.curious_ender_chest.capability.EnderChestCapabilityProvider;
import potatocult.curious_ender_chest.client.EnderChestKeybind;
import potatocult.curious_ender_chest.networking.NetworkLoader;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.capability.CuriosCapability;
import top.theillusivec4.curios.api.imc.CurioIMCMessage;


@Mod("curious_ender_chest")
public class CuriousEnderChest {

    public CuriousEnderChest() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        MinecraftForge.EVENT_BUS.addGenericListener(ItemStack.class, this::attachCapabilities);

        ClientRegistry.registerKeyBinding(EnderChestKeybind.OPEN_ENDERCHEST);

        NetworkLoader.registerMessages();
    }

    @SubscribeEvent
    public void attachCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        event.addCapability(CuriosCapability.ID_ITEM, new EnderChestCapabilityProvider(event.getObject()));
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosAPI.MODID, CuriosAPI.IMC.REGISTER_TYPE, () -> new CurioIMCMessage("back").setSize(1).setEnabled(true).setHidden(false));
    }

}
