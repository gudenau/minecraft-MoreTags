package net.gudenau.minecraft.moretags;

import net.minecraft.block.*;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.stream.Stream;

import static net.gudenau.minecraft.moretags.MoreTags.COMMON_NAMESPACE;

/**
 * All of the block tags that this mod provides as well as a couple block tag helpers.
 */
@SuppressWarnings("unused")
public final class MoreBlockTags {
    /**
     * @hidden A simple guard constructor.
     */
    private MoreBlockTags() {
        throw new RuntimeException("No MoreBlockTags for you!");
    }
    
    /**
     * Contains all blocks that can support plants being planted on them.
     *
     * This tag influences the behavior of the following classes:
     * - {@link PlantBlock}
     * - {@link StemBlock}
     *
     * Default entries:
     * - #minecraft:dirt
     * - #c:farmland
     */
    public static final TagKey<Block> PLANTABLE_BLOCKS = createTag("plantable_blocks");
    
    /**
     * Contains all blocks that can be used as enchanting bookshelves. This includes the particle effects and boosting
     * the enchanting level.
     *
     * This tag influences the behavior of {@link EnchantingTableBlock}.
     *
     * Default entries:
     * - minecraft:bookshelf
     */
    public static final TagKey<Block> BOOKSHELVES = createTag("bookshelves");
    
    /**
     * Contains all blocks that should be considered an "ore".
     *
     * Default entries:
     * - #minecraft:coal_ores
     * - #minecraft:copper_ores
     * - #minecraft:diamond_ores
     * - #minecraft:emerald_ores
     * - #minecraft:gold_ores
     * - #minecraft:iron_ores
     * - #minecraft:lapis_ores
     * - #minecraft:redstone_ores
     * - minecraft:ancient_debris
     * - minecraft:nether_quartz_ore
     */
    public static final TagKey<Block> ORES = createTag("ores");
    
    /**
     * Contains all wood blocks that the user has stripped by right-clicking with an axe.
     *
     * Default entries:
     * - #c:stripped_logs
     * - #c:stripped_bark
     */
    public static final TagKey<Block> STRIPPED_WOOD = createTag("stripped_wood");
    
    /**
     * Contains all log blocks that the user has stripped by right-clicking with an axe.
     *
     * Default entries:
     * - minecraft:stripped_spruce_log
     * - minecraft:stripped_birch_log
     * - minecraft:stripped_jungle_log
     * - minecraft:stripped_acacia_log
     * - minecraft:stripped_dark_oak_log
     * - minecraft:stripped_oak_log
     */
    public static final TagKey<Block> STRIPPED_LOGS = createTag("stripped_logs");
    
    /**
     * Contains all bark blocks that the user has stripped by right-clicking with an axe.
     *
     * Default entries:
     * - minecraft:stripped_spruce_wood
     * - minecraft:stripped_birch_wood
     * - minecraft:stripped_jungle_wood
     * - minecraft:stripped_acacia_wood
     * - minecraft:stripped_dark_oak_wood
     * - minecraft:stripped_oak_wood
     */
    public static final TagKey<Block> STRIPPED_BARK = createTag("stripped_bark");
    
    /**
     * Contains all wood blocks that the user has <b>not</b> stripped by right-clicking with an axe.
     *
     * Default entries:
     * - #c:dressed_logs
     * - #c:dressed_bark
     */
    public static final TagKey<Block> DRESSED_WOOD = createTag("dressed_wood");
    
    /**
     * Contains all log blocks that the user has <b>not</b> stripped by right-clicking with an axe.
     *
     * Default entries:
     * - minecraft:spruce_log
     * - minecraft:birch_log
     * - minecraft:jungle_log
     * - minecraft:acacia_log
     * - minecraft:dark_oak_log
     * - minecraft:oak_log
     */
    public static final TagKey<Block> DRESSED_LOGS = createTag("dressed_logs");
    
    /**
     * Contains all bark blocks that the user has <b>not</b> stripped by right-clicking with an axe.
     *
     * Default entries:
     * - minecraft:spruce_wood
     * - minecraft:birch_wood
     * - minecraft:jungle_wood
     * - minecraft:acacia_wood
     * - minecraft:dark_oak_wood
     * - minecraft:oak_wood
     */
    public static final TagKey<Block> DRESSED_BARK = createTag("dressed_bark");
    
