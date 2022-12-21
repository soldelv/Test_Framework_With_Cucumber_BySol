package features.utils;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    private SeleniumDriver(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver,TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void startBrowser(){
        setUpDriver();
    }

    public static void openPage(String url){
        setUpDriver();
        driver.get(url);
        //driver.get(PropertiesConfiguration.getInclude());
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setUpDriver(){
        if(seleniumDriver== null){
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void tearDown(){
        driver.close();
        driver.quit();

        seleniumDriver = null;
    }

    /** Functions for elements **/

    public static WebDriverWait waitDriver(){
        return waitDriver;
    }
    public static void waitUntilElementVisible(WebElement element){
        waitDriver.until(ExpectedConditions.visibilityOf(element));
    }
}
