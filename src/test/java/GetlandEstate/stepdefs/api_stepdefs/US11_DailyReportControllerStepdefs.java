package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.base_url.BaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.util.LinkedHashMap;
import java.util.Map;

import static GetlandEstate.utilities.ReusableMethods.get7DaysBeforeToday;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class US11_DailyReportControllerStepdefs {

    Response response;
    Map<String, Integer> contactMessages;
    Map<String, Integer> favorites;
    Map<String, Integer> rentAdverts;
    Map<String, Integer> saleAdverts;
    Map<String, Integer> tourRequests;
    Map<String, Integer> users;

    @Given("Daily Report controller GET için URL düzenlenir")
    public void dailyReportControllerGETIçinURLDüzenlenir() {

        BaseUrl.spec.pathParam("first", "daily-report");

    }

    @And("Daily Report controller GET için payload düzenlenir")
    public void dailyReportControllerGETIçinPayloadDüzenlenir() {


        contactMessages = new LinkedHashMap<>() {
            {
                put(get7DaysBeforeToday().get(0).toString(), 3);
                put(get7DaysBeforeToday().get(1).toString(), 3);
                put(get7DaysBeforeToday().get(2).toString(), 1);
                put(get7DaysBeforeToday().get(3).toString(), 2);
                put(get7DaysBeforeToday().get(4).toString(), 3);
                put(get7DaysBeforeToday().get(5).toString(), 120);
                put(get7DaysBeforeToday().get(6).toString(), 0);
                put(get7DaysBeforeToday().get(7).toString(), 19);
            }
        };

        favorites = new LinkedHashMap<>() {
            {
                put(get7DaysBeforeToday().get(0).toString(), 57);
                put(get7DaysBeforeToday().get(1).toString(), 57);
                put(get7DaysBeforeToday().get(2).toString(), 57);
                put(get7DaysBeforeToday().get(3).toString(), 57);
                put(get7DaysBeforeToday().get(4).toString(), 57);
                put(get7DaysBeforeToday().get(5).toString(), 57);
                put(get7DaysBeforeToday().get(6).toString(), 57);
                put(get7DaysBeforeToday().get(7).toString(), 57);
            }
        };

        rentAdverts = new LinkedHashMap<>() {
            {
                put(get7DaysBeforeToday().get(0).toString(), 40);
                put(get7DaysBeforeToday().get(1).toString(), 40);
                put(get7DaysBeforeToday().get(2).toString(), 40);
                put(get7DaysBeforeToday().get(3).toString(), 40);
                put(get7DaysBeforeToday().get(4).toString(), 40);
                put(get7DaysBeforeToday().get(5).toString(), 40);
                put(get7DaysBeforeToday().get(6).toString(), 40);
                put(get7DaysBeforeToday().get(7).toString(), 40);
            }
        };

        saleAdverts = new LinkedHashMap<>() {
            {
                put(get7DaysBeforeToday().get(0).toString(), 62);
                put(get7DaysBeforeToday().get(1).toString(), 62);
                put(get7DaysBeforeToday().get(2).toString(), 62);
                put(get7DaysBeforeToday().get(3).toString(), 64);
                put(get7DaysBeforeToday().get(4).toString(), 64);
                put(get7DaysBeforeToday().get(5).toString(), 64);
                put(get7DaysBeforeToday().get(6).toString(), 64);
                put(get7DaysBeforeToday().get(7).toString(), 64);
            }
        };

        tourRequests = new LinkedHashMap<>() {
            {
                put(get7DaysBeforeToday().get(0).toString(), 199);
                put(get7DaysBeforeToday().get(1).toString(), 200);
                put(get7DaysBeforeToday().get(2).toString(), 201);
                put(get7DaysBeforeToday().get(3).toString(), 128);
                put(get7DaysBeforeToday().get(4).toString(), 119);
                put(get7DaysBeforeToday().get(5).toString(), 118);
                put(get7DaysBeforeToday().get(6).toString(), 123);
                put(get7DaysBeforeToday().get(7).toString(), 128);
            }
        };

        users = new LinkedHashMap<>() {
            {
                put(get7DaysBeforeToday().get(0).toString(), 458);
                put(get7DaysBeforeToday().get(1).toString(), 468);
                put(get7DaysBeforeToday().get(2).toString(), 474);
                put(get7DaysBeforeToday().get(3).toString(), 481);
                put(get7DaysBeforeToday().get(4).toString(), 488);
                put(get7DaysBeforeToday().get(5).toString(), 494);
                put(get7DaysBeforeToday().get(6).toString(), 496);
                put(get7DaysBeforeToday().get(7).toString(), 505);
            }
        };

       // Map<String, Object> payload = new LinkedHashMap<>();
       // payload.put("ContactMessages", contactMessages);
       // payload.put("Favorites", favorites);
       // payload.put("RentAdverts", rentAdverts);
       // payload.put("SaleAdverts", saleAdverts);
       // payload.put("TourRequests", tourRequests);
       // payload.put("Users", users);

    }

    @When("Daily Report controller GET istegi gonderilir ve response alinir")
    public void dailyReportControllerGETIstegiGonderilirVeResponseAlinir() {

        response = given(BaseUrl.spec).when().get("{first}");
        response.prettyPrint();


    }

    @Then("Daily Report controller GET istegi status kodu {int} oldugundan emin olunur")
    public void dailyReportControllerGETIstegiStatusKoduOldugundanEminOlunur(int statusCode) {

        assertEquals(statusCode, response.statusCode());
    }

    @And("Daily Report controller GET istegi response body dogrulanir")
    public void dailyReportControllerGETIstegiResponseBodyDogrulanir() {

        JsonPath jsonPath = response.jsonPath();


        //"ContactMessages"
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(0).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(0).toString()));
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(1).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(1).toString()));
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(2).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(2).toString()));
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(3).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(3).toString()));
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(4).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(4).toString()));
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(5).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(5).toString()));
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(6).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(6).toString()));
        assertEquals(contactMessages.get(get7DaysBeforeToday().get(7).toString()), (Integer) jsonPath.getInt("ContactMessages." + get7DaysBeforeToday().get(7).toString()));

        //"Favorites"
        assertEquals(favorites.get(get7DaysBeforeToday().get(0).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(0).toString()));
        assertEquals(favorites.get(get7DaysBeforeToday().get(1).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(1).toString()));
        assertEquals(favorites.get(get7DaysBeforeToday().get(2).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(2).toString()));
        assertEquals(favorites.get(get7DaysBeforeToday().get(3).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(3).toString()));
        assertEquals(favorites.get(get7DaysBeforeToday().get(4).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(4).toString()));
        assertEquals(favorites.get(get7DaysBeforeToday().get(5).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(5).toString()));
        assertEquals(favorites.get(get7DaysBeforeToday().get(6).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(6).toString()));
        assertEquals(favorites.get(get7DaysBeforeToday().get(7).toString()), (Integer) jsonPath.getInt("Favorites." + get7DaysBeforeToday().get(7).toString()));

        //"RentAdverts"
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(0).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(0).toString()));
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(1).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(1).toString()));
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(2).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(2).toString()));
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(3).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(3).toString()));
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(4).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(4).toString()));
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(5).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(5).toString()));
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(6).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(6).toString()));
        assertEquals(rentAdverts.get(get7DaysBeforeToday().get(7).toString()), (Integer) jsonPath.getInt("RentAdverts." + get7DaysBeforeToday().get(7).toString()));

        // "SaleAdverts"
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(0).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(0).toString()));
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(1).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(1).toString()));
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(2).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(2).toString()));
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(3).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(3).toString()));
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(4).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(4).toString()));
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(5).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(5).toString()));
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(6).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(6).toString()));
        assertEquals(saleAdverts.get(get7DaysBeforeToday().get(7).toString()), (Integer) jsonPath.getInt("SaleAdverts." + get7DaysBeforeToday().get(7).toString()));

        //"TourRequests"
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(0).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(0).toString()));
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(1).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(1).toString()));
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(2).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(2).toString()));
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(3).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(3).toString()));
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(4).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(4).toString()));
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(5).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(5).toString()));
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(6).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(6).toString()));
        assertEquals(tourRequests.get(get7DaysBeforeToday().get(7).toString()), (Integer) jsonPath.getInt("TourRequests." + get7DaysBeforeToday().get(7).toString()));

        //"Users"
        assertEquals(users.get(get7DaysBeforeToday().get(0).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(0).toString()));
        assertEquals(users.get(get7DaysBeforeToday().get(1).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(1).toString()));
        assertEquals(users.get(get7DaysBeforeToday().get(2).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(2).toString()));
        assertEquals(users.get(get7DaysBeforeToday().get(3).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(3).toString()));
        assertEquals(users.get(get7DaysBeforeToday().get(4).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(4).toString()));
        assertEquals(users.get(get7DaysBeforeToday().get(5).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(5).toString()));
        assertEquals(users.get(get7DaysBeforeToday().get(6).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(6).toString()));
        assertEquals(users.get(get7DaysBeforeToday().get(7).toString()), (Integer) jsonPath.getInt("Users." + get7DaysBeforeToday().get(7).toString()));

    }
}
