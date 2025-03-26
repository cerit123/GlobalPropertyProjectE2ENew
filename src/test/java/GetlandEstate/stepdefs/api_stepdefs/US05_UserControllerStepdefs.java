package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.base_url.BaseUrl;
import GetlandEstate.pojos.US05_UserControllerPatchPayloadPojo;
import GetlandEstate.pojos.US05_UserControllerPayloadPojo;
import GetlandEstate.pojos.US05_UserControllerPostResponsePojo;
import GetlandEstate.utilities.ConfigReader;
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
    US05_UserControllerPatchPayloadPojo patchPayload;



    @Given("User register için URL düzenlenir")
    public void userRegisterIçinURLDüzenlenir() {

        BaseUrl.spec.pathParams("first", "users", "second", "register");

    }

    @And("User register için payload düzenlenir")
    public void userRegisterIçinPayloadDüzenlenir() {

        payloadPojo = new US05_UserControllerPayloadPojo("APItest", "APItest", "(213) 651-4776", ConfigReader.getProperty("passwordCustomer"), ConfigReader.getProperty("emailCustomer"));

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


    //TC02 StepDefs

    @Given("User controller GET için URL düzenlenir")
    public void userControllerGETIçinURLDüzenlenir() {


        BaseUrl.spec.pathParams("first", "users", "second", userId, "third", "admin");


    }

    @And("User controller GET için payload düzenlenir")
    public void userControllerGETIçinPayloadDüzenlenir() {

        expectedData = new US05_UserControllerPostResponsePojo
                (userId, "APItest", "APItest", ConfigReader.getProperty("emailCustomer"), "(213) 651-4776");

    }


    @When("User controller için GET request gönderilir ve response alınır")
    public void userControllerIçinGETRequestGönderilirVeResponseAlınır() {

        response = given(BaseUrl.spec).when().get("{first}/{second}/{third}");
        actualData = response.as(US05_UserControllerPostResponsePojo.class);
        response.prettyPrint();

    }

    @Then("User controller GET için Status Code {int} olduğu doğrulanır")
    public void userControllerGETIçinStatusCodeOlduğuDoğrulanır(int statusCode) {

        Assert.assertEquals(200, response.statusCode());

    }

    @And("User controller GET için response body dogrulanır")
    public void userControllerGETIçinResponseBodyDogrulanır() {

        Assert.assertEquals(expectedData.getId(), actualData.getId());
        Assert.assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(expectedData.getLastName(), actualData.getLastName());
        Assert.assertEquals(expectedData.getEmail(), actualData.getEmail());
        Assert.assertEquals(expectedData.getPhone(), actualData.getPhone());


    }


    //TC03 StepsDefs

    @Given("User controller PATCH için URL düzenlenir")
    public void userControllerPATCHIçinURLDüzenlenir() {

        BaseUrl.spec.pathParams("first", "users", "second", "auth");

    }

    @And("User controller PATCH için payload düzenlenir")
    public void userControllerPATCHIçinPayloadDüzenlenir() {

        patchPayload = new US05_UserControllerPatchPayloadPojo
                ("customer", "Muhamme", "(544) 666-2221", ConfigReader.getProperty("passwordCustomer"), ConfigReader.getProperty("emailCustomer"), "CUSTOMER");

    }

    @When("User controller için PATCH request gönderilir ve response alınır")
    public void userControllerIçinPATCHRequestGönderilirVeResponseAlınır() {

        response = given(BaseUrl.spec).body(patchPayload).when().patch("{first}/{second}");
        response.prettyPrint();
        actualData = response.as(US05_UserControllerPostResponsePojo.class);

    }

    @Then("User controller PATCH için Status Code {int} olduğu doğrulanır")
    public void userControllerPATCHIçinStatusCodeOlduğuDoğrulanır(int statusCode) {

        Assert.assertEquals(statusCode, response.statusCode());

    }

    @And("User controller PATCH için response body dogrulanır")
    public void userControllerPATCHIçinResponseBodyDogrulanır() {

        Assert.assertEquals(patchPayload.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(patchPayload.getLastName(), actualData.getLastName());
        Assert.assertEquals(patchPayload.getEmail(), actualData.getEmail());
        Assert.assertEquals(patchPayload.getPhone(), actualData.getPhone());

    }

    //TC04 StepDefs


    @Given("User controller DELETE için URL düzenlenir")
    public void userControllerDELETEIçinURLDüzenlenir() {

        BaseUrl.spec.pathParams("first", "users", "second", "auth");

    }

    @When("User controller için DELETE request gönderilir ve response alınır")
    public void userControllerIçinDELETERequestGönderilirVeResponseAlınır() {

        response=given(BaseUrl.spec).delete("{first}/{second}");

    }

    @Then("User controller DELETE için Status Code {int} olduğu doğrulanır")
    public void userControllerDELETEIçinStatusCodeOlduğuDoğrulanır(int statusCode) {

        Assert.assertEquals(statusCode, response.statusCode());

    }







}
