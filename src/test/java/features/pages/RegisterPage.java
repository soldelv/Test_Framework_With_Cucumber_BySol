package features.pages;

import features.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class RegisterPage extends HomeBasePage {
    public static void clickOnRegister(){
        clickOnMyAccount();
        WebElement registerButton = driver.findElement(By.xpath("//li//a[contains(text(),'Register')]"));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }

    public static void fillRegisterForm(String email, String password){
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Namefortest");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Surnamefortest");

        WebElement newUserEmail = driver.findElement(By.id("input-email"));
        newUserEmail.sendKeys(email);

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("22224444");

        WebElement newPassword = driver.findElement(By.id("input-password"));
        newPassword.sendKeys(password);

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys(password);

        WebElement subscribe = driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value=1]"));//yes
        CommonMethods.checkboxClick(subscribe);
        WebElement agree = driver.findElement(By.xpath("//div[@class='pull-right']//input[@value=1]"));
        CommonMethods.checkboxClick(agree);
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        System.out.println("Register form filled");
    }

    public static void checkRegisterOK(){
        try{
            WebElement congratsMessage = driver.findElement(By.xpath("//p[contains(.,'Congratulations')]"));
            wait.until(ExpectedConditions.visibilityOf(congratsMessage));
            assertNotNull("Registered correctly", congratsMessage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("User registered correctly");

        WebElement continueButton = driver.findElement(By.xpath("//div[@class='pull-right']"));
        continueButton.click();
    }

    public static void cleanAccount(){
        WebElement editButton = driver.findElement(By.xpath("//a[contains(.,'Edit Account')]"));
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        WebElement userEmail = driver.findElement(By.id("input-email"));
        userEmail.clear();
        userEmail.sendKeys(CommonMethods.generateRandomAccount());
        WebElement continueButton = driver.findElement(By.xpath("//div[@class='pull-right']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        System.out.println(successMessage.getText());
        assertEquals("Success: Your account has been successfully updated.",successMessage.getText());
        logoutFromPage();
    }
}
