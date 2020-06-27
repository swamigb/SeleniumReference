import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentSection12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    int checkboxIndex = (int) (Math.random()*3);
	    checkboxIndex++;
		WebElement checkbox = driver.findElement(By.id("checkBoxOption"+checkboxIndex));
		checkbox.click();
		String checkboxValue = checkbox.getAttribute("value");
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByValue(checkboxValue);
		String selectedValue = s.getFirstSelectedOption().getText();
		System.out.println(selectedValue);
		driver.findElement(By.id("name")).sendKeys(selectedValue);
		driver.findElement(By.id("alertbtn")).click();
		String alertTxt = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertTxt);
		if(alertTxt.contains(selectedValue)) {
			System.out.println("Test case success!");
		}
		else {
			System.out.println("Test case fail!");
		}
	}

}
