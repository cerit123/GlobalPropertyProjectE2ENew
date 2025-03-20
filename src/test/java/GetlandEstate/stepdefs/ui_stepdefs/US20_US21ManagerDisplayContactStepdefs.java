package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.ContactMessagesPage;
import GetlandEstate.pages.DashboardPage;
import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.JSUtils;
import GetlandEstate.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class US20_US21ManagerDisplayContactStepdefs {

    ContactMessagesPage contactMessagesPage = new ContactMessagesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("Contact mesajları sayfasına gidilir")
    public void contactMesajlarıSayfasınaGidilir() {
        ReusableMethods.waitForSecond(2);
        JSUtils.JSclickWithTimeout(dashboardPage.contactMessages);
    }

    @When("Mesajlar görüntülenir")
    public void mesajlarGörüntülenir() {
        ReusableMethods.waitForSecond(3);
        contactMessagesPage.message.click();
        //JSUtils.JSclickWithTimeout(contactMessagesPage.message);
    }

    @And("Bir mesaj silinir")
    public void birMesajSilinir() {
        ReusableMethods.waitForSecond(2);
        contactMessagesPage.deleteButton.click();
    }

    @Then("Mesajin silindigi dogrulanir")
    public void mesajinSilindigiDogrulanir() {

    }

    @When("Bir mesaj okundu olarak işaretlenir")
    public void birMesajOkunduOlarakIşaretlenir() {
        ReusableMethods.waitForSecond(3);
        contactMessagesPage.message.click();
        ReusableMethods.waitForSecond(3);
        contactMessagesPage.markUnReadButton.click();
    }

    @Then("Mesajin okundu olarak isaretlendigi dogrulanir")
    public void mesajinOkunduOlarakIsaretlendigiDogrulanir() {

    }

    @When("Belirli bir kelime ile arama yapilir")
    public void belirliBirKelimeIleAramaYapilir() {
        contactMessagesPage.searchBox.click();
        contactMessagesPage.searchBox.sendKeys("john");
        contactMessagesPage.searchButton.click();
    }

    @Then("Arama sonuclarinin listelendigi dogrulanir")
    public void aramaSonuclarininListelendigiDogrulanir() {
        List<WebElement> sonuc = Driver.getDriver().findElements(By.xpath("//span[contains(text(), 'John')] "));
        Assert.assertFalse(sonuc.isEmpty());
    }

    @When("Filter butonuna tiklanir")
    public void filterButonunaTiklanir() {
        contactMessagesPage.filterButton.click();
    }

    @And("Start Date alanian tarih girilir")
    public void startDateAlanianTarihGirilir() {
        contactMessagesPage.dropdownStartDate.sendKeys("15/03/2025");
    }

    @And("End Date alanian tarih girilir")
    public void endDateAlanianTarihGirilir() {
        contactMessagesPage.dropdownEndDate.sendKeys("16/03/2025");
    }

    @And("Onay butonuna basilir")
    public void onayButonunaBasilir() {
        contactMessagesPage.applyFiltersButton.click();
        ReusableMethods.waitForSecond(8);
    }


    @Then("Belirlitilen tarih araligindaki arama sonuclarinin listelendigi dogrulanir")
    public void belirlitilenTarihAraligindakiAramaSonuclarininListelendigiDogrulanir() {
        List<WebElement> sonuc2 = Driver.getDriver().findElements(By.className("h2.read.accordion-header"));
        Assert.assertTrue(sonuc2.isEmpty());
    }
}
