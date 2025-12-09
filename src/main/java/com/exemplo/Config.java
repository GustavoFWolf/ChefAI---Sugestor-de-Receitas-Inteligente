package com.exemplo;

import java.nio.file.*;
import org.json.JSONObject;

public class Config {

    private static JSONObject config;

    static {
        try {
            String json = Files.readString(Path.of("config.json"));
            config = new JSONObject(json);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar config.json", e);
        }
    }

    public static String getConfig(String key) {
        return config.getString(key);
    }
}
