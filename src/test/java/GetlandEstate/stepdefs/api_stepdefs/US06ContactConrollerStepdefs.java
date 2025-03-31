package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.US06GetPojo;
import GetlandEstate.pojos.US06PostPayloadPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US06ContactConrollerStepdefs {

    private US06PostPayloadPojo payload;
    private Response response;
    US06GetPojo actualData;
    US06GetPojo expectedData;
    Response response1;

    //TC1-----------------------

    @Given("Base URL kullanilir")
    public void baseURLKullanilir() {
        spec.pathParam("first", "contact-messages");
    }

    @When("Yeni bir iletisim mesaji  olusturulur")
    public void yeniBirIletisimMesajiOlusturulur() {
        payload = new US06PostPayloadPojo("Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true);
        response = given(spec).body(payload).post("{first}");

    }

    @Then("Staus code {int} olmalidir")
    public void stausCodeOlmalidir(int statusCode) {
        assertEquals(statusCode, response.statusCode());

    }

    @And("Yeni bir iletisim mesaji olusturuldigi dogrulanir")
    public void yeniBirIletisimMesajiOlusturuldigiDogrulanir() {

        String expectedMessage = "Contact message saved successfully.";
        String actualMessage = response.asString();
        assertEquals("Beklenen mesaj ile gelen mesaj uyusmuyor", expectedMessage, actualMessage);

    }

    //TC2----------------------------

    @When("Tum mesajlardan ilki iletisim mesaji getirilir")
    public void tumMesajlardanIlkiIletisimMesajiGetirilir() {
        spec.pathParam("first", "contact-messages")
                .queryParam("query", "merhaba hayat")
                .queryParam("status", "true")
                .queryParam("page", 0)
                .queryParam("size", 20)
                .queryParam("sort", "createdAt")
                .queryParam("type", "DESC");

        expectedData = new US06GetPojo
                (2540, "Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true, "2025-03-25T09:38:32.004796");

        response = given(spec).get("{first}");
        actualData = response.jsonPath().getObject("content[0]", US06GetPojo.class);
        System.out.println("response.prettyPrint() = " + response.prettyPrint());

    }


    @And("Yeni bir iletisim mesaji alindigi dogrulanir")
    public void yeniBirIletisimMesajiAlindigiDogrulanir() {

        //assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getMessage(), expectedData.getMessage());
       // assertEquals(actualData.getCreatedAt(), expectedData.getCreatedAt());


    }

    //TC3-------------------------
    @When("Belirli bir iletisim mesaji ID göre alın")
    public void belirliBirIletisimMesajiIDGöreAlın() {

        spec.pathParams("first", "contact-messages", "second", 2745);

        expectedData = new US06GetPojo
                (2540, "Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true, "2025-03-25T09:38:32.004796");

        response1 = given(spec).get("{first}/{second}");
        actualData = response1.jsonPath().getObject("", US06GetPojo.class);


    }

    @And("Ve seçilen mesaj ayrıntılarını doğrulayın")
    public void veSeçilenMesajAyrıntılarınıDogrulayın() {

        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getMessage(), expectedData.getMessage());
        //assertEquals(actualData.getCreatedAt(), expectedData.getCreatedAt());


    }

    //TC4----------------
    @When("Belirli bir iletisim mesaji guncellenir")
    public void belirliBirIletisimMesajiGuncellenir() {
        spec.pathParams("first", "contact-messages", "second", 2557);

        expectedData = new US06GetPojo
                (2540, "Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true, "2025-03-25T09:38:32.004796");
        response = given(spec).get("{first}/{second}");
        actualData = response.jsonPath().getObject("", US06GetPojo.class);

       // assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getMessage(), expectedData.getMessage());
       // assertEquals(actualData.getCreatedAt(), expectedData.getCreatedAt());



    }

    //TC5 DEL.ID-------------------------------
    @Given("Belirli bir mesaj silinir")
    public void belirliBirMesajSilinir() {
        spec.pathParams("first", "contact-messages", "second", 2556);

        Map<String, Object> expectedData = new HashMap<>();

        response = given(spec).when().delete("{first}/{second}");

        // Verify that the response is successful
        assertEquals(200, response.getStatusCode());

        // Verify that the message is deleted
        Response responseAfterDelete = given(spec).when().get("{first}/{second}");
        assertEquals(2556, responseAfterDelete.getStatusCode());
    }
}
