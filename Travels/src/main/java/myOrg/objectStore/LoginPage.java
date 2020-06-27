package myOrg.objectStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement UserName;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement MyProfile;

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getButtonElement(String buttonName) {

		switch (buttonName) {

		case "Login":
			return Login;

		default:
			return null;
		}

	}

	public WebElement getMyProfile() {
		return MyProfile;
	}

}
