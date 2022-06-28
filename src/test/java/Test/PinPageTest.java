package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;
import POM.ZerodhaPinPage;

public class PinPageTest {
	
	
	WebDriver driver;
	@BeforeMethod
	
	public void  launchBrowser()
	{
		driver = Browser.openBrowser();
	}
	
	@Test
	
	
	 public void loginToZerodhaWithPinTest() throws EncryptedDocumentException, IOException, InterruptedException
	 {
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		String username = Parametrization.getData(0, 1);
		String password = Parametrization.getData(1, 1);
		zerodhaloginpage.enteruserID(username);
		zerodhaloginpage.enterpassword(password);
		zerodhaloginpage.clickOnLogin();
		
		 
	    ZerodhaPinPage zerodhapinpage = new ZerodhaPinPage(driver);
	    String piN = Parametrization.getData(2, 1);
	    
	    Thread.sleep(3000);
	    
	    System.out.println(piN);
	    zerodhapinpage.enterpinNumber(piN,driver);
	    zerodhapinpage.clickOnContinue();
	    
	 }
	
	}
