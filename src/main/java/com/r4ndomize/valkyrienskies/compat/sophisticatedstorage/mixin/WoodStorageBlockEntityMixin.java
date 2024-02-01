package com.r4ndomize.valkyrienskies.compat.sophisticatedstorage.mixin;

import net.minecraft.world.Clearable;
import net.p3pp3rf1y.sophisticatedstorage.block.WoodStorageBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(WoodStorageBlockEntity.class)
public abstract class WoodStorageBlockEntityMixin implements Clearable {

    private static final Logger LOGGER = LogManager.getLogger();

    @Shadow protected abstract void setPacked(boolean packed);

    public void clearContent() {
        // Create a new Throwable to inspect the stack trace
        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();

        // The first element is the current method, so you check the second element
        if (elements.length > 1) {
            // Grab the class name of direct caller
            String callerClassName = elements[1].getClassName();

            // Check if the caller is from Valkyrien Skies and if so, modify
            // the clearContent behavior to set packed so it does not drop
            // items when VS relocates the block by destroying the instance
            // at the current location
            if (callerClassName.startsWith("org.valkyrienskies")) {
                    LOGGER.debug("ValkyrienStorageCompat: packing SophisticatedStorage Block Entity to prep for relocation");
                    this.setPacked(true);
            }
        }

    }
}
