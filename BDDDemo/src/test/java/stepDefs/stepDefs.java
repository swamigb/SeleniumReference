package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)
public class stepDefs {

    @Given("^User is on home page$")
    public void user_is_on_home_page() throws Throwable {
        System.out.println("User is on home page");
    }

    @When("^User clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
    	System.out.println("User clicked on login button");
    	// int j = 1/0;
    }

    @Then("^User should see profile screen$")
    public void user_should_see_profile_screen() throws Throwable {
        System.out.println("User saw profile screen");
    }

    @And("^User enters user name and password$")
    public void user_enters_user_name_and_password() throws Throwable {
    	System.out.println("User entered user name and password");
    }

}