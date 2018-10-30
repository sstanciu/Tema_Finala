//import io.restassured.RestAssured;
//import org.testng.annotations.BeforeClass;
//
//import static io.restassured.RestAssured.given;
//
//public class CreateUsers {
//        public String username = "admin";
//        public String password = "admin";
//
//        @BeforeClass
//        public void Setup(){
//            RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinicSecured/api";
//            RestAssured.basePath = "/users";
//
//
//            given().auth().preemptive().basic(username, password).
//                    contentType("application/json").
//                    body("{\"enabled\": \"true\", \"username\": \"owneradmin\", \"password\": \"parola123\", \"roles\": \"OWNER_ADMIN\"}").when().
//                    post("/users").
//                    then().statusCode(201).log().all();
//            ;
//
//
//
//
//        }
//
//    }
