package GetlandEstate.stepdefs.db_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US07_SütunİsimleriDoğrulanırStepdefs {
    @Given("Veritabanına bağlanılır")
    public void veritabanınaBağlanılır() {
    }

    @When("Countries sütun tablosu çağrılır")
    public void countriesSütunTablosuÇağrılır() {
    }

    @And("Countries sütundaki veriler eksiksiz gelmeli")
    public void countriesSütundakiVerilerEksiksizGelmeli() {
    }

    @Then("Database Bağlantısı kapatılır.")
    public void databaseBağlantısıKapatılır() {
    }

    // TC_02---------------------------------------------------

    @When("Countries tablosunun id ,lat,Ing,name sütunları getirilir.")
    public void countriesTablosununIdLatIngNameSütunlarıGetirilir() {
    }

    @And("Countriestablosundan {int} , {int} id numaralı sütunlar çağrılır.")
    public void countriestablosundanIdNumaralıSütunlarÇağrılır(int arg0, int arg1) {
    }
}
