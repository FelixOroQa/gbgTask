package regressApiPack;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DELETERequestReq {
    @Test
    public void performDELETA() {
        baseURI = "https://reqres.in";

        when().
                delete("/api/users/2").
                then().
                statusCode(204).log().all();
    }
}