    /**
     * Contains all glass blocks, including glass panes.
     *
     * Default entries:
     * - #c:glass_blocks
     * - #c:glass_panes
     */
    public static final TagKey<Block> GLASS = createTag("glass");
    
    /**
     * Contains all glass blocks, excluding glass panes.
     *
     * Default entries:
     * - minecraft:glass
     * - minecraft:white_stained_glass
     * - minecraft:orange_stained_glass
     * - minecraft:magenta_stained_glass
     * - minecraft:light_blue_stained_glass
     * - minecraft:yellow_stained_glass
     * - minecraft:lime_stained_glass
     * - minecraft:pink_stained_glass
     * - minecraft:gray_stained_glass
     * - minecraft:light_gray_stained_glass
     * - minecraft:cyan_stained_glass
     * - minecraft:purple_stained_glass
     * - minecraft:blue_stained_glass
     * - minecraft:brown_stained_glass
     * - minecraft:green_stained_glass
     * - minecraft:red_stained_glass
     * - minecraft:black_stained_glass
     * - minecraft:tinted_glass
     */
    public static final TagKey<Block> GLASS_BLOCKS = createTag("glass_blocks");
    
    /**
     * Contains all glass panes.
     *
     * Default entries:
     * - minecraft:glass_pane
     * - minecraft:white_stained_glass_pane
     * - minecraft:orange_stained_glass_pane
     * - minecraft:magenta_stained_glass_pane
     * - minecraft:light_blue_stained_glass_pane
     * - minecraft:yellow_stained_glass_pane
     * - minecraft:lime_stained_glass_pane
     * - minecraft:pink_stained_glass_pane
     * - minecraft:gray_stained_glass_pane
     * - minecraft:light_gray_stained_glass_pane
     * - minecraft:cyan_stained_glass_pane
     * - minecraft:purple_stained_glass_pane
     * - minecraft:blue_stained_glass_pane
     * - minecraft:brown_stained_glass_pane
     * - minecraft:green_stained_glass_pane
     * - minecraft:red_stained_glass_pane
     * - minecraft:black_stained_glass_pane
     */
    public static final TagKey<Block> GLASS_PANES = createTag("glass_panes");
    
    /**
     * Contains all chest blocks.
     *
     * Default entries:
     * - minecraft:chest
     * - minecraft:trapped_chest
     * - minecraft:ender_chest
     */
    public static final TagKey<Block> CHESTS = createTag("chests");
    
    /**
     * Contains all brick blocks.
     *
     * Default entries:
     * - #minecraft:stone_bricks
     * - minecraft:bricks
     */
    public static final TagKey<Block> BRICKS = createTag("bricks");
    
    /**
     * Contains all Silverfish-infested blocks.
     *
     * Default entries:
     * - minecraft:infested_stone
     * - minecraft:infested_cobblestone
     * - minecraft:infested_stone_bricks
     * - minecraft:infested_mossy_stone_bricks
     * - minecraft:infested_cracked_stone_bricks
     * - minecraft:infested_chiseled_stone_bricks
     * - minecraft:infested_deepslate
     */
    public static final TagKey<Block> INFESTED = createTag("infested");
    
    /**
     * Contains all skull and head blocks.
     *
     * Default entries:
     * - #c:floor_skulls
     * - #c:wall_skulls
     */
    public static final TagKey<Block> SKULLS = createTag("skulls");
    
    /**
     * Contains all skull and head blocks that get placed on walls.
     *
     * Default entries:
     * - minecraft:skeleton_wall_skull
     * - minecraft:wither_skeleton_wall_skull
     * - minecraft:zombie_wall_head
     * - minecraft:player_wall_head
     * - minecraft:creeper_wall_head
     * - minecraft:dragon_wall_head
     */
    public static final TagKey<Block> WALL_SKULLS = createTag("wall_skulls");
    
    /**
     * Contains all skull and head blocks that get place on the floor.
     *
     * Default entries:
     * - minecraft:skeleton_skull
     * - minecraft:wither_skeleton_skull
     * - minecraft:zombie_head
     * - minecraft:player_head
     * - minecraft:creeper_head
     * - minecraft:dragon_head
     */
    public static final TagKey<Block> FLOOR_SKULLS = createTag("floor_skulls");
    
