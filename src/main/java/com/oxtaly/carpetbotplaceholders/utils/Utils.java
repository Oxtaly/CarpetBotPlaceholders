package com.oxtaly.carpetbotplaceholders.utils;

import com.oxtaly.carpetbotplaceholders.config.ConfigManager;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static @NotNull String getConfigPath() {
        return FabricLoader.getInstance().getConfigDir() + "/CarpetBotPlaceholders.json";
    }

    public static class minecraftLogBuilder {
        public static @NotNull MutableText log(String string) {
            return minecraftLogBuilder.log(Text.literal(string));
        };
        public static @NotNull MutableText log(MutableText mutableText) {
            MutableText logString = Text.empty()
                    .append(Text.literal("[").formatted(Formatting.DARK_GRAY))
                    .append(Text.literal("CarpetBotPlaceholders").setStyle(Style.EMPTY.withColor(TextColor.parse("#F9DBDB").getOrThrow())
                        .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.literal("CarpetBotPlaceholders")))))
                    .append(Text.literal("] ").formatted(Formatting.DARK_GRAY));
            logString.append(mutableText);
            return logString;
        };
        public static @NotNull Text warn(String string) {
            return minecraftLogBuilder.warn(Text.literal(string));
        };
        public static @NotNull MutableText warn(MutableText mutableText) {
            return minecraftLogBuilder.log(mutableText).setStyle(Style.EMPTY.withColor(TextColor.parse("#ffc107").getOrThrow()));
        };
        public static @NotNull MutableText error(String string) {
            return minecraftLogBuilder.error(Text.literal(string));
        };
        public static @NotNull MutableText error(MutableText mutableText) {
            return minecraftLogBuilder.log(mutableText).formatted(Formatting.RED);
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
