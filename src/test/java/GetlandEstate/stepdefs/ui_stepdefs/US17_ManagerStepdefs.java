package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.AdminManagerRaporPage;
import GetlandEstate.pages.DashboardPage;
import GetlandEstate.pages.HomePage;
import GetlandEstate.pages.LoginPage;
import GetlandEstate.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US17_ManagerStepdefs {

    AdminManagerRaporPage adminManagerRaporPage = new AdminManagerRaporPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    HomePage homePage=new HomePage();


   @When("Manager olarak giris yapilir")
    public void managerOlarakGirisYapilir() {
        loginPage.loginButton.click();
        ActionsUtils.scrollLeft();
        ActionsUtils.scrollDown();
        loginPage.mailButton.sendKeys(ConfigReader.getProperty("manager"));
        loginPage.passwordButton.sendKeys(ConfigReader.getProperty("password2"));
        loginPage.login.click();
    }

    @And("raporlar sayfasina gidilir")
    public void raporlarSayfasinaGidilir() {

       dashboardPage.reports.click();
    }

    @And("start date kismina {string}veri girilir")
    public void startDateKisminaVeriGirilir(String startDate) {
        adminManagerRaporPage.startDate.sendKeys(ConfigReader.getProperty(startDate));
    }

    @And("end date kismina {string} veri girilir")
    public void endDateKisminaVeriGirilir(String endDate) {
        adminManagerRaporPage.endDate.sendKeys(ConfigReader.getProperty(endDate));
    }


    @And("category kismina gecerli veri girilir")
    public void categoryKisminaGecerliVeriGirilir() {
        adminManagerRaporPage.category.click();
        ReusableMethods.ddmValue(adminManagerRaporPage.category,"1");

    }

    @And("advert type kismina gecerli veri grilir")
    public void advertTypeKisminaGecerliVeriGrilir() {
        adminManagerRaporPage.type.click();
        ReusableMethods.ddmVisibleText(adminManagerRaporPage.type,"All");
    }

    @And("status kismina gecerli veri girilir")
    public void statusKisminaGecerliVeriGirilir() {
        adminManagerRaporPage.status.click();
        ReusableMethods.ddmVisibleText(adminManagerRaporPage.status,"All");
        WaitUtils.waitFor(3);
    }

    @And("rapor olustur butonuna tiklanir")
    public void raporOlusturButonunaTiklanir() {
        adminManagerRaporPage.reportButton1.click();
        WaitUtils.waitFor(1);
    }

    @Then("rapor basariyla olustugu gosterilir")
    public void raporBasariylaOlustuguGosterilir() {

        Assert.assertTrue(adminManagerRaporPage.raporExcel.isDisplayed());


    }

    @And("sayfa kapatilir")
    public void sayfaKapatilir() {
     Driver.closeDriver();
    }

//TC-2----------------------------


    @And("Manager olarak Raporlar sayfasina gidilir")
    public void managerOlarakRaporlarSayfasinaGidilir() {
        dashboardPage.reports.click();
        WaitUtils.waitFor(3);

    }

    @And("Manager olarak En Populer ilanlar kisminda miktar kismi secilir")
    public void managerOlarakEnPopulerIlanlarKismindaMiktarKismiSecilir() {
        adminManagerRaporPage.populerIlan.sendKeys(ConfigReader.getProperty("amount"));
        WaitUtils.waitFor(3);
    }

    @And("Manager olarak Rapor olustur butonuna tiklanir")
    public void managerOlarakRaporOlusturButonunaTiklanir() {
        adminManagerRaporPage.reportButton2.click();
        WaitUtils.waitFor(1);

    }

    @Then("Manager olarak  Rapor basariyla olustugu gosterilir")
    public void managerOlarakRaporBasariylaOlustuguGosterilir() {
        Assert.assertFalse(adminManagerRaporPage.reportVerfy.isDisplayed());
        //WaitUtils.waitFor(5);
    }

    //TC-3----------------------------------

    @Given("Manager olarak profil butonuna tiklanir")
    public void managerOlarakProfilButonunaTiklanir() {
        homePage.profilButton.click();
    }

    @And("Mnager olarak kontrol paneline tiklanir")
    public void mnagerOlarakKontrolPanelineTiklanir() {
        homePage.controlPannelButton.click();
    }

    @Then("Manager olarak Manager kullanici bilgisiyle raporun olusturuldugu  gorulur")
    public void managerOlarakManagerKullaniciBilgisiyleRaporunOlusturulduguGorulur() {
    }

    @And("Manager olarak Kullanicilar kismi Manager olarak secilir")
    public void managerOlarakKullanicilarKismiManagerOlarakSecilir() {
        adminManagerRaporPage.role.click();
        ReusableMethods.ddmValue(adminManagerRaporPage.role,"MANAGER");
    }

    @And("Manager olarak Raporu Olustur butonuna tiklanir")
    public void managerOlarakRaporuOlusturButonunaTiklanir() {
        WaitUtils.waitFor(3);
        adminManagerRaporPage.reportButton3.click();
    }

    @Then("Manager olarak Admin kullanici bilgisiyle raporun olusturuldugu  gorulur")
    public void managerOlarakAdminKullaniciBilgisiyleRaporunOlusturulduguGorulur() {
        Assert.assertFalse(adminManagerRaporPage.reportVerfy.isDisplayed());
        WaitUtils.waitFor(3);
    }

    //TC-4--------------------------------------

    @And("Manager olarak Start date kismina gecerli bir veri girilir")
    public void managerOlarakStartDateKisminaGecerliBirVeriGirilir() {
        ActionsUtils.scrollDown();
        adminManagerRaporPage.startDateTur.sendKeys(ConfigReader.getProperty("startDate"));

    }

    @And("Manager olarak End date kismina gecerli bir veri girlir")
    public void managerOlarakEndDateKisminaGecerliBirVeriGirlir() {
        adminManagerRaporPage.endDateTur.sendKeys(ConfigReader.getProperty("endDate"));
    }

    @And("Manager olarak Status kismi secilir")
    public void managerOlarakStatusKismiSecilir() {

        ReusableMethods.ddmValue(adminManagerRaporPage.statusTur,"1");
    }



    @And("Manager olarak Rapordort Olustur butonuna tiklanir")
    public void managerOlarakRapordortOlusturButonunaTiklanir() {
        adminManagerRaporPage.reportButton4.click();
    }

    @Then("Manager olarak Tur istekleri listelenir ve rapor basariyla olusturulur")
    public void managerOlarakTurIstekleriListelenirVeRaporBasariylaOlusturulur() {
        Assert.assertFalse(adminManagerRaporPage.reportVerfy.isDisplayed());
        WaitUtils.waitFor(5);
    }

    //TC-5 NEGATIVE

    @And("start date kismina  bos birakilir")
    public void startDateKisminaBosBirakilir() {
        adminManagerRaporPage.startDate.sendKeys("");
    }

    @Then("Manager olarak Raporun basariyla olusturulmadigi ve hata mesaji alindigi gorulur")
    public void managerOlarakRaporunBasariylaOlusturulmadigiVeHataMesajiAlindigiGorulur() {
        Assert.assertTrue(adminManagerRaporPage.raporExcelEmpyt.isDisplayed());
    }


    @And("end date kismina gecerli veri girilir")
    public void endDateKisminaGecerliVeriGirilir() {
    }

    @And("category kismi house olarak secilir")
    public void categoryKismiHouseOlarakSecilir() {
    }

    @And("advert type kismini rent olarak secilir")
    public void advertTypeKisminiRentOlarakSecilir() {
    }

    @And("Manager olarak Status kismi  pending olaraksecilir")
    public void managerOlarakStatusKismiPendingOlaraksecilir() {
    }

    @And("Manager olarak rapor Olusturulur")
    public void managerOlarakRaporOlusturulur() {
    }
}
