package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePropertyPage {

    public CreatePropertyPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

//Homepage create property button
@FindBy(xpath = "//span[@class='d-none d-lg-block']")
public WebElement createProperty;

//Common Information-------------------------------------------------------
    @FindBy(xpath ="//input[@id='title']" )
    public WebElement title;

    @FindBy(xpath = "//textarea[@id='desc']")
    public WebElement description;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement price;

    @FindBy(xpath = "//select[@id='advertTypeId']")
    public WebElement advertType;

    @FindBy(xpath = "//select[@id='categoryId']")
    public WebElement categoryId;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement address;


    //Address Information-------------------------------------------------------
    @FindBy(xpath = "//select[@id='countryId']")
    public WebElement countryId;

    @FindBy(xpath = "//select[@id='cityId']")
    public WebElement cityId;

    @FindBy(xpath = "//select[@id='districtId']")
    public WebElement districtId;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement addressInfo;

//Properties Information-------------------------------------------------------

    @FindBy(xpath = "//input[@id='Size']")
    public WebElement size;

    @FindBy(xpath = "//input[@id='Bedrooms']")
    public WebElement bedrooms;

    @FindBy(xpath = "//input[@id='Bathrooms']")
    public WebElement bathrooms;

    @FindBy(xpath = "//select[@id='Garage']")
    public WebElement garage;

    @FindBy(xpath = "//input[@id='Balcony']")
    public WebElement balcony;

    @FindBy(xpath = "//input[@id='Land Area']")
    public WebElement landArea;

    @FindBy(xpath = "//input[@id='Swimming Pool']")
    public WebElement swimmingPool;

    @FindBy(xpath = "//input[@id='View']")
    public WebElement view;

    @FindBy(xpath = "//input[@id='Year of Build']")
    public WebElement yearOfBuild;

    @FindBy(xpath = "//select[@id='Furniture']")
    public WebElement furniture;

    @FindBy(xpath = "//input[@id='Maintenance Fee']")
    public WebElement maintenanceFee;

    @FindBy(xpath = "//input[@id='Elevator']")
    public WebElement elevator;

    @FindBy(xpath = "//select[@id='Terrace']")
    public WebElement terrace;

    @FindBy(xpath = "//select[@id='Flat']")
    public WebElement flat;

    @FindBy(xpath = "//select[@id='GARDEN']")
    public WebElement garden;

    @FindBy(xpath = "//select[@id='FLOWER GARDEN']")
    public WebElement flowerGarden;

    @FindBy(xpath = "//select[@id='Central AC']")
    public WebElement centralAC;

    @FindBy(xpath = "//select[@id='Central heating']")
    public WebElement centralHeating;

    @FindBy(xpath = "//select[@id='Parking Space']")
    public WebElement parkingSpace;

    @FindBy(xpath = "//select[@id='Flatt']")
    public WebElement flatt;

    @FindBy(xpath = "//select[@id='Flattisa']")
    public WebElement flattisa;


    @FindBy(xpath = "//select[@id='Flat1']")
    public WebElement flat1;

    @FindBy(xpath = "//input[@id='Flat2']")
    public WebElement flat2;

    @FindBy(xpath = "//input[@id='Flat3']")
    public WebElement flat3;

    @FindBy(xpath = "//select[@id='Flat4']")
    public WebElement flat4;

    @FindBy(xpath = "//select[@id='Flat5']")
    public WebElement flat5;
    @FindBy(xpath = "//select[@id='Flat6']")
    public WebElement flat6;

    @FindBy(xpath = "//select[@id='Flat7']")
    public WebElement flat7;

    @FindBy(xpath = "//div[@class='upload-area']")
    public WebElement uploadArea;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createButton;

@FindBy(xpath = "//div[@class='formik-feedback invalid-feedback' and text()='Enter a title']")
public WebElement titleErrorMessage;

@FindBy(xpath = "//div[@class='formik-feedback invalid-feedback' and text()='Enter a description']")
    public WebElement descriptionErrorMessage;

@FindBy(xpath = "//div[normalize-space()='newAdvertPageTranslations.requiredAddress']")
    public WebElement addressErrorMessage;

@FindBy(xpath = "//div[@class='image-feedback']")
    public WebElement imageErrorMessage;

@FindBy(xpath = "//div[@class='image-feedback']")
    public WebElement moreThan3MBErrorMessage;











}
