package regressApiPack;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PUTRequestReq {
    @Test
    public void performPUTRequest() {
        baseURI = "https://reqres.in/api";

        //Map<String, Object> map = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Felix");
        jsonObject.put("job", "TestEngineer");

        System.out.println(jsonObject.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).log().all();
    }
}
