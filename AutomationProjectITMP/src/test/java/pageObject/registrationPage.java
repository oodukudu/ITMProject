package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registrationPage{

    public WebDriver driver;

    public registrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement nameField;

    public void enterFullName() {
        nameField.sendKeys("Oyin O");
    }

    @FindBy(xpath = "//input[@id='inputEmail4']")
    public WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='inputPassword4']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyNameField;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countryDropdownList;

    @FindBy(xpath = "//p[@class='success-msg hidden']")
    private WebElement expectedMsg;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitBtn;

    @FindBy(id = "websitename")
    private WebElement url;

    @FindBy(id = "inputCity")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='inputZip']")
    private WebElement zipcodeField;

    @FindBy(xpath = "//input[@id='inputState']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@id='inputAddress1']")
    private WebElement lineOfAddress1;

    @FindBy(xpath = "//input[@id='inputAddress2']")
    private WebElement lineOfAddress2;

    public void enterEmail() {
        emailAddressField.sendKeys("oyinodukudu@gmail.com");
    }

    public void enterPassword() {
        passwordField.sendKeys("hahdgdhiwolqk_208gdh");
    }

    public void enterCompanyName() {
        companyNameField.sendKeys("ITMP");
    }

    public void clickSubmitButton() {
        submitBtn.click();
    }

    public void selectCountry() {
        new Select(countryDropdownList).selectByVisibleText("United Kingdom");
    }

    public String verifyFormSubmission() {
        return expectedMsg.getText();
    }

    public void enterFirstName(String name) {
        nameField.sendKeys(name);
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
    }

    public void enterPassword(String validPassword) {
        passwordField.sendKeys(validPassword);
    }

    public void enterWebsiteURL(String websiteUrl) {
        url.sendKeys(websiteUrl);
    }

    public void enterCity(String cityName) {
        cityField.sendKeys(cityName);
    }

    public void enterZipcode(String zipcodeValue) {
        zipcodeField.sendKeys(zipcodeValue);
    }

    public void omitNameField() {
        nameField.sendKeys("");
    }

    public void enterStateField() {
        stateField.sendKeys("Wales");
    }

    public void enterAddressLine1() {
        lineOfAddress1.sendKeys("Wales");
    }

    public void enterAddressLine2() {
        lineOfAddress2.sendKeys("United Kingdom");
    }

}
