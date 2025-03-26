package GetlandEstate.stepdefs.ui_stepdefs;
import GetlandEstate.pages.*;
import GetlandEstate.utilities.ConfigReader;
import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class US15_AdministratorActionsStepdefs {
   // @When("Log in butonuna tıklanılır")
  //  public void logInButonunaTıklanılır() {
  //  }

//    @And("Admin bilgileri girilir")
//    public void adminBilgileriGirilir() {
//    }
    UsersPage usersPage = new UsersPage();
AdminManagerRaporPage adminManagerRaporPage = new AdminManagerRaporPage();
CategoriesPage categoriesPage = new CategoriesPage();
SearchPage searchPage = new SearchPage();
DashboardPage dashboardPage = new DashboardPage();
AdvertTypesPage advertTypesPage = new AdvertTypesPage();
    @And("Kategori sekmesine tıklanılır")
    public void kategoriSekmesineTıklanılır() {
        dashboardPage.categoryButton.click();
    }

    @And("Add New butonuna tıklanır")
    public void addNewButonunaTıklanır() {
        categoriesPage.addNewButton.click();
    }

    @And("Kategori başlık, sıra nosu, ikon ismi girilir")
    public void kategoriBaşlıkSıraNosuIkonIsmiGirilir() {
        categoriesPage.addNewCategoryTitle.click();
        categoriesPage.addNewCategoryTitle.sendKeys("HouseTinyMin");
        categoriesPage.addNewCategoryNo.click();
        categoriesPage.addNewCategoryNo.sendKeys("28");
        categoriesPage.addNewIconName.click();
        categoriesPage.addNewIconName.sendKeys("house");


    }

    @And("Oluştur butonuna tıklanılır")
    public void oluşturButonunaTıklanılır() {
        categoriesPage.addNewSubmitButton.click();
    }

    @Then("Kategori başarıyla oluşturuldu mesajı görüntülenmelidir")
    public void kategoriBaşarıylaOluşturulduMesajıGörüntülenmelidir() {
        categoriesPage.categorySuccesfulyMesage.isDisplayed();

    }

    @And("İlan türü sekmesine tıklanılır")
    public void ilanTürüSekmesineTıklanılır() {
        dashboardPage.advertTypes.click();

    }

    @And("İlan türü girilir")
    public void ilanTürüGirilir() {
//        advertTypesPage.AddNewButton.submit();
//        WaitUtils.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", advertTypesPage.AddNewButton);

        advertTypesPage.entertitle.click();
        advertTypesPage.entertitle.sendKeys(ConfigReader.getProperty("TinyHouses"));
        advertTypesPage.submitButton.click();

    }
//@And("İlan türü girilir")
//public void ilanTürüGirilir() {
//    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//
//    // "Add New" butonuna tıklama (Butonun tıklanabilir olmasını bekleyerek)
//    WebElement addNewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Add New']")));
//    addNewButton.click();
//
//    // "Title" giriş alanına tıklama (Öğenin görünür olmasını bekleyerek)
//    WebElement enterTitle = wait.until(ExpectedConditions.visibilityOf(advertTypesPage.entertitle));
//    enterTitle.click();
//
//
//
//    // "Title" giriş alanına değer girme
//    enterTitle.sendKeys(ConfigReader.getProperty("TinyHouses"));
//
//    // "Submit" butonuna tıklama (Butonun tıklanabilir olmasını bekleyerek)
//    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(advertTypesPage.submitButton));
//    submitButton.click();
//}


    @Then("İlan türü başarıyla oluşturuldu mesajı görüntülenmelidir")
    public void ilanTürüBaşarıylaOluşturulduMesajıGörüntülenmelidir() {

        advertTypesPage.successfulMessage.isDisplayed();
    }

    @And("Kullanıcılar sekmesine tıklanılır")
    public void kullanıcılarSekmesineTıklanılır() {
        usersPage.users.click();
    }

    @And("Search kutusuna aranan kullanıcı adı girilir")
    public void searchKutusunaArananKullanıcıAdıGirilir() {

        WaitUtils.waitForClickablility(usersPage.searchTitle,2).sendKeys("KAAN");
    }




    @And("Search butonuna tıklanır")
    public void searchButonunaTıklanır() {
        usersPage.searchButton.click();

        
    }

    @Then("Girilen kullanıcı adının arama sonuçlarında görüntülendiği doğrulanır")
    public void girilenKullanıcıAdınınAramaSonuçlarındaGörüntülendiğiDoğrulanır() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//tbody/tr[@role='row']/td[1]/div[1]"));
        if (element.getText().contains("KAAN")) {
            System.out.println("İstenilen isim bulundu: " + element.getText());
        } else {
            System.out.println("İstenilen isim bulunamadı.");
        }

    }

    @And("Search kutusuna kullanıcı adı girilir")
    public void searchKutusunaKullanıcıAdıGirilir() {
        usersPage.searchTitle.click();
        usersPage.searchTitle.sendKeys("KAAN");
        usersPage.searchButton.click();
    }

    @And("First Name ve Last Name alanında değişiklikler yapılır")
    public void firstNameVeLastNameAlanındaDeğişikliklerYapılır() {
        usersPage.usersPageAction.click();
        usersPage.usersPageName.click();
        usersPage.usersPageName.clear();
        WaitUtils.waitFor(2);
       usersPage.usersPageName.sendKeys("Ali");



    }
    @When("Edit butonuna tıklanır")
    public void editButonunaTıklanır() {
       // usersPage.arananKullanıcınınEditi.click();

  }

    @And("Güncelle butonuna tıklanılır")
    public void güncelleButonunaTıklanılır() {
        usersPage.updateButton.click();
    }

    @Then("Girilen bilgilerin başarıyla güncellendiği doğrulanır")
    public void girilenBilgilerinBaşarıylaGüncellendiğiDoğrulanır() {

    }

    @And("Roller butonuna tıklanır")
    public void rollerButonunaTıklanır() {
        WaitUtils.waitFor(1);
//        usersPage.usersPageRole.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(usersPage.rolesManager).click().perform();
//
//
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].click();", usersPage.usersPageRole);
//        WaitUtils.waitFor(1);
//        js.executeScript("arguments[0].click();", usersPage.rolesManager);
    }

        @And("Kullanıcı için farklı bir rol seçilir")
    public void kullanıcıIçinFarklıBirRolSeçilir() {
        usersPage.rolesManager.submit();
    }

    @Then("Kullanıcı rolünün başarıyla değiştiği doğrulanır")
    public void kullanıcıRolününBaşarıylaDeğiştiğiDoğrulanır() {
        
    }

    @And("Kategori ismi girilir")
    public void kategoriIsmiGirilir() {
        categoriesPage.categorySearchBox.click();
        categoriesPage.categorySearchBox.sendKeys("HouseTinyHouse");
        categoriesPage.categorySearchButton.click();
        categoriesPage.categorySearchEdit.click();
    }

    @Then("Girilen kategori adının arama sonuçlarında görüntülendiği doğrulanır")
    public void girilenKategoriAdınınAramaSonuçlarındaGörüntülendiğiDoğrulanır() {
        categoriesPage.categorySearchBox.getTagName();

    }

    @And("Başlık alanına farklı bir isim girilir")
    public void başlıkAlanınaFarklıBirIsimGirilir() {
        categoriesPage.addNewCategoryTitle.click();
        categoriesPage.addNewCategoryTitle.clear();
        WaitUtils.waitFor(1);
        categoriesPage.addNewCategoryTitle.sendKeys("HouseMiniSweet");
        WaitUtils.waitFor(1);
        categoriesPage.addNewSubmitButton.click();
    }

    @Then("Kategori başarıyla güncellendiği doğrulanır")
    public void kategoriBaşarıylaGüncellendiğiDoğrulanır() {
        
    }


    @And("Sol menüden Tur Talepleri sekmesine tıklanır")
    public void solMenüdenTurTalepleriSekmesineTıklanır() {
        dashboardPage.tourRequests.click();
        
    }

    @Then("Tur talepleri listesinin görüntülendiği doğrulanır")
    public void turTalepleriListesininGörüntülendiğiDoğrulanır() {

    }



}
