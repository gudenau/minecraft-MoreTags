package net.gudenau.minecraft.moretags.mixins.block.bookshelves;

import net.gudenau.minecraft.moretags.MoreBlockTags;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantingTableBlock.class)
public abstract class EnchantingTableBlockMixin {
    @Inject(
        method = "canAccessBookshelf",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void canAccessBookshelf$BlockState$isOf(World world, BlockPos tablePos, BlockPos bookshelfOffset, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
            world.getBlockState(tablePos.add(bookshelfOffset)).isIn(MoreBlockTags.BOOKSHELVES) &&
            world.isAir(tablePos.add(bookshelfOffset.getX() / 2, bookshelfOffset.getY(), bookshelfOffset.getZ() / 2))
        );
    }
}
