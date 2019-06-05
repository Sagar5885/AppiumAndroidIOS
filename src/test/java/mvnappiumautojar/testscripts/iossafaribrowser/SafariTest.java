package mvnappiumautojar.testscripts.iossafaribrowser;

import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SafariTest {
	public static AppiumDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName", "iPhone Simulator");
	        capabilities.setCapability("platformName", "iOS");
	        capabilities.setCapability("platformVersion", "7.1");
	        capabilities.setCapability("browserName", "safari");
	        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
	                capabilities);
		
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		
		driver.get("http://www.way2automation.com");
		
		driver.findElement(By.linkText("Courses")).click();
		driver.findElement(By.linkText("Selenium Training")).click();
		System.out.println("Title of the page is : "+driver.getTitle());
		
		System.out.println(driver.getPageSource());
	}
}
