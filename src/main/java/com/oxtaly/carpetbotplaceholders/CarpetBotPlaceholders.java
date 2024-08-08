package com.oxtaly.carpetbotplaceholders;

import com.oxtaly.carpetbotplaceholders.commands.ModCommands;
import com.oxtaly.carpetbotplaceholders.config.ConfigManager;
import com.oxtaly.carpetbotplaceholders.utils.Utils;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class CarpetBotPlaceholders implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "carpetbotplaceholders";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ConfigManager CONFIG_MANAGER = new ConfigManager();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		try {
			Utils.innitConfig(CONFIG_MANAGER);
			ModCommands.init();
			CarpetBotPlaceholdersPlaceHolders.register();
			LOGGER.info("[CarpetBotPlaceholders] Loaded!");
		} catch (IOException e) {
			LOGGER.error("[CarpetBotPlaceholders] An error happened trying to load config!", e);
		} catch (Exception e) {
			LOGGER.error("[CarpetBotPlaceholders] An error happened trying to load the mod!", e);
		}
	}
}