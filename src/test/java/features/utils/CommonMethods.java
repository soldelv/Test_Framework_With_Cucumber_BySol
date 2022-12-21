package features.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonMethods {

    public void safeClick(WebElement element){
        SeleniumDriver.waitUntilElementVisible(element);
        element.click();
    }

}
