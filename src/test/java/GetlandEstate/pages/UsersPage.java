package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

    public UsersPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Users']")
    public WebElement users;

    @FindBy(xpath = "(//span[text()='Name'])[1]")
    public WebElement usersPageName;

    @FindBy(xpath = "(//span[text()='Email'])[1]")
    public WebElement usersPageEmail;

    @FindBy(xpath = "(//span[text()='Phone'])[1]")
    public WebElement usersPagePhone;

    @FindBy(xpath = "(//span[text()='Role'])[1]")
    public WebElement usersPageRole;

    @FindBy(xpath = "(//span[text()='Action'])[1]")
    public WebElement usersPageAction;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement actionDelete;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement actionUpdate;

    @FindBy(xpath = "//span[text()='Are you sure you want to delete the user?']")
    public WebElement popupDeleteMessage;

    @FindBy(xpath = "//span[text()='Yes']")
    public WebElement popupDeleteMessageYes;

    @FindBy(xpath = "//span[text()='No']")
    public WebElement popupDeleteMessageNo;

    @FindBy(id = "[id='firstName']")
    public WebElement usersEditFirstName;

    @FindBy(className = "[class='p-toast-message-content']")
    public WebElement errorAlert;

    @FindBy(xpath = "(//option[@value])[1]")
    public WebElement rolesAdmin ;

    @FindBy(xpath = "(//option[@value])[2]")
    public WebElement rolesManager ;

    @FindBy(xpath = "(//option[@value])[3]")
    public WebElement rolesCustomer ;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement updateButton ;

    @FindBy(xpath = "//button[@type='button'][2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@type='button'][1]")
    public WebElement backButton;

    @FindBy(xpath = "(//span[text()='Name'])[2]")
    public WebElement usersName;

    @FindBy(xpath = "//div[@class='p-toast-detail']")
    public WebElement userCanNotUpdate;


    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchTitle;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div[2]/div/div[1]/div/button")
    public WebElement searchButton;

    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div[1]")
    public WebElement basariMesaji;

    @FindBy (xpath = "//tbody//button[2]//*[name()='svg']")
    public WebElement arananKullanıcınınEditi;







}
