package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.LocationPojo;
import GetlandEstate.pojos.US13CitiesPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US13CitiesControllStepdefs {

    Response response;
    LocationPojo locationPojo;
    US13CitiesPojo expectedData;
    US13CitiesPojo actualData;
    @Given("Kullanıcı için GET URL oluşturulur")
    public void kullanıcıIçinGETURLOluşturulur() {
        spec.pathParams("first", "cities", "second", "search","third",82);
    }

    @And("kullanıcı için GET isteği gönderilir ve yanıt alınır")
    public void kullanıcıIçinGETIsteğiGönderilirVeYanıtAlınır() {
         locationPojo=new LocationPojo(45.71001315,3.1531802964975517);
         expectedData=new US13CitiesPojo(1354,"Auvergne",locationPojo);
        response = given(spec).when().get("{first}/{second}/{third}");
    }



    @Then("yanıt gövdesinin kullanıcı için doğru olduğu doğrulanır")
    public void yanıtGövdesininKullanıcıIçinDoğruOlduğuDoğrulanır() {

         actualData=response.as(US13CitiesPojo.class);
        Assert.assertEquals(actualData.getId(),expectedData.getId());
        Assert.assertEquals(actualData.getName(),expectedData.getName());
        Assert.assertEquals(actualData.getLocation().getLat(),locationPojo.getLat());
        Assert.assertEquals(actualData.getLocation().getLng(),locationPojo.getLng());




    }
}
