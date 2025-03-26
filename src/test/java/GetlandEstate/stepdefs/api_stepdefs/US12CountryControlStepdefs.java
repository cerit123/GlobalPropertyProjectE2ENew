package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.LocationPojo;
import GetlandEstate.pojos.US12CountryConrolPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US12CountryControlStepdefs {

    LocationPojo locationPojo;
    US12CountryConrolPojo expectedData;
    Response response;
    US12CountryConrolPojo actualData;
    @Given("Get icin Base URL kullanilir")
    public void getIcinBaseURLKullanilir() {

        spec.pathParams("first","countries","second","all");
    }

    @When("Tum sehirleri getirir")
    public void tumSehirleriGetirir() {
        locationPojo=new LocationPojo(51.1638175, 10.4478313);
        expectedData=new US12CountryConrolPojo( 82, "Deutschland",locationPojo);
        response = given(spec).when().get("{first}/{second}");
    }

    @And("Tum sehirleri alindigi dogrulanir")
    public void tumSehirleriAlindigiDogrulanir() {
         actualData=response.as(US12CountryConrolPojo.class);
        Assert.assertEquals(actualData.getId(),expectedData.getId());
        Assert.assertEquals(actualData.getName(),expectedData.getName());
        Assert.assertEquals(actualData.getLocation().getLat(),locationPojo.getLat());
        Assert.assertEquals(actualData.getLocation().getLng(),locationPojo.getLng());


    }
}
