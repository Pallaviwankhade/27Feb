package POJO;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	 public static WebDriver openBrowser() {
		 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rajesh ingle\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();  // up casting chrome driver class to WevDriver
			
			driver.get("https://kite.zerodha.com/");
			driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS); //UNIVERSAL wait applicable for every instance of driver 
			return driver;          // implicit wait
		
			
		 
	 }
	

}
