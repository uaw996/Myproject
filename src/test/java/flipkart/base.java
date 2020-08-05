package flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class base {
	public WebDriver driver;
	public Properties prop;

    public String username= "77458556418782";
    public String password= "Umh67#";
	public static Logger log;

	public WebDriver initializerDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\flipkart\\data.properties");

		prop.load(fis);
//		String browserName = System.getProperty("browser"); //this is for to run from jenkins with build parameters ex.chrome , firefox
    	String browserName = prop.getProperty("browser");

		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "E:\\driver\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//		return driver;
		return driver;

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();

	}

	public String getScreenshot(String testMethodName, WebDriver driver) throws IOException {

		String dateName = new SimpleDateFormat("hh mm ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\screenshot\\" + testMethodName + "" + dateName
				+ ".jpg";
		FileHandler.copy(source, new File(destination));
		// FileHandler.copy(source, new
		// File("C:\\Users\\Umesh\\Desktop\\ScreenShot\\hfj.jpg"));
		return destination;
	}

}
