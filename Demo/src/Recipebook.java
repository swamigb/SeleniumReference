import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recipebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello");
		
		// Create an web driver object, in this case for chrome browser
		// webdriver.chrome.driver, webdriver.gecko.driver, webdriver.ie.driver
		// Download browser compatible web driver
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver chromeDriver = new ChromeDriver();
		
		// chromeDriver.get("https://google.com");
		// System.out.println(chromeDriver.getTitle());
		// System.out.println(chromeDriver.getWindowHandle());
		chromeDriver.get("https://facebook.com");
		chromeDriver.findElement(By.id("email")).sendKeys("myusername");
		chromeDriver.findElement(By.name("pass")).sendKeys("mypassword");
		chromeDriver.findElement(By.linkText("Forgot account?")).click();


		
		// chromeDriver.navigate().refresh();
		// chromeDriver.navigate().back();
		// chromeDriver.close();// closes current window
		// chromeDriver.quit(); // closes all windows
		
		
	}

}
