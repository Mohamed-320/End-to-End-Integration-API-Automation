package reqres.in;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUser {
    @Test
    public void deleteUserData() {
        given().
                when().
                //TODO may be this should be added to the given not the when
                        delete("https://reqres.in/api/users/2").

                then().
                statusCode(204)
                .log().all();
    }
}
