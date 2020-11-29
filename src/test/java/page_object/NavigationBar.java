package page_object;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By moveToRefinance = By.xpath(" /html/body/section/section[1]//li[2]/a[text()='Refinance']");
    private final By selectRefiCalculator = By.xpath("/html/body/section/section[1]/div//li[1]/a[text()='Refi Calculator']");
    private final By clickLogoHome = By.xpath("//a/img[@alt='Logo']");
    WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }
    public NavigationBar mouseHover() {
        ActOn.element(driver, moveToRefinance).mouseHover();
        return this;
    }

    public Refi_Calculate clickLink() {
        ActOn.element(driver, selectRefiCalculator).click();
        return new Refi_Calculate(driver);
    }
    public Home clickLogo(){
        ActOn.element(driver,clickLogoHome).click();
        return new Home(driver);
    }
}
