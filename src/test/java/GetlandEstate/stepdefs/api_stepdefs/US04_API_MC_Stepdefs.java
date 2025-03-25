package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.pojos.Us04postRequestPayloadPOJO;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Random;

import static GetlandEstate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US04_API_MC_Stepdefs {
    static Us04postRequestPayloadPOJO payload;
    static Us04postRequestPayloadPOJO gecersizPayload;
   static Response response;
    static Response gecersizResponse;
    static Response responseCity;
    Faker faker;
    private static int id;
    private static int ikinciId;
    static List<Integer> cityIds;
    static int randomCityId;


    //----TC01----
    @Given("set the url")
    public void setTheUrl() {
        spec.pathParam("first","advert-types");
    }

    @And("yetkili post işlemi için payload oluşturulur")
    public void yetkiliPostIşlemiIçinPayloadOluşturulur() {
      faker = new Faker();
      payload= new Us04postRequestPayloadPOJO(faker.gameOfThrones().house());

    }

    @When("yetkili yapılan post işlemi için response alınır")
    public void yetkiliYapılanPostIşlemiIçinResponseAlınır() {
        response = given(spec).body(payload).post("{first}");
        id = response.jsonPath().getInt("id");
        response.prettyPrint();

    }

    @Then("to do assertion- ilanın verildiği doğrulanır")
    public void toDoAssertionIlanınVerildiğiDoğrulanır() {
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().get("title"),payload.getTitle());
    }

    //---TC02---
    @Given("token alınmaz")
    public void tokenAlınmaz() {

    }

    @And("yetkisiz post işlemi için payload oluşturulur")
    public void yetkisizPostIşlemiIçinPayloadOluşturulur() {
        Faker faker = new Faker();
       gecersizPayload= new Us04postRequestPayloadPOJO(faker.gameOfThrones().house());
    }

    @When("yetkisiz yapılan post işlemi response alınır")
    public void yetkisizYapılanPostIşlemiResponseAlınır() {
        gecersizResponse = given(spec).body(gecersizPayload).post("{first}");
        ikinciId = gecersizResponse.jsonPath().getInt("id");
        gecersizResponse.prettyPrint();
    }

    @Then("to do assertion- {int} kodu ile {string} mesajı görülür")
    public void toDoAssertionKoduIleMesajıGörülür(int statusCode, String message) {
        Assert.assertEquals(message,gecersizResponse.jsonPath().get("message"));
        Assert.assertEquals(statusCode, gecersizResponse.statusCode());
    }

    //---TC03---
    @Given("set the url \\(url nin sonuna oluşturlan reklamın id si eklenir)")
    public void setTheUrlUrlNinSonunaOluşturlanReklamınIdSiEklenir() {
        spec.pathParams("first","advert-types","second",id);

    }

    @When("oluşturulan advert type get işlemi için response alınır")
    public void oluşturulanAdvertTypeGetIşlemiIçinResponseAlınır() {
        response = given(spec).get("{first}/{second}");
    }

    @Then("to do assertion- {int} status code ile verilen ilan görünür")
    public void toDoAssertionStatusCodeIleVerilenIlanGörünür(int statusCode) {
        response.prettyPrint();
        Assert.assertEquals(statusCode,response.statusCode());

    }

    //---TC04---
    @Then("to do assertion- {int} kodu ile {string} mesajı alınmalı")
    public void toDoAssertionKoduIleMesajıAlınmalı(int statusCode, String message) {
        response.prettyPrint();
        Assert.assertEquals(statusCode,response.statusCode());
        Assert.assertEquals(message,response.jsonPath().get("message"));
    }

    //---TC05---
    @When("set the url \\(url nin sonuna all eklenir)")
    public void setTheUrlUrlNinSonunaAllEklenir() {
        spec.pathParams("first","advert-types","second","all");
    }


    @Then("to do assertion- {int} kodu ile tüm ilanlar görünür")
    public void toDoAssertionKoduIleTümIlanlarGörünür(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());
    }

    //---TC06---//
    @When("set the expected data- title de yapılmak istenen değişiklik yazılır")
    public void setTheExpectedDataTitleDeYapılmakIstenenDeğişiklikYazılır() {
        Faker faker = new Faker();
        payload.setTitle(faker.gameOfThrones().house());
    }

    @And("değiştirilen advert type put işlemi için response alınır")
    public void değiştirilenAdvertTypePutIşlemiIçinResponseAlınır() {
        response = given(spec).body(payload).put("{first}/{second}");

    }

    //---TC07---
    @When("set the expected data title de yapılmak istenen değişiklikler yazılır")
    public void setTheExpectedDataTitleDeYapılmakIstenenDeğişikliklerYazılır() {
        Faker faker = new Faker();
        payload.setTitle(faker.animal().name());
    }

    @And("yetkisiz olarak değiştirilmek istenen advert type put işlemi için response alınır")
    public void yetkisizOlarakDeğiştirilmekIstenenAdvertTypePutIşlemiIçinResponseAlınır() {
        response =given(spec).body(payload).put("{first}/{second}");
    }

    //---TC08---
    @When("payloadta islem yapılmaz")
    public void payloadtaIslemYapılmaz() {
    }

    @And("delete islemi için response oluşturulur")
    public void deleteIslemiIçinResponseOluşturulur() {
        response = given(spec).when().delete("{first}/{second}");
    }

    //---TC09---
    @Given("set the url \\(url nin sonuna oluşturlan reklamın yeni id si eklenir)")
    public void setTheUrlUrlNinSonunaOluşturlanReklamınYeniIdSiEklenir() {
        spec.pathParams("first","advert-types","second",ikinciId);
    }

    @And("delete islemi için yeni id li advert typeresponse oluşturulur")
    public void deleteIslemiIçinYeniIdLiAdvertTyperesponseOluşturulur() {
        response = given(spec).delete("{first}/{second}");
    }

    //city id
    @Given("city idsi almak için url düzenlenir")
    public void cityIdsiAlmakIçinUrlDüzenlenir() {
        spec.pathParams("first","cities","second","all");
    }

    @When("city idleri getirilir ve bir list e atılır")
    public void cityIdleriGetirilirVeBirListEAtılır() {

        responseCity = given(spec)
                .when()
                .get("{first}/{second}");

        // Response içindeki city ID'lerini listeye atma
        JsonPath jsonPath = responseCity.jsonPath();
        cityIds = jsonPath.getList("id", Integer.class);

        // Listeyi ekrana yazdırma (Test için)
        System.out.println("City IDs: " + cityIds);
    }
    //us10-tc01
    @Given("set the url \\(url adresinin sonun rastgele cityId girilir)")
    public void setTheUrlUrlAdresininSonunRastgeleCityIdGirilir() {
        Random random = new Random();
        randomCityId = cityIds.get(random.nextInt(cityIds.size()));
        spec.pathParams("first","districts","second","search","third",randomCityId);

    }

    @And("get işlemi ile seçilen ilçe response atılır")
    public void getIşlemiIleSeçilenIlçeResponseAtılır() {
        response = given(spec)
                .get("{first}/{second}/{third}");

        // Test için seçilen random city ID'yi yazdırma
        System.out.println("Selected random city ID: " + randomCityId);
        System.out.println("responseCity = " + responseCity);
        response.prettyPrint();
    }

    //us10-tc02

}
