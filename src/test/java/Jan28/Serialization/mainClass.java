package Jan28.Serialization;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class mainClass {
    @BeforeClass
    public void strt(){
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/users/";
    }
    @Test(priority = 2)
    public void pOst(){
        pojo pj = new pojo("Ishav","Tester");
        Response resp = given().contentType("application/json").body(pj)
                .when().post().
                then().statusCode(201).extract().response();
        System.out.println(resp.getBody().asString());
        System.out.println("Done Posting the data...");
    }
    @Test(priority = 1)
    public void gEt(){
        Response resp = given().when().get().then().
                statusCode(200).extract().response();
        System.out.println(resp.getBody().asString());
        System.out.println("Displayed Data...");
    }
    @Test(priority = 3)
    public void pUt(){
        pojo pj = new pojo("Ishav","Student");
        Response resp = given().contentType("application/json").body(pj).when().put().then().
                statusCode(200).extract().response();
        System.out.println(resp.getBody().asString());
        System.out.println("Done Updating the data...");
    }
    @Test(priority = 4)
    public void dEl(){
//        pojo pj = new pojo("Ishav","Student");
        Response resp = given().when().delete().then().
                statusCode(204).extract().response();
        System.out.println(resp.getBody().asString());
        System.out.println("Done Deletion of the data...");
    }
}
