package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;

public class LoginFunctionalityDefinitions {

    public LoginPage lp;

    public LoginFunctionalityDefinitions(){
        lp = new LoginPage();
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        Assert.assertTrue(lp.isLoginPage());
    }
    @When("^User enters username as (.+)$")
    public void user_enters_username(String userName) {
        lp.enterUsername(userName);
    }
    @When("^User enters password as (.+)$")
    public void user_enters_password_as_secret_sauce(String password) {
        lp.enterPassword(password);
    }
    @When("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
        lp.clickLogin();
    }
    @Then("^User must be present inside homepage$")
    public void user_must_be_present_inside_homepage() {
        Assert.assertTrue(lp.isHomePage());
    }

    @Then("^User must be present inside login page$")
    public void user_must_be_present_inside_login_page() {
        Assert.assertTrue(lp.isLoginPage());
    }
}
