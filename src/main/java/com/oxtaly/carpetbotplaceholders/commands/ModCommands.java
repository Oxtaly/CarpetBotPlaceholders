package com.oxtaly.carpetbotplaceholders.commands;

import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import com.oxtaly.carpetbotplaceholders.CarpetBotPlaceholders;
import com.oxtaly.carpetbotplaceholders.config.ConfigData;
import com.oxtaly.carpetbotplaceholders.utils.Utils;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import me.lucko.fabric.api.permissions.v0.Permissions;



public final class ModCommands {
    private ModCommands() {}

    public static void init() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            final LiteralCommandNode<ServerCommandSource> node = dispatcher.register(
                CommandManager.literal("carpetbotplaceholders")
                    .requires(source -> Permissions.check(source, "carpetbotplaceholders.command.carpetbotplaceholders", 2))
                    .then(CommandManager.literal("reload")
                            .requires(source -> Permissions.check(source, "carpetbotplaceholders.command.carpetbotplaceholders.reload", 4))
                            .executes(ctx -> reload(ctx.getSource()))
                    )
            );
        });
    }
    public static int reload(ServerCommandSource source) {
        try {
            ConfigData oldConfigData = CarpetBotPlaceholders.CONFIG_MANAGER.getData().clone();
            int returnCode = Utils.innitConfig(CarpetBotPlaceholders.CONFIG_MANAGER);
            if(returnCode > 0) {
                CarpetBotPlaceholders.CONFIG_MANAGER.setData(oldConfigData);
                source.sendError(Utils.minecraftLogBuilder.error("An error happened trying reload config!"));
                return 1;
            }
            if(returnCode == -1) {
                source.sendFeedback(() -> Utils.minecraftLogBuilder.warn("Missing config, created config successfully!"), true);
                CarpetBotPlaceholders.LOGGER.warn("[CarpetBotPlaceholders] Missing config, created config successfully!");
                return 0;
            }
            source.sendFeedback(() -> Utils.minecraftLogBuilder.log("Reloaded config successfully!"), true);
            CarpetBotPlaceholders.LOGGER.info("[CarpetBotPlaceholders] Reloaded config successfully!");
            return 0;
        } catch (Exception e) {
            source.sendError(Utils.minecraftLogBuilder.error("An error happened trying reload config"));
            CarpetBotPlaceholders.LOGGER.error("[CarpetBotPlaceholders] An error happened trying reload config", e);
            return 0;
        }
    }
}
