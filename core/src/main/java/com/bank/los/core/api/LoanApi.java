package com.bank.los.core.api;

import io.restassured.response.Response;
import java.util.Map;

public class LoanApi extends BaseApi {
    public LoanApi(String baseUri) { super(baseUri); }

    public Response apply(int amount, int term, int creditScore) {
        return post("/api/loans", Map.of("amount", amount, "term", term, "creditScore", creditScore));
    }

    public Response status(String appId) {
        return get("/api/loans/" + appId + "/status");
    }
}
