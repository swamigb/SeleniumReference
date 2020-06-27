import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement subDriver = driver.findElement(By.id("gf-BIG"));
	
		for(int i=0;i<subDriver.findElements(By.tagName("a")).size();i++) {
			
			String clickCombi = Keys.chord(Keys.CONTROL, Keys.ENTER);
			subDriver.findElements(By.tagName("a")).get(i).sendKeys(clickCombi);
		}
		Set<String> wdhndls = driver.getWindowHandles();
		Iterator<String> it = wdhndls.iterator();
		while(it.hasNext()) {
			String id = it.next();
			System.out.println(driver.switchTo().window(id).getTitle());
		}
	}

}
