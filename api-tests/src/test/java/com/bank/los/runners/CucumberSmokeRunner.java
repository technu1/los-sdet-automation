package com.bank.los.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.bank.los.steps", "com.bank.los.support"},
    plugin = {"pretty","json:target/cucumber/smoke.json",
              "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    tags = "@smoke")
public class CucumberSmokeRunner extends AbstractTestNGCucumberTests {
  @Override @DataProvider(parallel = true)
  public Object[][] scenarios() { return super.scenarios(); }
}
