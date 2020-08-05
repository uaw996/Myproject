package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	public WebDriver driver;
	
	By electronics = By.xpath("/html/body/div/div/div[2]/div/ul/li[1]/span");
	By mobile_Holder = By.xpath("(//a[@title='Mobile Holders'])[1]");
	By login = By.cssSelector("a._3Ep39l");

	By userName = By.xpath("//*[@type='text' and @class='_2zrpKA _1dBPDZ']");
	By password = By.xpath("//*[@type='password']");

	By submit = By.cssSelector("button[class*='7UHT_c']");

	public LandingPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getloginTest() {

		return driver.findElement(login);
	}

	public WebElement getuserName() {

		return driver.findElement(userName);

	}

	public WebElement getpassword() {

		return driver.findElement(password);

	}

	public LoginPage getLoginBtn() {

		driver.findElement(submit).click();
		LoginPage lo = new LoginPage(driver);
		return lo;

	}

	

	

	public Actions getMouseOnElectronic() {
//		WebDriverWait w = new WebDriverWait(driver,30);
		Actions action = new Actions(driver);
//		WebElement electronic =driver.findElement(electronics).;
//		w.until(ExpectedConditions.visibilityOfElementLocated(mobile_Holder));
		
		return action.moveToElement(driver.findElement(electronics));
				
	

	}public Actions getMouseOnmobile_Holder() {
		WebDriverWait w = new WebDriverWait(driver,5);
		Actions action = new Actions(driver);
//		WebElement electronic =driver.findElement(electronics).;
		w.until(ExpectedConditions.visibilityOfElementLocated(mobile_Holder));
		
		
				
		return	action.moveToElement(driver.findElement(mobile_Holder));

	}

	

}
