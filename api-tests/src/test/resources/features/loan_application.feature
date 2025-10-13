@regression @los @api
Feature: Loan application lifecycle
  As a credit union
  I want to originate loans safely
  So that we serve members with compliant decisions

  Background:
    # env is read by ConfigManager via -Denv or ENV
    Given environment is "${env:-local}"

  @smoke
  Scenario: Member applies for a loan and is approved
    Given a member with FICO score 760 and annualIncome 120000
    When the member submits a loan application for amount 25000 and term 36
    Then the LOS returns status "SUBMITTED"
    And a credit bureau check is performed
    And underwriting decision is "APPROVED"
    And funding is initiated with disbursement "ACH"

  Scenario Outline: Negative paths - income or credit too low
    Given a member with FICO score <fico> and annualIncome <income>
    When the member submits a loan application for amount 15000 and term 24
    Then underwriting decision is "DECLINED"
    And decline reason contains "<reason>"

    Examples:
      | fico | income | reason              |
      | 580  | 48000  | credit too low      |
      | 690  | 25000  | insufficient income |
