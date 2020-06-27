import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Voorwaarden')]")).click();
		Set<String> wids = driver.getWindowHandles();
		Iterator<String> it = wids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//a[contains(text(),'Voorwaarden')]")).click();
		driver.switchTo().window(childid).close();
		driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());
		WindowsPractice wp = new WindowsPractice();
		wp.windowHandles();

		
	}

}
class WindowsPractice {
	void windowHandles() {
	System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/windows");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
	Set<String> wids = driver.getWindowHandles();
	Iterator<String> it = wids.iterator();
	String parentid = it.next();
	String childid = it.next();
	driver.switchTo().window(childid);
	System.out.println(driver.findElement(By.xpath("//h3")).getText());
	driver.switchTo().window(parentid);
	System.out.println(driver.findElement(By.xpath("//h3")).getText());

	
	}
}
