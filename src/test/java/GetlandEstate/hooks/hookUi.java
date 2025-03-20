package GetlandEstate.hooks;


import GetlandEstate.pages.HomePage;
import GetlandEstate.pages.LoginPage;
import GetlandEstate.utilities.ConfigReader;
import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.WaitUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class hookUi {

    @Before("@Admin")
    public void uiAdmin() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage=new HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        homePage.LoginButton.click();
        loginPage.mailButton.sendKeys(ConfigReader.getProperty("admin"));
        loginPage.passwordButton.sendKeys(ConfigReader.getProperty("password1"));
        loginPage.login.click();

        WaitUtils.waitFor(2);
    }

    @Before("@Customer")
    public void uiCustomer() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.LoginButton.click();
        loginPage.mailButton.sendKeys(ConfigReader.getProperty("emailCostumer"));
        loginPage.passwordButton.sendKeys(ConfigReader.getProperty("passwordCostumer"));
        loginPage.login.click();

        WaitUtils.waitFor(2);
    }

    @Before("@Manager")
    public static void uiManager() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage=new HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.LoginButton.click();
        loginPage.mailButton.sendKeys(ConfigReader.getProperty("manager"));
        loginPage.passwordButton.sendKeys(ConfigReader.getProperty("password2"));
        loginPage.login.click();

        WaitUtils.waitFor(2);
    }




    @After
    public void tearDown(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", "scenario" + scenario.getName());
            Driver.closeDriver();
        }
        try {
            Driver.closeDriver();
        } catch (Exception e) {
            System.out.println("Driver kapatma sırasında hata oluştu: " + e.getMessage());
        }
    }
}
