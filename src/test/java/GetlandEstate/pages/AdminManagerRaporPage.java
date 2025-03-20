package GetlandEstate.pages;

import GetlandEstate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminManagerRaporPage {

    public AdminManagerRaporPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[text()='Raporlar']")
    public WebElement raporlar;

    @FindBy(id = "startDate")
    public WebElement startDate;

    @FindBy(id = "endDate")
    public WebElement endDate;

    @FindBy(id = "category")
    public WebElement category;

    @FindBy(id = "type")
    public WebElement type;

    @FindBy(id = "status")
    public WebElement status;


    @FindBy(xpath = "//input[@type='number']")
    public WebElement populerIlan;

    @FindBy(id = "role")
    public WebElement role;

    @FindBy(xpath = "(//input[@id='startDate'])[2]")
    public WebElement startDateTur;

    @FindBy(xpath = "(//input[@id='endDate'])[2]")
    public WebElement endDateTur;

    @FindBy(xpath = "(//select[@id='status'])[2]")
    public WebElement statusTur;

    //tum raporlama icin bu buton kullanilacak
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[1]")
    public WebElement reportButton1;
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[2]")
    public WebElement reportButton2;
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[3]")
    public WebElement reportButton3;
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[4]")
    public WebElement reportButton4;

    //raporlama yaptiktan sonra bu mesaj gorunur olacak
    @FindBy(xpath = "//div[text()='Full authentication is required to access this resource']")
    public WebElement reportVerfy;


   @FindBy(xpath = "//span[text()='Success']")
   public WebElement raporExcel;
//    @FindBy(xpath = "//div[contains(text(), 'Report successfully')]")
//    public WebElement raporExcel;

    @FindBy(xpath = "//div[text()='There is no data to export to Excel. Data list empty]")
    public WebElement raporExcelEmpyt;

   @FindBy(xpath = "//span[text()='Error']")
   public WebElement dateVerfy;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logout;


}
