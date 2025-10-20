package com.bank.los.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        loadConfig();
    }

    private static void loadConfig() {
        // Read from system property, default to QA
        String env = System.getProperty("env", "qa").toLowerCase();
        String configPath = "core/src/main/resources/config." + env + ".properties";

        try (FileInputStream fis = new FileInputStream(configPath)) {
            props.load(fis);
            System.out.println("✅ Loaded environment config: " + configPath);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load configuration file for environment: " + env, e);
        }
    }

    public static String get(String key) {
        // Allow runtime override from system property (Jenkins, etc.)
        return System.getProperty(key, props.getProperty(key));
    }
}
