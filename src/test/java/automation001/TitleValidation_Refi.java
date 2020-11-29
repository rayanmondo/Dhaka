package automation001;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TitleValidation_Refi {

    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
            WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
            ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/ ");
    }
    @Test
    public void validateTitle(){
        ActOn.browser(driver).validateTitle("Mortgage Calculator");

    }
    @AfterMethod
    public void closeBrowser(){
        ActOn.browser(driver).closeBrowser();
    }

}
