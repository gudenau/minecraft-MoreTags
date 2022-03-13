package net.gudenau.minecraft.moretags.mixins.item.shears;

import net.gudenau.minecraft.moretags.MoreItemTags;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin {
    @Redirect(
        method = "interactMob",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
        )
    )
    private boolean interactMob$ItemStack$isOf(ItemStack instance, Item item) {
        return instance.isIn(MoreItemTags.SHEARS);
    }
}
