package com.bank.los.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.bank.los.api.LoanApi;
import com.bank.los.config.ConfigManager;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import java.util.Map;

public class LoanSteps {
  private final LoanApi loanApi;
  private Response lastResponse;
  private String applicationId;
  private Map<String, Object> memberPayload;

  public LoanSteps() {
    String env = System.getProperty("env", System.getenv().getOrDefault("ENV", "local"));
    this.loanApi = new LoanApi(ConfigManager.load(env));
  }

  @Given("a member with FICO score {int} and annualIncome {int}")
  public void memberWithFicoAndIncome(int fico, int income) {
    memberPayload = Map.of("fico", fico, "annualIncome", income);
  }

  @When("the member submits a loan application for amount {int} and term {int}")
  public void submitLoanApp(int amount, int term) {
    memberPayload = new java.util.HashMap<>(memberPayload);
    memberPayload.put("amount", amount);
    memberPayload.put("term", term);
    lastResponse = loanApi.submitApplication(memberPayload);
    applicationId = lastResponse.jsonPath().getString("applicationId");
  }

  @Then("the LOS returns status {string}")
  public void losReturnsStatus(String expected) {
    assertThat(lastResponse.statusCode()).isBetween(200, 201);
    assertThat(lastResponse.jsonPath().getString("status")).isEqualTo(expected);
  }

  @Then("a credit bureau check is performed")
  public void creditCheckPerformed() {
    Response resp = loanApi.getBureauReport(applicationId);
    assertThat(resp.statusCode()).isEqualTo(200);
    assertThat(resp.jsonPath().getString("bureau")).isEqualTo("EQUIFAX");
  }

  @Then("underwriting decision is {string}")
  public void underwritingDecision(String decision) {
    Response resp = loanApi.getUnderwritingDecision(applicationId);
    assertThat(resp.statusCode()).isEqualTo(200);
    assertThat(resp.jsonPath().getString("decision")).isEqualTo(decision);
  }

  @Then("decline reason contains {string}")
  public void declineReason(String reason) {
    assertThat(lastResponse.jsonPath().getString("declineReason")).containsIgnoringCase(reason);
  }

  @Then("funding is initiated with disbursement {string}")
  public void fundingInitiated(String method) {
    Response resp = loanApi.initiateFunding(applicationId, method);
    assertThat(resp.statusCode()).isEqualTo(201);
    assertThat(resp.jsonPath().getString("disbursementMethod")).isEqualTo(method);
  }
}
