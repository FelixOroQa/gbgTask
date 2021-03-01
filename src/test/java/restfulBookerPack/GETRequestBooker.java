package restfulBookerPack;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class GETRequestBooker {
    @Test
    public void healthCheckTest(){
        given().
                when().
                get("https://restful-booker.herokuapp.com/ping").
                then().
                assertThat().
                statusCode(201).log().all();

    }
    //@Test
    public void getBookingIdsWithoutFilterTest(){
        //Using BDD Syntax
//        given().
//                when().
//                get("https://restful-booker.herokuapp.com/booking").
//                then().
//                assertThat().
//                statusCode(200).log().all();

        //Get Response with Booking Ids
        Response response = get("https://restful-booker.herokuapp.com/booking");
        response.print();

        //Verify that the response is 200
        int statusCode = response.getStatusCode();
        //Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code should be 200, but it is not");

        //Verify at least 1 Booking Ids  in the response
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIds.isEmpty(), "but this should not be the case");

    }
    //@Test
    public void getBookingTest(){

        //Get Response with Booking
        Response response = get("https://restful-booker.herokuapp.com/booking/5");
        response.print();

        //Verify that the response is 200
        int statusCode = response.getStatusCode();
        //Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code should be 200, but it is not");

        //Verify All Fields
        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = response.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName,"Mary", "firstname is not expected");

        String actualLastName = response.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName,"Jones", "lastname is not expected");

        int price = response.jsonPath().getInt("totalprice");
        softAssert.assertEquals(price,236, "total price in response is not expected");

        boolean depositepaid = response.jsonPath().getBoolean("depositpaid");
        softAssert.assertFalse(depositepaid, "depositpaid should be false,but this is not the case");

//        boolean depositepaid = response.jsonPath().getBoolean("depositpaid");
//        softAssert.assertTrue(depositepaid, "depositpaid should be false,but this is not the case");

        String actualCheckin = response.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin,"2017-03-16", "checkin in response is not expected");

        String actualCheckout = response.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckout,"2017-03-16", "checkout in response is not expected");

        softAssert.assertAll();

    }
}
