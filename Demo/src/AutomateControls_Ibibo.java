import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class AutomateControls_Ibibo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/**
		 * Static dropdowns * Select s = new
		 * Select(driver.findElement(By.xpath("//*[@id='dropdown-class-example']")));
		 * s.selectByIndex(3); s.selectByValue("option1");
		 * s.selectByVisibleText("Option2"); Dynamic dropdown: * Parent - child xpath -
		 * Now the scope is restricted to parent and selenium searches under parent no
		 * whole document //tageName[parentlocator] //childtagname[locator] * to
		 * simulate key board events = sendKeys(Keys.KeyName) => sendKeys(Keys.ENTER)
		 */
		final String webUrl = "https://www.spicejet.com/";
		System.setProperty("webdriver.chrome.driver", "/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(webUrl);
		List<WebElement> ele = driver
				.findElements(By.cssSelector("div[id='discount-checkbox']  input[type='checkbox']"));
		Iterator<WebElement> it = ele.iterator();
		while (it.hasNext()) {
			WebElement chk = it.next();
			// String text = chk.findElement(By.id("//label")).getText();
			System.out.println("-" + chk.isSelected());
			chk.click();
		}
		it = ele.iterator();
		while (it.hasNext()) {
			WebElement chk = it.next();
			System.out.println(chk.getText() + "-" + chk.isSelected());
		}
		// span[@class*='txtTransUpper']
		// s.deselectByIndex(0);;
		WebElement chkBox = driver.findElement(By.id("input[id='checkBoxOption1']"));
		chkBox.click();
		Assert.assertTrue(chkBox.isSelected());
		chkBox.click();
		Assert.assertFalse(chkBox.isSelected());
		System.out.println(driver.findElements(By.xpath("input[type='checkbox']")).size());
	}

}
