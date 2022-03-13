package net.gudenau.minecraft.moretags.mixins.block.farmland;

import net.gudenau.minecraft.moretags.MoreBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StemBlock;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StemBlock.class)
public abstract class StemBlockMixin {
    @Inject(
        method = "canPlantOnTop",
        at = @At("HEAD"),
        cancellable = true
    )
    private void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(floor.isIn(MoreBlockTags.FARMLAND));
    }
    
    @Redirect(
        method = "randomTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
        )
    )
    private boolean randomTick$BlockState$isOf(BlockState instance, Block block) {
        return instance.isIn(MoreBlockTags.PLANTABLE_BLOCKS);
    }
    
    @Redirect(
        method = "randomTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/tag/TagKey;)Z"
        )
    )
    private boolean randomTick$BlockState$isOf(BlockState instance, TagKey<Block> tagKey) {
        return false;
    }
}
