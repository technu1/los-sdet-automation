
package com.bank.los.api;


import com.bank.los.config.Config;
import io.restassured.response.Response;
import java.util.Map;


public class LoanApi extends BaseApi {
public LoanApi(Config cfg) { super(cfg); }


public Response submitApplication(Map<String, Object> payload) {
return post("/api/loans", payload);
}


public Response getBureauReport(String appId) {
return get("/api/loans/" + appId + "/credit-bureau");
}


public Response getUnderwritingDecision(String appId) {
return get("/api/loans/" + appId + "/underwriting");
}


public Response initiateFunding(String appId, String method) {
return post("/api/loans/" + appId + "/funding", Map.of("method", method));
}
}