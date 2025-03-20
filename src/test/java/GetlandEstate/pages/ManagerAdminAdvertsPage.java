package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerAdminAdvertsPage {



    public ManagerAdminAdvertsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[normalize-space()='Back to Site']")
    public WebElement BackToSite;

    @FindBy(xpath = "(//img[@class='user-pic'])[1]")
    public WebElement profil;


    @FindBy(xpath = "//span[normalize-space()='My Adverts']")
    public WebElement MyAdverts;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/div[1]/button[2]//*[name()='svg']")
    public WebElement AdvertEditButton;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/div[1]/button[2]//*[name()='svg']")
    public WebElement AdverAdmintEditButton;


    @FindBy(xpath = "//tbody/tr[4]/td[5]/div[1]/div[1]/button[2]//*[name()='svg']")
    public WebElement AdvertAdminEditButton;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement advertTitle;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement advertPrice;


    @FindBy(xpath = "//select[@id='advertTypeId']")
    public WebElement AdvertType;


    @FindBy(xpath = "//select[@id='categoryId']")
    public WebElement AdvertCategory;

   // @FindBy(xpath = "//select[@id='advertTypeId']/option[text()='Sale']")
    //public WebElement AdvertTypeSale;

    @FindBy(xpath = "//select[@id='countryId']")
    public WebElement AdvertCountry;

    @FindBy(xpath = "//select[@id='cityId']")
    public WebElement AdvertCity;

    @FindBy(xpath = "//select[@id='districtId']")
    public WebElement AdvertDistrict;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement AdvertAddress;


    @FindBy(xpath = "//input[@id='Size']")
    public WebElement AdvertSize;

    @FindBy(xpath = "//input[@id='Bedrooms']")
    public WebElement AdvertBedrooms;



    @FindBy(xpath = "//input[@id='custom-switch']")
    public WebElement AdvertStatus;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    public WebElement AdvertUpdateButton;


    @FindBy(xpath = "//div[@class='p-toast-detail']")
    public WebElement AdvertSuccessfullyMessage;


    @FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/div[1]/button[1]//*[name()='svg']")
    public WebElement AdvertDeleteButton;

    @FindBy(xpath = "//button[@aria-label='Yes']//*[name()='svg']")
    public WebElement AdvertDeleteYesButton;

    @FindBy(xpath = "//div[@class='p-toast-detail']")
    public WebElement AdvertDeletedSuccessfullyMessage;

    @FindBy(xpath = "(//span[@class='p-tag-value' and @data-pc-section='value'])[4]")
    public WebElement advertStatusElement;


    @FindBy(xpath = "//tbody/tr[4]/td[5]/div[1]/div[1]/button[2]//*[name()='svg']")
    public WebElement getAdvertAdminEditButton;























}
