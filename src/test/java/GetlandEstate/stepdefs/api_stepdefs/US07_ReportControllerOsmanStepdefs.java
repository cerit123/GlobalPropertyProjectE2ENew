package GetlandEstate.stepdefs.api_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US07_ReportControllerOsmanStepdefs {

    Response response;

    @Given("Url tum raporlari gormek icin duzenlenir.")
    public void urlTumRaporlariGormekIcinDuzenlenir() {

        spec.pathParam("first", "report");
    }

    @Given("Url tour request raporlari gormek icin duzenlenir.")
    public void urlTourRequestRaporlariGormekIcinDuzenlenir() {

        spec.pathParams("first", "report", "second", "tour-requests");
    }

    @Given("Url most popular raporlari gormek icin duzenlenir.")
    public void urlMostPopularRaporlariGormekIcinDuzenlenir() {

        spec.pathParams("first", "report", "second", "most-popular");
    }

    @And("Most Popular raaporlar icin Get request gonderilir ve response alinir.")
    public void mostPopularRaaporlarIcinGetRequestGonderilirVeResponseAlinir() {

        spec.pathParams("first", "report", "second", "most-popular");
    }

    @Given("Url adverts raporlari gormek icin duzenlenir.")
    public void urlAdvertsRaporlariGormekIcinDuzenlenir() {

        spec.pathParams("first", "report", "second", "adverts");
    }

    @And("Adverts raporlarini gormek icin Get request gonderilir ve response alinir.")
    public void advertsRaporlariniGormekIcinGetRequestGonderilirVeResponseAlinir() {
    }

    @And("Rapor icin Get request gonderilir ve response alinir")
    public void raporIcinGetRequestGonderilirVeResponseAlinir() {
        response = given(spec).when().get("{first}");
    }

    @And("Tour Request Rapor icin Get request gonderilir ve response alinir")
    public void tourRequestRaporIcinGetRequestGonderilirVeResponseAlinir() {
        response = given(spec).when().get("{first}/{second}");
    }
}
