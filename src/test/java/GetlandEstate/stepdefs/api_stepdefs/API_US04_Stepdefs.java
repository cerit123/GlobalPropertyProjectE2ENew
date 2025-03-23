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
}
