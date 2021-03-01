package regressApiPack;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GETRequestReq {

    //@Test
    public void makeGetRequest(){
        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[4].first_name ", equalTo("George")).
                body("data.first_name", hasItems("George","Rachel"));

    }

    @Test
    public void performGetRequest(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void test_2(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].id", equalTo(8)).log();
    }
}

