package com.bank.los.steps;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class WireMockHooks {
  private static WireMockServer server;

  @BeforeAll
  public static void startWireMock() {
    if (server == null || !server.isRunning()) {
      server = new WireMockServer(
          options()
              .port(9090)
              .usingFilesUnderDirectory("src/test/resources/wiremock"));
      server.start();
      System.out.println("✅ WireMock started on http://localhost:9090");
    }
  }

  @AfterAll
  public static void stopWireMock() {
    if (server != null && server.isRunning()) {
      server.stop();
      System.out.println("🛑 WireMock stopped");
    }
  }
}
