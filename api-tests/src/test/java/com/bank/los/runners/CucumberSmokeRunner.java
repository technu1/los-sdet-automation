package com.bank.los.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.bank.los.steps"},
    plugin = {"pretty","json:target/cucumber/smoke.json",
              "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    tags = "@smoke"
)
public class CucumberSmokeRunner extends AbstractTestNGCucumberTests { }
