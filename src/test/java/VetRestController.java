import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;

public class VetRestController {
public String username = "OWNER_ADMIN";
public String password ="test1234";

@BeforeClass

public void Setup(){
        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinicSecured/api";
        RestAssured.basePath = "/vets";
        given().
        auth().
        preemptive().
        basic(username,password).
        contentType(ContentType.JSON);


        }

@Test
public void getVets() {

        System.out.println("start getAllVets*********************");
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
public void postVet() {


        given().
        auth().
        preemptive().
        basic(username, password).
        contentType(ContentType.JSON).

        body("{  \"firstName\": \"simona\", \"id\": 49, \"lastName\": \"stanciui\", \"specialties\": [{ \"id\": 3,  \"name\": \"intern\" }]}").
        when().
        post().
        then().log().body().
        statusCode(400);
        }

@Test
public void deleteVet(){
        int vetId = 49;
        given().
        auth().
        preemptive().
        basic(username, password).
        pathParam("vetId", vetId).
        when().
        delete("/{vetId}").
        then().
        statusCode(400);

        }
@Test
public void updateVet() {
        int vetId = 49;
        given().log().all().
                auth().
                preemptive().
                basic(username, password).
                contentType(ContentType.JSON).
                pathParam("vetId", vetId).
                body("{  \"id\": 49, \"firstName\": \"simona\", \"lastName\": \"stanciui\", \"specialties\": [{ \"id\": 3,  \"name\": \"intern\" }]}").
                when().
                put("/{vetId}").
                then().
                statusCode(400);
        }
}
