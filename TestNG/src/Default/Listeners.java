package Default;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	 public void onTestSuccess(ITestResult result) {
System.out.println("Test success"+ result.getName());
}
	 
	 
	@Override
	 public void onTestFailure(ITestResult result) {
		    // not implemented
		System.out.println("Test failed"+ result);
		  }
	 
	 
}
