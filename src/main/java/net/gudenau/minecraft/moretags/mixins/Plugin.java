package net.gudenau.minecraft.moretags.mixins;

import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.VersionParsingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public final class Plugin implements IMixinConfigPlugin{
    private static final Logger LOGGER = LogManager.getLogger("MoreTags");
    
    private enum VersionCheckType{
        ALWAYS((suppliedVersion, expectedVersion)->true),
        OLDER_THAN((suppliedVersion, expectedVersion)->suppliedVersion.compareTo(expectedVersion) > 0),
        NEWER_THAN((suppliedVersion, expectedVersion)->suppliedVersion.compareTo(expectedVersion) < 0),
        EQUAL_TO((suppliedVersion, expectedVersion)->suppliedVersion.equals(expectedVersion))
        ;
    
        private final BiPredicate<SemanticVersion, SemanticVersion> predicate;
    
        VersionCheckType(BiPredicate<SemanticVersion, SemanticVersion> predicate) {
            this.predicate = predicate;
        }
    
        public boolean test(SemanticVersion suppliedVersion, SemanticVersion expectedVersion) {
            return predicate.test(suppliedVersion, expectedVersion);
        }
    }

    private enum CompatibilityLayer {
        // All the Blocks You Want bulldozes some of our injection points, at least they do the same thing we do...
        ATBYW("atbyw", null, VersionCheckType.ALWAYS, (mixinName)->
            switch(mixinName){
                case "net.gudenau.minecraft.moretags.mixins.bookshelves.EnchantingTableBlockMixin",
                    "net.gudenau.minecraft.moretags.mixins.bookshelves.EnchantmentScreenHandlerMixin" -> false;
                default -> true;
            }
        ),
        // BCLib also does their own enchanting tables with the same tag name.
        BCLIB("bclib", null, VersionCheckType.ALWAYS, (mixinName)->
            switch(mixinName){
                case "net.gudenau.minecraft.moretags.mixins.bookshelves.EnchantingTableBlockMixin",
                    "net.gudenau.minecraft.moretags.mixins.bookshelves.EnchantmentScreenHandlerMixin" -> false;
                default -> true;
            }
        ),
        ;
    
        private final String modId;
        private final String modVersion;
        private final VersionCheckType checkType;
        private final Predicate<String> mixinPredicate;
    
        CompatibilityLayer(String modId, String modVersion, VersionCheckType checkType, Predicate<String> mixinPredicate){
            this.modId = modId;
            this.modVersion = modVersion;
            this.checkType = checkType;
            this.mixinPredicate = mixinPredicate;
        }
    
        public boolean shouldApply() {
            // For the universal one.
            if(modId == null){
                return true;
            }
            
            var container = FabricLoader.getInstance().getModContainer(modId);
            if(container.isEmpty()){
                return false;
            }
            // Allow null versions and short circuit.
            if(checkType == VersionCheckType.ALWAYS){
                return true;
            }
            var modVersion = container.get().getMetadata().getVersion();
            if(!(modVersion instanceof SemanticVersion suppliedVersion)){
                LOGGER.error("Failed to get SemanticVersion for mod %s".formatted(modId));
                return false;
            }
            SemanticVersion expectedVersion;
            try {
                expectedVersion = SemanticVersion.parse(this.modVersion);
            } catch (VersionParsingException e) {
                throw new RuntimeException("Failed to parse version %s for %s's compatibility layer".formatted(this.modVersion, modId));
            }
            return checkType.test(suppliedVersion, expectedVersion);
        }
        
        public boolean shouldApplyMixin(String mixinName){
            return mixinPredicate.test(mixinName);
        }
    }
    
    private static final Set<CompatibilityLayer> COMPATIBILITY_LAYERS = Stream.of(CompatibilityLayer.values())
        .filter(CompatibilityLayer::shouldApply)
        .collect(Collectors.toUnmodifiableSet());
    
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName){
        for (var layer : COMPATIBILITY_LAYERS) {
            if(!layer.shouldApplyMixin(mixinClassName)){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void onLoad(String mixinPackage){}
    
    @Override
    public String getRefMapperConfig(){
        return null;
    }
    
    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets){}
    
    @Override
    public List<String> getMixins(){
        return List.of();
    }
    
    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo){}
    
    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo){}
}
