package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(css ="input.LM6RPg")
	WebElement search;
	
	
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public WebElement  searchTab()
	{
		
		return search;
	}
	
	
	
	
	
	
	

}
