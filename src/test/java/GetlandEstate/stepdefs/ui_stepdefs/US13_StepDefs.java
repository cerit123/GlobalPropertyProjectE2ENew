package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.*;
import GetlandEstate.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US13_StepDefs {

    HomePage homePage= new HomePage();
    MyProfilePage myProfilePage= new MyProfilePage();
    LoginPage loginPage= new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();
    MyTourRequestsPage myTourRequestsPage=new MyTourRequestsPage();
    SearchPage searchPage=new SearchPage();


    @Given("siteye geri don kismina tiklamalidir")
    public void siteyeGeriDonKisminaTiklamalidir() {
        dashboardPage.backToSite.click();
    }

    @When("profile tiklamalidir")
    public void profileTiklamalidir() {
        homePage.profilButton.click();
        //ActionsUtils.scrollDown();
        ReusableMethods.waitForSecond(2);
    }

    @And("ilanlarima tiklanmalidir")
    public void ilanlarimaTiklanmalidir() {
        myTourRequestsPage.myTourRequests.click();
       // dashboardPage.tourRequests.click();
        ReusableMethods.waitForSecond(2);
        myTourRequestsPage.myResponses1.click();
    }

    @Then("ilanlarim listesindeki isim,durum,tur tarihi ,saat goruntulenebiliyor mu  kontrol edilir.")
    public void ilanlarimListesindekiIsimDurumTurTarihiSaatGoruntulenebiliyorMuKontrolEdilir() {
        Assert.assertTrue(myTourRequestsPage.statusResponses.isDisplayed());
    }
//13-tc02
    @And("Tur Taleplerime tiklamalidir")
    public void turTaleplerimeTiklamalidir() {
        myTourRequestsPage.myTourRequests.click();
    }

    @And("Tur Cevaplarim listesi goruntulenir.")
    public void turCevaplarimListesiGoruntulenir() {
        myTourRequestsPage.myResponses1.click();
    }

    @And("onaylanma kismina tiklanir")
    public void onaylanmaKisminaTiklanir() {
       myTourRequestsPage.myAction.click();
    }

    @And("cikan sekmedeki evet kutusuna tiklanir")
    public void cikanSekmedekiEvetKutusunaTiklanir() {
        myTourRequestsPage.myActionYes.click();
    }

    @Then("onaylandigina dair yazi kontrol edilir.")
    public void onaylandiginaDairYaziKontrolEdilir() {
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(myTourRequestsPage.myActionSuccessfully.isDisplayed());
        //burayi tekrar incele
    }
//tc03
    @And("reddetme kismina tiklanir")
    public void reddetmeKisminaTiklanir() { myTourRequestsPage.myActiondeleteOnay.click();
    }

    @And("cikan reddetme kutusuna yes'e tiklanir")
    public void cikanReddetmeKutusunaYesETiklanir() {

        myTourRequestsPage.myActionCancelYes.click();
    }

    @Then("reddedildigine dair yazi kontrol edilir.")
    public void reddedildigineDairYaziKontrolEdilir() {
        ReusableMethods.waitForSecond(2);
        Assert.assertTrue(myTourRequestsPage.myActionCancelYesMesaj.isDisplayed());
    }
}
