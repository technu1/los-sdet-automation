package com.bank.los.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {
    private final Properties p = new Properties();

    public EnvConfig() {
        String env = System.getProperty("env", "local");
        String file = "/config/" + env + ".properties";
        try (InputStream in = getClass().getResourceAsStream(file)) {
            if (in == null)
                throw new IllegalStateException("Missing env file: " + file);
            p.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return System.getProperty(key, p.getProperty(key));
    }

    public String baseUrl() {
        return get("base.url");
    }

    public String apiUrl() {
        return get("api.url");
    }

    public String user() {
        return get("user");
    }

    public String pass() {
        return get("pass");
    }
}
