package net.gudenau.minecraft.moretags.mixins.block.farmland;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VillagerProfession.class)
public interface VillagerProfessionAccessor {
    @Accessor @Mutable void setSecondaryJobSites(ImmutableSet<Block> value);
}
