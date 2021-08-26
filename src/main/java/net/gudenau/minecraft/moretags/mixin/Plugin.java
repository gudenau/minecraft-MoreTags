package net.gudenau.minecraft.moretags.mixin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

// This is so stupid.
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
    
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName){
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
