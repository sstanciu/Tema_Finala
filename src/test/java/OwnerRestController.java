import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OwnerRestController {
    public String username = "VET_ADMIN";
    public String password ="test1234";

    @BeforeClass
    public void Setup() {
        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinicSecured/api";
        RestAssured.basePath = "/owners";


        given().
                auth().
                preemptive().
                basic(username,password).
                contentType(ContentType.JSON);


    }

    @Test
    public void getVets() {
        given().
                auth().
                preemptive().
                basic(username, password).
                contentType(ContentType.JSON).
                when().
                get().
                then().assertThat().statusCode(400);
    }

    @Test
    public void postOwner() {

        String myBody = "{\n" +
        "\t\"id\": 99,\n" +
        "    \"firstName\": \"gigi\",\n" +
        "    \"lastName\": \"gigi\",\n" +
        "    \"address\": \"Pitesti\",\n" +
        "    \"city\": \"Arges\",\n" +
        "    \"telephone\": \"0756333333\",\n" +
        "    \"pets\": []\n" +
        "\t}";

        given().
                auth().
                preemptive().
                basic(username, password).
                contentType(ContentType.JSON).
                body(myBody).
                when().
                post().
                then().log().body().
                statusCode(400);
    }

    @Test
    public void deleteOwner() {
        int ownerId = 99;

        given().
                auth().
                preemptive().
                basic(username, password).
                pathParam("ownerId", ownerId).
                when().
                delete("/{ownerId)").
                then().
                statusCode(400);
    }

    @Test
    public void updateOwner() {
        int ownerId= 97;

        given().
                auth().
                preemptive().
                basic(username, password).
                contentType(ContentType.JSON).
                pathParam("ownerId", ownerId).
                body("{\n" +
                        "    \"address\": \"Calea Victoriei, nr.13B\",\n" +
                        "    \"city\": \"Pitesti\",\n" +
                        "    \"firstName\": \"Simona1\",\n" +
                        "    \"id\": 58,\n" +
                        "    \"lastName\": \"Stanciu\",\n" +
                        "    \"pets\": []\n" +
                        "    \"telephone\": \"0726221234\",\n" +
                        "  }").
                when().
                put("/{ownerId}").
                then().
                statusCode(400);
    }

}
