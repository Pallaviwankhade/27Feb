package Test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.Screenshot;

public class TestListeners extends BaseTest implements ITestListener
{

	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getName()+"Test has Started");
	}
	
	public void onTestFailure(ITestResult result)
	{
			try {
				Screenshot.takeScreenShot(driver,result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getName()+"Test  Success");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println(result.getName()+"Test Skipped");
	}
	
}
