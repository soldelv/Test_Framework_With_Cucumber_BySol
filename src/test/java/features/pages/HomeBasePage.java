package features.pages;

import features.utils.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertNotNull;

public class HomeBasePage {

    public final static WebDriver driver = SeleniumDriver.getDriver();
    public final static WebDriverWait wait = SeleniumDriver.waitDriver();

    public static void clickOnMyAccount(){
        WebElement myAccountButton = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
    }

    public static void logoutFromPage(){
        clickOnMyAccount();
        WebElement logoutButton = driver.findElement(By.xpath("//li//a[contains(text(),'Logout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        assertNotNull("Logged out correctly", logoutButton);
        logoutButton.click();

        System.out.println("User logged out correctly");
    }
}

