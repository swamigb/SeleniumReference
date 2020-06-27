import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello");
		
		// Create an web driver object, in this case for chrome browser
		// webdriver.chrome.driver, webdriver.gecko.driver, webdriver.ie.driver
		// Download browser compatible web driver
		System.setProperty("webdriver.chrome.driver","/home/swami/Selenium/chromedriver_linux64_83/chromedriver");
		WebDriver chromeDriver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(chromeDriver, 1);
		/**
		 * 
		 * Syntax for xpath = //tagName[@attribute='value']
		 * Syntax for css = tagName[attribute='value']
		 * Alternative syntax for css = tagName#id --this is only available for id attribute
		 * Alternative syntax for css = tagName.className --this is only available for class attribute
		 * Regular expression
		 *  xpath = //tagName[contains(@attribute, 'value')]
		 *  *  css = tagName[attribute*='value']
		 *  rahulshettyacademy.comnav-link-accountList
		 *  Absolute xpath
		 *  Relative xpath
		 *  //parenttagName/parennt/actualelement
		 *  //*[contains(text(),'Course content')]
		 *  Sibiling based xpath
		 *  //tagName[sibling locator]/following-sibling::tagName[@attributes=value]
		 *  //tagName[sibling locator]/previous-sibling::tagName[@attributes=value]
		 *  Child to parent - Only with xpath
		 *  //tageName[childlocator]/parent::tagName
		 *  ancestor	Selects all ancestors (parent, grandparent, etc.) of the current node
			ancestor-or-self	Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself
			attribute	Selects all attributes of the current node
			child	Selects all children of the current node
			descendant	Selects all descendants (children, grandchildren, etc.) of the current node
			descendant-or-self	Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself
			following	Selects everything in the document after the closing tag of the current node
			following-sibling	Selects all siblings after the current node
			namespace	Selects all namespace nodes of the current node
			parent	Selects the parent of the current node
			preceding	Selects all nodes that appear before the current node in the document, except ancestors, attribute nodes and namespace nodes
			preceding-sibling	Selects all siblings before the current node
			self	Selects the current node
			
			
		 *To select attribute based on text in web page - //*[text()='value']
		 *//*[contains(text(),'Course content')]
		 *css selector: tagName[class='value'] - css selectors are faster than xpaths
		 */
		
		
		// chromeDriver.get("https://google.com");
		// System.out.println(chromeDriver.getTitle());
		// System.out.println(chromeDriver.getWindowHandle());
		chromeDriver.get("https://amazon.com/");
		chromeDriver.manage().window().maximize();
		chromeDriver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		chromeDriver.findElement(By.cssSelector("a#createAccountSubmit")).click();
		chromeDriver.findElement(By.xpath("//input[contains(@name, 'customerNam')]")).sendKeys("Swami Ganesh Bandaru");
		chromeDriver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ganesh2cash@live.in");
		chromeDriver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("1234qwer$*A");
		chromeDriver.findElement(By.xpath("//input[@id='ap_password_check']")).sendKeys("1234qwer$*A");
		chromeDriver.findElement(By.cssSelector("#continue")).click();
		




		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-authentication/div/div/form/div[3]/app-alert/div/div")));
		
		// System.out.println(chromeDriver.findElement(By.xpath("/html/body/app-root/div/div/div/app-authentication/div/div/form/div[3]/app-alert/div/div")).getText());
		
		//chromeDriver.findElement(By.xpath("/html/body/app-root/app-header/nav/div/div[2]/div/ul/li[3]/a")).click();;
		//chromeDriver.findElement(By.xpath("/html/body/app-root/app-header/nav/div/div[2]/div/ul/li[3]/a
		// chromeDriver.findElement(By.name("passwd")).sendKeys("mypassword");
		// chromeDriver.findElement(By.linkText("Forgot account?")).click();
		
		


		
		// chromeDriver.navigate().refresh();
		// chromeDriver.navigate().back();
		// chromeDriver.close();// closes current window
		// chromeDriver.quit(); // closes all windows
		
		
	}

}
