package myOrg.objectStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[contains(text(),'Idly')]")
	WebElement Idly;
	
	@FindBy(linkText="Logout")
	WebElement Logout;
	public WebElement getIdly() {
		return Idly;
	}

	public WebElement getLogout() {
		return Logout;
	}
	
	
}
