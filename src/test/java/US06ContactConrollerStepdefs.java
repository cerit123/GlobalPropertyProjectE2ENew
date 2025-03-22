import GetlandEstate.base_url.BaseUrl;
import GetlandEstate.pojos.US06PostPayloadPojo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.path.json.JsonPath.given;

public class US06ContactConrollerStepdefs {

    public RequestSpecification spec;
    Response response;
    US06PostPayloadPojo payload;

    @Given("Base URL kullanilir")
    public void baseURLKullanilir() {
        spec.pathParam("first", "contact-messages");
    }


    @When("Yeni bir iletisim mesaji {string} olarak olusturulur")
    public void yeniBirIletisimMesajiOlarakOlusturulur(String message) {

        payload = new US06PostPayloadPojo("Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true);



    }

    @And("Staus code {int} olmalidir")
    public void stausCodeOlmalidir(int arg0) {
    }

    @Then("Yeni bir iletisim mesaji olusturuldigi dogrulanir")
    public void yeniBirIletisimMesajiOlusturuldigiDogrulanir() {
    }


}
