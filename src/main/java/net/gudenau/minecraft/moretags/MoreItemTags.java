package net.gudenau.minecraft.moretags;

import static net.gudenau.minecraft.moretags.MoreTags.COMMON_NAMESPACE;

import java.util.List;
import java.util.stream.Stream;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * All of the item tags that this mod provides as well as a couple item tag helpers.
 */
@SuppressWarnings("unused")
public final class MoreItemTags {
    /**
     * A simple guard constructor.
     *
     * @hidden
     */
    private MoreItemTags() {
        throw new RuntimeException("No MoreItemTags for you!");
    }
    
    /**
     * Contains all skull items.
     *
     * <p>Default entries:
     * <ul>
     * <li>{@link Items#SKELETON_SKULL minecraft:skeleton_skull}</li>
     * <li>{@link Items#WITHER_SKELETON_SKULL minecraft:wither_skeleton_skull}</li>
     * <li>{@link Items#ZOMBIE_HEAD minecraft:zombie_head}</li>
     * <li>{@link Items#PLAYER_HEAD minecraft:player_head}</li>
     * <li>{@link Items#CREEPER_HEAD minecraft:creeper_head}</li>
     * <li>{@link Items#DRAGON_HEAD minecraft:dragon_head}</li>
     * </ul>
     */
    public static final TagKey<Item> SKULLS = createTag("skulls");
    
    /**
     * Contains all sheer items.
     *
     * <p>Modifies the behavior of the following classes:
     * <ul>
     * <li>{@link net.minecraft.block.BeehiveBlock}</li>
     * <li>{@link net.minecraft.block.DispenserBlock}</li>
     * <li>{@link net.minecraft.enchantment.EfficiencyEnchantment}</li>
     * <li>{@link net.minecraft.entity.passive.MooshroomEntity}</li>
     * <li>{@link net.minecraft.block.PumpkinBlock}</li>
     * <li>{@link net.minecraft.entity.passive.SheepEntity}</li>
     * <li>{@link net.minecraft.entity.passive.SnowGolemEntity}</li>
     * <li>{@link net.minecraft.block.TripwireBlock}</li>
     * </ul>
     *
     * <p>Default entries:
     * <ul>
     * <li>{@link Items#SHEARS minecraft:shears}</li>
     * </ul>
     */
    public static final TagKey<Item> SHEARS = createTag("shears");
    
    /**
     * Creates a new {@link TagKey} in the common tag namespace.
     *
     * @hidden
     *
     * @param name The name of the new {@link TagKey}
     * @return The new {@link TagKey}
     */
    private static TagKey<Item> createTag(String name) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(COMMON_NAMESPACE, name));
    }
    
    /**
     * Ensures that &lt;clinit&gt; runs.
     *
     * @hidden
     */
    static void init() {}
    
    /**
     * Returns a {@link Stream} that contains all {@link Item}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link Stream}
     */
    public static Stream<Item> streamTagEntries(TagKey<Item> tag) {
        return MoreTags.streamTagEntries(Registry.ITEM, tag);
    }
    
    /**
     * Returns a {@link List} that contains all {@link Item}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link List}
     */
    public static List<Item> listTagEntries(TagKey<Item> tag) {
        return MoreTags.listTagEntries(Registry.ITEM, tag);
    }
}
