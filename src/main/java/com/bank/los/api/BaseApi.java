package com.bank.los.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.bank.los.config.Config;



public abstract class BaseApi {
protected final Config cfg;


protected BaseApi(Config cfg) {
this.cfg = cfg;
}


protected Response get(String path) {
return given().baseUri(cfg.baseUrl()).log().ifValidationFails().get(path);
}


protected Response post(String path, Object body) {
return given()
.baseUri(cfg.baseUrl())
.contentType("application/json")
.body(body)
.log().ifValidationFails()
.post(path);
}
}