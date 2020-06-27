package stepDefs;


import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myOrg.Tarvels.Base;
import myOrg.objectStore.HomePage;
import myOrg.objectStore.LoginPage;

public class StepDefinitions extends Base {

	//public WebDriver driver;
    @Given("^User opens the browser$")
    public void user_opens_the_browser() throws Throwable {
    	driver = initializeDriver();
    }
    
    @When("^User navigates to login page$")
    public void user_navigates_to_login_page() throws Throwable {
    	HomePage homePage = new HomePage(driver);
    	homePage.getMyAccount().click();
    	homePage.getLogin().click();
    }

    @When("^User clicks on \"([^\"]*)\" button$")
    public void user_clicks_on_something_button(String buttonName) throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getButtonElement(buttonName).click();
        
    }

    @And("^User navigates to \"([^\"]*)\"$")
    public void user_navigates_to_something(String strArg1) throws Throwable {
    	System.out.println("2");
    	driver.get(prop.getProperty("url"));
        
    }
    
    @Then("^User lands on profile is \"([^\"]*)\"$")
    public void user_lands_on_profile_is_something(String strArg1) throws Throwable {
    	System.out.println("3");
    	LoginPage loginPage = new LoginPage(driver);
    	if(strArg1.equalsIgnoreCase("Success")) {
    	AssertJUnit.assertEquals(loginPage.getMyProfile().getText().toLowerCase(),"My Profile".toLowerCase());}
    	else if(strArg1.equalsIgnoreCase("Fail")) {
        	AssertJUnit.assertFalse(loginPage.getMyProfile().isDisplayed());

    	}
    }

    @And("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_something_and_something(String userName, String passwd) throws Throwable {
    	System.out.println("1");
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getUserName().sendKeys(userName);
    	loginPage.getPassword().sendKeys(passwd);
    }
    @And("^Close the browser$")
    public void close_the_browser() throws Throwable {
        driver.close();
    }
    

    @And("^User enters (.+) and (.+)$")
    public void user_enters_and(String username, String password) throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getUserName().sendKeys(username);
    	loginPage.getPassword().sendKeys(password);
    }

}
