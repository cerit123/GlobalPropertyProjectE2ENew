package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.US12CountryPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.List;
import java.util.Map;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US12CountriesConrollerStepdefs {


    private Response response;

    /*
        {
            "id": 82,
            "name": "Deutschland",
            "location": {
                "lat": 51.1638175,
                "lng": 10.4478313
            }
        },
         */
    @Given("Get icin Base URL kullanilir")
    public void getIcinBaseURLKullanilir() {
        spec.pathParams("first", "countries","second", "all");
    }
    @When("Tum sehirleri getirir")
    public void tumSehirleriGetirir() {
        Response response = given(spec).get("/{first}/{second}");
        this.response = response;

    }

    @And("Tum sehirleri alindigi dogrulanir")
    public void tumSehirleriAlindigiDogrulanir() {

//Map<String, Object> responseMap = response.as(US12CountryPojo.class);

    }
}
