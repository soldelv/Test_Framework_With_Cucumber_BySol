package features.utils;

import org.openqa.selenium.WebElement;

public class CommonMethods {

    public static void openPage(){
        SeleniumDriver.openPage("https://opencart.abstracta.us/index.php?");
    }
    public void safeClick(WebElement element){
        SeleniumDriver.waitUntilElementVisible(element);
        element.click();
    }

    public static void checkboxClick(WebElement element){
       if(element.isSelected()){
           System.out.println("Checkbox is already selected");
       }else{
           element.click();
       }
    }

    public static String generateRandomAccount(){
        String randomAccount = "random"+ Math.random() +"@gmail.com";
        System.out.println(randomAccount);
        return randomAccount;
    }

}
