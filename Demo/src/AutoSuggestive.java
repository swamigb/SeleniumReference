import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("HYD");
		int i= 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while(true) {
			driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.DOWN);
			Thread.sleep(1000L);
			// System.out.println("hello");
			// System.out.println(driver.findElement(By.id("gosuggest_inputSrc")).getText());
			String script = "return document.getElementById('gosuggest_inputSrc').value";
			String destName = (String) js.executeScript(script);
			System.out.println(destName);
			if(destName.contains("Hyderabad")) {
				driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.ENTER);

				break;
			}
			
		}
		autoSuggest();
	}
	
	public static void autoSuggest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("United");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while(true) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			String script = "return document.getElementById('autocomplete').value";
			String destName = (String) js.executeScript(script);
			if(destName.contains("United States")) {
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
				break;
			}
	}
	}

}
