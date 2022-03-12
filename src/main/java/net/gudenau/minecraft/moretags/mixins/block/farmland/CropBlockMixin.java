package net.gudenau.minecraft.moretags.mixins.block.farmland;

import net.gudenau.minecraft.moretags.MoreBlockTags;
import net.minecraft.block.*;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CropBlock.class, priority = 1001)
public abstract class CropBlockMixin{
    @Redirect(
        method = "getAvailableMoisture",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
        ),
        slice = @Slice(
            from = @At("HEAD"),
            to = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"
            )
        )
    )
    private static boolean isBlockFarmland(BlockState blockState, Block block) {
        return blockState.isIn(MoreBlockTags.FARMLAND);
    }
    
    @Redirect(
        method = "getAvailableMoisture",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"
        )
    )
    private static Comparable<?> getFarmlandMoisture(BlockState blockState, Property<Integer> property) {
        if(blockState.contains(FarmlandBlock.MOISTURE)){
            return blockState.get(FarmlandBlock.MOISTURE);
        }else{
            return blockState.isIn(MoreBlockTags.MOIST_FARMLAND) ? FarmlandBlock.MAX_MOISTURE : 0;
        }
    }
    
    @Inject(
        method = "canPlantOnTop",
        at = @At("RETURN"),
        cancellable = true
    )
    private void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() || floor.isIn(MoreBlockTags.FARMLAND));
    }
}
