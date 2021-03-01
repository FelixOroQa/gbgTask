package restfulBookerPack;

import org.testng.Assert;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import testForBase.BaseTest;

public class POSTRequestBooker extends BaseTest {
    @Test
    public void createBookingTest(){
        Response response = createBooking();
        response.print();

        //Verify that the response is 200
        int statusCode = response.getStatusCode();
        //Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code should be 200, but it is not");

        //Verify All Fields
        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName,"Mary", "firstname is not expected");

        String actualLastName = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastName,"Jones", "lastname is not expected");

        int price = response.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(price,236, "total price in response is not expected");

        boolean depositepaid = response.jsonPath().getBoolean("booking.depositpaid");
        softAssert.assertFalse(depositepaid, "depositpaid should be false,but this is not the case");

//        boolean depositepaid = response.jsonPath().getBoolean("depositpaid");
//        softAssert.assertTrue(depositepaid, "depositpaid should be false,but this is not the case");

        String actualCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(actualCheckin,"2017-03-16", "checkin in response is not expected");

        String actualCheckout = response.jsonPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(actualCheckout,"2017-03-16", "checkout in response is not expected");

        softAssert.assertAll();

    }
}
