import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateCleatrip {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);
		String url = "https://www.cleartrip.com/";
		// System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.178.51:4444/wd/hub"), dc);
		// WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement fromTag = driver.findElement(By.id("FromTag"));
		fromTag.sendKeys("Hyderabad");
		Thread.sleep(2000L);
		fromTag.sendKeys(Keys.ENTER);
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Select adults = new Select(driver.findElement(By.id("Adults")));
		adults.selectByValue("3");
		driver.findElement(By.id("MoreOptionsLink")).click();
		Select airlineClass = new Select(driver.findElement(By.id("Class")));
		airlineClass.selectByVisibleText("Business");
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		

		

	}

}
