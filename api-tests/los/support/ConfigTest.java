package com.bank.los.support;

import com.bank.los.config.Config;
import com.bank.los.config.ConfigManager;
import org.testng.annotations.Test;

/**
 * Quick sanity check for ConfigManager.
 */
public class ConfigTest {

  @Test
  public void verifyConfigLoading() {
    // Load environment (pass "local", "dev", or "qa")
    Config cfg = ConfigManager.load("local");

    // Print values to verify
    System.out.println("Environment Base URL: " + cfg.baseUrl());
    System.out.println("Environment API Key: " + cfg.apiKey());
  }
}
