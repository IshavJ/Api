package Jan27;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class failed_login {
    //Globally declared the hashmap to use the key-value pair...
    public HashMap hm = new HashMap();

    @BeforeClass
    public void strtup() {
        //both functions are used to enter the link on which testing will occur...
        RestAssured.baseURI = "https://reqres.in";    //will contain front part of uri...
        RestAssured.basePath = "/api/login";   //will contain the path...
    }

    @BeforeClass
    public void get_val() {
        hm.put("email", "eve.holt@reqres.in");
        hm.put("password", "");
    }

    @Test
    public void getData() {
        //these are the basic codes to run an automation testing on the particular link..
        //given().when().then();
        Response resp =
                given().contentType("application/json").body(hm).  //given is used to add the pre-req data..
                        when().post().  //used to add the request and uri..
                        then().statusCode(200)
                        .body("token", equalTo("QpwL5tke4Pnpja7X4")).extract().response();//validations and outputs..

        String x = resp.asString();
        System.out.println(x);
        //.log().all() function set is used to get the response value ...
    }
}
