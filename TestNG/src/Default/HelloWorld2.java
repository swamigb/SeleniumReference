package Default;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class HelloWorld2 {
	@Test
	public void Demo() {
		System.out.println("Demo");
	}
	@Test(dependsOnMethods= {"HiDemo2"})
	public void Demo2() {
		System.out.println("Demo2");
	}

	@Parameters({"url","api"})
	@Test(groups= {"smoke"})
	public void HiDemo2(String url, String api) {
		System.out.println("HiDemo2, smoke test"+ url);
	}
	@BeforeTest
	public void HeyDemo2() {
		System.out.println("I'm executing first");
	}
	@Parameters({"api"})
	@Test
	public void HelloDemo2(String api) {
		System.out.println("HelloDemo2"+ api);
		Assert.assertTrue(false);
	}

	@Test(dataProvider="getData")
	public void newMethod(String user, String pwd) {
		System.out.println(user);
		System.out.println(pwd);

	}
	
	@DataProvider
	public Object getData() {
		Object[][] data= new Object[2][2];
		data[0][0] = "First user";
		data[0][1] = "First pwd";

		data[1][0] = "second user";

		data[1][1] = "second user";

		return data;	
		
	}
}
