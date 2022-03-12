package net.gudenau.minecraft.moretags.mixins.farmland;

import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PlantBlock.class, priority = 1001)
public abstract class PlantBlockMixin {
    @Inject(
        method = "canPlantOnTop",
        at = @At("RETURN"),
        cancellable = true
    )
    private void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() || floor.isIn(MoreTags.FARMLAND));
    }
}
