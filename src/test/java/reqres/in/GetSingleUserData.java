package reqres.in;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUserData {
    @Test
    public void validateSingleUserResponse() {
        given().
                when().
                get("https://reqres.in/api/users/2").

                then().
                //TODO Validate on id and avatar
                body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validateSingleUserResponseUsingAssertions() {
        Response response = get("https://reqres.in/api/users/2");

        System.out.println(response.getBody().asString());
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("content-type"));

//      Status Code Validation
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200); // Assert that expected status code to be 200

//        Data Returned Validation
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Janet"));
        Assert.assertTrue(responseBody.contains("Weaver"));
        Assert.assertTrue(responseBody.contains("janet.weaver@reqres.in"));
    }
}
