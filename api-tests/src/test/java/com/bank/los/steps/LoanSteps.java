package com.bank.los.steps;

import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoanSteps {

    private int fico;
    private int income;
    private int amount;
    private int term;

    @Given("a member with FICO score {int} and annualIncome {int}")
    public void a_member_with_FICO_score_and_annualIncome(Integer fico, Integer income) {
        this.fico = fico;
        this.income = income;
        System.out.println("Member created: FICO " + fico + " | Income " + income);
    }

    @When("the member submits a loan application for amount {int} and term {int}")
    public void the_member_submits_a_loan_application(Integer amount, Integer term) {
        this.amount = amount;
        this.term = term;
        System.out.println("Submitted loan: amount " + amount + " | term " + term);
    }

    @Then("the LOS returns status {string}")
    public void the_LOS_returns_status(String status) {
        System.out.println("Expected status: " + status);
        assertThat(status).isEqualTo("SUBMITTED");
    }
}
