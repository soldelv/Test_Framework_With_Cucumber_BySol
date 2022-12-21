package features.stepdefinitions;

import features.pages.HomePage;
import features.utils.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Before
    public void startBrowser(){
        SeleniumDriver.startBrowser();
    }

    @After
    public void closeBrowser(){
        SeleniumDriver.tearDown();
    }

    @Given("Login form in login page")
    public void fill_login_form(){
        SeleniumDriver.openPage("https://opencart.abstracta.us/index.php?");
        HomePage.clickOnLogin();
    }

    @When("Submit email using {string} and password using {string}")
    public void submit_login(String email, String password){
        HomePage.fillLoginForm(email,password);
    }

    @Then("Success login to home page with displaying account button")
    public void checkLoginOK(){
        HomePage.checkLoginPage();
    }

    @Then("Login failed with displaying error message")
    public void checkLoginFail(){
        HomePage.checkLoginFail();
    }

}
