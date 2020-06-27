import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/**
		 * Action a = new Actions(driver);
		 * a.actionname(webelement).build.perform
		 */
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();	
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();	
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("SwaMi").doubleClick().build().perform();
		Thread.sleep(2000L);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build().perform();
		
	}

}
