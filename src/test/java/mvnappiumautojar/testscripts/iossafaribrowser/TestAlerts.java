package mvnappiumautojar.testscripts.iossafaribrowser;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestAlerts {

	/**
	 * @param args
	 */
public static AppiumDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName", "iPhone Simulator");
	        capabilities.setCapability("platformName", "iOS");
	        capabilities.setCapability("platformVersion", "7.1");
	        capabilities.setCapability("browserName", "safari");
	        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
	                capabilities);
	        
	     
		
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		
		driver.get("http://www.rediff.com");
		
		driver.findElement(By.linkText("Rediffmail")).click();
		Thread.sleep(5000);
		System.out.println(driver.getPageSource());
		
		//driver.findElement(By.name("login")).sendKeys("raman");
		//driver.findElement(By.name("passwd")).sendKeys("sadfsdfdsf");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();
		
		
		

}
}