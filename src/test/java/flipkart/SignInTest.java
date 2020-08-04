package flipkart;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





import pageObject.LandingPage;
import pageObject.LoginPage;


public class SignInTest extends base {
	public WebDriver driver;
	
	Logger log = LogManager.getLogger(SignInTest.class.getName());
	
	@BeforeTest
	public void initializer() throws IOException {
		
	      driver = initializerDriver();
		  log.info("browser is launch");
	}
	

	@Test(dataProvider = "getDataProvide")
	public void loginTest(String userName , String password) throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		log.info("getting url");
		LandingPage la = new LandingPage(driver);
		log.info("logging url");
		la.getuserName().sendKeys(userName);
		log.info("enter username");
		la.getpassword().sendKeys(password);
		log.info("enter password");
		LoginPage lo=la.getLoginBtn();
		log.info("click on submit");
		
//		Thread.sleep(10000);
		
		Assert.assertTrue(driver.getTitle().matches("Online Shopping Site for Mobiles, Electronics, "
				+ "Furniture, Grocery, Lifestyle, Books & More. Best Offers!"), "Invalid creadintial");
		log.debug("validate by with different credential");
		
		
	}

	@DataProvider
	public Object[][] getDataProvide() {

		Object[][] data = new Object[3][2];
		data[0][0] = "ajshfh";
		data[0][1] = "pass";

		data[1][0] = "djsjjd";
		data[1][1] = "jhsdjhf";

		data[2][0] = "7745818782";
		data[2][1] = "Ume5sh67#";

		return data;
	}

}
