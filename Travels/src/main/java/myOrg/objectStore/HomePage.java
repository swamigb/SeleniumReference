package myOrg.objectStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@class,'login')]")
	WebElement MyAccount;
	
	@FindBy(css="a[href*='login']")
	WebElement Login;
	
	public WebElement getLogin() {
		return Login;
	}
	public WebElement getMyAccount() {
		return MyAccount;
	}
	
	

}
