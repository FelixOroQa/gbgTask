package nasaApiPack;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class NasaApiDemo {
    //Test
    public void nasaOne(){
        baseURI = "https://api.nasa.gov/planetary";
        given().
                get("/apod?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX").
                then().
                //body("page.size", equalTo(null)).
                        statusCode(200).log().all();
    }
    //@Test
    public void nasaTwo(){
        //
        Response response = get("https://api.nasa.gov/planetary/apod?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX");

        System.out.println(response.asString());
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    //@Test
    public void nasaThree(){
        baseURI = "https://api.nasa.gov";
        given().
                get("/neo/rest/v1/neo/browse?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX").
                then().
                statusCode(200).log().all();
    }
    //@Test
    public void nasaFour(){
        Response response = get("https://api.nasa.gov/neo/rest/v1/neo/3542519?api_key==OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX");

        System.out.println(response.asString());
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void nasaFive(){
        Response response = get("https://api.nasa.gov/DONKI/GST?startDate=yyyy-MM-dd&endDate=yyyy-MM-dd&api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX");

        System.out.println(response.asString());
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
/*
Neo - Feed: Retrieve a list of Asteroids based on their closest approach date to Earth.
"https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX"

 */


