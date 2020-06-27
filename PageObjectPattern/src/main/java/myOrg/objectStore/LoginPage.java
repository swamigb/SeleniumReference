package myOrg.objectStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By UserId = By.id("email");
	By Passwd = By.xpath("//input[@id='passwd']");
	By SwitchTo = By.xpath("//button[@class='btn btn-default']");
	By Submit = By.xpath("//span[@class='glyphicon glyphicon-lock']");

	public WebElement getUserId() {
		return this.driver.findElement(UserId);
	}
	public WebElement getPasswd() {
		return this.driver.findElement(Passwd);
	}
	public WebElement getSwitchTo() {
		return this.driver.findElement(SwitchTo);
	}
	public WebElement getSubmit() {
		return this.driver.findElement(Submit);
	}
	

}
