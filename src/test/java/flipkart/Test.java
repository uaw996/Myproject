package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.LandingPage;

public class Test  {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", "E:\\driver1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//*[@type='text' and @class='_2zrpKA _1dBPDZ']")).sendKeys("7745818782");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Umesh67#");
		driver.findElement(By.cssSelector("button[class*='7UHT_c']")).click();
		System.out.println(driver.getTitle());
		
		
		
		
		

	}

}
