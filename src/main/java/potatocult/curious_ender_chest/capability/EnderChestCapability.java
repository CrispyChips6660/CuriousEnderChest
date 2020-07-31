package potatocult.curious_ender_chest.capability;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import top.theillusivec4.curios.api.capability.ICurio;

public class EnderChestCapability implements ICurio {

    private final ItemStack displayedItem;

    public EnderChestCapability(ItemStack item) {
        this.displayedItem = item;
    }

    @Override
    public boolean hasRender(String identifier, LivingEntity livingEntity) {
        return true;
    }

    @Override
    public void render(String identifier, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ICurio.RenderHelper.translateIfSneaking(matrixStack, livingEntity);
        ICurio.RenderHelper.rotateIfSneaking(matrixStack, livingEntity);
        matrixStack.push();
        matrixStack.translate(0D, 0.35D, 0D);
        matrixStack.scale(2f, 2f, 1.5f);
        matrixStack.rotate(Direction.SOUTH.getRotation());
        Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(livingEntity, this.displayedItem, ItemCameraTransforms.TransformType.GROUND, false, matrixStack, renderTypeBuffer, light);
        matrixStack.pop();
    }

    @Override
    public boolean canRightClickEquip() {
        return true;
    }
}

