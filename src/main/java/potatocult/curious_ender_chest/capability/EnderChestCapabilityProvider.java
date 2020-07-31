package potatocult.curious_ender_chest.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.capability.CuriosCapability;
import top.theillusivec4.curios.api.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EnderChestCapabilityProvider implements ICapabilityProvider {

    private ItemStack stack;

    public EnderChestCapabilityProvider(ItemStack stack) {
        this.stack = stack;
    }

    final LazyOptional<ICurio> curio = LazyOptional.of(() -> new EnderChestCapability(stack));

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return CuriosCapability.ITEM.orEmpty(cap, curio);
    }

}
