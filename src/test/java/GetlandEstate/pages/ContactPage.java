package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {


    public ContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "firstName")
    public WebElement firstNameBox;

   @FindBy(id = "lastName")
    public WebElement LastNameBox;

   @FindBy(css = "input[id='email']")
    public WebElement eMailBox;

   @FindBy(css = "textarea[id='message']")
    public WebElement massageBox;

  @FindBy(css = "button[type='submit']")
    public WebElement sendButton;

  @FindBy(xpath = "//div[text()='Contact message saved successfully.']")
    public WebElement successMassage;


}
