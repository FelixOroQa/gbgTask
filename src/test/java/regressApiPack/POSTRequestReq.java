package regressApiPack;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class POSTRequestReq {

    @Test
    public void makePostRequest(){
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Felix");
        jsonObject.put("job", "TestEngineer");

        System.out.println(jsonObject.toJSONString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();

    }
}

