package com.bank.los.core.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseApi {
    public BaseApi(String baseUri) { RestAssured.baseURI = baseUri; }

    protected Response get(String path) { return RestAssured.given().when().get(path); }
    protected Response post(String path, Object body) {
        return RestAssured.given().contentType("application/json").body(body).when().post(path);
    }
}
