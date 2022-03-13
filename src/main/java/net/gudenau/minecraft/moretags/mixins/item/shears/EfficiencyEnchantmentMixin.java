package net.gudenau.minecraft.moretags.mixins.item.shears;

import net.gudenau.minecraft.moretags.MoreItemTags;
import net.minecraft.enchantment.EfficiencyEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EfficiencyEnchantment.class)
public abstract class EfficiencyEnchantmentMixin extends Enchantment {
    private EfficiencyEnchantmentMixin() {
        super(null, null, null);
    }
    
    @Inject(
        method = "isAcceptableItem",
        at = @At("HEAD"),
        cancellable = true
    )
    private void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if(stack.isIn(MoreItemTags.SHEARS)){
            cir.setReturnValue(true);
        }else if(stack.getItem() == Items.SHEARS){
            cir.setReturnValue(super.isAcceptableItem(stack));
        }
    }
}
