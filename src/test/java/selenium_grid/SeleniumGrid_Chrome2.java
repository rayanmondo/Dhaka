package selenium_grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

public class SeleniumGrid_Chrome2 {
    WebDriver driver;

    @Test
    public void RunInChrome1() {
        WebDriverManager.chromedriver().setup();
        driver = TestEnvironment.selectTestEnvironment();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
