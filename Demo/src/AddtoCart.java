import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/**
		 * implict wait = driver.manage.timeouts => Waits for specified amount of time. If fails to find element then fails
		 * If element is found before timeout, then execution flow continues. 
		 * 
		 * Explicit wait WebDriverWait wait= new WebDriverWait(drivername, seconds)
		 * wait.unit(expectedconditions.)
		 */

		System.out.println("Hello");
		
		// Create an web driver object, in this case for chrome browser
		// webdriver.chrome.driver, webdriver.gecko.driver, webdriver.ie.driver
		// Download browser compatible web driver
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		String[] itemsToSelect = {"Brocolli","Beetroot","Potato","Apple","Almonds"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		for(int i=0;i<itemsToSelect.length;i++) {
			int count = (int) (Math.random()*10);
			WebElement noOfItems = driver.findElement(By.xpath("//*[contains(text(),'"+itemsToSelect[i]+"')]/parent::div //a[@class='increment']"));
			WebElement addToCart = driver.findElement(By.xpath("//*[contains(text(),'"+itemsToSelect[i]+"')]/parent::div //button[@type='button']"));
		
			for(int k=0; k<=count; k++) {
				wdw.until(ExpectedConditions.elementToBeClickable(noOfItems));
				try{
					noOfItems.click();
				}
				catch(Exception e) {
					System.out.println(noOfItems.getText()+	addToCart.isDisplayed());
				}
			}
			addToCart.click();
			//Thread.sleep(2000L);
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
	}

}
