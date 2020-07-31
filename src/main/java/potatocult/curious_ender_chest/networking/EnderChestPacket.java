package potatocult.curious_ender_chest.networking;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import potatocult.curious_ender_chest.client.EnderChestKeybind;

import java.util.function.Supplier;


public class EnderChestPacket {

    public EnderChestPacket() {

    }

    public static void encode(EnderChestPacket msg, PacketBuffer buf) {

    }

    public static EnderChestPacket decode(PacketBuffer buf) {
        return new EnderChestPacket();
    }

    public static void handle(EnderChestPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> EnderChestKeybind.OpenEnderChestGUI(ctx.get().getSender()));
        ctx.get().setPacketHandled(true);
    }
}
