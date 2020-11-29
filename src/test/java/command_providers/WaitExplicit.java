package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WaitExplicit {
    public static Waitfor waitfor(WebDriver driver, By locator){
        return new Waitfor(driver,locator);
    }
}
