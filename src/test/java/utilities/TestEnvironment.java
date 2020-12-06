package utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TestEnvironment {
      static WebDriver driver;
      static URL gridUrl ;
    private static final Logger LOGGER  = LogManager.getLogger(TestEnvironment.class);

    public static WebDriver selectTestEnvironment() {
//        String environment = System.getProperty("environment");
//        String browser = System.getProperty("browser");
        String environment = System.getProperty("environment")==null? "local":System.getProperty("environment");
        String browser = System.getProperty("browser")==null? "chrome":System.getProperty("browser");
        try {
            gridUrl = new URL("http://localhost:4444/wd/hub");
        } catch (Exception e) {
            LOGGER.error("Selenium Grid URL exception is :"+ e.getMessage());
        }

        if (environment.equals("remote") && browser.equals("chrome")){
            LOGGER.info("Chrome Browser");
            ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(gridUrl, chromeOptions);
        }else if (environment.equals("remote") && browser.equals("firefox")){
            LOGGER.info("firefox Browser");
            FirefoxOptions firefoxOptions= new FirefoxOptions();
            driver = new RemoteWebDriver(gridUrl, firefoxOptions);
        }else if (environment.equals("local") && browser.equals("chrome")){
            LOGGER.info("execute test in local");
            driver = new ChromeDriver();
        }
        return driver;
    }
}

