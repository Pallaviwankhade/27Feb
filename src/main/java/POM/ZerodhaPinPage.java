package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaPinPage {
	@FindBy(xpath="//input[@type='password']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//a[text()='Forgot 2FA?']")private WebElement forgotpin;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signup;
	
	
	public ZerodhaPinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterpinNumber(String pinNo,WebDriver driver)   
	{
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));  // explicit wait
	//	wait.until(ExpectedConditions.visibilityOf(pin));  // will recheck the element in 500ms
	
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);      // fluent wait
		wait.withTimeout(Duration.ofMillis(50000));   // total wait time
		wait.pollingEvery(Duration.ofMillis(5000));     // polling time or rechecking time
		wait.ignoring(Exception.class);  // exception ignore
		wait.until(ExpectedConditions.visibilityOf(pin));
		
		pin.sendKeys(pinNo);
	}
	
	public void clickOnContinue() {
		submit.click();
	}
	public void clickOnForgotPin() {
		forgotpin.click();
	}

    public void clickOnsignUp() {
    	signup.click();
    }

}
