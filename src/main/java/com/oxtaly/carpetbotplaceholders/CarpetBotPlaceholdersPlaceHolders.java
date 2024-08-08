package com.oxtaly.carpetbotplaceholders;

import com.oxtaly.carpetbotplaceholders.api.CarpetBotPlaceholdersAPI;
import eu.pb4.placeholders.api.PlaceholderResult;
import eu.pb4.placeholders.api.Placeholders;
import eu.pb4.placeholders.api.TextParserUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static com.oxtaly.carpetbotplaceholders.CarpetBotPlaceholders.MOD_ID;
import static com.oxtaly.carpetbotplaceholders.compatibility.ModCompatibility.CARPET;

// I know, confusing name, sorry xD
public class CarpetBotPlaceholdersPlaceHolders {
    public static final ResourceLocation CARPET_BOT_PREFIX = new ResourceLocation(MOD_ID, "carpet_bot_prefix");
    public static final ResourceLocation SHADOWED_PLAYER_PREFIX = new ResourceLocation(MOD_ID, "shadowed_player_prefix");
    public static final ResourceLocation CARPET_ENTITY_PREFIX = new ResourceLocation(MOD_ID, "carpet_entity_prefix");

    public static void register() {
        Placeholders.register(CARPET_BOT_PREFIX, (context, argument) -> {
            if(!CARPET) {
                return PlaceholderResult.invalid("Carpet mod not found!");
            }
            if (context.player() != null) {
                if(CarpetBotPlaceholdersAPI.isCarpetBot(context.player())) return PlaceholderResult.value(TextParserUtils.formatText(CarpetBotPlaceholders.CONFIG_MANAGER.getData().carpetBotPrefix));
                return PlaceholderResult.value(Component.empty());
            }
            return PlaceholderResult.invalid("No player!");
        });
        Placeholders.register(SHADOWED_PLAYER_PREFIX, (context, argument) -> {
            if(!CARPET) {
                return PlaceholderResult.invalid("Carpet mod not found!");
            }
            if (context.player() != null) {
                if(CarpetBotPlaceholdersAPI.isShadowedPlayer(context.player())) return PlaceholderResult.value(TextParserUtils.formatText(CarpetBotPlaceholders.CONFIG_MANAGER.getData().shadowedPlayerPrefix));
                return PlaceholderResult.value(Component.empty());
            }
            return PlaceholderResult.invalid("No player!");
        });
        Placeholders.register(CARPET_ENTITY_PREFIX, (context, argument) -> {
            if(!CARPET) {
                return PlaceholderResult.invalid("Carpet mod not found!");
            }
            if (context.player() != null) {
                if(CarpetBotPlaceholdersAPI.isShadowedPlayer(context.player())) return PlaceholderResult.value(TextParserUtils.formatText(CarpetBotPlaceholders.CONFIG_MANAGER.getData().shadowedPlayerPrefix));
                if(CarpetBotPlaceholdersAPI.isCarpetBot(context.player())) return PlaceholderResult.value(TextParserUtils.formatText(CarpetBotPlaceholders.CONFIG_MANAGER.getData().carpetBotPrefix));
                return PlaceholderResult.value(Component.empty());
            }
            return PlaceholderResult.invalid("No player!");
        });
    }
}
