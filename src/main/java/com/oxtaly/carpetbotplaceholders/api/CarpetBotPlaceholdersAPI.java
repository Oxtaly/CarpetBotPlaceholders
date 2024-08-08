package com.oxtaly.carpetbotplaceholders.api;

import carpet.patches.EntityPlayerMPFake;
import static com.oxtaly.carpetbotplaceholders.compatibility.ModCompatibility.CARPET;

import net.minecraft.server.level.ServerPlayer;

public interface CarpetBotPlaceholdersAPI {
    static boolean isCarpetBot(ServerPlayer player) {
        if(!CARPET) return false;
        return player instanceof EntityPlayerMPFake;
    }

    static boolean isShadowedPlayer(ServerPlayer player) {
        if(!CARPET) return false;
        try {
            return ((EntityPlayerMPFake) player).isAShadow;
        } catch (Exception e) {
            return false;
        }
    }
}
