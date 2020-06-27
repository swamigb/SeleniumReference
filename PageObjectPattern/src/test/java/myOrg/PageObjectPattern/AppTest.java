package myOrg.PageObjectPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import myOrg.objectStore.HomePage;
import myOrg.objectStore.LoginPage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * 
     */
	WebDriver driver;
	public AppTest() {
		 System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
	   	 driver  = new ChromeDriver();
	}
	@Test
    public void SignUp() throws InterruptedException, SQLException
    {
   	  getData();
   	   this.driver.get("https://recipe-book-d702b.firebaseapp.com/");
   	   LoginPage lp = new LoginPage(this.driver);
   	   lp.getUserId().sendKeys("swamigb1234@gmail.com");
   	   lp.getPasswd().sendKeys("seleniumpassword");
   	   // lp.getSwitchTo().click();
   	   lp.getSubmit().click(); 
   	   Thread.sleep(2000L);
   	   logout();
    }
    public void logout()
    {
   	  // this.driver.get("https://recipe-book-d702b.firebaseapp.com/");
  	   HomePage hp = new HomePage(this.driver);
  	   hp.getIdly().click();
  	   hp.getLogout().click();
  	   // jdbc:postgresql://host:port/database
   	   
    }
    
    public void getData() throws SQLException {
    	System.out.println("hello");
    	String host = "localhost";
    	String port = "5432";
    	String database = "customerdb";
    	Connection con = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+database,"swami","egr135abcd");
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("Select * from agents");
    	while (rs.next()) {
			System.out.println(rs.getString("agent_code"));
			
		}
    	con.close();
    }
	
	
}
