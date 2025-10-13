package com.bank.los.support;

import com.bank.los.config.Config;
import com.bank.los.config.ConfigManager;
import io.restassured.response.Response;
import java.util.Map;

public class World {
  private final Config config;
  public Response lastResponse;
  public String applicationId;
  public Map<String, Object> memberPayload;

  public World() {
    String env = System.getProperty("env", System.getenv().getOrDefault("ENV", "local"));
    this.config = ConfigManager.load(env);
  }
  public Config config() { return config; }
}
