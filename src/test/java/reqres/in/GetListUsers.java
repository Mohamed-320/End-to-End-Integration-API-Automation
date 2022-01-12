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
                // Validate on the page number of the returned data
                .body("page", equalTo(2))
                // validate on the number of data returned per page
                .body("per_page", equalTo(6))
                // Validate on the total number of pages
                .body("total_pages", equalTo(2))
                // validate on the returned data records in the data array
                .body("data.size()", is(6))

                // First returned data record validation in the returned data array
                .body("data[0].email", equalTo("michael.lawson@reqres.in"))
                .body("data[0].first_name", equalTo("Michael"))
                .body("data[0].last_name", equalTo("Lawson"))

                // Second returned data record validation in the returned data array
                .body("data[1].email", equalTo("lindsay.ferguson@reqres.in"))
                .body("data[1].first_name", equalTo("Lindsay"))
                .body("data[1].last_name", equalTo("Ferguson"))

                // Third returned data record validation in the returned data array
                .body("data[2].email", equalTo("tobias.funke@reqres.in"))
                .body("data[2].first_name", equalTo("Tobias"))
                .body("data[2].last_name", equalTo("Funke"))

                // Fourth returned data record validation in the returned data array
                .body("data[3].email", equalTo("byron.fields@reqres.in"))
                .body("data[3].first_name", equalTo("Byron"))
                .body("data[3].last_name", equalTo("Fields"))

                // Fifth returned data record validation in the returned data array
                .body("data[4].email", equalTo("george.edwards@reqres.in"))
                .body("data[4].first_name", equalTo("George"))
                .body("data[4].last_name", equalTo("Edwards"))

                // Sixth returned data record validation in the returned data array
                .body("data[5].email", equalTo("rachel.howell@reqres.in"))
                .body("data[5].first_name", equalTo("Rachel"))
                .body("data[5].last_name", equalTo("Howell"))
                // Validate on the response status code
                .statusCode(200)
                // list all the "response" returned data in the console
                .log().all();
    }
}
