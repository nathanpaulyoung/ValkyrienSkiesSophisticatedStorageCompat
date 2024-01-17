package com.dwayn.valkyrienskies.compat.sophisticatedstorage;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("valkyrienskies_sophisticatedstorage_compat")
public class ValkyrienSkiesSophisticatedStorageCompatMod {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "ValkyrienSkiesSophisticatedStorageCompat";

    public ValkyrienSkiesSophisticatedStorageCompatMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        if (ModList.get().isLoaded("sophisticatedstorage")) {
            LOGGER.warn("[{}]: SophisticatedStorage is loaded, adding ValkyrienSkies support", MODID);
        }
    }
}