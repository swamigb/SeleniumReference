import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateControls_Spicejet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/**
		 * Static dropdowns
		 * 
		 * Select s = new Select(driver.findElement(By.xpath("//*[@id='dropdown-class-example']")));
			s.selectByIndex(3);
			s.selectByValue("option1");
			s.selectByVisibleText("Option2");
		 *Dynamic dropdown:
		 *
		 *
		 *Parent - child xpath - Now the scope is restricted to parent and selenium searches under parent no whole document
		 * //tageName[parentlocator] //childtagname[locator]
		 * 
		 * to simulate key board events = sendKeys(Keys.KeyName) => sendKeys(Keys.ENTER)
		 */
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("pax_label")).click();
		for(int i=0;i<5;i++)
		driver.findElement(By.id("adultPaxPlus")).click();
		driver.findElement(By.id("pax_close")).click();

		// System.out.println(driver.findElement(By.id("pax_label")).getText());
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Amsterdam");
		 Thread.sleep(300L);
		driver.findElement(By.xpath("//span[text()='(AMS)']")).click();
		WebElement destination = driver.findElement(By.id("gosuggest_inputDest"));
		destination.sendKeys("HYD");
		// destination.sendKeys(Keys.ENTER);
		 Thread.sleep(300L);

		driver.findElement(By.xpath("//span[text()='(HYD)']")).click();
		driver.findElement(By.id("departureCalendar")).sendKeys("Sun, 24 Aug");
		driver.findElement(By.id("returnCalendar")).sendKeys("Sun, 24 Sep");
		driver.findElement(By.id("gi_search_btn")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='hypFltErr'] //span[contains(text(), 'Please enter')]")).getText());

		
		
		//span[@class*='txtTransUpper']
		
		//s.deselectByIndex(0);;
	}

}
