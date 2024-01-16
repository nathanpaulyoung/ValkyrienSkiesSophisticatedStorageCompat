package com.dwayn.valkyrienskies.compat.sophisticatedstorage.mixin;

import net.p3pp3rf1y.sophisticatedstorage.block.WoodStorageBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodStorageBlockEntity.class)
public interface WoodStorageBlockEntityAccessor {
    @Invoker("setPacked")
    public void callSetPacked(boolean packed);
}
