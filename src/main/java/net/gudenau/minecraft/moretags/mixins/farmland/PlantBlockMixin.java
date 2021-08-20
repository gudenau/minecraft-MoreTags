package net.gudenau.minecraft.moretags.mixins.farmland;

import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlantBlock.class)
public abstract class PlantBlockMixin{
    @Redirect(
        method = "canPlantOnTop",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
        )
    )
    private boolean canPlantOnTop(BlockState blockState, Block block){
        return blockState.isIn(MoreTags.FARMLAND);
    }
}
