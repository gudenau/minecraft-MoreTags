package net.gudenau.minecraft.moretags.mixins.retro;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.gudenau.minecraft.moretags.MoreTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MoreTags.class)
public abstract class OldTagApiSupport {
    /**
     * @author gudenau
     * @reason To support older FAPI versions
     */
    @Overwrite
    private static Tag<Block> createBlockTag(Identifier identifier) {
        return TagRegistry.block(identifier);
    }
    
    /**
     * @author gudenau
     * @reason To support older FAPI versions
     */
    @Overwrite
    private static Tag<Item> createItemTag(Identifier identifier) {
        return TagRegistry.item(identifier);
    }
}
