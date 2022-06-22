package net.gudenau.minecraft.moretags.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;

public final class Hacks {
    private static final MethodHandles.Lookup LOOKUP = createLookup();
    
    private static MethodHandles.Lookup createLookup() {
        var unsafe = getUnsafe();
        var offset = findOverrideOffset(unsafe);
        
        try {
            var constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Class.class, int.class);
            unsafe.putBoolean(constructor, offset, true);
            return constructor.newInstance(Object.class, null, -1);
        } catch (Throwable t) {
            throw new RuntimeException("Failed to create lookup", t);
        }
    }
    
    private static Unsafe getUnsafe() {
        Set<Throwable> exceptions = new HashSet<>();
        for (var field : Unsafe.class.getDeclaredFields()) {
            if (field.getType() == Unsafe.class && Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    if (field.get(null) instanceof Unsafe unsafe) {
                        return unsafe;
                    }
                } catch (ReflectiveOperationException e) {
                    exceptions.add(e);
                }
            }
        }
        
        var exception = new RuntimeException("Failed to get Unsafe handle");
        exceptions.forEach(exception::addSuppressed);
        throw exception;
    }
    
    private static long findOverrideOffset(Unsafe unsafe) {
        AccessibleObject object;
        try {
            object = (AccessibleObject) unsafe.allocateInstance(AccessibleObject.class);
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to allocate AccessibleObject", e);
        }
        
        for (long offset = 4; offset < 64; offset++) {
            object.setAccessible(false);
            if (unsafe.getBoolean(object, offset)) {
                continue;
            }
    
            object.setAccessible(true);
            if (unsafe.getBoolean(object, offset)) {
                return offset;
            }
        }
        
        throw new RuntimeException("Failed to locate AccessibleObject.override");
    }
    
    static MethodHandle findSetter(Class<?> owner, List<String> names, Class<?> type) {
        var exceptions = new HashSet<Throwable>();
        for (var name : names) {
            try {
                return LOOKUP.findSetter(owner, name, type);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                exceptions.add(e);
            }
        }
        
        var exception = new RuntimeException(
            "Failed to locate field in %s by names %s".formatted(
                owner.getSimpleName(),
                String.join(", ", names)
            ));
        exceptions.forEach(exception::addSuppressed);
        throw exception;
    }
    
    /**
     * Ensures that &lt;clinit&gt; was run.
     *
     * @hidden
     */
    public static void init() {
    }
}

