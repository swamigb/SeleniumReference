import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.espncricinfo.com/series/19430/scorecard/1152846/england-vs-australia-1st-test-icc-world-test-championship-2019-2021");
	    
	    List<WebElement> scoreCards = driver.findElements(By.cssSelector("[class*='match-scorecard-table']"));
	    
	    for(int i=0;i<scoreCards.size();i++) {
	    	String scoreCardTitle = scoreCards.get(i).findElement(By.cssSelector(" [class*='header-title']")).getText();
	    	
	    	if(scoreCardTitle.contains("INNINGS")) {
	    		System.out.println(scoreCardTitle);
	    		List<WebElement> score = scoreCards.get(i).findElements(By.xpath("//*[contains(@class, 'batsman-cell')]/parent::tr //td[3]"));
	    		score.add(scoreCards.get(i).findElement(By.xpath("//*[contains(text(), 'Extras')]/parent::tr //td[3]")));
	    		score.add(scoreCards.get(i).findElement(By.xpath("//*[contains(text(), 'TOTAL')]/parent::tr //td[3]")));
	    		for(int j=0;j<score.size();j++)
	    			System.out.println(score.get(j).getText());
	    		
	    	}
	    }
	    
	    assignment();
		
	}
	
	public static void assignment() {
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    WebElement productsTable = driver.findElement(By.id("product"));
	    List<WebElement> rows = productsTable.findElements(By.tagName("tr"));
	    System.out.println("No .of rows: "+ rows.size());
	    System.out.println("No. of columns: "+ productsTable.findElements(By.tagName("th")).size());
	    for(int i=0;i<rows.size();i++) {
	    	if(i == 2) {
	    		List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
	    		for(int j=0;j<cells.size();j++)
	    			System.out.println(cells.get(j).getText());
	    	}
	    }
	    
	}

}
