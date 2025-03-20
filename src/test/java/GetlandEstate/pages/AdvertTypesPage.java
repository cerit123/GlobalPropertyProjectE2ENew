package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvertTypesPage {

    public  AdvertTypesPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//button[@title='Add New']")
    public WebElement AddNewButton;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement entertitle;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


    @FindBy(xpath = "//*[@id='root']/div[2]/div/div/div/div[1]/span")
    public WebElement successfulMessage;




}
