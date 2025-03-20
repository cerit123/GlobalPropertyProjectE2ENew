package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.HomePage;
import GetlandEstate.pages.LoginPage;
import GetlandEstate.pages.MyProfilePage;
import GetlandEstate.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class US03_CustomerProfileUpdateStepdefs {
    LoginPage loginPage = new LoginPage();
    MyProfilePage saveButton = new MyProfilePage();
    MyProfilePage myProfilePage = new MyProfilePage();
    HomePage homePage=new HomePage();

//   @Given("sayfaya gidilir")
//    public void sayfayaGidilir() {Driver.getDriver().get(ConfigReader.getProperty("url"));
//   }

    @When("Login sekmesinee tiklanir")
    public void loginSekmesineeTiklanir() {
        homePage.LoginButton.click();


   }

//    @When("Login sekmesine tiklanir")
//    public void loginSekmesineTiklanir() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
//        loginButton.click();
//    }
    @And("Login butonuna tiklanir")
    public void loginButonunaTiklanir() {
        ReusableMethods.click(loginPage.login);

    }

    @And("Siteye kaydolunan email adres girilir")
    public void siteyeKaydolunanEmailAdresGirilir() {
        loginPage.mailButton.sendKeys(ConfigReader.getProperty(""));
    }

    @And("Kullanici passwordu girilir")
    public void kullaniciPassworduGirilir() {
        loginPage.passwordButton.sendKeys(ConfigReader.getProperty("passwordCostumer"));
    }



//    ReusableMethods reusableMethods = new ReusableMethods();
//    WaitUtils waitUtils;
//
//    public void setWaitUtils(WaitUtils waitUtils) throws InterruptedException {
//        this.waitUtils = waitUtils;
//        waitUtils.wait(1);
//
//    }

    @And("Profil butonuna tiklanir")
    public void profilButonunaTiklanir() {
        ReusableMethods.click(homePage.profilButton);

    }

    @And("My Profile butonuna tiklanir")
    public void myProfileButonunaTiklanir() {

        myProfilePage.myProfileButton.click();
    }



    @And("First name guncellenir")
    public void firstNameGuncellenir() {
        myProfilePage.firstName.sendKeys(Keys.COMMAND + "a");
        myProfilePage.firstName.sendKeys(Keys.DELETE);
        myProfilePage.firstName.sendKeys("Raymond");
    }

    @And("Last name guncellenir")
    public void lastNameGuncellenir() {
        myProfilePage.lastName.sendKeys(Keys.COMMAND + "a");
        myProfilePage.lastName.sendKeys(Keys.DELETE);
        myProfilePage.lastName.sendKeys("Sanchez");
    }

    @And("Phone guncellenir")
    public void phoneGuncellenir() {
        myProfilePage.phoneNumber.sendKeys(Keys.COMMAND + "a");
        myProfilePage.phoneNumber.sendKeys(Keys.DELETE);
        myProfilePage.phoneNumber.sendKeys("5555555550");
    }

    @And("Email guncellenir")
    public void emailGuncellenir() throws InterruptedException {
        myProfilePage.email.sendKeys(Keys.COMMAND + "a");
        myProfilePage.email.sendKeys(Keys.DELETE);
        myProfilePage.email.sendKeys("AH2N9K@example.com");
        ReusableMethods.waitForSecond(5);
    }
    @And("Update butonuna tiklanir")
    public void updateButonunaTiklanir() throws InterruptedException {
        myProfilePage.updateButton.click();

    }

    @Then("Profil bilgilerinin degistirildigi dogrulanir")
    public void profilBilgilerininDegistirildigiDogrulanir() {

        ReusableMethods.visibleWait(myProfilePage.profileUpdatesuccessfullMessage, 5);
        Assert.assertTrue(myProfilePage.profileUpdatesuccessfullMessage.getText().contains("successfully"));

    }

    @And("Change password sekmesine tiklanir")
    public void changePasswordSekmesineTiklanir() {

       myProfilePage.changePasswordButton.click();
    }

    @And("Current password girilir")
    public void currentPasswordGirilir() {
        ReusableMethods.click(myProfilePage.currentPassword);
        myProfilePage.currentPassword.sendKeys(ConfigReader.getProperty("passwordCostumer"));

    }

    @And("Sistem gerekliliklerine gore New password girilir")
    public void sistemGerekliliklerineGoreNewPasswordGirilir() {
        myProfilePage.newPassword.sendKeys(ConfigReader.getProperty("newPasswordCostumer"));
    }

    @And("Confirm password kutucuguna yeni olusturulan password tekrar girilir")
    public void confirmPasswordKutucugunaYeniOlusturulanPasswordTekrarGirilir() {
        myProfilePage.confirmPassword.sendKeys(ConfigReader.getProperty("newPasswordCostumer"));
    }

    @And("Change butonuna tiklanir")
    public void changeButonunaTiklanir() throws InterruptedException {
        myProfilePage.changeButton.click();
//
    }

    @Then("Password'un basarili bir sekilde degistirildigi dogrulanir")
    public void passwordUnBasariliBirSekildeDegistirildigiDogrulanir() {
        loginPage.loginButton.isDisplayed();
//    ReusableMethods.visibleWait(myProfilePage.changePasswordSuccessfullMessage, 5);
//        Assert.assertTrue(myProfilePage.changePasswordSuccessfullMessage.isDisplayed());
    }

    @And("Profile photo sekmesine tiklanir")
    public void profilePhotoSekmesineTiklanir() {

        myProfilePage.profilePhoto.click();
        ReusableMethods.waitForSecond(5);

    }

    @And("Select sekmesiyle yeni profil resmi secilir")
    public void selectSekmesiyleYeniProfilResmiSecilir() {
        WebElement uploadElement = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
        String filePath = "/Users/emresmac/Desktop/pexels-moose-photos-1586996.jpg";
        uploadElement.sendKeys(filePath);
    }
    @And("Done butonu tiklanir")
    public void doneButonuTiklanir() {
        myProfilePage.doneButton.click();
    }

    @And("Save butonu tiklanir")
    public void saveButonuTiklanir() throws InterruptedException {

        ReusableMethods.waitForSecond(5);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ActionsUtils.scrollDown();
        saveButton.saveButton.click();


    }

    @Then("Profil resminin basarili bir sekilde eklendigi dogrulanir")
    public void profilResmininBasariliBirSekildeEklendigiDogrulanir() {

        ReusableMethods.visibleWait(myProfilePage.profilePhotoUpdatedSuccessfullMessage, 5);
        Assert.assertTrue(myProfilePage.profilePhotoUpdatedSuccessfullMessage.isDisplayed());
    }

    @And("Delete Account sekmesine tiklanir")
    public void deleteAccountSekmesineTiklanir() {
        myProfilePage.deleteAccountButton.click();
    }

    @And("Silme islemini gerceklestirmek icin gerekli olan kullanici password'u girilir")
    public void silmeIsleminiGerceklestirmekIcinGerekliOlanKullaniciPasswordUGirilir() {
        myProfilePage.currentPassword.sendKeys(ConfigReader.getProperty("passwordCostumer"));
    }

    @And("Delete Account butonuna tiklanir")
    public void deleteAccountButonunaTiklanir() {
        myProfilePage.deleteAccountButton.click();
    }

//    @And("Are you sure to delete your account permanently? confirmation sorusu icin Yes tiklanir")
//    public void confirmationSorusuIcinYesTiklanir(String arg0) {
//        myProfilePage.yesButton.click();
//
//    }

    @Then("Hesabin silindigi dogrulanir")
    public void hesabinSilindigiDogrulanir() {
        ReusableMethods.visibleWait(myProfilePage.deleteAccountSuccessfullMessage, 5);
        Assert.assertTrue(myProfilePage.deleteAccountSuccessfullMessage.isDisplayed());
    }





    @And("My Profile sekmesine tiklanir")
    public void myProfileSekmesineTiklanir() {

        myProfilePage.myProfileSekmesi.click();

    }


    @And("Delete Account confirmation sorusu icin Yes tiklanir")
    public void deleteAccountConfirmationSorusuIcinYesTiklanir() {
        myProfilePage.yesButton.click();
    }



    @And("Are you sure to delete your account permanently? confirmation sorusu icin Yes tiklanir")
    public void areYouSureToDeleteYourAccountPermanentlyConfirmationSorusuIcinYesTiklanir() {
    }
}


