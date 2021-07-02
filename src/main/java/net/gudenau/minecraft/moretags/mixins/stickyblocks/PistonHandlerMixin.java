package net.gudenau.minecraft.moretags.mixins.stickyblocks;

import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonHandler.class)
public abstract class PistonHandlerMixin{
    @Shadow private static boolean isBlockSticky(BlockState state){return false;}
    
    @Inject(
        method = "isBlockSticky",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void isBlockSticky(BlockState state, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(MoreTags.STICKY_BLOCKS.contains(state.getBlock()));
    }
    
    @Inject(
        method = "isAdjacentBlockStuck",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void isAdjacentBlockStuck(BlockState state, BlockState adjacentState, CallbackInfoReturnable<Boolean> cir){
        var block = state.getBlock();
        var adjacentBlock = adjacentState.getBlock();
        
        if(block != adjacentBlock && MoreTags.HONEY_BLOCKS.contains(block) && MoreTags.SLIME_BLOCKS.contains(adjacentBlock)){
            cir.setReturnValue(true);
        }else if(MoreTags.SLIME_BLOCKS.contains(adjacentBlock) && MoreTags.HONEY_BLOCKS.contains(block)){
            cir.setReturnValue(false);
        }else{
            cir.setReturnValue(isBlockSticky(state) || isBlockSticky(adjacentState));
        }
    }
}
