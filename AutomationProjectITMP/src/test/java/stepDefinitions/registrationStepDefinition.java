package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.registrationPage;

public class registrationStepDefinition {

    public static WebDriver driver;
    public registrationPage registrationPage;

    public registrationStepDefinition() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registrationPage = new registrationPage(driver);
    }

    @Given("I navigate to the form demo website")
    public void i_navigate_to_the_form_demo_website() {
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.manage().window().maximize();
    }

    @When("I enter my name")
    public void i_enter_my_name() {
        registrationPage.enterFullName();
    }
    @When("I enter a valid email address")
    public void i_enter_a_valid_email_address() {
        registrationPage.enterEmail();
    }
    @When("I enter a valid password")
    public void i_enter_a_valid_password() {
        registrationPage.enterPassword();
    }
    @When("I enter my company name")
    public void i_enter_my_company_name() {
//        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("ITMP");
        registrationPage.enterCompanyName();
    }
    @When("I enter my website url")
    public void i_enter_my_website_url() {
//        driver.findElement(By.id("websitename")).sendKeys("https://www.linkedin.com/in/oluwaseun-odukuduoy/");
        registrationPage.enterWebsiteURL("https://www.linkedin.com/in/oluwaseun-odukuduoy/");
    }

    @When("I select country from the dropdown list")
    public void i_select_country_from_the_dropdown_list() {
//        new Select(driver.findElement(By.xpath("//select[@name='country']"))).selectByVisibleText("United Kingdom");
        registrationPage.selectCountry();
    }
    @When("I enter my city")
    public void i_enter_my_city() {
//        driver.findElement(By.id("inputCity")).sendKeys("Wales");
        registrationPage.enterCity("Wales");
    }

    @When("I enter my address")
    public void i_enter_my_address() {
//        driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("Wales");
        registrationPage.enterAddressLine1();
    }

    @When("I enter the second line of my address")
    public void i_enter_the_second_line_of_my_address() {
//        driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("United Kingdom");
        registrationPage.enterAddressLine2();
    }
    @When("I enter my state")
    public void i_enter_my_state() {
//        driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Wales");
        registrationPage.enterStateField();
    }

    @When("I enter my zip code")
    public void i_enter_my_zip_code() {
//        driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("G72 5GH");
        registrationPage.enterZipcode("G72 5GH");
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
       // driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
        registrationPage.clickSubmitButton();
    }

    @Then("the form is submitted successfully")
    public void the_form_is_submitted_successfully() {
//        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='success-msg hidden']")).isDisplayed());

        String actualMsg = "Thanks for contacting us, we will get back to you shortly.";

//        String expectedMsg = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();

        Assert.assertEquals(actualMsg, registrationPage.verifyFormSubmission());

        driver.quit();

        // driver.close();
    }

    @When("I enter my name {string}")
    public void iEnterMyName(String name) {
        registrationPage.enterFirstName(name);
    }

    @And("I enter an email address {string}")
    public void iEnterAnEmailAddress(String email) {
        registrationPage.enterEmailAddress(email);
    }

    @And("I enter a valid password {string}")
    public void iEnterAValidPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @And("I enter my website url {string}")
    public void iEnterMyWebsiteUrl(String url) {
        registrationPage.enterWebsiteURL(url);
    }

    @And("I enter my city {string}")
    public void iEnterMyCity(String city) {
        registrationPage.enterCity(city);
    }

    @And("I enter my zip code {string}")
    public void iEnterMyZipCode(String zipcode) {
        registrationPage.enterZipcode(zipcode);
    }

    @When("I omit my name")
    public void iOmitMyName() {
        registrationPage.omitNameField();
    }

    @Then("a warning prompt is displayed")
    public void aWarningPromptIsDisplayed() {
    }
}







//    -ea -Dcucumber.filter.tags="@regression"
