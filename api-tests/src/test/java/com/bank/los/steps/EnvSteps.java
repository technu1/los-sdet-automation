package com.bank.los.steps;

import io.cucumber.java.en.Given;

public class EnvSteps {
    @Given("environment is {string}")
    public void environment_is(String env) {
        System.out.println("Environment set to: " + env);
    }
}
