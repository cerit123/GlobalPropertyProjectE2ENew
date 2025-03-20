package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//span[text()='Reports']")
    public WebElement reports;


    @FindBy(xpath = "//span[contains(text(), 'ContactMessages')]")
    public WebElement contactMessages;


    @FindBy(xpath = "//span[text()='Tour Requests']")
    public WebElement tourRequests;

    @FindBy(xpath = "//span[normalize-space()='Back to Site']")
    public WebElement backToSite;


    @FindBy(xpath = "//span[contains(text(),'Categories')]")
    public WebElement categoryButton;

    @FindBy(xpath = "//span[contains(text(),'Advert Types')]")
    public WebElement advertTypes;



}
