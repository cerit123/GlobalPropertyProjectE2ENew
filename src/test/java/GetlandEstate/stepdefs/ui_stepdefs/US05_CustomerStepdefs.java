package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.AdminManagerRaporPage;
import GetlandEstate.pages.LoginPage;
import GetlandEstate.pages.UsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US05_CustomerStepdefs {
    LoginPage loginPage = new LoginPage();
    UsersPage userpage = new UsersPage();
    AdminManagerRaporPage admin = new AdminManagerRaporPage();
    Select rolesSelect;

    @When("Login sekmesine tiklanir")
    public void loginSekmesineTiklanir() {
        loginPage.loginButton.click();
    }

    @And("Siteye kaydolunan email adresi girilir")
    public void siteyeKaydolunanEmailAdresiGirilir() {

        loginPage.mailButton.sendKeys("admin@gmail.com");
    }

    @And("Kullanici password girilir")
    public void kullaniciPasswordGirilir() {

        loginPage.passwordButton.sendKeys("admin123!");
    }

    @Then("Login olundugu dogrulanir")
    public void loginOlunduguDogrulanir() {
        loginPage.login.click();
        Assert.assertTrue(loginPage.loginButton.isEnabled());
    }

    @And("Admin olarak giriş yapılabilmeliır")
    public void adminOlarakGirişYapılabilmeliır() {
    }

    // TC_02 ---------

    @And("Kullanıcı sekmesine tıklanır")
    public void kullanıcıSekmesineTıklanır() {

        userpage.users.click();
    }

    @Then("Oluşturulan kullanıcı bilgileri görülebilmeli")
    public void oluşturulanKullanıcıBilgileriGörülebilmeli() {

        Assert.assertTrue(userpage.usersName.isDisplayed());

    }

    // TC_03 ----------

    @And("Rol seçme sekmesine tıklanır")
    public void rolSeçmeSekmesineTıklanır() {

        userpage.usersPageRole.click();
    }

    @Then("\"Customer roli seçilerek atanır")
    public void customerRoliSeçilerekAtanır() throws Throwable {
        userpage.rolesCustomer.click();

        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }
    // TC_04 -------------

    @And("Günceleme sekmesine tıklanılır")
    public void güncelemeSekmesineTıklanılır() {
        userpage.actionUpdate.click();
        userpage.usersEditFirstName.sendKeys("ilos");
        userpage.updateButton.click();
    }

    @Then("Günceleme yapıldığı doğrulanır.")
    public void güncelemeYapıldığıDoğrulanır() {
        Assert.assertTrue(userpage.usersName.getText().contains("ilos"));
    }

    // TC_05 ---------
    @And("Delete sekmesine tıklanılır")
    public void deleteSekmesineTıklanılır() {
        userpage.actionUpdate.click();
        userpage.deleteButton.click();
    }

    @Then("Oluşturulan kullanıcı silinebilir olmalı")
    public void oluşturulanKullanıcıSilinebilirOlmalı() {

        Assert.assertTrue(userpage.errorAlert.isDisplayed());

    }

    // TC_06 ---------
    @Then("\"Admin rolu atamaya izin vermiyor")
    public void adminRoluAtamayaIzinVermiyor() throws Throwable {

        userpage.rolesAdmin.click();
        rolesSelect = new Select(userpage.rolesAdmin);
        rolesSelect.selectByVisibleText("Admin");

        Assert.assertTrue(rolesSelect.getFirstSelectedOption().getText().equals("Admin"));

        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }
    // TC_07 -------
    @Then("\"Manager rolu atamaya izin vermiyor")
    public void managerRoluAtamayaIzinVermiyor() throws Throwable {
        Assert.assertTrue(userpage.userCanNotUpdate.isDisplayed());// Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }
}
