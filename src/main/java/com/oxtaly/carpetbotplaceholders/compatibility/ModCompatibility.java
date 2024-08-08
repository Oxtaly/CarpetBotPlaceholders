package com.oxtaly.carpetbotplaceholders.compatibility;

import net.fabricmc.loader.api.FabricLoader;

public class ModCompatibility {
    public static final boolean CARPET = FabricLoader.getInstance().isModLoaded("carpet");

    // public void init() {}
}
