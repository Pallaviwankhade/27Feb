package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaHomePage {
	
	@FindBy(xpath = "//input[@type='text']")private WebElement search;
	@FindBy(xpath = "//button[@type=\"button\"]")private WebElement  buybutton;
	@FindBy(xpath = "//input[@id=\"radio-136\"]")private WebElement  radioBSE;
	@FindBy(xpath = "")private WebElement  radioNSE;
	@FindBy(xpath = "//input[@id=\"radio-136\"]")private WebElement  intraday;
	@FindBy(xpath = "//input[@id=\"radio-136\"]")private WebElement  radio;



public ZerodhaHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
			}
	
	
	public void enterValueInsearchBox(String user)
	{
		search.sendKeys(user);
	}
	
	
	
}
