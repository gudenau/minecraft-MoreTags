package net.gudenau.minecraft.moretags.mixins.item.shears;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import java.util.Map;
import net.gudenau.minecraft.moretags.MoreItemTags;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Allows the shears tag to manipulate how dispensers work.
 */
@Mixin(DispenserBlock.class)
public abstract class DispenserBlockMixin {
    @Shadow @Final private static Map<Item, DispenserBehavior> BEHAVIORS;
    
    @Inject(
        method = "getBehaviorForItem",
        at = @At("HEAD"),
        cancellable = true
    )
    private void getBehaviorForItem(ItemStack stack, CallbackInfoReturnable<DispenserBehavior> cir) {
        if (stack.isIn(MoreItemTags.SHEARS)) {
            cir.setReturnValue(BEHAVIORS.get(Items.SHEARS));
        } else if (stack.getItem() == Items.SHEARS) {
            cir.setReturnValue(((Object2ObjectMap<Item, DispenserBehavior>) BEHAVIORS).defaultReturnValue());
        }
    }
}
