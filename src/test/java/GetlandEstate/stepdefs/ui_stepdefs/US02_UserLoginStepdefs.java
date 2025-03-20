package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.LoginPage;
import GetlandEstate.utilities.ConfigReader;
import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US02_UserLoginStepdefs {
    LoginPage loginPage = new LoginPage();

     @Given("sayfaya gidilir")
     public void sayfayaGidilir() {
           Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

//    @When("Login sekmesine tiklanir")
//    public void loginSekmesineTiklanir() {
//        loginPage.loginButton.click();
//    }

//    @And("Siteye kaydolunan email adresi girilir")
//    public void siteyeKaydolunanEmailAdresiGirilir() {
//        loginPage.mailButton.sendKeys(ConfigReader.getProperty("Costumeremail"));
//    }

//    @And("Kullanici password girilir")
//    public void kullaniciPasswordGirilir() {
//        loginPage.passwordButton.sendKeys(ConfigReader.getProperty("Costumerpassword"));
//    }

//    @Then("Login olundugu dogrulanir")
//    public void loginOlunduguDogrulanir() {
//        loginPage.login.click();
//        Assert.assertTrue(loginPage.loginButton.isEnabled());
//    }


    @And("Email adresi @ sembolu olmadan girilir")
    public void emailAdresiEksikGirilir() {
        loginPage.mailButton.sendKeys(ConfigReader.getProperty("invalidCustomerEmail"));
    }

    @Then("Siteye giris yapilamadigi dogrulanir")
    public void siteyeGirisYapilamadigiDogrulanir() {
        Assert.assertTrue(loginPage.invalidEmailMessage.isDisplayed());
    }

    @And("Email adresi . sembolu olmadan girilir")
    public void emailAdresiNoktaOlmadanGirilir() {
        loginPage.mailButton.sendKeys(ConfigReader.getProperty("invalidCustomerEmail2"));
    }
    @Then("Invalid email uyarisi geldigi dogrulanir")
    public void invalidEmailUyarisiGeldigiDogrulanir() {
        ReusableMethods.waitForSecond(3);
     Assert.assertTrue(loginPage.invalidEmailMessage.isDisplayed());

    }

    @And("Password bos birakilir")
    public void passwordBosBirakilir() {
        loginPage.passwordButton.clear();

    }
    @Then("Password is required uyarisinin geldigi dogrulanir")
    public void passwordIsRequiredUyarisininGeldigiDogrulanir() {
        Assert.assertTrue(loginPage.passwordRequiredMessage.isDisplayed());
    }

    @And("Email kutucugu bos birakilir")
    public void emailKutucuguBosBirakilir() {
        loginPage.mailButton.clear();
    }

    @Then("Login butonunun tiklanamadigi dogrulanir")
    public void loginButonununTiklanamadigiDogrulanir() {
        Assert.assertFalse(loginPage.login.isEnabled());
    }


  // @And("Kullanici passwordu girilir")
  // public void kullaniciPassworduGirilir() {
  //     loginPage.passwordButton.sendKeys(ConfigReader.getProperty("passwordCostumer"));

  // }
}
