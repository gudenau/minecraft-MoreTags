package net.gudenau.minecraft.moretags.mixins.maps;

import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class ItemFrameEntityRendererMixin{
    @Redirect(
        method = "getModelId",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        )
    )
    private boolean getModelId$ItemStack$isOf(ItemStack stack, Item item){
        return stack.isIn(MoreTags.FILLED_MAP);
    }
    @Redirect(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        )
    )
    private boolean render$ItemStack$isOf(ItemStack stack, Item item){
        return stack.isIn(MoreTags.FILLED_MAP);
    }
}
