package automation001.dataDrivenParameter;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.Refi_Calculate;
import utilities.ConfigFilesRead;
import utilities.SqlConnector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class RefiCalculatorParameter {
//    private final By moveToRefinance = By.xpath(" /html/body/section/section[1]//li[2]/a[text()='Refinance']");
//    private final By selectRefiCalculator = By.xpath("/html/body/section/section[1]/div//li[1]/a[text()='Refi Calculator']");
//    private final By setHomeValue = By.id("HomeValue");
//    private final By setDownPayment  = By.id("Down");
//    private final By loanTerm  = By.name("Length");
//    private final By interestRate  = By.name("Interest3");
//    private final By calculateButton =By.name("calculate");
//    private final By monthlyPayment = By.xpath("//*[@id='analysisDiv']/table[3]//td[2][text()='$2,513.74']");
private static  final Logger LOGGER = LogManager.getLogger(RefiCalculatorParameter.class);

    WebDriver driver;
   @BeforeMethod
    public void openBrowser()throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ConfigFilesRead readConfigFiles=new ConfigFilesRead();
        Properties prop= readConfigFiles.getPropertyValue();
        String url= prop.getProperty("URL");

        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/ ");
        LOGGER.info("THIS IS NOT THE REAL URL");

    }
    @Test
    public void dataEnterRefinance() {
        ResultSet resultSet= SqlConnector.readData("select * from refi_calc");
        try {
            while (resultSet.next()) {
                new Refi_Calculate(driver)
                        .mouseHover()
                        .clickLink()
                        .homeValue(resultSet.getString("homevalue"))
                        .downPayment(resultSet.getString("downpayment"))
                        .loanLenght(resultSet.getString("loanterm"))
                        .interestValue(resultSet.getString("interestrate"))
                        .enterCalculateButton()
                        .priceVal(resultSet.getString("totalmonthlypayment"));
                       // .clickLogo();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(moveToRefinance)).perform();
//        ActOn.element(driver,selectRefiCalculator).click();
//        ActOn.element(driver,setHomeValue).setValue("500000");
//        ActOn.element(driver,setDownPayment).setValue("70000");
//        ActOn.element(driver,loanTerm).setValue("25");
//        ActOn.element(driver,interestRate).setValue("5");
//        ActOn.element(driver,calculateButton).click();
//        AssertThat.elementAssertions(driver,monthlyPayment).elementExist();
//
  }
            }catch(SQLException e){
                LOGGER.error(e.getMessage());
            }
        }

    @AfterMethod
    public void closeBrowser(){
        ActOn.browser(driver).closeBrowser();

    }

}
