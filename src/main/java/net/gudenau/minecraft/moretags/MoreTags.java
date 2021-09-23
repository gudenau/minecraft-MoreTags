package net.gudenau.minecraft.moretags;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.gudenau.minecraft.moretags.mixins.farmland.VillagerProfessionAccessor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

public final class MoreTags implements ModInitializer{
    public static final String MOD_ID = "moretags";
    
    public static final Tag<Block> BOOKSHELVES = createBlockTag(new Identifier(MOD_ID, "bookshelves"));
    public static final Tag<Block> ORES = createBlockTag(new Identifier(MOD_ID, "ores"));
    public static final Tag<Block> STRIPPED_WOOD = createBlockTag(new Identifier(MOD_ID, "stripped_wood"));
    public static final Tag<Block> STRIPPED_LOGS = createBlockTag(new Identifier(MOD_ID, "stripped_logs"));
    public static final Tag<Block> STRIPPED_BARK = createBlockTag(new Identifier(MOD_ID, "stripped_bark"));
    public static final Tag<Block> DRESSED_WOOD = createBlockTag(new Identifier(MOD_ID, "dressed_wood"));
    public static final Tag<Block> DRESSED_LOGS = createBlockTag(new Identifier(MOD_ID, "dressed_logs"));
    public static final Tag<Block> DRESSED_BARK = createBlockTag(new Identifier(MOD_ID, "dressed_bark"));
    public static final Tag<Block> GLASS = createBlockTag(new Identifier(MOD_ID, "glass"));
    public static final Tag<Block> GLASS_BLOCKS = createBlockTag(new Identifier(MOD_ID, "glass_blocks"));
    public static final Tag<Block> GLASS_PANES = createBlockTag(new Identifier(MOD_ID, "glass_panes"));
    public static final Tag<Block> CHESTS = createBlockTag(new Identifier(MOD_ID, "chests"));
    public static final Tag<Block> BRICKS = createBlockTag(new Identifier(MOD_ID, "bricks"));
    public static final Tag<Block> INFESTED = createBlockTag(new Identifier(MOD_ID, "infested"));
    public static final Tag<Block> SKULLS = createBlockTag(new Identifier(MOD_ID, "skulls"));
    public static final Tag<Block> WALL_SKULLS = createBlockTag(new Identifier(MOD_ID, "wall_skulls"));
    public static final Tag<Block> FLOOR_SKULLS = createBlockTag(new Identifier(MOD_ID, "floor_skulls"));
    public static final Tag<Block> REDSTONE_DEVICES = createBlockTag(new Identifier(MOD_ID, "redstone_devices"));
    public static final Tag<Block> REDSTONE_RAILS = createBlockTag(new Identifier(MOD_ID, "redstone_rails"));
    public static final Tag<Block> REDSTONE = createBlockTag(new Identifier(MOD_ID, "redstone"));
    public static final Tag<Block> PISTONS = createBlockTag(new Identifier(MOD_ID, "pistons"));
    public static final Tag<Block> REDSTONE_GATES = createBlockTag(new Identifier(MOD_ID, "redstone_gates"));
    public static final Tag<Block> TERRACOTTA = createBlockTag(new Identifier(MOD_ID, "terracotta"));
    public static final Tag<Block> GLAZED_TERRACOTTA = createBlockTag(new Identifier(MOD_ID, "glazed_terracotta"));
    public static final Tag<Block> TERRACOTTA_BLOCKS = createBlockTag(new Identifier(MOD_ID, "terracotta_blocks"));
    public static final Tag<Block> STICKY_BLOCKS = createBlockTag(new Identifier(MOD_ID, "sticky_blocks"));
    public static final Tag<Block> HONEY_BLOCKS = createBlockTag(new Identifier(MOD_ID, "honey_blocks"));
    public static final Tag<Block> SLIME_BLOCKS = createBlockTag(new Identifier(MOD_ID, "slime_blocks"));
    public static final Tag<Block> CONCRETE = createBlockTag(new Identifier(MOD_ID, "concrete"));
    public static final Tag<Block> CONCRETE_POWDER = createBlockTag(new Identifier(MOD_ID, "concrete_powder"));
    public static final Tag<Block> FARMLAND = createBlockTag(new Identifier(MOD_ID, "farmland"));
    public static final Tag<Block> MOIST_FARMLAND = createBlockTag(new Identifier(MOD_ID, "moist_farmland"));
    
    public static final Tag<Item> SKULL_ITEMS = createItemTag(new Identifier(MOD_ID, "skull"));
    
    private static Tag<Block> createBlockTag(Identifier identifier){
        return TagFactory.BLOCK.create(identifier);
    }
    
    private static Tag<Item> createItemTag(Identifier identifier){
        return TagFactory.ITEM.create(identifier);
    }
    
    @Override
    public void onInitialize(){
        ServerLifecycleEvents.SERVER_STARTED.register((server)->{
            // Support for farmland, Vanilla assumes it will always be a specific block and we change that during runtime
            ((VillagerProfessionAccessor)VillagerProfession.FARMER).setSecondaryJobSites(ImmutableSet.copyOf(FARMLAND.values()));
        });
    }
}
