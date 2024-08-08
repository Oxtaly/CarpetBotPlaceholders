package com.oxtaly.carpetbotplaceholders.utils;

import com.oxtaly.carpetbotplaceholders.config.ConfigManager;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static @NotNull String getConfigPath() {
        return FabricLoader.getInstance().getConfigDir() + "/CarpetBotPlaceholders.json";
    }

    public static class minecraftLogBuilder {
        public static @NotNull MutableComponent log(String string) {
            return minecraftLogBuilder.log(Component.literal(string));
        };
        public static @NotNull MutableComponent log(MutableComponent mutableText) {
            MutableComponent logString = Component.empty()
                    .append(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY))
                    .append(Component.literal("CarpetBotPlaceholders").withStyle(Style.EMPTY.withColor(TextColor.parseColor("#F9DBDB"))
                            .withHoverEvent(HoverEvent.Action.SHOW_TEXT.deserializeFromLegacy(Component.literal("CarpetBotPlaceholders")))))
                    .append(Component.literal("] ").withStyle(ChatFormatting.DARK_GRAY));
            logString.append(mutableText);
            return logString;
        };
        public static @NotNull MutableComponent warn(String string) {
            return minecraftLogBuilder.warn(Component.literal(string));
        };
        public static @NotNull MutableComponent warn(MutableComponent mutableText) {
            return minecraftLogBuilder.log(mutableText).withStyle(Style.EMPTY.withColor(TextColor.parseColor("#ffc107")));
        };
        public static @NotNull MutableComponent error(String string) {
            return minecraftLogBuilder.error(Component.literal(string));
        };
        public static @NotNull MutableComponent error(MutableComponent mutableText) {
            return minecraftLogBuilder.log(mutableText).withStyle(ChatFormatting.RED);
        };
    }

    public static int innitConfig(ConfigManager config) throws IOException {
        File configFile = new File(getConfigPath());
        if(!configFile.exists()) {
            config.writeConfig(configFile);
            return -1;
        }
        return config.readConfig(configFile);
    }
}
