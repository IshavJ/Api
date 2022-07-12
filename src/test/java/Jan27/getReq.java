package Jan27;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class getReq {
    //Globally declared the hashmap to use the key-value pair...
    public HashMap hm = new HashMap();

    @BeforeClass
    public void strtup() {
        //both functions are used to enter the link on which testing will occur...
        RestAssured.baseURI = "https://reqres.in";    //will contain front part of uri...
        RestAssured.basePath = "/api/users";   //will contain the path...
    }

    @BeforeClass
    public void queryParm() {
        hm.put("page", 1);
        //eXtras.randomNum.radm() is used to add random values in the query param..
    }

    @Test
    public void getData() {
        //these are the basic codes to run an automation testing on the particular link..
        //given().when().then();
        Response resp =
                given().queryParams(hm).   //given is used to add the pre-req data..
                        when().get().  //used to add the request and uri..
                        then().statusCode(200)  //validations and outputs..
                        .statusLine("HTTP/1.1 200 OK").header("Content-Type", "application/json; charset=utf-8")
                        .extract().response();
        String x = resp.asString();
        System.out.println(x);
        //.log().all() function set is used to get the response value ...
    }
}
