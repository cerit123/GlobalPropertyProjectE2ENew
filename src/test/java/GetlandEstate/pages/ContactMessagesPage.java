package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactMessagesPage {

    public ContactMessagesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@class='filter-button btn btn-primary']")
    public WebElement filterButton;

    @FindBy(xpath = "//button[@class='search-button btn btn-primary']")
    public WebElement searchButton;

    @FindBy(xpath = "(//button[contains(@class, 'accordion-button')])[1]")
    public WebElement message;

    @FindBy(xpath = "(//button[@title='Delete message'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "(//button[@title='Mark as read'])[1]")
    public WebElement markReadButton;

    @FindBy(xpath = "(//button[@title='Mark as unread'])[1]")
    public WebElement markUnReadButton;

    @FindBy(id = "startDate")
    public WebElement dropdownStartDate;

    @FindBy(id = "endDate")
    public WebElement dropdownEndDate;

    @FindBy(xpath = "//button[@title='Apply Filters']")
    public WebElement applyFiltersButton;










}
