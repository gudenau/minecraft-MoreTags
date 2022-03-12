package net.gudenau.minecraft.moretags.mixins.bookshelves;

import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantingTableBlock.class)
public abstract class EnchantingTableBlockMixin {
    @Redirect(
        method = "canAccessBookshelf",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
        )
    )
    private static boolean canAccessBookshelf$BlockState$isOf(BlockState blockState, Block block) {
        return blockState.isIn(MoreTags.BOOKSHELVES);
    }
}
