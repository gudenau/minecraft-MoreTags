package net.gudenau.minecraft.moretags.mixins.bookshelves;

import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.screen.EnchantmentScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentScreenHandler.class)
public abstract class EnchantmentScreenHandlerMixin{
    @Redirect(
        method = "method_17411(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
        ),
        expect = 6
    )
    private boolean onContentChanged$BlockState$isOf(BlockState blockState, Block block){
        return MoreTags.BOOKSHELVES.contains(blockState.getBlock());
    }
}
