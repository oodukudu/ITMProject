package stepDefinitions;

import CucumberManager.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.DashboardPage;
import pageObject.StudentTeacherRegPage;

public class DashboardStepDefinition {

    public static WebDriver driver;

    public DashboardPage dashboardPage;

    public BasePage basePage;

    public StudentTeacherRegPage studentTeacherRegPage;


    public DashboardStepDefinition() {
        driver = new ChromeDriver();
        dashboardPage = new DashboardPage(driver);
        basePage = new BasePage(driver);
        studentTeacherRegPage = new StudentTeacherRegPage(driver);
    }

    @Given("I am on the home page with login details {string} {string}")
    public void iAmOnTheHomePageWithLoginDetails(String username, String password) {
        basePage.goToCollabToolsUrl();
        dashboardPage.landingPageLoginDetails(username, password);

//        dashboardPage.verifyHomepageWording();
//        Assert.assertEquals("https://test.rcs-ct.com/", driver.getCurrentUrl());
        dashboardPage.homePageIsDisplayed();
    }

    @When("I select the login button")
    public void iSelectTheLoginButton() {
        dashboardPage.clickLoginBtn();
    }

    @And("I provide the credentials {string} {string} {string}")
    public void iProvideTheCredentials(String acctType, String emailAddress, String pwd) {
        dashboardPage.loginPageDetails(acctType, emailAddress, pwd);
    }

    @Then("I am able to access the dashboard")
    public void iAmAbleToAccessTheDashboard() {
        dashboardPage.verifyConnectionsTab();
        basePage.closeBroswer();
    }

    @Then("a warning message pops up")
    public void aWarningMessagePopsUp() {
        Assert.assertTrue(dashboardPage.loginPageWarningMsg.isDisplayed(), "Pop up not displayed/locator used is incorrect");
        basePage.closeBroswer();
    }

}
