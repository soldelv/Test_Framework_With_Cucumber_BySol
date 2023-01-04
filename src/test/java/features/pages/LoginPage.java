package features.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.TestCase.assertNotNull;

public class LoginPage extends HomeBasePage {

    public static void clickOnLogin(){
        clickOnMyAccount();
        WebElement loginButton = driver.findElement(By.xpath("//li//a[contains(text(),'Login')]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public static void fillLoginForm(String email, String password){
        WebElement emailField = driver.findElement(By.id("input-email"));
        WebElement passwordField = driver.findElement(By.id("input-password"));
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        driver.findElement(
                new By.ByXPath("//input[contains(@Class,'btn btn-primary')]")).click();

        System.out.println("Login form filled");
    }

    public static void checkLoginFail(){
        WebElement failMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]"));
        wait.until(ExpectedConditions.visibilityOf(failMessage));
        assertNotNull("User with invalid credentials", failMessage);

        System.out.println("User with invalid credentials - Login failed");
    }
}
