package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.US06GetPojo;
import GetlandEstate.pojos.US06PostPayloadPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US06ContactConrollerStepdefs {

    private US06PostPayloadPojo payload;
    private Response response;
    US06GetPojo actualData;
    US06GetPojo expectedData;


    @Given("Base URL kullanilir")
    public void baseURLKullanilir() {
        spec.pathParam("first", "contact-messages");
    }

    @When("Yeni bir iletisim mesaji  olusturulur")
    public void yeniBirIletisimMesajiOlusturulur() {

        payload = new US06PostPayloadPojo("Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true);
        Response response = given(spec).body(payload).post("{first}");
        // Yanıtı kontrol etme
        if (response == null) {
            System.out.println("API yanıtı alınamadı!");
        } else {
            System.out.println("API yanıtı: " + response.asString());
        }
    }

    @Then("Staus code {int} olmalidir")
    public void stausCodeOlmalidir(int statusCode) {
        payload = new US06PostPayloadPojo("Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true);
        Response response = given(spec).body(payload).post("{first}");
        Assert.assertEquals(statusCode, response.statusCode());

    }

    @And("Yeni bir iletisim mesaji olusturuldigi dogrulanir")
    public void yeniBirIletisimMesajiOlusturuldigiDogrulanir() {
        payload = new US06PostPayloadPojo("Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true);
        response = given(spec).body(payload).post("{first}");
        String expectedMessage = "Contact message saved successfully.";
        String actualMessage = response.asString();
        Assert.assertEquals("Beklenen mesaj ile gelen mesaj uyusmuyor", expectedMessage, actualMessage);

    }

    //TC2----------------------------

    @When("Tum mesajlardan ilki iletisim mesaji getirilir")
    public void tumMesajlardanIlkiIletisimMesajiGetirilir() {
        spec.pathParam("first", "contact-messages");
        Response response1 = given(spec).get("{first}");
        List<US06GetPojo> actualData = response1.jsonPath().getList("content", US06GetPojo.class);
        System.out.println("actualData = " + actualData);
    }


    @And("Yeni bir iletisim mesaji alindigi dogrulanir")
    public void yeniBirIletisimMesajiAlindigiDogrulanir() {

        spec.pathParams("first", "contact-messages", "second",2519 );
        payload = new US06PostPayloadPojo("Fatma", "yasar", "ftmsmz@gmail.com", "merhaba hayat", true);
        response = given(spec).body(payload).get("{first}/{second}");
        System.out.println("Response Body: " + response.getBody().asString());

        actualData = response.jsonPath().getObject("content[0]", US06GetPojo.class);
        String expectedMessage = "merhaba hayat";
        System.out.println("actualData: " + actualData);

        String actualMessage = actualData.getMessage();
        Assert.assertEquals("Beklenen mesaj ile gelen mesaj uyusmuyor", expectedMessage, actualMessage);
    }

    //TC3-------------------------
    @When("Belirli bir iletisim mesaji ID göre alın")
    public void belirliBirIletisimMesajiIDGöreAlın() {
        // Get the ID of the message to retrieve
        int messageId = 2417; // Replace with the actual ID
        Response response = given(spec).pathParam("id", messageId).get("{first}/{id}");
        // Store the response in a variable
        this.response = response;
    }

    @And("Ve seçilen mesaj ayrıntılarını doğrulayın")
    public void veSeçilenMesajAyrıntılarınıDoğrulayın() {

    }
}