    /**
     * Contains all dynamic blocks that either receive or power redstone devices that are not gates or dust.
     *
     * Default entries:
     * - minecraft:dispenser
     * - minecraft:daylight_detector
     * - minecraft:dropper
     * - minecraft:hopper
     * - minecraft:redstone_torch
     * - #c:redstone_rails
     * - #c:pistons
     * - minecraft:sculk_sensor
     */
    public static final TagKey<Block> REDSTONE_DEVICES = createTag("redstone_devices");
    
    /**
     * Contains all rail blocks that either recieve or power redstone devices.
     *
     * Default entries:
     * - minecraft:activator_rail
     * - minecraft:powered_rail
     * - minecraft:detector_rail
     */
    public static final TagKey<Block> REDSTONE_RAILS = createTag("redstone_rails");
    
    /**
     * Contains all redstone dust blocks.
     *
     * Default entries:
     * - minecraft:redstone_dust
     */
    public static final TagKey<Block> REDSTONE_DUST = createTag("redstone_dust");
    
    /**
     * Contains all redstone related blocks.
     *
     * Default entries:
     * - minecraft:redstone_block
     * - #c:redstone_wire
     * - #c:redstone_devices
     * - #c:redstone_gates
     */
    public static final TagKey<Block> REDSTONE = createTag("redstone");
    
    /**
     * Contains all piston blocks.
     *
     * Default entries:
     * - minecraft:piston
     * - minecraft:sticky_piston
     * - minecraft:piston_head
     */
    public static final TagKey<Block> PISTONS = createTag("pistons");
    
    /**
     * Contains all redstone "gate" blocks.
     *
     * Default entries:
     * - minecraft:repeater
     * - minecraft:comparator
     */
    public static final TagKey<Block> REDSTONE_GATES = createTag("redstone_gates");
    
    /**
     * Contains all raw terracotta blocks.
     *
     * Default entries:
     * - minecraft:white_terracotta
     * - minecraft:orange_terracotta
     * - minecraft:magenta_terracotta
     * - minecraft:light_blue_terracotta
     * - minecraft:yellow_terracotta
     * - minecraft:lime_terracotta
     * - minecraft:pink_terracotta
     * - minecraft:gray_terracotta
     * - minecraft:light_gray_terracotta
     * - minecraft:cyan_terracotta
     * - minecraft:purple_terracotta
     * - minecraft:blue_terracotta
     * - minecraft:brown_terracotta
     * - minecraft:green_terracotta
     * - minecraft:red_terracotta
     * - minecraft:black_terracotta
     */
    public static final TagKey<Block> TERRACOTTA = createTag("terracotta");
    
    /**
     * Contains all glazed terracotta blocks.
     *
     * Default entries:
     * - minecraft:white_glazed_terracotta
     * - minecraft:orange_glazed_terracotta
     * - minecraft:magenta_glazed_terracotta
     * - minecraft:light_blue_glazed_terracotta
     * - minecraft:yellow_glazed_terracotta
     * - minecraft:lime_glazed_terracotta
     * - minecraft:pink_glazed_terracotta
     * - minecraft:gray_glazed_terracotta
     * - minecraft:light_gray_glazed_terracotta
     * - minecraft:cyan_glazed_terracotta
     * - minecraft:purple_glazed_terracotta
     * - minecraft:blue_glazed_terracotta
     * - minecraft:brown_glazed_terracotta
     * - minecraft:green_glazed_terracotta
     * - minecraft:red_glazed_terracotta
     * - minecraft:black_glazed_terracotta
     */
    public static final TagKey<Block> GLAZED_TERRACOTTA = createTag("glazed_terracotta");
    
    /**
     * Contains all terracotta blocks, both raw and glazed.
     *
     * Default entries:
     * - #c:terracotta
     * - #c:glazed_terracotta
     */
    public static final TagKey<Block> TERRACOTTA_BLOCKS = createTag("terracotta_blocks");
    
    /**
     * Contains all sticky blocks. Sticky blocks are blocks that pistons can use to move multiple blocks at a time.
     *
     * This tag influences the behavior of the following classes:
     * - {@link net.minecraft.block.piston.PistonHandler}
     *
     * Default entries:
     * - #c:slime_blocks
     * - #c:honey_blocks
     */
    public static final TagKey<Block> STICKY_BLOCKS = createTag("sticky_blocks");
    
