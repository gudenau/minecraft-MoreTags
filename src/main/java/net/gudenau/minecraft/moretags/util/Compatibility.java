package net.gudenau.minecraft.moretags.util;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.block.Block;
import net.minecraft.village.VillagerProfession;

/**
 * Where all of the dirty compatibility hacks reside.
 */
public final class Compatibility {
    private static final BiConsumer<VillagerProfession, Collection<Block>> jobSiteOverride = getJobSiteHandler();
    
    private static BiConsumer<VillagerProfession, Collection<Block>> getJobSiteHandler() {
        var fieldNames = List.of(
            // Pre 1.19
            "field_18880",
            // Post 1.19
            "comp_822",
            // Development
            "secondaryJobSites"
        );
        
        var setter = Hacks.findSetter(VillagerProfession.class, fieldNames, ImmutableSet.class);
        return (profession, secondary) -> {
            try {
                setter.invokeExact(profession, ImmutableSet.copyOf(secondary));
            } catch (Throwable t) {
                throw new RuntimeException("Failed to update villager profession");
            }
        };
    }
    
    public static void overrideVillagerJobSites(VillagerProfession profession, List<Block> secondary) {
        jobSiteOverride.accept(profession, secondary);
    }
}
