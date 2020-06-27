import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumGridAutomateCleatrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url = "https://www.cleartrip.com/";
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
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
