package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.*;
import GetlandEstate.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US16_CreatReportStepdefs {

    AdminManagerRaporPage adminManagerRaporPage = new AdminManagerRaporPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    HomePage homePage=new HomePage();


//TC1------------------------------------------------

    @And("Rapor butonuna tiklanir")
    public void raporButonunaTiklanir() {
        dashboardPage.reports.click();
    }

    @And("Start date kismina gecerli veri girilir")
    public void startDateKisminaGecerliVeriGirilir() {
        adminManagerRaporPage.startDate.sendKeys(ConfigReader.getProperty("startDate"));

    }

    @And("End date kismina gecerli veri girilir")
    public void endDateKisminaGecerliVeriGirilir() {
        adminManagerRaporPage.endDate.sendKeys(ConfigReader.getProperty("endDate"));
    }

    @And("Category kismina gecerli veri girilir")
    public void categoryKisminaGecerliVeriGirilir() {
        adminManagerRaporPage.category.click();
        ReusableMethods.ddmVisibleText(adminManagerRaporPage.category,"All");
    }

    @And("Advert type kismina gecerli veri grilir")
    public void advertTypeKisminaGecerliVeriGrilir() {
        adminManagerRaporPage.type.click();
        ReusableMethods.ddmVisibleText(adminManagerRaporPage.type,"All");
    }

    @And("Status kismina gecerli veri girilir")
    public void statusKisminaGecerliVeriGirilir() {
        adminManagerRaporPage.status.click();
        ReusableMethods.ddmVisibleText(adminManagerRaporPage.status,"All");
        WaitUtils.waitFor(3);
    }

    @And("Rapor olustur butonuna tiklanir")
    public void raporOlusturButonunaTiklanir() {
        adminManagerRaporPage.reportButton1.click();


    }

    @Then("Rapor basariyla olustugu gosterilir")
    public void raporBasariylaOlustuguGosterilir() {
        WaitUtils.waitFor(1);
        Assert.assertTrue(adminManagerRaporPage.raporExcel.isDisplayed());
        WaitUtils.waitFor(3);

    }

    @And("logout butonuna tiklanir")
    public void logoutButonunaTiklanir() {
        adminManagerRaporPage.logout.click();
    }

//TC-2 test case



    @And("Profile tiklanir")
    public void profileTiklanir() {

        homePage.profilButton.click();
    }

    @And("Kontrol Paneline tiklanir")
    public void kontrolPanelineTiklanir() {

        homePage.controlPannelButton.click();
    }
    @And("En Populer ilanlar kisminda miktar kismi secilir")
    public void enPopulerIlanlarKismindaMiktarKismiSecilir() {
        adminManagerRaporPage.populerIlan.sendKeys(ConfigReader.getProperty("amount"));


    }


    @Then("Rapor  populer ilanlar raporu basariyla olustugu gosterilir")
    public void raporPopulerIlanlarRaporuBasariylaOlustuguGosterilir() {
        //Assert.assertTrue(adminManagerRaporPage.reportVerfy.isDisplayed());
        BrowserUtils.verifyElementDisplayed(adminManagerRaporPage.raporExcel);
        WaitUtils.waitFor(3);
    }

//TC-3-------------------------------------------------
    @And("Kullanicilar kismi Admin olarak secilir")
    public void kullanicilarKismiAdminOlarakSecilir() {
        adminManagerRaporPage.role.click();
        ReusableMethods.ddmValue(adminManagerRaporPage.role,"ADMIN");
    }

    @And("Raporu Olustur butonuna tiklanir")
    public void raporuOlusturButonunaTiklanir() {

        adminManagerRaporPage.reportButton2.click();
    }

    @Then("Admin kullanici bilgisiyle raporun olusturuldugu  gorulur")
    public void adminKullaniciBilgisiyleRaporunOlusturulduguGorulur() {
        Assert.assertTrue(adminManagerRaporPage.raporExcel.isDisplayed());
    }

//TC-4---------------------------------------------------
    @And("Start date kismina gecerli bir veri girilir")
    public void startDateKisminaGecerliBirVeriGirilir() {
        ActionsUtils.scrollDown();
        adminManagerRaporPage.startDateTur.sendKeys(ConfigReader.getProperty("startDate"));



    }

    @And("End date kismina gecerli bir veri girlir")
    public void endDateKisminaGecerliBirVeriGirlir() {
        adminManagerRaporPage.endDateTur.sendKeys(ConfigReader.getProperty("endDate"));
    }

    @And("Status kismi secilir")
    public void statusKismiSecilir() {
        ReusableMethods.ddmValue(adminManagerRaporPage.statusTur,"1");
    }

    @Then("Tur istekleri listelenir ve rapor basariyla olusturulur")
    public void turIstekleriListelenirVeRaporBasariylaOlusturulur() {
        WaitUtils.waitForVisibility(adminManagerRaporPage.raporExcel,10);
        Assert.assertTrue(adminManagerRaporPage.raporExcel.isDisplayed());

    }

    @And("Sayfa kapatilir")
    public void sayfaKapatilir() {

        Driver.closeDriver();
    }


}
