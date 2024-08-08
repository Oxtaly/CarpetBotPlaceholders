package com.oxtaly.carpetbotplaceholders.config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().setLenient().create();
    public ConfigData data = ConfigData.DEFAULT;

    public ConfigManager() {}
    public ConfigManager(ConfigData data) {
        this.data = data;
    }

    public int readConfig(File file) throws IOException {
        Logger logger = LoggerFactory.getLogger("ResourcePackManager:config");
        FileReader reader = new FileReader(file);

        ConfigData configData = GSON.fromJson(reader, ConfigData.class);

        reader.close();

        configData.fillMissing();

        data = configData;
        return 0;
    }

    public void writeConfig(File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        GSON.toJson(data, writer);
        writer.close();
    }

    public void setData(ConfigData data) {
        this.data = data;
    }

    public ConfigData getData() {
        return this.data;
    }
}
