package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.LoginPage;
import GetlandEstate.pages.ManagerAdminAdvertsPage;
import GetlandEstate.utilities.*;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US08_09ManagerUndAdminAdvertStepdefs {


    ManagerAdminAdvertsPage managerAdminAdvertsPage= new ManagerAdminAdvertsPage();
    LoginPage loginPage=new LoginPage();





    @And("Back to site butonuna tiklanir")
    public void backToSiteButonunaTiklanir() {
        managerAdminAdvertsPage.BackToSite.click();
    }


    @And("Profil Butonuna tiklanir")
    public void profilButonunaTiklanir() {
        managerAdminAdvertsPage.profil.click();
    }

    @And("My Adverts sekmesine tiklanir")
    public void myAdvertsSekmesineTiklanir() {

        managerAdminAdvertsPage.MyAdverts.click();
    }

    @And("Guncellenmek istenen ilanda Edit butonuna tiklanir")
    public void guncellenmekIstenenIlandaEditButonunaTiklanir() {
    managerAdminAdvertsPage.AdvertEditButton.click();
        ReusableMethods.waitForSecond(2);
    }

    @And("Guncellenmek istenen ilanda Title güncellenir")
    public void guncellenmekIstenenIlandaTitleGüncellenir() {
        //managerAdminAdvertsPage.advertTitle.click();
        managerAdminAdvertsPage.advertTitle.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
       managerAdminAdvertsPage.advertTitle.clear();
        managerAdminAdvertsPage.advertTitle.sendKeys(ConfigReader.getProperty("advertTitle"));
    }

    @And("Guncellenmek istenen ilanda Price güncellenir")
    public void guncellenmekIstenenIlandaPriceGüncellenir() {
        managerAdminAdvertsPage.advertPrice.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        managerAdminAdvertsPage.advertPrice.sendKeys(ConfigReader.getProperty("advertPrice"));

    }
    @And("Guncellenmek istenen ilanda Advert Type güncellenir")
    public void guncellenmekIstenenIlandaAdvertTypeGüncellenir() {
        managerAdminAdvertsPage.AdvertType.click();
        ReusableMethods.ddmVisibleText(managerAdminAdvertsPage.AdvertType, "for sale");
    }

    @And("Guncellenmek istenen ilanda Category güncellenir")
    public void guncellenmekIstenenIlandaCategoryGüncellenir() {
        managerAdminAdvertsPage.AdvertCategory.click();
        ReusableMethods.ddmVisibleText(managerAdminAdvertsPage.AdvertCategory, "Villa");
    }

    @And("Guncellenmek istenen ilan Active veya deactive edilerek güncellenir")
    public void guncellenmekIstenenIlanActiveVeyaDeactiveEdilerekGüncellenir() {
        managerAdminAdvertsPage.AdvertStatus.click();
    }



    @And("Guncellenmek istenen ilanda City güncellenir")
    public void guncellenmekIstenenIlandaCityGüncellenir() {
        managerAdminAdvertsPage.AdvertCity.click();
        ReusableMethods.ddmVisibleText(managerAdminAdvertsPage.AdvertCity, "Ordu");

    }

    @And("Guncellenmek istenen ilanda District güncellenir")
    public void guncellenmekIstenenIlandaDistrictGüncellenir() {
        managerAdminAdvertsPage.AdvertDistrict.click();
        ReusableMethods.ddmVisibleText(managerAdminAdvertsPage.AdvertDistrict, "Fatsa");
    }

    @And("Guncellenmek istenen ilanda Address güncellenir")
    public void guncellenmekIstenenIlandaAddressGüncellenir() {
        managerAdminAdvertsPage.AdvertAddress.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        managerAdminAdvertsPage.AdvertAddress.sendKeys(ConfigReader.getProperty("advertAddress"));
        ReusableMethods.waitForSecond(2);
    }

    @And("Guncellenmek istenen ilanda Size güncellenir")
    public void guncellenmekIstenenIlandaSizeGüncellenir() {
        managerAdminAdvertsPage.AdvertSize.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        managerAdminAdvertsPage.AdvertSize.sendKeys(ConfigReader.getProperty("advertSize"));
    }

    @And("Guncellenmek istenen ilanda Bedrooms güncellenir")
    public void guncellenmekIstenenIlandaBedroomsGüncellenir() {
        managerAdminAdvertsPage.AdvertBedrooms.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        managerAdminAdvertsPage.AdvertBedrooms.sendKeys(ConfigReader.getProperty("advertBedrooms"));
        ReusableMethods.waitForSecond(3);

    }






    @Then("Guncellenmek istenen ilan icin Update butonuna tiklanir")
    public void guncellenmekIstenenIlanIcinUpdateButonunaTiklanir() {
        managerAdminAdvertsPage.AdvertUpdateButton.click();

    }


    @Then("Ilanin basariyla guncellendigi mesajı gorulmeli")
    public void ılaninBasariylaGuncellendigiMesajıGorulmeli() {
        WaitUtils.waitForVisibility(managerAdminAdvertsPage.AdvertSuccessfullyMessage, 5);
        Assert.assertTrue(managerAdminAdvertsPage.AdvertSuccessfullyMessage.isDisplayed());

    }
/////////////////////////////////////////////////////////////////////////////////////////

    @And("Silinmek istenen ilan için {string} butonuna tıklanir")
    public void silinmekIstenenIlanIcinButonunaTıklanir(String arg0) {
        managerAdminAdvertsPage.AdvertDeleteButton.click();

    }

    @And("Onay mesajında Yes butonuna tıklanir")
    public void onayMesajındaYesButonunaTıklanir() {
        managerAdminAdvertsPage.AdvertDeleteYesButton.click();

        
    }

    @Then("Ilanin basariyla silindigi mesajı gorulmeli")
    public void ılaninBasariylaSilindigiMesajıGorulmeli() {
        managerAdminAdvertsPage.AdvertDeletedSuccessfullyMessage.isDisplayed();

    }

    @And("Guncellenmek istenen ilanda Title alanı boş bırakılır")
    public void guncellenmekIstenenIlandaTitleBosBirakilir() {
        managerAdminAdvertsPage.advertTitle.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }

    @And("Guncellenmek istenen ilanda Price alanı boş bırakılır")
    public void guncellenmekIstenenIlandaPriceBosBirakilir() {
        managerAdminAdvertsPage.advertPrice.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }

    @And("Guncellenmek istenen ilanda Advert Type güncellenmez")
    public void guncellenmekIstenenIlandaAdvertTypeGuncellenmez() {
        // Dropdown seçimi yapılmıyor, işlem atlanıyor.
    }

    @And("Guncellenmek istenen ilanda Category güncellenmez")
    public void guncellenmekIstenenIlandaCategoryGuncellenmez() {
        // Dropdown seçimi yapılmıyor, işlem atlanıyor.
    }

    @And("Guncellenmek istenen ilan Active veya deactive edilmez")
    public void guncellenmekIstenenIlanActiveVeyaDeactiveEdilmez() {
        // Toggle durumu değiştirilmeden bırakılıyor.
    }

    @And("Guncellenmek istenen ilanda City güncellenmez")
    public void guncellenmekIstenenIlandaCityGuncellenmez() {
        // City dropdown seçim yapılmıyor.
    }

    @And("Guncellenmek istenen ilanda District güncellenmez")
    public void guncellenmekIstenenIlandaDistrictGuncellenmez() {
        // District dropdown seçim yapılmıyor.
    }

    @And("Guncellenmek istenen ilanda Address güncellenmez")
    public void guncellenmekIstenenIlandaAddressGuncellenmez() {
        managerAdminAdvertsPage.AdvertAddress.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }

    @And("Guncellenmek istenen ilanda Size güncellenmez")
    public void guncellenmekIstenenIlandaSizeGuncellenmez() {
        managerAdminAdvertsPage.AdvertSize.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }

    @And("Guncellenmek istenen ilanda Bedrooms güncellenmez")
    public void guncellenmekIstenenIlandaBedroomsGuncellenmez() {
        managerAdminAdvertsPage.AdvertBedrooms.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }


    @Then("Güncelle butonunun aktif olmadığını ve ilan güncelleme işleminin gerçekleşmediğini kontrol et")
    public void guncelleButonununAktifOlmadiginiVeGuncellenmediginiKontrolEt() {
        Assert.assertFalse("Güncelle butonu aktif olmamalı!", managerAdminAdvertsPage.AdvertUpdateButton.isEnabled());
    }




 @And("Guncellenmek istenen  Admin ilanda Edit butonuna tiklanir")
    public void guncellenmekIstenenAdminIlandaEditButonunaTiklanir() {
        managerAdminAdvertsPage.AdvertAdminEditButton.click();
        ReusableMethods.waitForSecond(2);
    }
    @And("Guncellenmek istenen ilanda Country güncellenir")
    public void guncellenmekIstenenIlandaCountryGüncellenir() {
        managerAdminAdvertsPage.AdvertCountry.click();
        ReusableMethods.ddmVisibleText(managerAdminAdvertsPage.AdvertCountry, "Türkiye");

    }




    @Then("İlanın aktif olduğunu doğrula {string}")
    public void ilanınAktifOlduğunuDoğrula(String arg0) {
        ReusableMethods.getScreenshot("pembe ev IlanDurumu ACTIVATED olmali");
        Assert.assertTrue(managerAdminAdvertsPage.advertStatusElement.getText().contains("ACTIVATED"));

    }
}
