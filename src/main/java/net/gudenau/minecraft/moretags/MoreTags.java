package net.gudenau.minecraft.moretags;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.gudenau.minecraft.moretags.mixins.farmland.VillagerProfessionAccessor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

public final class MoreTags implements ModInitializer{
    public static final String MOD_ID = "moretags";
    private static final String COMMON_NAMESPACE = "c";
    
    public static final Tag<Block> BOOKSHELVES = createBlockTag(new Identifier(COMMON_NAMESPACE, "bookshelves"));
    public static final Tag<Block> ORES = createBlockTag(new Identifier(COMMON_NAMESPACE, "ores"));
    public static final Tag<Block> STRIPPED_WOOD = createBlockTag(new Identifier(COMMON_NAMESPACE, "stripped_wood"));
    public static final Tag<Block> STRIPPED_LOGS = createBlockTag(new Identifier(COMMON_NAMESPACE, "stripped_logs"));
    public static final Tag<Block> STRIPPED_BARK = createBlockTag(new Identifier(COMMON_NAMESPACE, "stripped_bark"));
    public static final Tag<Block> DRESSED_WOOD = createBlockTag(new Identifier(COMMON_NAMESPACE, "dressed_wood"));
    public static final Tag<Block> DRESSED_LOGS = createBlockTag(new Identifier(COMMON_NAMESPACE, "dressed_logs"));
    public static final Tag<Block> DRESSED_BARK = createBlockTag(new Identifier(COMMON_NAMESPACE, "dressed_bark"));
    public static final Tag<Block> GLASS = createBlockTag(new Identifier(COMMON_NAMESPACE, "glass"));
    public static final Tag<Block> GLASS_BLOCKS = createBlockTag(new Identifier(COMMON_NAMESPACE, "glass_blocks"));
    public static final Tag<Block> GLASS_PANES = createBlockTag(new Identifier(COMMON_NAMESPACE, "glass_panes"));
    public static final Tag<Block> CHESTS = createBlockTag(new Identifier(COMMON_NAMESPACE, "chests"));
    public static final Tag<Block> BRICKS = createBlockTag(new Identifier(COMMON_NAMESPACE, "bricks"));
    public static final Tag<Block> INFESTED = createBlockTag(new Identifier(COMMON_NAMESPACE, "infested"));
    public static final Tag<Block> SKULLS = createBlockTag(new Identifier(COMMON_NAMESPACE, "skulls"));
    public static final Tag<Block> WALL_SKULLS = createBlockTag(new Identifier(COMMON_NAMESPACE, "wall_skulls"));
    public static final Tag<Block> FLOOR_SKULLS = createBlockTag(new Identifier(COMMON_NAMESPACE, "floor_skulls"));
    public static final Tag<Block> REDSTONE_DEVICES = createBlockTag(new Identifier(COMMON_NAMESPACE, "redstone_devices"));
    public static final Tag<Block> REDSTONE_RAILS = createBlockTag(new Identifier(COMMON_NAMESPACE, "redstone_rails"));
    public static final Tag<Block> REDSTONE = createBlockTag(new Identifier(COMMON_NAMESPACE, "redstone"));
    public static final Tag<Block> PISTONS = createBlockTag(new Identifier(COMMON_NAMESPACE, "pistons"));
    public static final Tag<Block> REDSTONE_GATES = createBlockTag(new Identifier(COMMON_NAMESPACE, "redstone_gates"));
    public static final Tag<Block> TERRACOTTA = createBlockTag(new Identifier(COMMON_NAMESPACE, "terracotta"));
    public static final Tag<Block> GLAZED_TERRACOTTA = createBlockTag(new Identifier(COMMON_NAMESPACE, "glazed_terracotta"));
    public static final Tag<Block> TERRACOTTA_BLOCKS = createBlockTag(new Identifier(COMMON_NAMESPACE, "terracotta_blocks"));
    public static final Tag<Block> STICKY_BLOCKS = createBlockTag(new Identifier(COMMON_NAMESPACE, "sticky_blocks"));
    public static final Tag<Block> HONEY_BLOCKS = createBlockTag(new Identifier(COMMON_NAMESPACE, "honey_blocks"));
    public static final Tag<Block> SLIME_BLOCKS = createBlockTag(new Identifier(COMMON_NAMESPACE, "slime_blocks"));
    public static final Tag<Block> CONCRETE = createBlockTag(new Identifier(COMMON_NAMESPACE, "concrete"));
    public static final Tag<Block> CONCRETE_POWDER = createBlockTag(new Identifier(COMMON_NAMESPACE, "concrete_powder"));
    public static final Tag<Block> FARMLAND = createBlockTag(new Identifier(COMMON_NAMESPACE, "farmland"));
    public static final Tag<Block> MOIST_FARMLAND = createBlockTag(new Identifier(COMMON_NAMESPACE, "moist_farmland"));
    
    public static final Tag<Item> SKULL_ITEMS = createItemTag(new Identifier(COMMON_NAMESPACE, "skull"));
    
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
