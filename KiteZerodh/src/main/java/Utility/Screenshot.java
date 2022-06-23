package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static void takeScreenShot(WebDriver driver , String name) throws IOException
	{
		String d = Screenshot.date();
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
		File destintationFile = new File("C:\\Users\\rajesh ingle\\Pictures\\Screenshots"+ name + d +".jpeg");
		
		FileHandler.copy(source, destintationFile);
	}
	
   public static String date()
   {
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss"); // format the time date and time as required
	   LocalDateTime currentTime = LocalDateTime.now();  // return current time
	   String d = dtf.format(currentTime);  //format the time  given by now() method to required format and return string
	   return d;
   
	//   String date = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss").format(LocalDateTime.now());
	 //  return date;
   
   }
  
}
