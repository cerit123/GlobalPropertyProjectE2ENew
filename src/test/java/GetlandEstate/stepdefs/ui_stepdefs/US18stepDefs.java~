package GetlandEstate.stepdefs;

import GetlandEstate.pages.*;
import GetlandEstate.utilities.ActionsUtils;
import GetlandEstate.utilities.ConfigReader;
import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class US18stepDefs {
    HomePage homePage= new HomePage();
    MyProfilePage myProfilePage= new MyProfilePage();
    LoginPage loginPage= new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();
    MyTourRequestsPage myTourRequestsPage=new MyTourRequestsPage();
    SearchPage searchPage=new SearchPage();

    @Given("Homepage e tiklanir.")
    public void homepageETiklanir() {



        dashboardPage.backToSite.click();
        //myProfilePage.myProfileButton.click();
        //ActionsUtils.scrollDown();
        //homePage.profilButton.click();
        ReusableMethods.waitForSecond(5);
        //myTourRequestsPage.myTourRequests.click();
    }

    @When("Istenilen ilan a tiklanir")
    public void ıstenilenIlanATiklanir() {

        searchPage.saleButton.click();

        ReusableMethods.waitForSecond(5);
        //myTourRequestsPage.myRequests.click();
        ReusableMethods.waitForSecond(5);
        //myTourRequestsPage.actionUpdateButton.click();
        ReusableMethods.visibleWait(searchPage.searchButton,30);
        searchPage.searchBox.sendKeys("ev");
        searchPage.searchButton.click();
        ReusableMethods.waitForSecond(5);
        myTourRequestsPage.houseButton.click();

    }

    @And("Schedule a Tour kismindan tur tarihi secilir.")
    public void scheduleATourKismindanTurTarihiSecilir() {
        ReusableMethods.waitForSecond(2);
        ActionsUtils.scrollDown();
        //myTourRequestsPage.tourDateChoose.click();
        myTourRequestsPage.tourDateChoose.sendKeys(ConfigReader.getProperty("contactDate"), Keys.TAB);

    }

    @And("Schedule a Tour kismindan  tur saati secilir.")
    public void scheduleATourKismindanTurSaatiSecilir() {
        ReusableMethods.waitForSecond(5);
        Select select = new Select(myTourRequestsPage.tourTimeChoose);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
    }

    @And("Submit a tour request butonu  tiklanir.")
    public void submitATourRequestButonuTiklanir() {
        ReusableMethods.waitForSecond(2);
        myTourRequestsPage.tourRequestSubmitButton.click();

    }

    @Then("Tour Requestin gonderildigi dogrulanir.")
    public void tourRequestinGonderildigiDogrulanir() {
        ReusableMethods.waitForSecond(1);
        Assert.assertTrue(myTourRequestsPage.tourRequestCreatedSuccessfully.isDisplayed());
    }

    //TC02=====================================================================

    //@Given("Manager olarak giris yapilir.")
    //public void managerOlarakGirisYapilir() {
       // Driver.getDriver().get(ConfigReader.getProperty("url"));
        //loginPage.loginButton.click();
       // ActionsUtils.scrollLeft();
        //ActionsUtils.scrollDown();
        //loginPage.mailButton.sendKeys(ConfigReader.getProperty("manager"));
        //loginPage.passwordButton.sendKeys(ConfigReader.getProperty("password2"));
        //loginPage.login.click();


//}
    @And("Profil menusunden  My Tour Requests sekmesi tiklanir")
    public void profilMenusundenMyTourRequestsSekmesiTiklanir() {
    homePage.profilButton.click();
    ReusableMethods.waitForSecond(2);
    dashboardPage.tourRequests.click();

}

    @And("My Responses listesi acilir.")
    public void myResponsesListesiAcilir() {
        ReusableMethods.waitForSecond(2);
        myTourRequestsPage.myResponses.click();
    }

    @Then("My Respopnses listesindeki guest goruntulenebiliyor mu kontrol edilir.")
    public void myRespopnsesListesindekiGuestGoruntulenebiliyorMuKontrolEdilir() {
        Assert.assertTrue(myTourRequestsPage.statusResponses.isDisplayed());
    }

    //TC03==========================================================


    @And("My Responsesdaki ilanda onay tusuna basar")
    public void myResponsesdakiIlandaOnayTusunaBasar() {

        myTourRequestsPage.approveAction.click();
    }

    @Then("Tour Request approved yazisinin gorundugu dogrulanir")
    public void tourRequestApprovedYazisininGorunduguDogrulanir() {
        Assert.assertTrue(myTourRequestsPage.tourRequestCreatedSuccessfully.isDisplayed());
    }


    //TC04============================================================================



    @And("My Responsesdaki ilanda silme\\(x) tusuna basar")
    public void myResponsesdakiIlandaSilmeXTusunaBasar() {

        myTourRequestsPage.actionDeleteButton.click();
    }

    @Then("Tour request declined mesajinin gorundugu dogrulanir")
    public void tourRequestDeclinedMesajininGorunduguDogrulanir() {
        Assert.assertTrue(myTourRequestsPage.tourRequestDecline.isDisplayed());
    }




}

