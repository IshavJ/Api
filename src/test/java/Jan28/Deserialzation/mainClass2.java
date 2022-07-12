package Jan28.Deserialzation;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class mainClass2 {
    public HashMap hm = new HashMap();
    @BeforeClass
    public void strtup(){
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/users/";
    }
    @BeforeClass
    public void query(){
        hm.put("page",2);
    }
    @Test
    public void gEt(){
        given().queryParams(hm).when().get().as(pOjo.class);
    }
//    @Test
//    public void main2(){
//        given().queryParams(hm).when().put().as(pOjo.class);
//    }
}
