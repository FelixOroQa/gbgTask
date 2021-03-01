package testForBase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected Response createBooking(){
        //Create JSON Body
        JSONObject jsonObject = new JSONObject();
        //Response response = createBooking();

        jsonObject.put("firstname", "Fel1x");
        jsonObject.put("lastname", "Oro");
        jsonObject.put("totalprise", 500);
        jsonObject.put("depositpaid", false);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin",2021-03-2);
        bookingDates.put("checkout",2021-03-27);
        jsonObject.put("bookingdates", bookingDates);

        jsonObject.put("additionalneeds", "Extra Charger");

        //Get Response
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(jsonObject.toJSONString()).post("https://restful-booker.herokuapp.com/booking");
        return response;
    }
}
