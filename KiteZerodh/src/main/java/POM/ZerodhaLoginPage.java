package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPage {

	@FindBy(xpath = "//input[@id='userid']")private WebElement userID;
	@FindBy(xpath = "//input[@id='password']")private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")private WebElement login;
	@FindBy(xpath = "//a[text()='Forgot user ID or password?']")private WebElement forgot;
	@FindBy(xpath = "//a[@class='text-light']")private WebElement signUP;
	@FindBy(xpath = "//span[text()=\"User ID should be minimum 6 characters.\"]")private WebElement userIDError;


	public ZerodhaLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
			}
	
	
	public void enteruserID(String user)
	{
		userID.sendKeys(user);
	}
	
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnForgotPassword() {
		forgot.click();
	}
	 public void clickOnsignUp()
	 {
		 signUP.click();
	 }



	public String getErrorText() {
		
		String status = userIDError.getText();
		return status;
	}
	
	



}