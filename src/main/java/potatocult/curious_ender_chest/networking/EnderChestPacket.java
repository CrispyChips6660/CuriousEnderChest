package potatocult.curious_ender_chest.networking;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import potatocult.curious_ender_chest.ModUtils;

import java.util.function.Supplier;


/**
 * @author TBroski
 * https://www.curseforge.com/members/tbr0skl/projects
 */

public class EnderChestPacket {

    public EnderChestPacket() {

    }

    public static void encode(EnderChestPacket msg, PacketBuffer buf) {

    }

    public static EnderChestPacket decode(PacketBuffer buf) {
        return new EnderChestPacket();
    }

    public static void handle(EnderChestPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() ->
                ModUtils.OpenGUI(ctx.get().getSender(), "container.enderchest"));
        ctx.get().setPacketHandled(true);
    }
}
