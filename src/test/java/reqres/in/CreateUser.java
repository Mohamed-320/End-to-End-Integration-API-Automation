package reqres.in;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class CreateUser {
    @Test
    public void createUser() {
        JSONObject dataProvided = new JSONObject();
//        Parameter to be added using POST peration
        dataProvided.put("name", "morpheus");
        dataProvided.put("job", "leader");

        given().
                header("Content-type", "application/json").
                contentType(ContentType.JSON).
                body(dataProvided.toJSONString()).

                // Perform POST Operation
                when().
                post("https://reqres.in/api/users").

                then().
                 body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                // TODO Check id and createdAt
                .body("id", instanceOf(String.class))
                .body("createdAt", instanceOf(String.class))
                .statusCode(201)                     // Status Code Validation expected to be 201
                .log().all();                        // Logs For The JSON Object Created on Server
    }
}
