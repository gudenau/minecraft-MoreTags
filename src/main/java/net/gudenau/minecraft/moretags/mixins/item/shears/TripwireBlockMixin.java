package net.gudenau.minecraft.moretags.mixins.item.shears;

import net.gudenau.minecraft.moretags.MoreItemTags;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.block.TripwireBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TripwireBlock.class)
public abstract class TripwireBlockMixin {
    @Redirect(
        method = "onBreak",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        )
    )
    private boolean onBreak$ItemStack$isOf(ItemStack instance, Item item) {
        return instance.isIn(MoreItemTags.SHEARS);
    }
}
