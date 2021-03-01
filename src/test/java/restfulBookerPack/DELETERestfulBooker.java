package restfulBookerPack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testForBase.BaseTest;

public class DELETERestfulBooker extends BaseTest {
    @Test
    public void deleteBookingTest (){
        //Create Booking
        Response responseCreate = createBooking();
        responseCreate.print();

        //Get BookingID of New Booking
        int bookingid = responseCreate.jsonPath().get("bookingid");

        //Delete Booking
        Response responseDelete = RestAssured.given().auth().preemptive().basic("admin", "password123").delete("https://restful-booker.herokuapp.com/booking/" + bookingid);
        responseDelete.print();

        //Verify that the response is 201
        int statusCode = responseDelete.getStatusCode();
        //Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(responseDelete.getStatusCode(), 200, "Status Code should be 200, but it is not");

    }
}
