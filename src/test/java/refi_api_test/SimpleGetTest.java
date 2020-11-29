package refi_api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest {
    private static final Logger LOGGER = LogManager.getLogger(SimpleGetTest.class);
    public void GetAllUsers(){
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        LOGGER.debug(response.getBody().asString());
        LOGGER.debug("Actual Status code:" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();


        String record = jsonPath.getString("data[0]");
        Assert.assertNotNull(record,"User record is null");

        //jsonPath.getString("data[0]");

    }
    @Test
    public void getSingleuser(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/2");
        LOGGER.debug(response.getBody().asString());
        LOGGER.debug("Actual Status code:" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();


        String record = jsonPath.getString("data.first_name");
        Assert.assertEquals(record,"Janet");

    }

}
