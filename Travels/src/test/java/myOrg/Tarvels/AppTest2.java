package myOrg.Tarvels;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import myOrg.objectStore.HomePage;
import myOrg.objectStore.LoginPage;

/**
 * Unit test for simple App.
 */
public class AppTest2 extends Base
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     */
	public WebDriver driver;
	public static Logger logger = (Logger) LogManager.getLogger(AppTest2.class.getName());
	@BeforeMethod
	public void Initialize() throws IOException {
		driver = initializeDriver();
    	driver.get(prop.getProperty("url"));		
		logger.info("Driver initialized");
		
		
	}
    @Test(dataProvider="getLoginDetails")
    public void login(String userName, String passwd) throws IOException {
    	logger.info("test case started");
    	HomePage homePage = new HomePage(driver);
    	LoginPage loginPage = new LoginPage(driver);
    	homePage.getMyAccount().click();
    	homePage.getLogin().click();
    	loginPage.getUserName().sendKeys(userName);
    	loginPage.getPassword().sendKeys(passwd);
    	loginPage.getLogin().click();
    	AssertJUnit.assertEquals(loginPage.getMyProfile().getText().toLowerCase(),"My Profile".toLowerCase());
    	logger.error("test case finished");

    }
    
    @DataProvider
    public Object[][] getLoginDetails() {
    	Object data[][] = new Object[1][2];
    	data[0][0] = "user@phptravels.com";
    	data[0][1] = "demouser";
    	
    //	data[1][0] = "admin@phptravels.com";
    //	data[1][1] = "demoadmin";
    	return data;
    }
    
    @AfterMethod
    public void cleanUpTest() {
    	driver.close();
    }

}
