package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='(XXX) XXX-XXXX']")
    public WebElement phoneNumber;


    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement email;


    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public WebElement password;


    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    public WebElement confirmPassword;


    @FindBy(xpath = "//input[@id='terms']")
    public WebElement termsCheckBox;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;


    @FindBy(xpath = "//div[@class='p-toast-detail']")
    public WebElement successfullMessage;


}
