package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;
import Utility.Report;


@Listeners(TestListeners.class)


public class LoginPageTest extends BaseTest
{ 
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void extentReports()
	{
		reports = Report.createReport();
	}
     
	
	@BeforeMethod
	public void browser()
	{
		driver = Browser.openBrowser();
	}
	
	@Test
	public void loginWithValidCredentialsTest() throws EncryptedDocumentException, IOException
	{
		test = reports.createTest("loginWithValidCredentialsTest");
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0,1);
		String password = Parametrization.getData(1,1);
		zerodhaloginpage.enteruserID(userName);
		zerodhaloginpage.enterpassword(password);
		zerodhaloginpage.clickOnLogin();
		
	}
	@Test
	
	public void forgotPasswordLinkTest()
	{ 
		test = reports.createTest("forgotPasswordLinkTest");
		
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		zerodhaloginpage.clickOnForgotPassword();
	}
	
	@Test
	
	public void signUpLinkTest() {
		
    	test = reports.createTest("signUpLinkTest");

		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		zerodhaloginpage.clickOnsignUp();
	}
	
	@Test
	
	public void clickOnLoginWithoutDataTest() throws EncryptedDocumentException, IOException
	{
		test = reports.createTest("clickOnLoginWithoutDataTest");
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		zerodhaloginpage.clickOnLogin(); 
		
	     String text = zerodhaloginpage.getErrorText();
		
	     String expectedText = "User ID should be minimum 6 characters.";
		
	//    Assert.assertEquals(text, expectedText);    //hard Assert , in hard assert if defect found he can not proceed means not giving output skip all code remaining
		
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(text, expectedText);  // soft assert in this if error found he can proceed next step and giving output i e skip this method only
		
		String userName = Parametrization.getData(0,1);
		String password = Parametrization.getData(1,1);
		zerodhaloginpage.enteruserID(userName);
		zerodhaloginpage.enterpassword(password);
		zerodhaloginpage.clickOnLogin();
		
	   softAssert.assertAll();
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void flushResult()
	{
		reports.flush();
}
	@Test
   public void test()
   {
	   System.out.println("hi");
   }
	
}
