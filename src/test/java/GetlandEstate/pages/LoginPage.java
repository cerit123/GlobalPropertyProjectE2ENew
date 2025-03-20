package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement mailButton;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordButton;


    @FindBy(xpath = "//div[@class='form-submit-button']")
    public WebElement login;

    @FindBy(xpath = " //div[contains(text(),'Invalid email')]")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "//div[contains(text(),'Password is required')]")
    public WebElement passwordRequiredMessage;


}
