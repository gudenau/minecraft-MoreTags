package net.gudenau.minecraft.moretags.mixins;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.VersionParsingException;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public final class Plugin implements IMixinConfigPlugin{
    private static final boolean DEV;
    static{
        boolean dev;
        try{
            dev = Files.isDirectory(Path.of(Plugin.class.getProtectionDomain().getCodeSource().getLocation().toURI()));
        }catch(Throwable t){
            dev = false;
        }
        DEV = dev;
    }
    
    @Override
    public void onLoad(String mixinPackage){}
    
    @Override
    public String getRefMapperConfig(){
        return null;
    }
    
    private boolean isModOlderThan(String id, String version){
        var container = FabricLoader.getInstance().getModContainer(id);
        if(container.isEmpty()){
            return false;
        }
        var modVersion = container.get().getMetadata().getVersion();
        if(!(modVersion instanceof SemanticVersion semanticVersion)){
            throw new IllegalStateException("Weird fabric-tag-extensions-v0 version");
        }
        try{
            return semanticVersion.compareTo(SemanticVersion.parse(version)) < 0;
        }catch(VersionParsingException e){
            throw new RuntimeException("Failed to parse version: " + version, e);
        }
    }
    
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName){
        if(mixinClassName.equals("net.gudenau.minecraft.moretags.mixins.retro.OldTagApiSupport")){
            return isModOlderThan("fabric-tag-extensions-v0", "1.2.2");
        }
        
        return switch(mixinClassName){
            case "net.gudenau.minecraft.moretags.mixins.farmland.RabbitEntity$EatCarrotCropGoalMixin" -> !DEV;
            case "net.gudenau.minecraft.moretags.mixins.farmland.RabbitEntity$EatCarrotCropGoal$DevMixin" -> DEV;
            default -> true;
        };
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
