package stepDefinitions;

import CucumberManager.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DashboardPage;
import pageObject.StudentTeacherRegPage;

import javax.inject.Inject;
import java.util.ArrayList;

public class StudentTeacherRegStepDefinition {

    public static WebDriver driver;

    public StudentTeacherRegPage studentTeacherRegPage;

    public DashboardPage dashboardPage;

    public BasePage basePage;

    public StudentTeacherRegStepDefinition() {
        driver = new ChromeDriver();
        studentTeacherRegPage = new StudentTeacherRegPage(driver);
        basePage = new BasePage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @And("I click on the student teacher registration button")
    public void iClickOnTheStudentTeacherRegistrationButton() {
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(0));
        studentTeacherRegPage.selectStudentTeacherRegBtn();
    }

    @And("I select account type as {string}")
    public void iSelectAccountTypeAs(String acctType) {
        studentTeacherRegPage.selectAccountType(acctType);
    }

    @And("I fill in first name as {string} and last name as {string}")
    public void iFillInFirstNameAsAndLastNameAs(String firstName, String lastName) {
        studentTeacherRegPage.enterFirstName(firstName);
        studentTeacherRegPage.enterLastName(lastName);
    }

    @And("I enter date of birth as {string}")
    public void iEnterDateOfBirthAs(String dob) {
        studentTeacherRegPage.enterDOB(dob);
    }

    @And("I select gender as {string}")
    public void iSelectGenderAs(String gender) {
        studentTeacherRegPage.selectGender(gender);
    }

    @And("I enter uni email address {string}")
    public void iEnterUniEmailAddress(String emailAddress) {
        studentTeacherRegPage.enterEmailAddress(emailAddress);
    }

    @And("I enter password as {string} and confirm password as {string}")
    public void iEnterPasswordAsAndConfirmPasswordAs(String password, String confirmPassword) {
        studentTeacherRegPage.enterPassword(password);
        studentTeacherRegPage.enterConfirmPassword(confirmPassword);
    }

    @And("I enter mobile number {string}")
    public void iEnterMobileNumber(String number) {
        studentTeacherRegPage.enterTelephoneNumber(number);
    }

    @And("I click on the next button")
    public void iClickOnTheNextButton() {
        studentTeacherRegPage.clickNextBtn();
    }

    @Given("I am on the home page with login details username {string} password {string}")
    public void iAmOnTheHomePageWithLoginDetailsUsernamePassword(String username, String password) {
        basePage.goToCollabToolsUrl();
        dashboardPage.landingPageLoginDetails(username, password);
    }

    @And("I fill out my academia details with {string} {string} {string} {string} {string}")
    public void iFillOutMyAcademiaDetailsWith(String academicLevel, String courseLength, String academicYear, String startDate, String grade) {
        studentTeacherRegPage.selectCourse();
        studentTeacherRegPage.selectAcademicLevel(academicLevel);
        studentTeacherRegPage.selectCourseLength(courseLength);
        studentTeacherRegPage.selectAcademicYear(academicYear);
        studentTeacherRegPage.enterCourseStartDate(startDate);
        studentTeacherRegPage.selectGrade(grade);
    }

    @And("I fill out other information section with industrial sector as {string} {string}")
    public void iFillOutOtherInformationSectionWithIndustrialSectorAs(String sector1, String sector2) {
        studentTeacherRegPage.enterSkills();
       // studentTeacherRegPage.selectIndustrialSector(sector1, sector2);
        studentTeacherRegPage.clickOptionalInfoBtn();
        studentTeacherRegPage.uploadFile();
    }
}
