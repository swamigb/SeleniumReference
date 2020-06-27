package Default;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HelloWorld {
	@BeforeTest
	public void Demo() {
		System.out.println("In helloworld first");
	}
	
	@Test(groups= {"smoke"})
	public void Demo1() {
		System.out.println("Hello1, smoke test");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Before every method");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("After every method");
	}

	
	@AfterTest
	public void Demo2() {
		System.out.println("After execution");
	}

}
