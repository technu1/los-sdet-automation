@smoke @regression
Feature: Loan Application Lifecycle

  Background:
    Given environment is "local"

  Scenario: Happy path approval
    Given a member with FICO score 760 and annualIncome 120000
    When the member submits a loan application for amount 25000 and term 36
    Then the LOS returns status "SUBMITTED"
