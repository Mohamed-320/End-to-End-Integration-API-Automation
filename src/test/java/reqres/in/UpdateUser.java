package reqres.in;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class UpdateUser {
    @Test
    public void updateUserData(){
        JSONObject update = new JSONObject();

        update.put("name","morpheus");
        update.put("job","zion resident");

        given().
                header("Content-type","application/json").
                contentType(ContentType.JSON).
                body(update.toJSONString()).

                // Perform PUT Operation
                when().
                put("https://reqres.in/api/users/2").

                then().
                body("name",equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .body("updatedAt", instanceOf(String.class))
                .statusCode(200)
                .log().all();
    }
}
