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

public class LandingPageStepDefinition {

    public static WebDriver driver;

    public BasePage basePage;

    public DashboardPage dashboardPage;

    public LandingPageStepDefinition() {
        driver = new ChromeDriver();
        dashboardPage = new DashboardPage(driver);
        basePage = new BasePage(driver);
    }

    @Given("I nagivate to the collabtool url")
    public void iNagivateToTheCollabtoolUrl() {
        basePage.goToCollabToolsUrl();
    }

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username) {
        dashboardPage.landingpageUsernameField.sendKeys(username);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password) {
        dashboardPage.landingpagePasswordField.sendKeys(password);
    }

    @And("I click the submit button on the landing page")
    public void iClickTheSubmitButtonOnTheLandingPage() {
        dashboardPage.submitBtn.click();
    }

    @Then("a warning message is displayed {string}")
    public void aWarningMessageIsDisplayed(String warningMsg) {
        Assert.assertEquals(warningMsg, dashboardPage.warningMsgPrompt.getText());
        basePage.closeBroswer();
    }
}
