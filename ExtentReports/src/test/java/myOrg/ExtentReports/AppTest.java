package myOrg.ExtentReports;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	ExtentReports report;

	@BeforeTest
	public void extentReports() {
		System.out.println("hello");
		
		String reportPath = System.getProperty("user.dir")+"/reports/index.html";		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("My Test Report");
		reporter.config().setReportName("Extent Report Results");
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Swami");
		
		
	}
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
    	ExtentTest extTst = report.createTest("Should anwer with true");
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://google.com");
    	System.out.println(driver.getTitle());
    	driver.close();
    	// assertTrue(false);
    	extTst.fail("Failed to execute the tests");
    	report.flush();
    }
}
