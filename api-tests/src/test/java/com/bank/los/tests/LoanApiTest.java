package com.bank.los.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoanApiTest {

    @Test
    public void positiveLoanApproval() {
        RestAssured.baseURI = "http://localhost:8089";
        given()
            .header("Content-Type", "application/json")
            .body("{\"loanAmount\":20000, \"creditScore\":750}")
        .when()
            .post("/loan/apply")
        .then()
            .statusCode(200)
            .body("status", equalTo("Approved"));
    }

    @Test
    public void negativeLoanDecline() {
        RestAssured.baseURI = "http://localhost:8089";
        given()
            .header("Content-Type", "application/json")
            .body("{\"loanAmount\":5000, \"creditScore\":650}")
        .when()
            .post("/loan/apply")
        .then()
            .statusCode(400)
            .body("status", equalTo("Declined"));
    }
}
