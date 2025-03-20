package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.*;
import GetlandEstate.utilities.ActionsUtils;
import GetlandEstate.utilities.ConfigReader;
import GetlandEstate.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class US14_StepDefs {



    HomePage homePage= new HomePage();
    MyProfilePage myProfilePage= new MyProfilePage();
    LoginPage loginPage= new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();
    MyTourRequestsPage myTourRequestsPage=new MyTourRequestsPage();
    SearchPage searchPage=new SearchPage();







    @Given("Anasayfaya  tiklanir.")
    public void anasayfayaTiklanir() {dashboardPage.backToSite.click();
        ReusableMethods.waitForSecond(5);
    }

    @When("secilen ilan a tiklanir")
    public void secilenIlanATiklanir() { ReusableMethods.waitForSecond(5); ReusableMethods.visibleWait(searchPage.searchButton,30);
        searchPage.searchBox.sendKeys("ev");
        searchPage.searchButton.click();
        ReusableMethods.waitForSecond(5);
        myTourRequestsPage.houseButton.click();
    }

    @And("Schedule a Tour kismindan gecerli bir tur tarihi secilir.")
    public void scheduleATourKismindanGecerliBirTurTarihiSecilir() {   ReusableMethods.waitForSecond(3);
        ActionsUtils.scrollDown();
        //myTourRequestsPage.tourDateChoose.click();
        ReusableMethods.waitForSecond(2);
        myTourRequestsPage.tourDateChoose.sendKeys(ConfigReader.getProperty("contactDate"), Keys.TAB);
    }

    @And("Schedule a Tour kismindan gecerli tur saati secilir.")
    public void scheduleATourKismindanGecerliTurSaatiSecilir() {
        ReusableMethods.waitForSecond(5);
        Select select = new Select(myTourRequestsPage.tourTimeChoose);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
    }

    @And("Submit a tour request den buton'a  tiklanir.")
    public void submitATourRequestDenButonATiklanir() { ReusableMethods.waitForSecond(2);
        myTourRequestsPage.tourRequestSubmitButton.click();
    }

    @Then("Tour Requestin kisminin gonderildigi dogrulanir.")
    public void tourRequestinKismininGonderildigiDogrulanir() { ReusableMethods.waitForSecond(1);
        Assert.assertTrue(myTourRequestsPage.tourRequestCreatedSuccessfully.isDisplayed());
    }

    @And("Schedule a Tour kisminda tur tarihi bos birakilir.")
    public void scheduleATourKismindaTurTarihiBosBirakilir() {ReusableMethods.waitForSecond(2);
    }

    @And("Schedule a Tour kismindan gecerli  bir tur saati secilir.")
    public void scheduleATourKismindanGecerliBirTurSaatiSecilir() {
        ReusableMethods.waitForSecond(5);
        Select select = new Select(myTourRequestsPage.tourTimeChoose);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
    }

    @And("Submit a tour request de buton'a  tiklanir.")
    public void submitATourRequestDeButonATiklanir() {//myTourRequestsPage.tourRequestSubmitButton.click();
    }

    @Then("Tour Requestin kisminin gonderilmedigi dogrulanir.")
    public void tourRequestinKismininGonderilmedigiDogrulanir() {
        ReusableMethods.waitForSecond(5);
        Assert.assertFalse(searchPage.tourDateRequiredMassage.isDisplayed());
        ReusableMethods.waitForSecond(5);

    }

    @And("Schedule a Tour kisminda bir tur tarihi secilir.")
    public void scheduleATourKismindaBirTurTarihiSecilir(){
        ActionsUtils.scrollDown();
        //myTourRequestsPage.tourDateChoose.click();
        myTourRequestsPage.tourDateChoose.sendKeys(ConfigReader.getProperty("contactDate"), Keys.TAB);
    }

    @And("Schedule a Tour kismindan  tur saati bos birakilir.")
    public void scheduleATourKismindanTurSaatiBosBirakilir() {
    }

    @And("Submit a tour request den butona  tiklanir.")
    public void submitATourRequestDenButonaTiklanir() {
    }

    @Then("Tour Requestin kismi gonderilmedigi dogrulanir.")
    public void tourRequestinKismiGonderilmedigiDogrulanir() {  Assert.assertFalse(searchPage.tourTimeRequiredMassage.isDisplayed());
    }
}
