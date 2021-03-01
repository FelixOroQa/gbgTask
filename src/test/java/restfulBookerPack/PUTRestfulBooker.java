package restfulBookerPack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testForBase.BaseTest;

public class PUTRestfulBooker extends BaseTest {
    @Test
    public void updateBookingTest (){
        //Create Booking
        Response responseCreate = createBooking();
        responseCreate.print();

        //Get BookingID of New Booking
        int bookingid = responseCreate.jsonPath().get("bookingid");


        //Create JSON Body
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("firstname", "Peter");
        jsonObject.put("lastname", "Well");
        jsonObject.put("totalprise", 300);
        jsonObject.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin",2021-03-3);
        bookingDates.put("checkout",2021-04-04);
        jsonObject.put("bookingdates", bookingDates);

        jsonObject.put("additionalneeds", "Extra Charger");

        //Update Booking
        Response responseUpdate = RestAssured.given().auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON).
                body(jsonObject.toJSONString()).put("https://restful-booker.herokuapp.com/booking/" + bookingid);
        responseUpdate.print();

        //Verify that the response is 200
        int statusCode = responseUpdate.getStatusCode();
        //Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(responseUpdate.getStatusCode(), 200, "Status Code should be 200, but it is not");

        //Verify All Fields
        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = responseUpdate.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName,"Peter", "firstname is not expected");

        String actualLastName = responseUpdate.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName,"Well", "lastname is not expected");

        int price = responseUpdate.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(price,300, "total price in response is not expected");

        boolean depositepaid = responseUpdate.jsonPath().getBoolean("depositpaid");
        softAssert.assertTrue(depositepaid, "depositpaid should be true,but this is not the case");

//        boolean depositepaid = response.jsonPath().getBoolean("depositpaid");
//        softAssert.assertTrue(depositepaid, "depositpaid should be false,but this is not the case");

        String actualCheckin = responseUpdate.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin,"2017-03-16", "checkin in response is not expected");

        String actualCheckout = responseUpdate.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckout,"2017-03-16", "checkout in response is not expected");

        softAssert.assertAll();

    }

}
