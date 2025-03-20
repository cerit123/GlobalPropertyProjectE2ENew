package GetlandEstate.stepdefs.ui_stepdefs;

import GetlandEstate.pages.SearchPage;
import GetlandEstate.utilities.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class US10_US11_Stepdefs {

    SearchPage searchPage= new SearchPage();
    Faker faker;
    Select advertTypeDropDown;
    Select  countryDropDown;
    Select  cityDropDown;
    Select  categoryDropDown;
    Select   districtDropDown;
//    @Given("sayfaya gidilir")
  //  public void sayfayaGidilir() {
  //      Driver.getDriver().get("http://64.227.123.49/");
  //  }
//
    @Given("search box ın üzerindeki rent butonuna tıklanır")
    public void searchBoxInÜzerindekiRentButonunaTıklanır() {

        ReusableMethods.waitForSecond(2);
        searchPage.rentButton.click();
       
    }

    @And("search box ın altındaki istenilen {string} seçilir")
    public void searchBoxInAltındakiIstenilenSeçilir(String emlaktürü) {
        WebElement propertyButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(), '" + emlaktürü + "')]"));
        propertyButton.click();
    }

    @And("search butonuna tıklanır")
    public void searchButonunaTıklanır() {
        ReusableMethods.visibleWait(searchPage.searchButton,30);
        searchPage.searchButton.click();
    }

    @And("açılan pencerede seçilen ürünün geldiği görünür")
    public void açılanPenceredeSeçilenÜrününGeldiğiGörünür() {

        Assert.assertTrue(searchPage.totalFoundText.isDisplayed());
    }

  //  @Then("sayfa kapatılır")
  //  public void sayfaKapatılır() {
  //      Driver.closeDriver();
  //  }



    @And("açılan sol pencerede Price Range bölümünde min kutusuna geçerli bir data girilir")
    public void açılanSolPenceredePriceRangeBölümündeMinKutusunaGeçerliBirDataGirilir() {
      Driver.getDriver().navigate().refresh();
        searchPage.minPriceRange.sendKeys("100");
    }

    @And("açılan sol pencerede Price Range bölümünde max kutusuna geçerli ve min kutusundaki değerden büyük bir data girilri")
    public void açılanSolPenceredePriceRangeBölümündeMaxKutusunaGeçerliVeMinKutusundakiDeğerdenBüyükBirDataGirilri() {

        searchPage.maxPriceRange.sendKeys("200");
    }

    @And("Advert Type, Category, dropdownlarında all seçeneği seçilir")
    public void advertTypeCategoryDropdownlarındaAllSeçeneğiSeçilir() {
       WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='at']/option[text()='All']")));

       ActionsUtils.scrollDown();


       advertTypeDropDown=new Select(searchPage.advertTypeDropDown);
       ReusableMethods.waitForSecond(1);
       advertTypeDropDown.selectByVisibleText("All");


       categoryDropDown=new Select(searchPage.categoryDropDown);
       categoryDropDown.selectByVisibleText("All");
    }

    @And("Country,City,District  dropdown ından herhangi bir seçenek seçilir")
    public void countryCityDistrictDropdownIndanHerhangiBirSeçenekSeçilir() {


    }

    @Then("arama sonucunun başarılı olduğu görülür")
    public void aramaSonucununBaşarılıOlduğuGörülür() {
        ReusableMethods.visibleWait(searchPage.totalFoundText,5);
        ActionsUtils.scrollHome();

        Assert.assertTrue(searchPage.totalFoundText.isDisplayed());
    }


    @And("açılan sol pencerede Price Range bölümünde min kutusuna negatif değer yazılır")
    public void açılanSolPenceredePriceRangeBölümündeMinKutusunaNegatifDeğerYazılır() {
        Driver.getDriver().navigate().refresh();
        searchPage.minPriceRange.sendKeys("-100");
    }

    @And("açılan sol pencerede Price Range bölümünde max kutusu boş bırakılır")
    public void açılanSolPenceredePriceRangeBölümündeMaxKutusuBoşBırakılır() {
    }

    @And("Advert Type, Category, Country dropdownlarında all seçeneği seçilmelidir")
    public void advertTypeCategoryCountryDropdownlarındaAllSeçeneğiSeçilmelidir() {

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

    @And("City ve District  dropdownları boş olmalıdır")
    public void cityVeDistrictDropdownlarıBoşOlmalıdır() {
    }

    @Then("uyarı mesajı görülmelidir")
    public void uyarıMesajıGörülmelidir() {
        ActionsUtils.scrollHome();
        ReusableMethods.waitForSecond(1);

        Assert.assertTrue(searchPage.propertiesList.isEmpty());
    }

    @And("açılan sol pencerede Price Range bölümünde min kutusuna bir değer girilir")
    public void açılanSolPenceredePriceRangeBölümündeMinKutusunaBirDeğerGirilir() {
       Driver.getDriver().navigate().refresh();
        searchPage.minPriceRange.sendKeys("100");
    }

    @And("açılan sol pencerede Price Range bölümünde max kutusuna miinimum değerden küçük bir değer girilir")
    public void açılanSolPenceredePriceRangeBölümündeMaxKutusunaMiinimumDeğerdenKüçükBirDeğerGirilir() {
        searchPage.maxPriceRange.sendKeys("50");
    }


    @And("search box ın altındaki istenilen emlak seçilir")
    public void searchBoxInAltındakiIstenilenEmlakSeçilir() {
      //  searchPage.villaButton.click();
    }

    @And("gelen ürünlerden bir tanesi üzerine tıklayarak açılır")
    public void gelenÜrünlerdenBirTanesiÜzerineTıklayarakAçılır() {
        Driver.getDriver().navigate().refresh();


                ReusableMethods.waitForSecond(1);
                Random random = new Random();
                int randomIndex = random.nextInt(searchPage.propertiesList.size());
                searchPage.propertiesList.get(randomIndex).click();

        
    }

    @And("açılan ürün sayfasında description bilgileri görünür")
    public void açılanÜrünSayfasındaDescriptionBilgileriGörünür() {
        Assert.assertTrue(searchPage.Description.isDisplayed());
    }

    @And("açılan ürün sayfasında DETAILSbilgileri görünür")
    public void açılanÜrünSayfasındaDETAILSbilgileriGörünür() {
        Assert.assertTrue(searchPage.Details.isDisplayed());
    }

    @Then("açılan ürün sayfasında LOCATION bilgileri görünür")
    public void açılanÜrünSayfasındaLOCATIONBilgileriGörünür() {
        Assert.assertTrue(searchPage.Location.isDisplayed());
    }

    @And("açılan ürün sayfasında resim bilgileri görünür")
    public void açılanÜrünSayfasındaResimBilgileriGörünür() {
        Assert.assertTrue(searchPage.image.isDisplayed());
    }


    @Then("searchh butonuna tıklanır")
    public void searchhButonunaTıklanır() {
        ActionsUtils.scrollDown();
        ReusableMethods.waitForSecond(30);
        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        // WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchPage.searchButton2));
        searchPage.searchButton2.click();
    }

    @And("contact number kutusundan görünürlüğü açılır")
    public void contactNumberKutusundanGörünürlüğüAçılır() {
        WaitUtils.waitFor(2);
        searchPage.contactNumberButton.click();
    }

    @Then("send mail kutusundan görünürlüğü açılır")
    public void sendMailKutusundanGörünürlüğüAçılır() {
        searchPage.sendMailButton.click();
    }

    @Then("contact number ve mail görünür olur")
    public void contactNumberVeMailGörünürOlur() {

        Assert.assertTrue(searchPage.sendMail.isDisplayed());
        Assert.assertTrue(searchPage.contactNumber.isDisplayed());
    }


    @And("Schedule a tour bölümünde geçerli geçerli bir tarih seçilir")
    public void scheduleATourBölümündeGeçerliGeçerliBirTarihSeçilir() {
        faker = new Faker();
        ReusableMethods.waitForSecond(1);
        searchPage.tourDate.sendKeys("15.12.2026", Keys.TAB, Keys.TAB);
    }

    @And("Schedule a tour bölümünde geçerli geçerli bir saat seçilir")
    public void scheduleATourBölümündeGeçerliGeçerliBirSaatSeçilir() {
        Select select = new Select(searchPage.tourTime);


        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);

        // ReusableMethods.ddmValue(searchPage.tourTime,"11:00");
    }

    @And("Submit a tour request butonuna basılır")
    public void submitATourRequestButonunaBasılır() {
        searchPage.submitTourRequestButton.click();
    }

    @Then("TourRequest created successfully yazısı görünür")
    public void tourrequestCreatedSuccessfullyYazısıGörünür() {
        ReusableMethods.visibleWait(searchPage.createdVerify,5);
        Assert.assertTrue(searchPage.createdVerify.isDisplayed());
    }

    @And("Schedule a tour bölümünde tarih kısmı boş bırakılır")
    public void scheduleATourBölümündeTarihKısmıBoşBırakılır() {
        ReusableMethods.waitForSecond(2);
    }

    @And("Schedule a tour bölümünde saat kısmı boş bırakılır")
    public void scheduleATourBölümündeSaatKısmıBoşBırakılır() {
    }

    @Then("hata mesajları görülmelidir")
    public void hataMesajlarıGörülmelidir() {
        Assert.assertTrue(searchPage.tourDateRequiredMassage.isDisplayed());
        Assert.assertTrue(searchPage.tourTimeRequiredMassage.isDisplayed());
    }

    @And("sağ üstteki kullanıcı ikonuna tıklanır")
    public void sağÜsttekiKullanıcıIkonunaTıklanır() {
        ReusableMethods.waitForSecond(2);
        searchPage.costumerIcon.click();
    }

   

    @Then("Oluşturulan randevunun eklendiği görülür")
    public void oluşturulanRandevununEklendiğiGörülür() {
        ReusableMethods.waitForSecond(8);
        Assert.assertTrue(searchPage.myTourVerify.isDisplayed());
    }

    @And("açılan dropdown da tur isteklerim butonuna tıklanır")
    public void açılanDropdownDaTurIsteklerimButonunaTıklanır() {
        searchPage.myTourRequests.click();
    }


    @Then("Status sütununda oluşturulan randevunun durumu görülür")
    public void statusSütunundaOluşturulanRandevununDurumuGörülür() {
        Assert.assertNotNull(searchPage.statusVerify.getText());
    }

    @Given("search box ın üzerindeki sale butonuna tıklanır")
    public void searchBoxInÜzerindekiSaleButonunaTıklanır() {
        searchPage.saleButton.click();
    }
}



