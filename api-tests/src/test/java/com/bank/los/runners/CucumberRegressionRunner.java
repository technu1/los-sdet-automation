package com.bank.los.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.bank.los.steps"},
    plugin = {
        "pretty",
        "json:target/cucumber/regression.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    tags = "@regression"
)
public class CucumberRegressionRunner extends AbstractTestNGCucumberTests {
  // optional: enable parallel execution of scenarios in TestNG
  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
