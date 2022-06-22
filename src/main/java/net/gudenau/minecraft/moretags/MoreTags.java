package net.gudenau.minecraft.moretags;

import java.util.List;
import java.util.stream.Stream;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.gudenau.minecraft.moretags.util.Compatibility;
import net.gudenau.minecraft.moretags.util.Hacks;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.village.VillagerProfession;

/**
 * The entrypoint of MoreTags. Provides a couple of generic tag helper methods.
 */
public final class MoreTags implements ModInitializer {
    /**
     * The common tag namespace, yes this is overkill but javac inlines it anyway.
     *
     * @hidden
     */
    static final String COMMON_NAMESPACE = "c";
    
    /**
     * The Fabric entrypoint, used here to ensure &lt;clinit&gt; is run and to fix Villagers.
     *
     * @hidden
     */
    @Override
    public void onInitialize() {
        Hacks.init();
        MoreBlockTags.init();
        MoreItemTags.init();
        
        ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
            // Support for farmland, Vanilla assumes it will always be a specific block, and we change that during runtime
            Compatibility.overrideVillagerJobSites(VillagerProfession.FARMER, MoreBlockTags.listTagEntries(MoreBlockTags.FARMLAND));
        });
    }
    
    /**
     * Returns a {@link Stream} that contains all entries in the provided tag.
     *
     * @param registry The registry for the entry type
     * @param tag The tag to query
     * @param <T> The type of entry
     * @return A {@link Stream}
     */
    public static <T> Stream<T> streamTagEntries(Registry<T> registry, TagKey<T> tag) {
        return registry.getOrCreateEntryList(tag).stream()
            .map(RegistryEntry::value);
    }
    
    /**
     * Returns a {@link List} that contains all entries in the provided tag.
     *
     * @param registry The registry for the entry type
     * @param tag The tag to query
     * @param <T> The type of entry
     * @return A {@link List}
     */
    public static <T> List<T> listTagEntries(Registry<T> registry, TagKey<T> tag) {
        return streamTagEntries(registry, tag).toList();
    }
}
