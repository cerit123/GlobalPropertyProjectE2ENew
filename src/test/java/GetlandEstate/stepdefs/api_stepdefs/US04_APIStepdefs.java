package GetlandEstate.stepdefs.api_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US04_APIStepdefs {

    //----TC01----
    @Given("set the url")
    public void setTheUrl() {
    }

    @And("yetkili post işlemi için payload oluşturulur")
    public void yetkiliPostIşlemiIçinPayloadOluşturulur() {
    }

    @When("yetkili yapılan post işlemi için response alınır")
    public void yetkiliYapılanPostIşlemiIçinResponseAlınır() {
    }

    @Then("to do assertion- ilanın verildiği doğrulanır")
    public void toDoAssertionIlanınVerildiğiDoğrulanır() {
    }

    //---TC02---
    @Given("token alınmaz")
    public void tokenAlınmaz() {
    }

    @And("yetkisiz post işlemi için payload oluşturulur")
    public void yetkisizPostIşlemiIçinPayloadOluşturulur() {
    }

    @When("yetkisiz yapılan post işlemi response alınır")
    public void yetkisizYapılanPostIşlemiResponseAlınır() {
    }

    @Then("to do assertion- {int} kodu ile {string} mesajı görülür")
    public void toDoAssertionKoduIleMesajıGörülür(int arg0, String arg1) {
    }
}
