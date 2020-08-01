package potatocult.curious_ender_chest.networking;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

/**
 * @author TBroski
 * https://www.curseforge.com/members/tbr0skl/projects
 */
public class NetworkLoader {

    public static SimpleChannel INSTANCE;
    private static int id = 1;

    public static int nextID() {
        return id++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("curious_ender_chest", "default"), () -> "1.0", s -> true, s -> true);

        INSTANCE.registerMessage(nextID(), EnderChestPacket.class, EnderChestPacket::encode, EnderChestPacket::decode, EnderChestPacket::handle);
    }

}
