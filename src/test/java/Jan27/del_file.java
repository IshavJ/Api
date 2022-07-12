package Jan27;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class del_file {
        //Globally declared the hashmap to use the key-value pair...
        public HashMap hm = new HashMap();

        @BeforeClass
        public void strtup() {
            //both functions are used to enter the link on which testing will occur...
            RestAssured.baseURI = "https://reqres.in";    //will contain front part of uri...
            RestAssured.basePath = "/api/users/2";   //will contain the path...
        }

        @Test
        public void getData() {
            //these are the basic codes to run an automation testing on the particular link..
            //given().when().then();
            Response resp =
                    given().  //given is used to add the pre-req data..
                            when().delete().  //used to add the request and uri..
                            then().statusCode(204)
                            .extract().response();//validations and outputs..

            String x = resp.asString();
            System.out.println(x +" Done Deletion..");
            //.log().all() function set is used to get the response value ...
        }
    }



