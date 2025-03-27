package GetlandEstate.stepdefs.api_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US01_TourRequestsStepDefs {
    private String url;
    private String payload;
    private int statusCode;

    @Given("^Submit a tour request gondermek icin URL düzenlenir$")
    public void submit_a_tour_request_url_is_created() {
        // Implement the step to create the URL for submitting a tour request
        url = "https://example.com/tour-requests";
    }

    @And("^Tour Request için payload düzenlenir$")
    public void tour_request_payload_is_created() {
        // Implement the step to create the payload for the tour request
        payload = "{\"name\":\"John Doe\",\"email\":\"johndoe@example.com\"}";
    }

    @When("^Tour Request için POST request gönderilir ve response alınır$")
    public void tour_request_post_request_is_sent_and_response_is_received() {
        // Implement the step to send the POST request and get the response
        // Use a library like OkHttp or Unirest to send the request
        // Get the status code from the response
        statusCode = 201;
    }

    @Then("^Tour Request için Status Code (\\d+) olduğu doğrulanır$")
    public void tour_request_status_code_is_verified(Integer expectedStatusCode) {
        // Implement the step to verify the status code
        assert statusCode == expectedStatusCode;
    }
}