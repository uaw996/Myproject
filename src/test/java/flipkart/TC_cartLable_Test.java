package flipkart;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;

public class TC_cartLable_Test extends base {

	public WebDriver driver;
	LandingPage la;
	Logger log = LogManager.getLogger(TC_cartLable_Test.class.getName());

	@BeforeTest
	public void startTest() throws IOException {

		driver = initializerDriver();
		log.info("browser launch");
	}

	@Test
	public void cartlabelTest() throws InterruptedException {

		driver.get(prop.getProperty("url"));
		
		Thread.sleep(2000);
		log.info("enter url");
		la = new LandingPage(driver);

//		la.getuserName().sendKeys("username");
//		log.info("enter username");
//		la.getpassword().sendKeys("password");
//		log.info("enter password");
//		LoginPage lp = la.getLoginBtn();
//		log.info("click on submit");

//		lp.searchTab().sendKeys("mobile");

		Assert.assertTrue(driver.getTitle().matches("Online Shopping Site for Mobiles, Electronics, "
				+ "Furniture, Grocery, Lifestyle, Books & More. Best Offers!"), "Invalid creadintial");
		log.debug("validate by with different credential");

	}
	
	@Test
	public void validateElectronics() throws InterruptedException {
		
	
	la.getMouseOnElectronic().build().perform();	
		
		
	}

	@Test
	public void validateMoblie_handler() throws InterruptedException {
		
		
	la.getMouseOnmobile_Holder().click().build().perform();	
		
		
	}

}
