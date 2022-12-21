package features.pages;

import features.utils.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertNotNull;

public class HomePage {

    private static WebDriver driver = SeleniumDriver.getDriver();
    private static WebDriverWait wait = SeleniumDriver.waitDriver();

    public static void clickOnMyAccount(){
        WebElement myAccountButton = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
    }

    public static void clickOnRegister(){
        WebElement myAccountButton = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        WebElement registerButton = driver.findElement(By.xpath("//li//a[contains(text(),'Register')]"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }

    public static void clickOnLogin(){
        WebElement myAccountButton = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
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

    public static void checkLoginPage(){
        WebElement myAccountButton = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        WebElement logoutButton = driver.findElement(By.xpath("//li//a[contains(text(),'Logout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        assertNotNull("Logged correctly", logoutButton);
        logoutButton.click();

        System.out.println("User logged correctly");
    }

    public static void checkLoginFail(){
        WebElement failMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]"));
        wait.until(ExpectedConditions.visibilityOf(failMessage));
        assertNotNull("User with invalid credentials", failMessage);

        System.out.println("User with invalid credentials - Login failed");
    }
}

