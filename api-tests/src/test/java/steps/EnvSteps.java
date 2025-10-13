package com.bank.los.steps;

import io.cucumber.java.en.Given;

public class EnvSteps {

  public EnvSteps() { }

  @Given("environment is {string}")
  public void environment_is(String declared) {
    String cliEnv = System.getProperty("env", System.getenv().getOrDefault("ENV", "local"));
    String effective = declared.startsWith("${") ? cliEnv : declared;
    System.out.println("✅ Environment step acknowledged. Effective env: " + effective);
  }
}