    /**
     * Contains all honey blocks.
     *
     * This tag influences the behavior of the following classes:
     * - {@link net.minecraft.block.piston.PistonHandler}
     *
     * Default entries:
     * - minecraft:honey_block
     */
    public static final TagKey<Block> HONEY_BLOCKS = createTag("honey_blocks");
    
    /**
     * Contains all slime blocks.
     *
     * This tag influences the behavior of the following classes:
     * - {@link net.minecraft.block.piston.PistonHandler}
     *
     * Default entries:
     * - minecraft:slime_block
     */
    public static final TagKey<Block> SLIME_BLOCKS = createTag("slime_blocks");
    
    /**
     * Contains all concrete blocks, does not contain the powder variants.
     *
     * Default entries:
     * - minecraft:white_concrete
     * - minecraft:orange_concrete
     * - minecraft:magenta_concrete
     * - minecraft:light_blue_concrete
     * - minecraft:yellow_concrete
     * - minecraft:lime_concrete
     * - minecraft:pink_concrete
     * - minecraft:gray_concrete
     * - minecraft:light_gray_concrete
     * - minecraft:cyan_concrete
     * - minecraft:purple_concrete
     * - minecraft:blue_concrete
     * - minecraft:brown_concrete
     * - minecraft:green_concrete
     * - minecraft:red_concrete
     * - minecraft:black_concrete
     */
    public static final TagKey<Block> CONCRETE = createTag("concrete");
    
    /**
     * Contains all concrete powder blocks.
     *
     * Default entries:
     * - minecraft:white_concrete_powder
     * - minecraft:orange_concrete_powder
     * - minecraft:magenta_concrete_powder
     * - minecraft:light_blue_concrete_powder
     * - minecraft:yellow_concrete_powder
     * - minecraft:lime_concrete_powder
     * - minecraft:pink_concrete_powder
     * - minecraft:gray_concrete_powder
     * - minecraft:light_gray_concrete_powder
     * - minecraft:cyan_concrete_powder
     * - minecraft:purple_concrete_powder
     * - minecraft:blue_concrete_powder
     * - minecraft:brown_concrete_powder
     * - minecraft:green_concrete_powder
     * - minecraft:red_concrete_powder
     * - minecraft:black_concrete_powder
     */
    public static final TagKey<Block> CONCRETE_POWDER = createTag("concrete_powder");
    
    /**
     * Contains all farmland blocks.
     *
     * This tag influences the behavior of the following classes:
     * - {@link CropBlock}
     * - {@link net.minecraft.entity.passive.RabbitEntity.EatCarrotCropGoal}
     * - {@link StemBlock}
     *
     * This tag influences the behavior of {@link net.minecraft.village.VillagerProfession#FARMER farmer Villagers}.
     *
     * Default entries:
     * - #c:moist_farmland
     * - minecraft:farmland
     */
    @SuppressWarnings("JavadocReference")
    public static final TagKey<Block> FARMLAND = createTag("farmland");
    
    /**
     * Contains all moist farmland blocks:
     *
     * This tag influences the behavior of the following classes:
     * - {@link CropBlock}
     *
     * Default entries:
     */
    public static final TagKey<Block> MOIST_FARMLAND = createTag("moist_farmland");
    
    /**
     * @hidden Creates a new {@link TagKey<Block>} in the common tag namespace.
     *
     * @param name The name of the new {@link TagKey<Block>}
     * @return The new {@link TagKey<Block>}
     */
    private static TagKey<Block> createTag(String name) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(COMMON_NAMESPACE, name));
    }
    
    /**
     * @hidden Ensures that &lt;clinit&gt; runs.
     */
    static void init() {}
    
    /**
     * Returns a {@link Stream<Block>} that contains all {@link Block}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link Stream<Block>}
     */
    public static Stream<Block> streamTagEntries(TagKey<Block> tag) {
        return MoreTags.streamTagEntries(Registry.BLOCK, tag);
    }
    
    /**
     * Returns a {@link List<Block>} that contains all {@link Block}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link List<Block>}
     */
    public static List<Block> listTagEntries(TagKey<Block> tag) {
        return MoreTags.listTagEntries(Registry.BLOCK, tag);
    }
}
