package GetlandEstate.stepdefs.db_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US04_SütunİsimleriniDoğrulamaStepdefs {
    @Given("Veritabanına bağlanılır.")
    public void veritabanınaBağlanılır() {
    }

    @When("Contacts sütun tablosu çağrılır")
    public void contactsSütunTablosuÇağrılır() {
    }

    @And("Contacts sütundaki veriler eksiksiz gelmeli")
    public void contactsSütundakiVerilerEksiksizGelmeli() {
    }

    @Then("Database bağlantısı kapatılır.")
    public void databaseBağlantısıKapatılır() {
    }

    // TC_02--------------------------------------------------


    @When("Contacts tablosunun id, created_at,email,first_name,last_name,message,status sütunları getirilir.")
    public void contactsTablosununIdCreated_atEmailFirst_nameLast_nameMessageStatusSütunlarıGetirilir() {
    }

    @And("Contacts tablosundan {int} , {int} id numaralı sütunlar çağrılır.")
    public void contactsTablosundanIdNumaralıSütunlarÇağrılır(int arg0, int arg1) {
    }
}
