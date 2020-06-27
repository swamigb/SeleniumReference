package myOrg.Tarvels;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	protected WebDriver driver;
	protected Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/settings.properties");
		prop.load(fis);	
		String browserName = System.getProperty("browser");
		if(browserName==null)
			browserName = prop.getProperty("browser");
		switch(browserName) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			String headless = "false";
			if(System.getProperty("headless")==null) {
				headless = "false";
			} else {
				headless = System.getProperty("headless");
			}
			if(headless.equals("true")) {
				options.addArguments("headless");
			}
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			
			// firefox code
			break;
		default:
			// default code
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String CaptureScreenshot(String fileName, WebDriver driver) throws IOException {
		fileName = fileName+"-"+new Timestamp(new Date().getTime());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"/reports/"+fileName+".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}
	
}
