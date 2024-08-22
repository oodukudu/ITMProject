package pageObject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StudentTeacherRegPage {

    public WebDriver driver;

    public StudentTeacherRegPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Student/Teacher']")
    private WebElement studentTeacherRegBtn;

    @FindBy(xpath = "//select[@id='account_type']")
    private WebElement accountType;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='date-of-birth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//select[@id='gender']")
    private WebElement genderDropdown;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='confirm-password']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement telephoneNumberField;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    private WebElement nextBtn;

    @FindBy(xpath = "//input[@placeholder='Subject/Course']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[normalize-space()='Aeronautical Engineering']")
    private WebElement subjectFieldValue;

    @FindBy(xpath = "//select[@id='level']")
    private WebElement academicLevelDropdown;

    @FindBy(xpath = "//select[@id='length_of_course']")
    private WebElement courseLengthDropdown;

    @FindBy(xpath = "//select[@id='academic_year']")
    private WebElement academicYearDropdown;

    @FindBy(xpath = "//input[@id='course-start-date']")
    private WebElement courseStartDateField;

    @FindBy(xpath = "//select[@id='grade']")
    private WebElement gradeDropdown;

    @FindBy(xpath = "//input[@id='skillsOfInterest']")
    private WebElement skillsOfInterestField;

    @FindBy(xpath = "//label[normalize-space()='Select Industrial Sector']")
    private WebElement industrialSectorDropdown;

    @FindBy(xpath = "//a[normalize-space()='Profile Information (optional)']")
    private WebElement optionalInfoBtn;


    public void selectStudentTeacherRegBtn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        studentTeacherRegBtn.click();
    }

    public void selectAccountType(String acctType) {
        new Select(accountType).selectByVisibleText(acctType);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterDOB(String dob) {
        dateOfBirth.sendKeys(dob);
    }

    public void selectGender(String gender) {
        new Select(genderDropdown).selectByVisibleText(gender);
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
    }

    public void enterPassword(String dob) {
        passwordField.sendKeys(dob);
    }

    public void enterConfirmPassword(String dob) {
        confirmPasswordField.sendKeys(dob);
    }

    public void enterTelephoneNumber(String dob) {
        telephoneNumberField.sendKeys(dob);
    }

    public void clickNextBtn() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", nextBtn);
    }

    public void selectCourse() {
        subjectField.sendKeys("Aero");
        subjectFieldValue.click();
    }

    public void selectAcademicLevel(String academicLevel) {
        new Select(academicLevelDropdown).selectByVisibleText(academicLevel);
    }

    public void selectCourseLength(String courseLength) {
        new Select(courseLengthDropdown).selectByVisibleText(courseLength);
    }

    public void selectAcademicYear(String academicYear) {
        new Select(academicYearDropdown).selectByVisibleText(academicYear);
    }

    public void enterCourseStartDate(String courseStartDate) {
        courseStartDateField.sendKeys(courseStartDate);
    }

    public void selectGrade(String grade) {
        new Select(gradeDropdown).selectByVisibleText(grade);
    }

    public void enterSkills() {
        skillsOfInterestField.sendKeys("Maths");
        skillsOfInterestField.sendKeys(Keys.ENTER);

        skillsOfInterestField.sendKeys("Science");
        skillsOfInterestField.sendKeys(Keys.ENTER);
    }

    public void selectIndustrialSector(String sector1, String sector2) {
        industrialSectorDropdown.click();

        WebElement selectedSector1 = driver.findElement(By.xpath("//label[normalize-space()='" + sector1 + "']"));
        selectedSector1.click();

        WebElement selectedSector2 = driver.findElement(By.xpath("//label[normalize-space()='" + sector2 + "']"));
        selectedSector2.click();

//        WebElement sectorDropdown = driver.findElement(By.xpath("//label[contains(text(),'" + sector1 + ", " + sector2 + "')]"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementByXpath('elementID').setAttribute('value', 'new value for element')");
//        sectorDropdown.sendKeys(Keys.ESCAPE);
    }

    public void  clickOptionalInfoBtn() {
        optionalInfoBtn.click();
    }

    public void uploadFile() {
        WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", addFile);

        String filePath = StringUtils.substring(System.getProperty("user.dir"), 0, 70);
        System.out.println(filePath);
        String filePath2 = StringUtils.substring(System.getProperty("user.dir"), 0, 18);
        System.out.println("Absolute path is " + filePath2 + "/Downloads/Profile Picture.jpeg");
        addFile.sendKeys(filePath2 + "/Downloads/Profile Picture.jpeg");
    }

}
