package reqres.in;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetListUsers {
    @Test
    public void retrieveListOfUsersData(){
        given().
                when().
                get("https://reqres.in/api/users?page=2")

                .then()
                .body("page", equalTo(2))
                .body("data.size()", is(6))
                .body("data[0].email", equalTo("michael.lawson@reqres.in"))
                .statusCode(200)
                .log().all();
    }
}
