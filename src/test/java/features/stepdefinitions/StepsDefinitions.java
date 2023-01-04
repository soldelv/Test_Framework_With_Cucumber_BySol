package features.stepdefinitions;

import features.pages.LoginPage;
import features.pages.RegisterPage;
import features.utils.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import features.utils.CommonMethods;

public class StepsDefinitions {

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
        CommonMethods.openPage();
        LoginPage.clickOnLogin();
    }

    @When("Submit email using {string} and password using {string}")
    public void submit_login(String email, String password){
        LoginPage.fillLoginForm(email,password);
    }

    @Then("Success login to home page with displaying account button")
    public void checkLoginOK(){
        LoginPage.logoutFromPage();
    }

    @Then("Login failed with displaying error message")
    public void checkLoginFail(){
        LoginPage.checkLoginFail();
    }

    @Given("Register form after login page")
    public void fill_register_page(){
        CommonMethods.openPage();
        RegisterPage.clickOnRegister();
    }

    @When("The form is completed using email {string} and password {string}")
    public void complete_register_form(String email, String password){
        RegisterPage.fillRegisterForm(email,password);
    }

    @Then("Success register for user")
    public void checkRegisterOK(){
        RegisterPage.checkRegisterOK();
    }

    @Then("Deletion of account recently registered")
    public void cleanRecentRegistration(){
        RegisterPage.cleanAccount();
    }

}
