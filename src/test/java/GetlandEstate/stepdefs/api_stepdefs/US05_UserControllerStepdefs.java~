package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.base_url.BaseUrl;
import GetlandEstate.pojos.US05_UserControllerPayloadPojo;
import GetlandEstate.pojos.US05_UserControllerPostResponsePojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class US05_UserControllerStepdefs {

    US05_UserControllerPayloadPojo payloadPojo;
    Response response;
    US05_UserControllerPostResponsePojo actualData;
    US05_UserControllerPostResponsePojo expectedData;
    static int userId;


    @Given("User register için URL düzenlenir")
    public void userRegisterIçinURLDüzenlenir() {

        BaseUrl.spec.pathParams("first", "users", "second", "register");

    }

    @And("User register için payload düzenlenir")
    public void userRegisterIçinPayloadDüzenlenir() {

        payloadPojo = new US05_UserControllerPayloadPojo("APItest", "APItest", "(213) 651-4776", "123456.M", "Zb4ç4yY@example.com");

    }

    @When("User register için POST request gönderilir ve response alınır")
    public void userRegisterIçinPOSTRequestGönderilirVeResponseAlınır() {

        response = given(BaseUrl.spec).body(payloadPojo).post("{first}/{second}");
        actualData = response.as(US05_UserControllerPostResponsePojo.class);
        userId = actualData.getId();
        response.prettyPrint();

    }

    @Then("User register için Status Code {int} olduğu doğrulanır")
    public void userRegisterIçinStatusCodeOlduğuDoğrulanır(int statusCode) {

        response.then().assertThat().statusCode(statusCode);

    }

    @And("User register için response body dogrulanır")
    public void userRegisterIçinResponseBodyDogrulanır() {


        Assert.assertEquals(payloadPojo.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(payloadPojo.getLastName(), actualData.getLastName());
        Assert.assertEquals(payloadPojo.getPhone(), actualData.getPhone());
        Assert.assertEquals(payloadPojo.getEmail(), actualData.getEmail());


    }


    @Given("User controller GET için URL düzenlenir")
    public void userControllerGETIçinURLDüzenlenir() {


        BaseUrl.spec.pathParams("first", "users", "second", userId, "third", "admin");


    }

    @And("User controller GET için payload düzenlenir")
    public void userControllerGETIçinPayloadDüzenlenir() {

        expectedData = new US05_UserControllerPostResponsePojo
                (userId, "APItest", "APItest", "Zb4ç4yY@example.com", "(213) 651-4776");

    }


    @When("User controller için GET request gönderilir ve response alınır")
    public void userControllerIçinGETRequestGönderilirVeResponseAlınır() {

        response = given(BaseUrl.spec).when().get("{first}/{second}/{third}");
        actualData = response.as(US05_UserControllerPostResponsePojo.class);
        response.prettyPrint();

    }

    @Then("User controller GET için Status Code {int} olduğu doğrulanır")
    public void userControllerGETIçinStatusCodeOlduğuDoğrulanır(int statusCode) {

        Assert.assertEquals(200,response.statusCode());

    }

    @And("User controller GET için response body dogrulanır")
    public void userControllerGETIçinResponseBodyDogrulanır() {

        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(expectedData.getLastName(), actualData.getLastName());
        Assert.assertEquals(expectedData.getEmail(), actualData.getEmail());
        Assert.assertEquals(expectedData.getPhone(), actualData.getPhone());


    }


}
