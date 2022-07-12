package Jan27;

import eXtras.Val_postFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class postReq {
        //Globally declared the hashmap to use the key-value pair...
        public HashMap hm = new HashMap();

        @BeforeClass
        public void strtup() {
            //both functions are used to enter the link on which testing will occur...
            RestAssured.baseURI = "https://reqres.in";    //will contain front part of uri...
            RestAssured.basePath = "/api/users/";   //will contain the path...
        }

        @BeforeClass
        public int get_val() {
            hm.put("name", Val_postFile.get_Name());
            hm.put("job",Val_postFile.get_Job());
            return 0;
        }

        @Test
        public void getData() {
            //these are the basic codes to run an automation testing on the particular link..
            //given().when().then();
            Response resp =
                    given().body(get_val()).   //given is used to add the pre-req data..
                            when().post().  //used to add the request and uri..
                            then().statusCode(201)  //validations and outputs..
                            .extract().response();
            String x = resp.asString();
            System.out.println(x);
            //.log().all() function set is used to get the response value ...
        }
    }
