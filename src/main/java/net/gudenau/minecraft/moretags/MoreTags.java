package net.gudenau.minecraft.moretags;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.gudenau.minecraft.moretags.mixins.block.farmland.VillagerProfessionAccessor;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;

import java.util.List;
import java.util.stream.Stream;

/**
 * The entrypoint of MoreTags. Provides a couple of generic tag helper methods.
 */
public final class MoreTags implements ModInitializer {
    /**
     * @hidden The common tag namespace, yes this is overkill but javac inlines it anyway.
     */
    static final String COMMON_NAMESPACE = "c";
    
    /**
     * @hidden The Fabric entrypoint, used here to ensure &lt;clinit&gt; is run and to fix Villagers.
     */
    @Override
    public void onInitialize() {
        MoreBlockTags.init();
        MoreItemTags.init();
        
        ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
            // Support for farmland, Vanilla assumes it will always be a specific block, and we change that during runtime
            ((VillagerProfessionAccessor) VillagerProfession.FARMER).setSecondaryJobSites(ImmutableSet.copyOf(MoreBlockTags.listTagEntries(MoreBlockTags.FARMLAND)));
        });
    }
    
    /**
     * Returns a {@link Stream<T>} that contains all entries in the provided tag.
     *
     * @param registry The registry for the entry type
     * @param tag The tag to query
     * @param <T> The type of entry
     * @return A {@link Stream<T>}
     */
    public static <T> Stream<T> streamTagEntries(Registry<T> registry, TagKey<T> tag) {
        return registry.getOrCreateEntryList(tag).stream()
            .map(RegistryEntry::value);
    }
    
    /**
     * Returns a {@link List<T>} that contains all entries in the provided tag.
     *
     * @param registry The registry for the entry type
     * @param tag The tag to query
     * @param <T> The type of entry
     * @return A {@link List<T>}
     */
    public static <T> List<T> listTagEntries(Registry<T> registry, TagKey<T> tag) {
        return streamTagEntries(registry, tag).toList();
    }
}
