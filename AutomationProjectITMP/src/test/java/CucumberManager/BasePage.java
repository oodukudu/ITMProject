package CucumberManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCollabToolsUrl() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://test.rcs-ct.com/");
        driver.manage().window().maximize();
    }

    public void closeBroswer() {
        driver.quit();
    }

}
