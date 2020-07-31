package potatocult.curious_ender_chest.networking.packets;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkEvent;
import potatocult.curious_ender_chest.CuriousEnderChest;

import java.util.function.Supplier;

public class PacketOpenEnderChest {

    public PacketOpenEnderChest()
    {

    }

    public static void encode(PacketOpenEnderChest msg, PacketBuffer buf)
    {
    }

    public static PacketOpenEnderChest decode(PacketBuffer buf)
    {
        return new PacketOpenEnderChest();
    }

    public static void handle(PacketOpenEnderChest msg, Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() -> {
            CuriousEnderChest.OpenEnderChestGUI(ctx.get().getSender());
        });
        ctx.get().setPacketHandled(true);
    }
}
