package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.*;
import GetlandEstate.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US06_US07_ManagerRentandSaleAdStepDefs {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    HomePage homePage=new HomePage();
    CreatePropertyPage createPropertyPage=new CreatePropertyPage();
    DashboardPage dashboardPage=new DashboardPage();


    @Given("Sayfaya gidilir")
    public void sayfayaGidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @When("Manager olarak Siteye gidilir")
    public void managerOlarakGirisYapilir() {
        loginPage.loginButton.click();
        loginPage.mailButton.sendKeys(ConfigReader.getProperty("manager"));
        loginPage.passwordButton.sendKeys(ConfigReader.getProperty("password2"));
        loginPage.login.click();
    }

    @And("Dashboard sayfasindan ana sayfaya geri donulur")
    public void dashboardSayfasindanAnaSayfayaGeriDonulur() {
        dashboardPage.backToSite.click();
    }

    @And("Create property sekmesine tiklanir")
    public void createPropertySekmesineTiklanir() {
        createPropertyPage.createProperty.click();
    }


    @And("Title kismi girilir")
    public void titleKismiGirilir() {
        createPropertyPage.title.sendKeys("Add a rental ad");
    }

    @And("Description kismi girilir")
    public void descriptionKismiGirilir() {
        createPropertyPage.description.sendKeys("description");
        ActionsUtils.scrollDown();
    }

    @And("Price kismi girilir")
    public void priceKismiGirilir() {
        createPropertyPage.price.sendKeys("6541");
    }

    @And("Advert type kismina Rent verisi grilir")
    public void advertTypeKisminaRentVerisiGrilir() {
        createPropertyPage.advertType.click();
        ReusableMethods.ddmVisibleText(createPropertyPage.advertType,"Rent");
    }

    @And("Advert type kismina Sale verisi grilir")
    public void advertTypeKisminaSaleVerisiGrilir() {
        createPropertyPage.advertType.click();
        ReusableMethods.ddmVisibleText(createPropertyPage.advertType,"Sale");
    }

    @And("Category kismina  veri girilir")
    public void categoryKisminaVeriGirilir() {
        createPropertyPage.categoryId.click();
        ReusableMethods.ddmValue(createPropertyPage.categoryId,"1");
    }

    @And("Country kismina  veri girilir")
    public void countryKisminaVeriGirilir() {
        createPropertyPage.countryId.click();
        Select select = new Select(createPropertyPage.countryId);
        select.selectByVisibleText("Deutschland");


    }

    @And("City kismina veri girilir")
    public void cityKisminaVeriGirilir() {
        createPropertyPage.cityId.click();
        Select select = new Select(createPropertyPage.cityId);
        select.selectByVisibleText("Bayern");
    }

    @And("District kismina veri girilir")
    public void districtKisminaVeriGirilir() {
        createPropertyPage.districtId.click();
        Select select = new Select(createPropertyPage.districtId);
        select.selectByVisibleText("Gauting");
    }

    @And("Address kismina veri girilir")
    public void addressKisminaVeriGirilir() {
        createPropertyPage.addressInfo.sendKeys("address info");
    }

    @And("Size kismina veri girilir")
    public void sizeKisminaVeriGirilir() {
        createPropertyPage.size.sendKeys("132");
    }

    @And("Parking space kismina veri girilir")
    public void parkingSpaceKisminaVeriGirilir() {
        createPropertyPage.parkingSpace.click();
        ReusableMethods.ddmValue(createPropertyPage.districtId,"1");

    }

    @And("Year of build kismina veri girilir")
    public void yearOfBuildKisminaVeriGirilir() {
        createPropertyPage.yearOfBuild.sendKeys("2000");
    }

    @And("Furniture kismina veri girilir")
    public void furnitureKisminaVeriGirilir() {
        createPropertyPage.furniture.click();
        Select select = new Select(createPropertyPage.furniture);
        select.selectByVisibleText("No");
    }

    @And("Maintenance Fee kismina veri girilir")
    public void maintenanceFeeKisminaVeriGirilir() {
        createPropertyPage.maintenanceFee.sendKeys("1000");
    }

    @And("Elevator kismina veri girilir")
    public void elevatorKisminaVeriGirilir() {
        createPropertyPage.elevator.sendKeys("1");

    }

    @And("Bedrooms kismina veri girilir")
    public void bedroomsKisminaVeriGirilir() {
        createPropertyPage.bedrooms.sendKeys("3");

    }

    @And("Bathrooms kismina veri girilir")
    public void bathroomsKisminaVeriGirilir() {
        createPropertyPage.bathrooms.sendKeys("2");

    }

    @And("Garage kismina veri girilir")
    public void garageKisminaVeriGirilir() {
        createPropertyPage.garage.click();
        Select select = new Select(createPropertyPage.garage);
        select.selectByVisibleText("Yes");
    }

    @And("Terrace kismina veri girilir")
    public void terraceKisminaVeriGirilir() {
        createPropertyPage.terrace.click();
        Select select = new Select(createPropertyPage.terrace);
        select.selectByVisibleText("Yes");
    }

    @And("Flat kismina veri girilir")
    public void flatKisminaVeriGirilir() {
        createPropertyPage.flat.click();
        Select select = new Select(createPropertyPage.flat);
        select.selectByVisibleText("Yes");
    }

    @And("Flatt kismina veri girilir")
    public void flattKisminaVeriGirilir() {
        createPropertyPage.flatt.click();
        ReusableMethods.ddmValue(createPropertyPage.flatt,"1");
    }

    @And("Flat1 kismina veri girilir")
    public void flat1KisminaVeriGirilir() {
        createPropertyPage.flat1.click();
        ReusableMethods.ddmValue(createPropertyPage.flat,"1");
    }
    @And("Flat2 kismina veri girilir")
    public void flat2KisminaVeriGirilir() {
        createPropertyPage.flat2.click();
        ReusableMethods.ddmValue(createPropertyPage.flat2, "1");
    }

    @And("Flat3 kismina veri girilir")
    public void flat3KisminaVeriGirilir() {
        createPropertyPage.flat3.click();
        ReusableMethods.ddmValue(createPropertyPage.flat3, "1");
    }

    @And("Flat4 kismina veri girilir")
    public void flat4KisminaVeriGirilir() {
        createPropertyPage.flat4.click();
        ReusableMethods.ddmValue(createPropertyPage.flat4, "1");
    }

    @And("Flat5 kismina veri girilir")
    public void flat5KisminaVeriGirilir() {
        createPropertyPage.flat5.click();
        ReusableMethods.ddmValue(createPropertyPage.flat5, "1");
    }

    @And("Flat6 kismina veri girilir")
    public void flat6KisminaVeriGirilir() {
        createPropertyPage.flat6.click();
        ReusableMethods.ddmValue(createPropertyPage.flat6, "2");
    }

    @And("Flat7 kismina veri girilir")
    public void flat7KisminaVeriGirilir() {
        createPropertyPage.flat7.click();
        ReusableMethods.ddmValue(createPropertyPage.flat7, "1");
    }

    @And("GARDEN kismina veri girilir")
    public void gardenKisminaVeriGirilir() {
        createPropertyPage.garden.click();
        Select select = new Select(createPropertyPage.garden);
        select.selectByVisibleText("Yes");
    }

    @And("Flower Garden kismina veri girilir")
    public void flowerGardenKisminaVeriGirilir() {
        createPropertyPage.flowerGarden.click();
        Select select = new Select(createPropertyPage.flowerGarden);
        select.selectByVisibleText("Yes");
    }

    @And("Central AC kismina veri girilir")
    public void centralACKisminaVeriGirilir() {
        createPropertyPage.centralAC.click();
        Select select = new Select(createPropertyPage.centralAC);
        select.selectByVisibleText("No");
    }

    @And("Central heating kismina veri girilir")
    public void centralHeatingKisminaVeriGirilir() {
        createPropertyPage.centralHeating.click();
        Select select = new Select(createPropertyPage.centralHeating);
        select.selectByVisibleText("No");
    }

    @And("Flattisa kismina veri girilir")
    public void flattisaKisminaVeriGirilir() {
        createPropertyPage.flattisa.click();
        Select select = new Select(createPropertyPage.flattisa);
        select.selectByVisibleText("Yes");
    }

    @And("Balcony kismina veri girilir")
    public void balconyKisminaVeriGirilir() {
        createPropertyPage.balcony.sendKeys("1");
    }

    @And("Kullanici ilan icin fotograf ekler")
    public void kullaniciIlanIcinFotografEkler(){
        WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = "C:\\Users\\krstg\\Downloads\\image.png";
        uploadElement.sendKeys(filePath);
        System.out.println("Fotoğraf başarıyla yüklendi.");
    }

    @Then("Bilgiler eksiksiz şekilde girilmeli ve hatasız kaydedilmelidir")
    public void bilgilerEksiksizSekildeDogrulanir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(createPropertyPage.createButton));
        Assert.assertTrue("Create butonu tiklanabilir degil",createPropertyPage.createButton.isEnabled());
        System.out.println("Bilgiler eksiksiz sekilde girildi ");
    }


    //    TC02---------------
    @And("Title kismi bos birakilir")
    public void titleKisminaTiklanilir() {
        createPropertyPage.title.click();
    }

    @And("Description kismi bos birakilir")
    public void descriptionKisminaTiklanilir() {
        createPropertyPage.description.click();

    }

    @Then("Title bos birakildiginda hata mesaji goruntulendi")
    public void titleHataMesaji() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement titleError = wait.until(ExpectedConditions.visibilityOf(createPropertyPage.titleErrorMessage));
        Assert.assertTrue(createPropertyPage.titleErrorMessage.isDisplayed());
    }

    @Then("Description bos birakildiginda hata mesaji goruntulendi")
    public void descriptionHataMesaji() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement descriptionError = wait.until(ExpectedConditions.visibilityOf(createPropertyPage.descriptionErrorMessage));
        Assert.assertTrue(createPropertyPage.descriptionErrorMessage.isDisplayed());
    }

    @And("Address kismina tiklanilir")
    public void addressKisminaTiklanilir() {
        createPropertyPage.address.click();
    }

    @Then("Address bos birakildiginda hata mesaji goruntulendi")
    public void addressHataMesaji() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addressError = wait.until(ExpectedConditions.visibilityOf(createPropertyPage.addressErrorMessage));
        Assert.assertTrue(createPropertyPage.addressErrorMessage.isDisplayed());
    }

    @Then("Fotograf yuklendiginda hata mesaji kayboldu")
    public void fotografYuklendi() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        boolean isNotVisible = wait.until(ExpectedConditions.invisibilityOf(createPropertyPage.imageErrorMessage));
        Assert.assertTrue("Fotograf yuklendikten sonra hata mesajı kaybolmadi", isNotVisible);
    }

    @And("Kullanici ilan icin 3mb boyutundan yuksek bir fotograf ekler")
    public void moreThan3mbFileSize(){
        WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = "C:\\Users\\krstg\\Downloads\\morethan3mb.png";
        uploadElement.sendKeys(filePath);
        System.out.println("+3MB fotograf basariyla yuklendi.");

    }

    @Then("Fotograf yuklendiginda hata mesaji gosterildi")
    public void fotografYuklendigindaHataMesajiGosterildi() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement addressError = wait.until(ExpectedConditions.visibilityOf(createPropertyPage.moreThan3MBErrorMessage));
        Assert.assertTrue(createPropertyPage.moreThan3MBErrorMessage.isDisplayed());
    }

    @Then("Create butonu pasif olmalidir")
    public void butonuPasifOlmalidir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Assert.assertFalse("Create butonu pasif olmali", createPropertyPage.createButton.isEnabled());
    }

    @And("Create butonu aktif olmalidir")
    public void createButonuAktifOlmalidir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createButton);
        System.out.println("Create butonuna tiklandi.");


    }

    @Then("Islem basarili, kullanici my adverts sayfasina aktarildi")
    public void ilanOlusturmaBasarili() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.urlContains("my-adverts"));
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("kullanici sayfaya yonlendirilemedi mevcut url:" + currentURL, currentURL.contains("my-adverts"));


    }


}
