package net.gudenau.minecraft.moretags.mixins.farmland;

import com.google.common.collect.ImmutableSet;
import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.Block;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VillagerProfession.class)
public abstract class VillagerProfessionMixin {
    @Shadow
    @Mutable
    @Final
    private ImmutableSet<Block> secondaryJobSites;

    @Shadow
    @Final
    public static VillagerProfession FARMER;

    static {
        ((VillagerProfessionMixin) (Object) FARMER).secondaryJobSites = ImmutableSet.<Block>builder()
                .addAll(((VillagerProfessionMixin) (Object) FARMER).secondaryJobSites)
                .addAll(MoreTags.FARMLAND.values())
                .build();
    }
}
