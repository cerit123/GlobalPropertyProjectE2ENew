package GetlandEstate.pages;


import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
    //public WebElement changeButton;
    //public WebElement yesButton;

    //public WebElement changePasswordSuccessfullMessage;
    public WebElement profilePhotoSuccessfullMessage;
    public WebElement deleteAccountSuccessfullMessage;

    public MyProfilePage() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "(//img[@src='/images/profile/user.jpg'])[1]")
    public WebElement myProfileButton;

    @FindBy(xpath = "//span[normalize-space()='My Profile']")
    public WebElement myProfileSekmesi;
    

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='(XXX) XXX-XXXX']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement email;

    @FindBy(xpath = "//button[normalize-space()='UPDATE']")
    public WebElement updateButton;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M 22.1875 ')]")
    public WebElement changePassword;

    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    public WebElement currentPassword;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//p[normalize-space()='Change Password']")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//button[normalize-space()='CHANGE']")
    public WebElement changeButton;

    @FindBy(xpath = "//p[normalize-space()='Profile Photo']")
    public WebElement profilePhoto;

    @FindBy(xpath = "//button[normalize-space()='SELECT']")
    public WebElement selectButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileUploadInput;  // Actual file input field

    @FindBy(xpath = "//button[normalize-space()='DONE']")
    public WebElement doneButton;

    @FindBy(xpath = "//button[normalize-space()='SAVE']")
    public WebElement saveButton; // Save button after uploading

    @FindBy(xpath = "//div[@class='p-toast-message-text']")
    public WebElement profileUpdatesuccessfullMessage;

    @FindBy(xpath = "//span[@class='p-toast-summary']")
    public WebElement profilePhotoUpdatedSuccessfullMessage;

    @FindBy(xpath = "//p[normalize-space()='Delete Account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//span[normalize-space()='Yes']")
    public WebElement yesButton;

    @FindBy(xpath = "//div[@class='p-toast-detail']")
    public WebElement accountDeleteSuccessfullMessage;











    }






