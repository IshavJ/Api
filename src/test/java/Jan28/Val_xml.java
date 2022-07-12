package Jan28;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;

public class Val_xml {
    @BeforeClass
    public void strtup(){
        RestAssured.baseURI="http://www.thomas-bayer.com/";
        RestAssured.basePath="sqlrest/CUSTOMER/2";
    }

    @Test
    public void gettingData(){
        given().when().get()
                .then().statusCode(200);
    }
//        @BeforeClass
//        public void uri_config(){
//            int id = 7;
//            RestAssured.baseURI = "http://www.thomas-bayer.com";
//            RestAssured.basePath = "/sqlrest/CUSTOMER/"+id;
//        }
//
//        @Test
//        public void validateXMl(){
//            given()
//
//                    .when()
//                    .get()
//
//                    .then()
//                    .statusCode(200)
//                    .log().all()
//                    .contentType("application/xml")
//                    .header("Content-Type", "application/xml")
//                    .body("CUSTOMER.CITY",equalTo("San Francisco"))
//                    .body("CUSTOMER.FIRSTNAME",equalTo("James"))
//                    .body("CUSTOMER.text()",contains("231 Upland Pl."));
//            //  .body("CUSTOMER.text()",containsInAnyOrder("231 Upland Pl."));
//        }

    }

