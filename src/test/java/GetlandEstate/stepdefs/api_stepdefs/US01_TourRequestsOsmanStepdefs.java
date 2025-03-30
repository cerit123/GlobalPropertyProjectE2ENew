package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.TourTimepojo;
import GetlandEstate.pojos.US01TourRequestpojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US01_TourRequestsOsmanStepdefs {
    private String url;
    private US01TourRequestpojo payload;
    private int statusCode;
    Response response;




    @Given("Submit a tour request gondermek icin URL düzenlenir.")
    public void submitATourRequestGondermekIcinURLDüzenlenir() {

        spec.pathParam("first", "tour-requests");
    }

    @And("Tour Request için payload düzenlenir.")
    public void tourRequestIçinPayloadDüzenlenir() {

        TourTimepojo tourTime = new TourTimepojo(18, 0, 0, 0);
        payload = new US01TourRequestpojo("2025-03-30", tourTime, 1);
    }

    @When("Tour Request için POST request gönderilir ve response alınır.")
    public void tourRequestIçinPOSTRequestGönderilirVeResponseAlınır() {

        response = given(spec).body(payload).post("{first}");
    }

    @Then("Tour Request için Status Code {\\d+} olduğu doğrulanır.")
    public void tourRequestIçinStatusCodeOlduğuDoğrulanır(int expectedStatusCode) {

        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    @Given("Url Get requeste gore duzenlenir.")
    public void urlGetRequesteGoreDuzenlenir() {

        spec.pathParams("first", "tour-requests", "second", 1031, "third", "approve");
    }

    @And("Get request gonderilir ve response alinır.")
    public void getRequestGonderilirVeResponseAlinır() {

        response = given(spec).when().get("{first}/{second}");
    }

    @Then("Status Code {int} oldugundan emin olunur.")
    public void statusCodeOldugundanEminOlunur(int arg0) {

        Assert.assertEquals(statusCode, response.statusCode());
    }

    @Given("Url Cancel requeste gore duzenlenir.")
    public void urlCancelRequesteGoreDuzenlenir() {

        spec.pathParams("first", "tour-requests", "second", 285, "third", "cancel");
    }

    @Given("Url Put requeste gore duzenlenir.")
    public void urlPutRequesteGoreDuzenlenir() {

        spec.pathParams("first", "tour-requests", "second", 1044, "third", "auth");
    }

    @And("Put islemi icin payload olusturulur.")
    public void putIslemiIcinPayloadOlusturulur() {

        TourTimepojo tourTime = new TourTimepojo(17, 0, 0, 0);
        payload = new US01TourRequestpojo("2025-03-30", tourTime, 1);
    }

    @And("Put request gonderilir ve response alinir.")
    public void putRequestGonderilirVeResponseAlinir() {

        response = given(spec).body(payload).when().put("{first}/{second}/{third}");
    }

    @Given("Url decline requeste gore duzenlenir.")
    public void urlDeclineRequesteGoreDuzenlenir() {

        spec.pathParams("first", "tour-requests", "second", 1044, "third", "decline");
    }


    @Given("Url tour request gormek icin duzenlenir.")
    public void urlTourRequestGormekIcinDuzenlenir() {

        spec.pathParams("first", "tour-requests", "second", "admin");
    }

    @Given("Url tour requesti silmek icin duzenlenir.")
    public void urlTourRequestiSilmekIcinDuzenlenir() {

        spec.pathParams("first", "tour-requests", "second", 1044);
    }

    @And("Delete request gonderilir ve response alinir.")
    public void deleteRequestGonderilirVeResponseAlinir() {

        response = given(spec).when().delete("{first}/{second}");
    }
}
