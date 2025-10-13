// ConfigManager.java
package com.bank.los.config;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigManager {
  public static Config load(String env) {
    try {
      String file = switch (env == null ? "local" : env) {
        case "dev" -> "src/test/resources/config/dev.properties";
        case "qa" -> "src/test/resources/config/qa.properties";
        default -> "src/test/resources/config/local.properties";
      };
      Properties p = new Properties();
      p.load(new FileInputStream(file));
      return new Config(p.getProperty("baseUrl"), p.getProperty("apiKey", ""));
    } catch (Exception e) { throw new RuntimeException(e); }
  }
}
