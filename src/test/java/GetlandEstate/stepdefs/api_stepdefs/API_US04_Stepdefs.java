package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.Us04postRequestPOJO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class API_US04_Stepdefs {
    Us04postRequestPOJO payload;
    Response response;

    @Given("set the url-")
    public void setTheUrl() {
        spec.pathParam("first", "advert-types");
    }

    @And("set the expected data-")
    public void setTheExpectedData() {
        payload=new Us04postRequestPOJO();
    }

    @When("send request get response")
    public void sendRequestGetResponse() {
        response = given(spec).body(payload).get("{first}");
        response.prettyPrint();
    }

    @Then("to do assertion- ilanın verildiği doğrulanır")
    public void toDoAssertionIlanınVerildiğiDoğrulanır() {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(payload.getTitle(),response.jsonPath().get("title"));

    }

    @Given("token alınmaz")
    public void tokenAlınmaz() {
    }

    @Then("to do assertion- {int} kodu ile {string} mesajı görülür")
    public void toDoAssertionKoduIleMesajıGörülür(int statusCode, String mesage) {
        Assert.assertTrue(response.statusCode()==statusCode);
        Assert.assertTrue(response.jsonPath().get("message").equals(mesage));

    }

    @Given("admin olarak token alınır")
    public void adminOlarakTokenAlınır() {
    }

    @And("set the url- url nin sonuna oluşturlan reklamın id si girilir")
    public void setTheUrlUrlNinSonunaOluşturlanReklamınIdSiGirilir() {
        spec.pathParams("first","advert-types","second",response.jsonPath().get("id"));
    }

    @And("get işlemi yapılır")
    public void getIşlemiYapılır() {
        given(spec).get("{first}/{second}");
    }

    @Then("to do assertion- {int} status code ile verilen ilan görünür olır")
    public void toDoAssertionStatusCodeIleVerilenIlanGörünürOlır(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
        Assert.assertTrue("title".equals(response.jsonPath().get("title")));
    }

    @And("set the expected data- url nin sonun id girilir")
    public void setTheExpectedDataUrlNinSonunIdGirilir() {
        spec.pathParams("first","advert-types","second",response.jsonPath().get("id"));

    }

    @And("herhangi bir hesap oluşturulmaz")
    public void herhangiBirHesapOluşturulmaz() {
    }

    @When("set the expected data- url nin sonun {string} girilir")
    public void setTheExpectedDataUrlNinSonunGirilir(String url) {
        spec.pathParams("first",url);
        given(spec).get("{first}");
    }
}
