package net.gudenau.minecraft.moretags.mixins.item.shears;

import net.gudenau.minecraft.moretags.MoreItemTags;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {
    @Redirect(
        method = "onUse",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z",
            ordinal = 0
        )
    )
    private boolean onUse$ItemStack$isOf(ItemStack instance, Item item) {
        return instance.isIn(MoreItemTags.SHEARS);
    }
}
