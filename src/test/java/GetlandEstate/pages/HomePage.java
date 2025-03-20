package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//a[text()='Home'])[1]")
    public WebElement HomeButton;

    @FindBy(xpath = "(//a[text()='Properties'])[1]")
    public WebElement PropertiesButton;

    @FindBy(xpath = "(//a[text()='About'])[1]")
    public WebElement AboutButton;


    @FindBy(xpath = "(//a[text()='Contact'])[1]")
    public WebElement ContactButton;


    @FindBy(xpath = "//a[text()='Login']")
    public WebElement LoginButton;


    @FindBy(xpath = "//a[text()='Register']")
    public WebElement RegisterButton;


    @FindBy(xpath = "(//a[@role='button'])[1]")
    public WebElement LanguageDropDownButton;

    @FindBy(xpath = "//a[text()='English']")
    public WebElement EnglishLanguageButton;

    @FindBy(xpath = "(//a[text()='Contact'])[1]")
    public WebElement verifyEnglishLanguage;

    @FindBy(xpath = "//a[text()='Türkçe']")
    public WebElement TürkçeLanguageButton;

    @FindBy(xpath = "//a[text()='İletişim']")
    public WebElement verifyTurkishLanguage;

    @FindBy(xpath = "//a[text()='Français']")
    public WebElement FrançaisLanguageButton;

    @FindBy(xpath = "//a[text()='À propos']")
    public WebElement verifyFrançaisLanguage;

    @FindBy(xpath = "//a[text()='Deutsch']")
    public WebElement DeutschLanguageButton;

    @FindBy(xpath = "//a[text()='Kontakt']")
    public WebElement verifyDeutschLanguage;

    @FindBy(xpath = "//a[text()='Español']")
    public WebElement EspañolLanguageButton;

    @FindBy(xpath = "(//a[text()='Contacto'])[1]")
    public WebElement verifyEspañolLanguage;



    @FindBy(xpath = "//div[@class='user-logo-nav navbar-nav']")
    public WebElement profilButton;


    @FindBy(xpath = "//span[text()='Control Panel']")
    public WebElement controlPannelButton;


}
