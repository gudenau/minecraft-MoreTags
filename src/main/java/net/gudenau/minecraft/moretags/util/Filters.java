package net.gudenau.minecraft.moretags.util;

import net.gudenau.minecraft.mixinfilter.MixinFilter;
import net.gudenau.minecraft.mixinfilter.MixinFilterProvider;

public final class Filters implements MixinFilterProvider {
    @Override
    public void registerFilters() {
        MixinFilter.register("bclib", (modId, config, targetClassName, mixinClassName)->
            mixinClassName.contains("shears")
        );
    }
}
