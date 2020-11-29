package refi_api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePatchTest {
    private static final Logger LOGGER = LogManager.getLogger(SimplePatchTest.class);

    @Test
    public void updateExistingUserSingleField() {

        String jobRole = "driver";
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject reqBody = new JSONObject();

        reqBody.put("job",jobRole);
        LOGGER.debug("request body:" + reqBody);

        httpRequest.header("Content-Type", "Application/json");
        httpRequest.body(reqBody.toJSONString());
        Response response = httpRequest.request(Method.PATCH,"/2");
        LOGGER.debug(response.getBody().asString());
        LOGGER.debug("Actual Status code:" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();


        String record = jsonPath.getString("job");
        Assert.assertEquals(record, jobRole);
    }
}
