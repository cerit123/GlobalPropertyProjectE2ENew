package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.US06PostPayloadPojo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;


public class US06ContactConrollerStepdefs {


    Response response;
    US06PostPayloadPojo payload;

    @Given("Base URL kullanilir")
    public void baseURLKullanilir() {
      spec.pathParam("first", "contact-messages");
    }


    @When("Yeni bir iletisim mesaji {string} olarak olusturulur")
    public void yeniBirIletisimMesajiOlarakOlusturulur(String message) {

        payload = new US06PostPayloadPojo("Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true);
         response = given(spec).body(payload).when().post("{first}");

    }

    @And("Staus code {int} olmalidir")
    public void stausCodeOlmalidir(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());

    }

    @Then("Yeni bir iletisim mesaji olusturuldigi dogrulanir")
    public void yeniBirIletisimMesajiOlusturuldigiDogrulanir() {

    }


}
