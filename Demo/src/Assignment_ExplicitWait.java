import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
		// wdw.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("results")));
		// System.out.println(driver.findElement(By.id("results")).getText());
		
		Wait<WebDriver> fw = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(5))
		.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		
		System.out.println(driver.findElement(By.id("results")).isDisplayed());

		WebElement foo = fw.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.id("results")).isDisplayed()) {
					System.out.println("Found");
					return driver.findElement(By.id("results"));
				}
				else {
					System.out.println("Not found");
					return null;
				}
			}
		});
		System.out.println(driver.findElement(By.id("results")).isDisplayed());
		
	}

}
