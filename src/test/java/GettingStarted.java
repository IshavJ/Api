import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GettingStarted {
    String url = "https://reqres.in/api/users?page=2", body, base = "http://localhost:3000";
    Response response;

    @BeforeClass(enabled = false)
    public void setup() {
        response = RestAssured.get(url);
    }

    @Test(enabled = false)
    public void tst() {
        int status = response.statusCode();
        System.out.println(status);
        Assert.assertEquals(status, 200, "Status code varies");
    }

    @Test(enabled = false)
    public void tst_bdd() {
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
    }

    @Test(enabled = false)
    public void post_1() {
        JSONObject request = new JSONObject();

        request.put("name", "Ishav");
        request.put("Job", "Intern");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().body(request.toJSONString()).when()
                .post("https://reqres.in/api/users").then()
                .statusCode(201).log().all();
    }

    @Test(enabled = false)
    public void get() {
        given().baseUri(base).param("body", "some other comment").
                get("/comments").then().statusCode(200).log().all();
    }

    @Test(enabled = false)
    public void post() {
        JSONObject jsOb = new JSONObject();
        jsOb.put("firstname", "Harry");
        jsOb.put("lastname", "Jnagal");
        jsOb.put("Contact", "12345");

        //add post method inside script
        given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(base).
                body(jsOb.toJSONString()).post("/comments/").then().statusCode(201).log().all();
    }

    @Test(enabled = false)
    public void patch() {
        JSONObject js = new JSONObject();
        js.put("firstname", "Jerry");

        // add patch method in the script
        given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(base).
                body(js.toJSONString()).patch("/profile").then().statusCode(200).log().all();
    }

    @Test(enabled = false)
    public void put() {
        JSONObject js = new JSONObject();
        js.put("firstname", "kerry");
        js.put("lastname", "kerry");
        js.put("salary", "abcxx");

        // add put method in the script
        given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(base).
                body(js.toJSONString()).put("/profile").then().statusCode(200).log().all();
    }

    @Test(enabled = false)
    public void delete(){
        given().baseUri(base).delete("/comments/5").then().log().all();
    }

    //Param Section
    @DataProvider(name = "Post_data")
    public String[][] post_data(){
        return new String[][]{
                {"Olla","Olla","1234"},
                {"franky","Johnson","123456"}
        };
    }

    @DataProvider(name = "del_data")
    public Object[][] del_data(){
        return new Object[][]{
                {"3"}
        };
    }

    public String[] x(){
        return new String[]{
          "123","123"
        };
    }

    @Test(dataProvider = "Post_data",enabled = false)
    public void post_param(String fname,String lname,String phone) {
        JSONObject jsOb = new JSONObject();
        jsOb.put("firstname", fname);
        jsOb.put("lastname", lname);
        jsOb.put("Contact", phone);

        //add post method inside script
        given().contentType(ContentType.JSON).accept(ContentType.JSON).baseUri(base).
                body(jsOb.toJSONString()).post("/comments/").then().statusCode(201).log().all();
    }

    @Test(enabled = true,dataProvider = "del_data")
    public void delete_param(Object x){
        given().baseUri(base).delete("/comments/"+x).then().log().all();
    }
}
