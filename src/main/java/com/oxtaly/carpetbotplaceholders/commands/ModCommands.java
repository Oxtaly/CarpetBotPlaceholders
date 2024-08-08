package com.oxtaly.carpetbotplaceholders.commands;

import com.mojang.brigadier.tree.LiteralCommandNode;
import com.oxtaly.carpetbotplaceholders.CarpetBotPlaceholders;
import com.oxtaly.carpetbotplaceholders.config.ConfigData;
import com.oxtaly.carpetbotplaceholders.utils.Utils;
import net.minecraft.commands.CommandSourceStack;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import me.lucko.fabric.api.permissions.v0.Permissions;

import net.minecraft.commands.Commands;


public final class ModCommands {
    private ModCommands() {}

    public static void init() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            final LiteralCommandNode<CommandSourceStack> node = dispatcher.register(
                Commands.literal("carpetbotplaceholders")
                    .requires(source -> Permissions.check(source, "carpetbotplaceholders.command.carpetbotplaceholders", 2))
                    .then(Commands.literal("reload")
                            .requires(source -> Permissions.check(source, "carpetbotplaceholders.command.carpetbotplaceholders.reload", 4))
                            .executes(ctx -> reload(ctx.getSource()))
                    )
            );
        });
    }
    public static int reload(CommandSourceStack source) {
        try {
            ConfigData oldConfigData = CarpetBotPlaceholders.CONFIG_MANAGER.getData().clone();
            int returnCode = Utils.innitConfig(CarpetBotPlaceholders.CONFIG_MANAGER);
            if(returnCode > 0) {
                CarpetBotPlaceholders.CONFIG_MANAGER.setData(oldConfigData);
                source.sendFailure(Utils.minecraftLogBuilder.error("An error happened trying reload config!"));
                return 1;
            }
            if(returnCode == -1) {
                source.sendSuccess(() -> Utils.minecraftLogBuilder.warn("Missing config, created config successfully!"), true);
                CarpetBotPlaceholders.LOGGER.warn("[CarpetBotPlaceholders] Missing config, created config successfully!");
                return 0;
            }
            source.sendSuccess(() -> Utils.minecraftLogBuilder.log("Reloaded config successfully!"), true);
            CarpetBotPlaceholders.LOGGER.info("[CarpetBotPlaceholders] Reloaded config successfully!");
            return 0;
        } catch (Exception e) {
            source.sendFailure(Utils.minecraftLogBuilder.error("An error happened trying reload config"));
            CarpetBotPlaceholders.LOGGER.error("[CarpetBotPlaceholders] An error happened trying reload config", e);
            return 0;
        }
    }
}
