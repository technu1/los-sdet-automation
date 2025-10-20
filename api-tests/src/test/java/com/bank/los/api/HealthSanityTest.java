package com.bank.los.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HealthSanityTest {

    @Test
    public void health_is_up_200() {
        given()
            .baseUri("http://localhost:8089")
            .log().all()
        .when()
            .get("/health")
        .then()
            .log().all()
            .statusCode(200)
            .body("status", equalTo("UP"));
    }
}
