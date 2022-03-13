package net.gudenau.minecraft.moretags;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.stream.Stream;

import static net.gudenau.minecraft.moretags.MoreTags.COMMON_NAMESPACE;

/**
 * All of the item tags that this mod provides as well as a couple item tag helpers.
 */
//@SuppressWarnings("unused")
public final class MoreItemTags {
    /**
     * @hidden A simple guard constructor.
     */
    private MoreItemTags() {
        throw new RuntimeException("No MoreItemTags for you!");
    }
    
    /**
     * Contains all skull items.
     *
     * Default entries:
     * - minecraft:skeleton_skull
     * - minecraft:wither_skeleton_skull
     * - minecraft:zombie_head
     * - minecraft:player_head
     * - minecraft:creeper_head
     * - minecraft:dragon_head
     */
    public static final TagKey<Item> SKULLS = createTag("skulls");
    
    /**
     * Contains all sheer items.
     *
     * Modifies the behavior of the following classes:
     * - {@link net.minecraft.block.BeehiveBlock}
     * - {@link net.minecraft.block.DispenserBlock}
     * - {@link net.minecraft.enchantment.EfficiencyEnchantment}
     * - {@link net.minecraft.entity.passive.MooshroomEntity}
     * - {@link net.minecraft.block.PumpkinBlock}
     * - {@link net.minecraft.entity.passive.SheepEntity}
     * - {@link net.minecraft.entity.passive.SnowGolemEntity}
     * - {@link net.minecraft.block.TripwireBlock}
     *
     * Default entries:
     * - minecraft:shears
     */
    public static final TagKey<Item> SHEARS = createTag("shears");
    
    /**
     * @hidden Creates a new {@link TagKey<Item>} in the common tag namespace.
     *
     * @param name The name of the new {@link TagKey<Item>}
     * @return The new {@link TagKey<Item>}
     */
    private static TagKey<Item> createTag(String name) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(COMMON_NAMESPACE, name));
    }
    
    /**
     * @hidden Ensures that &lt;clinit&gt; runs.
     */
    static void init() {}
    
    /**
     * Returns a {@link Stream<Item>} that contains all {@link Item}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link Stream<Item>}
     */
    public static Stream<Item> streamTagEntries(TagKey<Item> tag) {
        return MoreTags.streamTagEntries(Registry.ITEM, tag);
    }
    
    /**
     * Returns a {@link List<Item>} that contains all {@link Item}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link List<Item>}
     */
    public static List<Item> listTagEntries(TagKey<Item> tag) {
        return MoreTags.listTagEntries(Registry.ITEM, tag);
    }
}
