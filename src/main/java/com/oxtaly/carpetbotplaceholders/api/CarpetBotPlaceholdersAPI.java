package com.oxtaly.carpetbotplaceholders.api;

import net.minecraft.server.network.ServerPlayerEntity;

import carpet.patches.EntityPlayerMPFake;
import static com.oxtaly.carpetbotplaceholders.compatibility.ModCompatibility.CARPET;


public interface CarpetBotPlaceholdersAPI {
    static boolean isCarpetBot(ServerPlayerEntity player) {
        if(!CARPET) return false;
        return player instanceof EntityPlayerMPFake;
    }

    static boolean isShadowedPlayer(ServerPlayerEntity player) {
        if(!CARPET) return false;
        try {
            return ((EntityPlayerMPFake) player).isAShadow;
        } catch (Exception e) {
            return false;
        }
    }
}
