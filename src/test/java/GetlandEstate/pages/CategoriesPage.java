package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {

    public CategoriesPage (){
        PageFactory.initElements(Driver.getDriver(), this);}



    @FindBy(xpath = "//button[@title='Add New']")
    public WebElement addNewButton;

    @FindBy(xpath = "//input[@name='search']")
    public WebElement categorySearchBox;

    @FindBy(xpath = "//button[@type='button' and contains(@class, 'search-button')]")
    public WebElement categorySearchButton;


    @FindBy(xpath = "//input[@id='title']")
    public WebElement addNewCategoryTitle;

    @FindBy(xpath = "//input[@id='seq']")
    public WebElement addNewCategoryNo;


    @FindBy(xpath = "//input[@id='icon']")
    public WebElement addNewIconName;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addNewSubmitButton;

    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div[1]/span")
    public WebElement categorySuccesfulyMesage;

    @FindBy (xpath = "//tbody//button[2]")
    public WebElement categorySearchEdit;


    }




