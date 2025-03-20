package GetlandEstate.stepdefs.ui_stepdefs;


import GetlandEstate.pages.HomePage;
import GetlandEstate.pages.RegistrationPage;
import GetlandEstate.utilities.ActionsUtils;
import GetlandEstate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.common.assertion.Assertion;
import org.apache.groovy.json.internal.Exceptions;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;


public class US01_RegisterPageStepdefs {


    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();
    boolean isClickIntercepted = false;


    @When("Register sekmesine tiklanir")
    public void registerSekmesineTiklanir() {

        homePage.RegisterButton.click();

    }

    @And("First name kısmına {string} girilir")
    public void firstNameKısmınaGirilir(String name) {

        registrationPage.firstName.sendKeys(name);

    }

    @And("Last name kısmına {string} girilir")
    public void lastNameKısmınaGirilir(String lastname) {

        registrationPage.lastName.sendKeys(lastname);

    }

    @And("Phone number kısmına {string} girilir")
    public void phoneNumberKısmınaGirilir(String phoneNumber) {

        registrationPage.phoneNumber.click();
        registrationPage.phoneNumber.sendKeys(phoneNumber);

    }

    @And("Email address kısmına {string} girilir")
    public void emailAddressKısmınaGirilir(String email) {

        registrationPage.email.sendKeys(email);

    }

    @And("Password kısmına {string} yazılır")
    public void passwordKısmınaYazılır(String password) {

        registrationPage.password.sendKeys(password);

    }

    @And("Confirm password kısmına {string} tekrar yazılır")
    public void confirmPasswordKısmınaTekrarYazılır(String password) {

        registrationPage.confirmPassword.sendKeys(password);

    }

    @And("Terms of Use butonuna tıklanır")
    public void termsOfUseButonunaTıklanır() {

        registrationPage.termsCheckBox.click();

    }

    @And("Register butonuna tıklanır")
    public void registerButonunaTıklanır() {

        try {

            registrationPage.registerButton.click();

        } catch (ElementClickInterceptedException e) {

            isClickIntercepted = true;
            Assert.assertTrue(true);

        }


    }

    @Then("Kayıt işlemi doğrulanır")
    public void kayıtIşlemiDoğrulanır() {

        if (!isClickIntercepted) { // Eğer hata oluşmadıysa başarı mesajını doğrula
            WaitUtils.waitForVisibility(registrationPage.successfullMessage, 5);
            Assert.assertTrue(registrationPage.successfullMessage.getText().contains("successfully"));
        } else {
            Assert.fail("Kayıt işlemi doğrulanamaz, çünkü butona tıklanamadı.");
        }
    }


    @Then("Kayıt işleminin başarısız olduğu doğrulanır")
    public void kayıtIşlemininBaşarısızOlduğuDoğrulanır() {

        Assert.assertTrue("ElementClickInterceptedException fırlatılmadığı için kayıt başarısız sayıldı.", isClickIntercepted);

    }

    @And("Terms of Use butonuna tıklanmaz")
    public void termsOfUseButonunaTıklanmaz() {



    }
}
