package nasaApiPack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

/*
        Nasa_Open_Api   API KEY- OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX

1- 		APOD-  Astronomy Picture of the Day:-
            https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
2- 		Earth-  Landsat imagery is provided to the public as a joint project between NASA and USGS:-
            https://api.nasa.gov/planetary/earth/imagery?lon=100.75&lat=1.5&date=2014-02-01&api_key=DEMO_KEY
3-		EPIC--  The EPIC API provides information on the daily imagery collected by DSCOVR's Earth Polychromatic Imaging Camera (EPIC) instrument:-
            https://api.nasa.gov/EPIC/api/natural/all?api_key=DEMO_KEY
4-		InSight: Mars Weather Service API:
            https://api.nasa.gov/insight_weather/?api_key=DEMO_KEY&feedtype=json&ver=1.0
5-		TechTransfer-- NASA's Technology Transfer Program ensures that innovations developed for exploration and discovery are broadly available to the public.
            https://api.nasa.gov/techtransfer/patent/?engine&api_key=DEMO_KEY
6-		Techport--  NASA's resource for collecting and sharing information about NASA-funded technology development.
            https://api.nasa.gov/techport/api/specification?api_key=DEMO_KEY.
7- 		TLE API-- TLE API provides up to date two line element set records, the data is updated daily from CelesTrak and served in JSON format.
            http://tle.ivanstanojevic.me/api/tle
            The TLE API consists of two endpoints GET http://tle.ivanstanojevic.me
 */

public class NasaPublicApiTaskForGBG {

    //@Test(priority = 1, testName = "NASA-1 APOD")
    public void nasaGETRequestForAPOD() {
        baseURI = "https://api.nasa.gov";
        given()
                .contentType(ContentType.JSON)
                //.pathParam("", "")
        .when()
                .get("/planetary/apod?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX")
        .then()
                .statusCode(200)
                .body("copyright", equalTo("Nicolas Lefaudeux"))
                .body("media_type", equalTo("image")).log().all().log().all();
    }
    //@Test(priority = 2,testName = "NASA-2 Earth")
    public void nasaGETRequestForEarth() {
        RestAssured.given()
                .baseUri("https://api.nasa.gov")
        .when()
                .get("/planetary/earth/imagery?lon=100.75&lat=1.5&date=2014-02-01&api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").log().all();
    }
    @Test(priority = 3, testName = "NASA-3 EPIC")
    public void nasaGETRequestForEPIC() {
        RestAssured.given()
                .baseUri("https://api.nasa.gov")
        .when()
                .get("/EPIC/api/natural/all?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                //Verify
                .body("date", hasItems("2021-03-06"))
                .body("date", hasItems("2021-03-04")).log().all().log().all();
    }
    //@Test(priority = 4, testName = "NASA-4 Insight")
    public void nasaGETRequestInsight() {
        RestAssured.given()
                .baseUri("https://api.nasa.gov")
        .when()
                .get("/insight_weather/?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX&feedtype=json&ver=1.0")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").log().all();
    }
    @Test(priority = 5, testName = "NASA-5 TechTransfer")
    public void nasaGETRequestForTechTransfer() {
        RestAssured.given()
                .baseUri("https://api.nasa.gov")
        .when()
                .get("/techtransfer/patent/?engine&api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").log().all();
    }
    @Test(priority = 6, testName = "NASA-6 Techport")
    public void nasaGETRequestForTechPort() {
        // Given
        RestAssured.given()
                .baseUri("https://api.nasa.gov")
        .when()
                .get("/techport/api/specification?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX")
        .then()
                .statusCode(200).log().all();
    }
    @Test(priority = 7, testName = "nasa-7 TLE API")
    public void nasaGETRequestForTLEAPI() {
        RestAssured.given()
                .baseUri("http://tle.ivanstanojevic.me")
        .when()
                .get("/api/tle")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }
}
/*
                        Without Using BDD Syntax
    //@Test
    public void nasaAPI(){
        //
        Response response = get("https://api.nasa.gov/planetary/apod?api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX");

        System.out.println(response.asString());
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
*/
/*
Neo - Feed: Retrieve a list of Asteroids based on their closest approach date to Earth.
"https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=OMXY0toNAPUImihcMQB3WStbDymu9s65uxF0UdgX"

 */


