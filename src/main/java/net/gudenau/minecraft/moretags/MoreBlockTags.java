package net.gudenau.minecraft.moretags;

import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
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
     * <p>
     * This tag influences the behavior of the following classes:
     * <ul>
     * <li>{@link PlantBlock}</li>
     * <li>{@link StemBlock}</li>
     * </ul>
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link BlockTags#DIRT #minecraft:dirt}</li>
     * <li>{@link #FARMLAND #c:farmland}</li>
     * </ul>
     */
    public static final TagKey<Block> PLANTABLE_BLOCKS = createTag("plantable_blocks");
    
    /**
     * Contains all blocks that can be used as enchanting bookshelves. This includes the particle effects and boosting
     * the enchanting level.
     * <p>
     * This tag influences the behavior of {@link EnchantingTableBlock}.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#BOOKSHELF minecraft:bookshelf}</li>
     * </ul>
     */
    public static final TagKey<Block> BOOKSHELVES = createTag("bookshelves");
    
    /**
     * Contains all blocks that should be considered an "ore".
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link BlockTags#COAL_ORES #minecraft:coal_ores}</li>
     * <li>{@link BlockTags#COPPER_ORES minecraft:copper_ores}</li>
     * <li>{@link BlockTags#DIAMOND_ORES minecraft:diamond_ores}</li>
     * <li>{@link BlockTags#EMERALD_ORES minecraft:emerald_ores}</li>
     * <li>{@link BlockTags#GOLD_ORES minecraft:gold_ores}</li>
     * <li>{@link BlockTags#IRON_ORES minecraft:iron_ores}</li>
     * <li>{@link BlockTags#LAPIS_ORES minecraft:lapis_ores}</li>
     * <li>{@link BlockTags#REDSTONE_ORES minecraft:redstone_ores}</li>
     * <li>{@link Blocks#ANCIENT_DEBRIS minecraft:ancient_debris}</li>
     * <li>{@link Blocks#NETHER_QUARTZ_ORE minecraft:nether_quartz_ore}</li>
     * </ul>
     */
    public static final TagKey<Block> ORES = createTag("ores");
    
    /**
     * Contains all wood blocks that the user has stripped by right-clicking with an axe.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link #STRIPPED_LOGS c:stripped_logs}</li>
     * <li>{@link #STRIPPED_BARK c:stripped_bark}</li>
     * </ul>
     */
    public static final TagKey<Block> STRIPPED_WOOD = createTag("stripped_wood");
    
    /**
     * Contains all log blocks that the user has stripped by right-clicking with an axe.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#STRIPPED_SPRUCE_LOG minecraft:stripped_spruce_log}</li>
     * <li>{@link Blocks#STRIPPED_BIRCH_LOG minecraft:stripped_birch_log}</li>
     * <li>{@link Blocks#STRIPPED_JUNGLE_LOG minecraft:stripped_jungle_log}</li>
     * <li>{@link Blocks#STRIPPED_ACACIA_LOG minecraft:stripped_acacia_log}</li>
     * <li>{@link Blocks#STRIPPED_DARK_OAK_LOG minecraft:stripped_dark_oak_log}</li>
     * <li>{@link Blocks#STRIPPED_OAK_LOG minecraft:stripped_oak_log}</li>
     * </ul>
     */
    public static final TagKey<Block> STRIPPED_LOGS = createTag("stripped_logs");
    
    /**
     * Contains all bark blocks that the user has stripped by right-clicking with an axe.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#STRIPPED_SPRUCE_WOOD minecraft:stripped_spruce_wood}</li>
     * <li>{@link Blocks#STRIPPED_BIRCH_WOOD minecraft:stripped_birch_wood}</li>
     * <li>{@link Blocks#STRIPPED_JUNGLE_WOOD minecraft:stripped_jungle_wood}</li>
     * <li>{@link Blocks#STRIPPED_ACACIA_WOOD minecraft:stripped_acacia_wood}</li>
     * <li>{@link Blocks#STRIPPED_DARK_OAK_WOOD minecraft:stripped_dark_oak_wood}</li>
     * <li>{@link Blocks#STRIPPED_OAK_WOOD minecraft:stripped_oak_wood}</li>
     * </ul>
     */
    public static final TagKey<Block> STRIPPED_BARK = createTag("stripped_bark");
    
    /**
     * Contains all wood blocks that the user has <b>not</b> stripped by right-clicking with an axe.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link #DRESSED_LOGS c:dressed_logs}</li>
     * <li>{@link #DRESSED_BARK c:dressed_bark}</li>
     * </ul>
     */
    public static final TagKey<Block> DRESSED_WOOD = createTag("dressed_wood");
    
    /**
     * Contains all log blocks that the user has <b>not</b> stripped by right-clicking with an axe.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#SPRUCE_LOG minecraft:spruce_log}</li>
     * <li>{@link Blocks#BIRCH_LOG minecraft:birch_log}</li>
     * <li>{@link Blocks#JUNGLE_LOG minecraft:jungle_log}</li>
     * <li>{@link Blocks#ACACIA_LOG minecraft:acacia_log}</li>
     * <li>{@link Blocks#DARK_OAK_LOG minecraft:dark_oak_log}</li>
     * <li>{@link Blocks#OAK_LOG minecraft:oak_log}</li>
     * </ul>
     */
    public static final TagKey<Block> DRESSED_LOGS = createTag("dressed_logs");
    
    /**
     * Contains all bark blocks that the user has <b>not</b> stripped by right-clicking with an axe.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#SPRUCE_WOOD minecraft:spruce_wood}</li>
     * <li>{@link Blocks#BIRCH_WOOD minecraft:birch_wood}</li>
     * <li>{@link Blocks#JUNGLE_WOOD minecraft:jungle_wood}</li>
     * <li>{@link Blocks#ACACIA_WOOD minecraft:acacia_wood}</li>
     * <li>{@link Blocks#DARK_OAK_WOOD minecraft:dark_oak_wood}</li>
     * <li>{@link Blocks#OAK_WOOD minecraft:oak_wood}</li>
     * </ul>
     */
    public static final TagKey<Block> DRESSED_BARK = createTag("dressed_bark");
    
    /**
     * Contains all glass blocks, including glass panes.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link #GLASS_BLOCKS c:glass_blocks}</li>
     * <li>{@link #GLASS_PANES c:glass_panes}</li>
     * </ul>
     */
    public static final TagKey<Block> GLASS = createTag("glass");
    
    /**
     * Contains all glass blocks, excluding glass panes.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#GLASS minecraft:glass}</li>
     * <li>{@link Blocks#WHITE_STAINED_GLASS minecraft:white_stained_glass}</li>
     * <li>{@link Blocks#ORANGE_STAINED_GLASS minecraft:orange_stained_glass}</li>
     * <li>{@link Blocks#MAGENTA_STAINED_GLASS minecraft:magenta_stained_glass}</li>
     * <li>{@link Blocks#LIGHT_BLUE_STAINED_GLASS minecraft:light_blue_stained_glass}</li>
     * <li>{@link Blocks#YELLOW_STAINED_GLASS minecraft:yellow_stained_glass}</li>
     * <li>{@link Blocks#LIME_STAINED_GLASS minecraft:lime_stained_glass}</li>
     * <li>{@link Blocks#PINK_STAINED_GLASS minecraft:pink_stained_glass}</li>
     * <li>{@link Blocks#GRAY_STAINED_GLASS minecraft:gray_stained_glass}</li>
     * <li>{@link Blocks#LIGHT_GRAY_STAINED_GLASS minecraft:light_gray_stained_glass}</li>
     * <li>{@link Blocks#CYAN_STAINED_GLASS minecraft:cyan_stained_glass}</li>
     * <li>{@link Blocks#PURPLE_STAINED_GLASS minecraft:purple_stained_glass}</li>
     * <li>{@link Blocks#BLUE_STAINED_GLASS minecraft:blue_stained_glass}</li>
     * <li>{@link Blocks#BROWN_STAINED_GLASS minecraft:brown_stained_glass}</li>
     * <li>{@link Blocks#GREEN_STAINED_GLASS minecraft:green_stained_glass}</li>
     * <li>{@link Blocks#RED_STAINED_GLASS minecraft:red_stained_glass}</li>
     * <li>{@link Blocks#BLACK_STAINED_GLASS minecraft:black_stained_glass}</li>
     * <li>{@link Blocks#TINTED_GLASS minecraft:tinted_glass}</li>
     * </ul>
     */
    public static final TagKey<Block> GLASS_BLOCKS = createTag("glass_blocks");
    
    /**
     * Contains all glass panes.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#GLASS_PANE minecraft:glass_pane}</li>
     * <li>{@link Blocks#WHITE_STAINED_GLASS_PANE minecraft:white_stained_glass_pane}</li>
     * <li>{@link Blocks#ORANGE_STAINED_GLASS_PANE minecraft:orange_stained_glass_pane}</li>
     * <li>{@link Blocks#MAGENTA_STAINED_GLASS_PANE minecraft:magenta_stained_glass_pane}</li>
     * <li>{@link Blocks#LIGHT_BLUE_STAINED_GLASS_PANE minecraft:light_blue_stained_glass_pane}</li>
     * <li>{@link Blocks#YELLOW_STAINED_GLASS_PANE minecraft:yellow_stained_glass_pane}</li>
     * <li>{@link Blocks#LIME_STAINED_GLASS_PANE minecraft:lime_stained_glass_pane}</li>
     * <li>{@link Blocks#PINK_STAINED_GLASS_PANE minecraft:pink_stained_glass_pane}</li>
     * <li>{@link Blocks#GRAY_STAINED_GLASS_PANE minecraft:gray_stained_glass_pane}</li>
     * <li>{@link Blocks#LIGHT_GRAY_STAINED_GLASS_PANE minecraft:light_gray_stained_glass_pane}</li>
     * <li>{@link Blocks#CYAN_STAINED_GLASS_PANE minecraft:cyan_stained_glass_pane}</li>
     * <li>{@link Blocks#PURPLE_STAINED_GLASS_PANE minecraft:purple_stained_glass_pane}</li>
     * <li>{@link Blocks#BLUE_STAINED_GLASS_PANE minecraft:blue_stained_glass_pane}</li>
     * <li>{@link Blocks#BROWN_STAINED_GLASS_PANE minecraft:brown_stained_glass_pane}</li>
     * <li>{@link Blocks#GREEN_STAINED_GLASS_PANE minecraft:green_stained_glass_pane}</li>
     * <li>{@link Blocks#RED_STAINED_GLASS_PANE minecraft:red_stained_glass_pane}</li>
     * <li>{@link Blocks#BLACK_STAINED_GLASS_PANE minecraft:black_stained_glass_pane}</li>
     * </ul>
     */
    public static final TagKey<Block> GLASS_PANES = createTag("glass_panes");
    
    /**
     * Contains all chest blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#CHEST minecraft:chest}</li>
     * <li>{@link Blocks#TRAPPED_CHEST minecraft:trapped_chest}</li>
     * <li>{@link Blocks#ENDER_CHEST minecraft:ender_chest}</li>
     * </ul>
     */
    public static final TagKey<Block> CHESTS = createTag("chests");
    
    /**
     * Contains all brick blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link BlockTags#STONE_BRICKS minecraft:stone_bricks}</li>
     * <li>{@link Blocks#BRICKS minecraft:bricks}</li>
     * </ul>
     */
    public static final TagKey<Block> BRICKS = createTag("bricks");
    
    /**
     * Contains all Silverfish-infested blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#INFESTED_STONE minecraft:infested_stone}</li>
     * <li>{@link Blocks#INFESTED_COBBLESTONE minecraft:infested_cobblestone}</li>
     * <li>{@link Blocks#INFESTED_STONE_BRICKS minecraft:infested_stone_bricks}</li>
     * <li>{@link Blocks#INFESTED_MOSSY_STONE_BRICKS minecraft:infested_mossy_stone_bricks}</li>
     * <li>{@link Blocks#INFESTED_CRACKED_STONE_BRICKS minecraft:infested_cracked_stone_bricks}</li>
     * <li>{@link Blocks#INFESTED_CHISELED_STONE_BRICKS minecraft:infested_chiseled_stone_bricks}</li>
     * <li>{@link Blocks#INFESTED_DEEPSLATE minecraft:infested_deepslate}</li>
     * </ul>
     */
    public static final TagKey<Block> INFESTED = createTag("infested");
    
    /**
     * Contains all skull and head blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link #FLOOR_SKULLS c:floor_skulls}</li>
     * <li>{@link #WALL_SKULLS c:wall_skulls}</li>
     * </ul>
     */
    public static final TagKey<Block> SKULLS = createTag("skulls");
    
    /**
     * Contains all skull and head blocks that get placed on walls.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#SKELETON_WALL_SKULL minecraft:skeleton_wall_skull}</li>
     * <li>{@link Blocks#WITHER_SKELETON_WALL_SKULL minecraft:wither_skeleton_wall_skull}</li>
     * <li>{@link Blocks#ZOMBIE_WALL_HEAD minecraft:zombie_wall_head}</li>
     * <li>{@link Blocks#PLAYER_WALL_HEAD minecraft:player_wall_head}</li>
     * <li>{@link Blocks#CREEPER_WALL_HEAD minecraft:creeper_wall_head}</li>
     * <li>{@link Blocks#DRAGON_WALL_HEAD minecraft:dragon_wall_head}</li>
     * </ul>
     */
    public static final TagKey<Block> WALL_SKULLS = createTag("wall_skulls");
    
    /**
     * Contains all skull and head blocks that get place on the floor.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#SKELETON_SKULL minecraft:skeleton_skull}</li>
     * <li>{@link Blocks#WITHER_SKELETON_SKULL minecraft:wither_skeleton_skull}</li>
     * <li>{@link Blocks#ZOMBIE_HEAD minecraft:zombie_head}</li>
     * <li>{@link Blocks#PLAYER_HEAD minecraft:player_head}</li>
     * <li>{@link Blocks#CREEPER_HEAD minecraft:creeper_head}</li>
     * <li>{@link Blocks#DRAGON_HEAD minecraft:dragon_head}</li>
     * </ul>
     */
    public static final TagKey<Block> FLOOR_SKULLS = createTag("floor_skulls");
    
    /**
     * Contains all dynamic blocks that either receive or power redstone devices that are not gates or dust.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#DISPENSER minecraft:dispenser}</li>
     * <li>{@link Blocks#DAYLIGHT_DETECTOR minecraft:daylight_detector}</li>
     * <li>{@link Blocks#DROPPER minecraft:dropper}</li>
     * <li>{@link Blocks#HOPPER minecraft:hopper}</li>
     * <li>{@link Blocks#REDSTONE_TORCH minecraft:redstone_torch}</li>
     * <li>{@link #REDSTONE_RAILS c:redstone_rails}</li>
     * <li>{@link #PISTONS c:pistons}</li>
     * <li>{@link Blocks#SCULK_SENSOR minecraft:sculk_sensor}</li>
     * </ul>
     */
    public static final TagKey<Block> REDSTONE_DEVICES = createTag("redstone_devices");
    
    /**
     * Contains all rail blocks that either recieve or power redstone devices.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#ACTIVATOR_RAIL minecraft:activator_rail}</li>
     * <li>{@link Blocks#POWERED_RAIL minecraft:powered_rail}</li>
     * <li>{@link Blocks#DETECTOR_RAIL minecraft:detector_rail}</li>
     * </ul>
     */
    public static final TagKey<Block> REDSTONE_RAILS = createTag("redstone_rails");
    
    /**
     * Contains all redstone dust blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#REDSTONE_WIRE minecraft:redstone_dust}</li>
     * </ul>
     */
    public static final TagKey<Block> REDSTONE_DUST = createTag("redstone_dust");
    
    /**
     * Contains all redstone related blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#REDSTONE_BLOCK minecraft:redstone_block}</li>
     * <li>{@link #REDSTONE_DUST c:redstone_dust}</li>
     * <li>{@link #REDSTONE_DEVICES c:redstone_devices}</li>
     * <li>{@link #REDSTONE_GATES c:redstone_gates}</li>
     * </ul>
     */
    public static final TagKey<Block> REDSTONE = createTag("redstone");
    
    /**
     * Contains all piston blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#PISTON minecraft:piston}</li>
     * <li>{@link Blocks#STICKY_PISTON minecraft:sticky_piston}</li>
     * <li>{@link Blocks#PISTON_HEAD minecraft:piston_head}</li>
     * </ul>
     */
    public static final TagKey<Block> PISTONS = createTag("pistons");
    
    /**
     * Contains all redstone "gate" blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#REPEATER minecraft:repeater}</li>
     * <li>{@link Blocks#COMPARATOR minecraft:comparator}</li>
     * </ul>
     */
    public static final TagKey<Block> REDSTONE_GATES = createTag("redstone_gates");
    
    /**
     * Contains all raw terracotta blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#WHITE_TERRACOTTA minecraft:white_terracotta}</li>
     * <li>{@link Blocks#ORANGE_TERRACOTTA minecraft:orange_terracotta}</li>
     * <li>{@link Blocks#MAGENTA_TERRACOTTA minecraft:magenta_terracotta}</li>
     * <li>{@link Blocks#LIGHT_BLUE_TERRACOTTA minecraft:light_blue_terracotta}</li>
     * <li>{@link Blocks#YELLOW_TERRACOTTA minecraft:yellow_terracotta}</li>
     * <li>{@link Blocks#LIME_TERRACOTTA minecraft:lime_terracotta}</li>
     * <li>{@link Blocks#PINK_TERRACOTTA minecraft:pink_terracotta}</li>
     * <li>{@link Blocks#GRAY_TERRACOTTA minecraft:gray_terracotta}</li>
     * <li>{@link Blocks#LIGHT_GRAY_TERRACOTTA minecraft:light_gray_terracotta}</li>
     * <li>{@link Blocks#CYAN_TERRACOTTA minecraft:cyan_terracotta}</li>
     * <li>{@link Blocks#PURPLE_TERRACOTTA minecraft:purple_terracotta}</li>
     * <li>{@link Blocks#BLUE_TERRACOTTA minecraft:blue_terracotta}</li>
     * <li>{@link Blocks#BROWN_TERRACOTTA minecraft:brown_terracotta}</li>
     * <li>{@link Blocks#GREEN_TERRACOTTA minecraft:green_terracotta}</li>
     * <li>{@link Blocks#RED_TERRACOTTA minecraft:red_terracotta}</li>
     * <li>{@link Blocks#BLACK_TERRACOTTA minecraft:black_terracotta}</li>
     * </ul>
     */
    public static final TagKey<Block> TERRACOTTA = createTag("terracotta");
    
    /**
     * Contains all glazed terracotta blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#WHITE_GLAZED_TERRACOTTA minecraft:white_glazed_terracotta}</li>
     * <li>{@link Blocks#ORANGE_GLAZED_TERRACOTTA minecraft:orange_glazed_terracotta}</li>
     * <li>{@link Blocks#MAGENTA_GLAZED_TERRACOTTA minecraft:magenta_glazed_terracotta}</li>
     * <li>{@link Blocks#LIGHT_BLUE_GLAZED_TERRACOTTA minecraft:light_blue_glazed_terracotta}</li>
     * <li>{@link Blocks#YELLOW_GLAZED_TERRACOTTA minecraft:yellow_glazed_terracotta}</li>
     * <li>{@link Blocks#LIME_GLAZED_TERRACOTTA minecraft:lime_glazed_terracotta}</li>
     * <li>{@link Blocks#PINK_GLAZED_TERRACOTTA minecraft:pink_glazed_terracotta}</li>
     * <li>{@link Blocks#GRAY_GLAZED_TERRACOTTA minecraft:gray_glazed_terracotta}</li>
     * <li>{@link Blocks#LIGHT_GRAY_GLAZED_TERRACOTTA minecraft:light_gray_glazed_terracotta}</li>
     * <li>{@link Blocks#CYAN_GLAZED_TERRACOTTA minecraft:cyan_glazed_terracotta}</li>
     * <li>{@link Blocks#PURPLE_GLAZED_TERRACOTTA minecraft:purple_glazed_terracotta}</li>
     * <li>{@link Blocks#BLUE_GLAZED_TERRACOTTA minecraft:blue_glazed_terracotta}</li>
     * <li>{@link Blocks#BROWN_GLAZED_TERRACOTTA minecraft:brown_glazed_terracotta}</li>
     * <li>{@link Blocks#GREEN_GLAZED_TERRACOTTA minecraft:green_glazed_terracotta}</li>
     * <li>{@link Blocks#RED_GLAZED_TERRACOTTA minecraft:red_glazed_terracotta}</li>
     * <li>{@link Blocks#BLACK_GLAZED_TERRACOTTA minecraft:black_glazed_terracotta}</li>
     * </ul>
     */
    public static final TagKey<Block> GLAZED_TERRACOTTA = createTag("glazed_terracotta");
    
    /**
     * Contains all terracotta blocks, both raw and glazed.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link #TERRACOTTA c:terracotta}</li>
     * <li>{@link #GLAZED_TERRACOTTA c:glazed_terracotta}</li>
     * </ul>
     */
    public static final TagKey<Block> TERRACOTTA_BLOCKS = createTag("terracotta_blocks");
    
    /**
     * Contains all sticky blocks. Sticky blocks are blocks that pistons can use to move multiple blocks at a time.
     * <p>
     * This tag influences the behavior of the following classes:
     * <ul>
     * <li>{@link net.minecraft.block.piston.PistonHandler}
     * </ul>
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link #SLIME_BLOCKS c:slime_blocks}</li>
     * <li>{@link #HONEY_BLOCKS c:honey_blocks}</li>
     * </ul>
     */
    public static final TagKey<Block> STICKY_BLOCKS = createTag("sticky_blocks");
    
    /**
     * Contains all honey blocks.
     * <p>
     * This tag influences the behavior of the following classes:
     * <ul>
     * <li>{@link net.minecraft.block.piston.PistonHandler}
     * </ul>
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#HONEY_BLOCK minecraft:honey_block}</li>
     * </ul>
     */
    public static final TagKey<Block> HONEY_BLOCKS = createTag("honey_blocks");
    
    /**
     * Contains all slime blocks.
     * <p>
     * This tag influences the behavior of the following classes:
     * <ul>
     * <li>{@link net.minecraft.block.piston.PistonHandler}
     * </ul>
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#SLIME_BLOCK minecraft:slime_block}</li>
     * </ul>
     */
    public static final TagKey<Block> SLIME_BLOCKS = createTag("slime_blocks");
    
    /**
     * Contains all concrete blocks, does not contain the powder variants.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#WHITE_CONCRETE minecraft:white_concrete}</li>
     * <li>{@link Blocks#ORANGE_CONCRETE minecraft:orange_concrete}</li>
     * <li>{@link Blocks#MAGENTA_CONCRETE minecraft:magenta_concrete}</li>
     * <li>{@link Blocks#LIGHT_BLUE_CONCRETE minecraft:light_blue_concrete}</li>
     * <li>{@link Blocks#YELLOW_CONCRETE minecraft:yellow_concrete}</li>
     * <li>{@link Blocks#LIME_CONCRETE minecraft:lime_concrete}</li>
     * <li>{@link Blocks#PINK_CONCRETE minecraft:pink_concrete}</li>
     * <li>{@link Blocks#GRAY_CONCRETE minecraft:gray_concrete}</li>
     * <li>{@link Blocks#LIGHT_GRAY_CONCRETE minecraft:light_gray_concrete}</li>
     * <li>{@link Blocks#CYAN_CONCRETE minecraft:cyan_concrete}</li>
     * <li>{@link Blocks#PURPLE_CONCRETE minecraft:purple_concrete}</li>
     * <li>{@link Blocks#BLUE_CONCRETE minecraft:blue_concrete}</li>
     * <li>{@link Blocks#BROWN_CONCRETE minecraft:brown_concrete}</li>
     * <li>{@link Blocks#GREEN_CONCRETE minecraft:green_concrete}</li>
     * <li>{@link Blocks#RED_CONCRETE minecraft:red_concrete}</li>
     * <li>{@link Blocks#BLACK_CONCRETE minecraft:black_concrete}</li>
     * </ul>
     */
    public static final TagKey<Block> CONCRETE = createTag("concrete");
    
    /**
     * Contains all concrete powder blocks.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link Blocks#WHITE_CONCRETE_POWDER minecraft:white_concrete_powder}</li>
     * <li>{@link Blocks#ORANGE_CONCRETE_POWDER minecraft:orange_concrete_powder}</li>
     * <li>{@link Blocks#MAGENTA_CONCRETE_POWDER minecraft:magenta_concrete_powder}</li>
     * <li>{@link Blocks#LIGHT_BLUE_CONCRETE_POWDER minecraft:light_blue_concrete_powder}</li>
     * <li>{@link Blocks#YELLOW_CONCRETE_POWDER minecraft:yellow_concrete_powder}</li>
     * <li>{@link Blocks#LIME_CONCRETE_POWDER minecraft:lime_concrete_powder}</li>
     * <li>{@link Blocks#PINK_CONCRETE_POWDER minecraft:pink_concrete_powder}</li>
     * <li>{@link Blocks#GRAY_CONCRETE_POWDER minecraft:gray_concrete_powder}</li>
     * <li>{@link Blocks#LIGHT_GRAY_CONCRETE_POWDER minecraft:light_gray_concrete_powder}</li>
     * <li>{@link Blocks#CYAN_CONCRETE_POWDER minecraft:cyan_concrete_powder}</li>
     * <li>{@link Blocks#PURPLE_CONCRETE_POWDER minecraft:purple_concrete_powder}</li>
     * <li>{@link Blocks#BLUE_CONCRETE_POWDER minecraft:blue_concrete_powder}</li>
     * <li>{@link Blocks#BROWN_CONCRETE_POWDER minecraft:brown_concrete_powder}</li>
     * <li>{@link Blocks#GREEN_CONCRETE_POWDER minecraft:green_concrete_powder}</li>
     * <li>{@link Blocks#RED_CONCRETE_POWDER minecraft:red_concrete_powder}</li>
     * <li>{@link Blocks#BLACK_CONCRETE_POWDER minecraft:black_concrete_powder}</li>
     * </ul>
     */
    public static final TagKey<Block> CONCRETE_POWDER = createTag("concrete_powder");
    
    /**
     * Contains all farmland blocks.
     * <p>
     * This tag influences the behavior of the following classes:
     * <ul>
     * <li>{@link CropBlock}</li>
     * <li>{@link net.minecraft.entity.passive.RabbitEntity.EatCarrotCropGoal}</li>
     * <li>{@link StemBlock}</li>
     * </ul>
     * <p>
     * This tag influences the behavior of {@link net.minecraft.village.VillagerProfession#FARMER farmer Villagers}.
     * <p>
     * Default entries:
     * <ul>
     * <li>{@link #MOIST_FARMLAND c:moist_farmland}</li>
     * <li>{@link Blocks#FARMLAND minecraft:farmland}</li>
     * </ul>
     */
    @SuppressWarnings("JavadocReference")
    public static final TagKey<Block> FARMLAND = createTag("farmland");
    
    /**
     * Contains all moist farmland blocks:
     * <p>
     * This tag influences the behavior of the following classes:
     * <ul>
     * <li>{@link CropBlock}</li>
     * </ul>
     */
    public static final TagKey<Block> MOIST_FARMLAND = createTag("moist_farmland");
    
    /**
     * @hidden Creates a new {@link TagKey} in the common tag namespace.
     *
     * @param name The name of the new {@link TagKey}
     * @return The new {@link TagKey}
     * @hidden Creates a new {@link TagKey} in the common tag namespace.
     */
    private static TagKey<Block> createTag(String name) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(COMMON_NAMESPACE, name));
    }
    
    /**
     * @hidden Ensures that &lt;clinit&gt; runs.
     */
    static void init() {}
    
    /**
     * Returns a {@link Stream} that contains all {@link Block}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link Stream}
     */
    public static Stream<Block> streamTagEntries(TagKey<Block> tag) {
        return MoreTags.streamTagEntries(Registry.BLOCK, tag);
    }
    
    /**
     * Returns a {@link List} that contains all {@link Block}s in the provided tag.
     *
     * @param tag The tag to query
     * @return A {@link List}
     */
    public static List<Block> listTagEntries(TagKey<Block> tag) {
        return MoreTags.listTagEntries(Registry.BLOCK, tag);
    }
}
