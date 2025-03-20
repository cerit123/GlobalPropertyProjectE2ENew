package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.SearchPage;
import GetlandEstate.utilities.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class US12SearchAbleStepdefs {

    SearchPage searchPage= new SearchPage();
    Faker faker;
    Select advertTypeDropDown;
    Select  countryDropDown;
    Select  cityDropDown;
    Select  categoryDropDown;
    Select   districtDropDown;

    @Given("Siteye gidilir.")
    public void siteyeGidilir() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitForSecond(5);

    }

    @When("Search kisminda bulunan Rent butonuna tiklanir")
    public void searchKismindaBulunanRentButonunaTiklanir() {
        searchPage.rentButton.click();
    }

    @And("search box ın altındaki emlak {string} seçilir")
    public void searchBoxInAltındakiEmlakSeçilir(String emlakTürleri) {
        WebElement propertyButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(), '" + emlakTürleri + "')]"));
        propertyButton.click();
    }

    @And("search butonuna tiklanir")
    public void searchButonunaTiklanir() {
        ReusableMethods.visibleWait(searchPage.searchButton,30);
        searchPage.searchButton.click();

    }

    @Then("acilan pencerede seçilen emlakın geldigi gorunur")
    public void acilanPenceredeSeçilenEmlakınGeldigiGorunur() {
        Assert.assertTrue(searchPage.totalFoundText.isDisplayed());
    }



   @Then("sayfa kapatilir.")
    public void sayfaKapatilir() {
        Driver.closeDriver();
   }


    @When("Search kisminda bulunan arama butonuna tiklanir")
    public void searchKismindaBulunanAramaButonunaTiklanir() {
        searchPage.searchButton.click();
    }

    @And("Acilan pencerede Price Range, Advert Type, Category, Country, City, District bölümleri gorulur.")
    public void acilanPenceredePriceRangeAdvertTypeCategoryCountryCityDistrictBölümleriGorulur() {
        ReusableMethods.waitForSecond(5);
    }

    @And("Price Range bolumunde bulunan Min box bolumune gecerli bir data girilir.")
    public void priceRangeBolumundeBulunanMinBoxBolumuneGecerliBirDataGirilir() {
        searchPage.minPriceRange.sendKeys("1");
    }

    @And("Price Range bolumunde bulunan Max box bolumune gecerli bir data girilir.")
    public void priceRangeBolumundeBulunanMaxBoxBolumuneGecerliBirDataGirilir() {
        searchPage.maxPriceRange.sendKeys("100");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='at']/option[text()='All']")));

        ActionsUtils.scrollDown();


        advertTypeDropDown=new Select(searchPage.advertTypeDropDown);
        ReusableMethods.waitForSecond(1);
        advertTypeDropDown.selectByVisibleText("All");


        categoryDropDown=new Select(searchPage.categoryDropDown);
        categoryDropDown.selectByVisibleText("All");
        searchPage.searchButton2.click();
    }

    @Then("Price Range bolumunde bulunan Min box ve Max box bolumlerine gecerli bir data girilebildigi dogrulanir.")
    public void priceRangeBolumundeBulunanMinBoxVeMaxBoxBolumlerineGecerliBirDataGirilebildigiDogrulanir() {
        ReusableMethods.visibleWait(searchPage.totalFoundText,5);
        ActionsUtils.scrollHome();

        Assert.assertTrue(searchPage.totalFoundText.isDisplayed());
    }


    @And("Price Range bolumunde bulunan Min box bolumune gecersiz bir data girilir.")
    public void priceRangeBolumundeBulunanMinBoxBolumuneGecersizBirDataGirilir() {
        Driver.getDriver().navigate().refresh();
        searchPage.minPriceRange.sendKeys("-1");
        JSUtils.JSscrollIntoView(searchPage.advertTypeDropDown);
        advertTypeDropDown=new Select(searchPage.advertTypeDropDown);
        advertTypeDropDown.selectByValue("1");

        JSUtils.JSscrollIntoView(searchPage.categoryDropDown);
        categoryDropDown=new Select(searchPage.categoryDropDown);
        categoryDropDown.selectByVisibleText("All");


        JSUtils.JSscrollIntoView(searchPage.countryDropDown);
        countryDropDown=new Select(searchPage.countryDropDown);
        countryDropDown.selectByVisibleText("All");
    }

    @Then("Search arama butonuna tiklandiginda uyari vermelidir.")
    public void searchAramaButonunaTiklandigindaUyariVermelidir() {
        ReusableMethods.waitForSecond(1);
        Assert.assertTrue(searchPage.errorMassage.isDisplayed());
    }




    @And("Acilan pencerede bir emlak secilir.")
    public void acilanPenceredeBirEmlakSecilir() {
        Driver.getDriver().navigate().refresh();

        if (!searchPage.propertiesList.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(searchPage.propertiesList.size());
            searchPage.propertiesList.get(randomIndex).click();
        } else {
            throw new RuntimeException("No property images found!");
        }
    }

    @Then("Seçilen emlak ile alakalı resim, Description, DETAILS, LOCATION bilgilerinin gorulebildigi dogrulanir.")
    public void seçilenEmlakIleAlakalıResimDescriptionDETAILSLOCATIONBilgilerininGorulebildigiDogrulanir() {
        Assert.assertTrue(searchPage.Description.isDisplayed());
        Assert.assertTrue(searchPage.Details.isDisplayed());
        Assert.assertTrue(searchPage.Location.isDisplayed());
    }




}
