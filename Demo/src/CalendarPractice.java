import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.goibibo.com/");
	    driver.findElement(By.id("departureCalendar")).click();
	    while(!driver.findElement(By.className("DayPicker-Caption")).getText().contains("Mar")) {
	    	driver.findElement(By.xpath("//div[@class='DayPicker-NavBar'] /span[contains(@class,'next')]")).click();
	    }
	    List<WebElement> dates = driver.findElements(By.className("calDate"));
	    for(int i=0;i<dates.size();i++) {
	    	// System.out.println(dates.get(i).getText());
	    	if(dates.get(i).getText().equals("30")) {
	    		dates.get(i).click();
	    		break;
	    	}
	    }
	}

}
