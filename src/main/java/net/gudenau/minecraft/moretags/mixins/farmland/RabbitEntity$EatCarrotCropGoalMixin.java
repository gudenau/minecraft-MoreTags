package net.gudenau.minecraft.moretags.mixins.farmland;

import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal")
public abstract class RabbitEntity$EatCarrotCropGoalMixin{
    @Redirect(
        method = "isTargetPos",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
        )
    )
    private boolean isTargetFarmland(BlockState blockState, Block block){
        return blockState.isIn(MoreTags.FARMLAND);
    }
}
