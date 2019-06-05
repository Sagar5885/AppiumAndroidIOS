package mvnappiumautojar.testscripts.iossafaribrowser;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class TestDropdowns {

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
		
		
		driver.get("http://www.wikipedia.org/");
		
		
		
		//new Select(driver.findElement(By.id("searchLanguage"))).selectByVisibleText("Eesti");
		new Select(driver.findElement(By.id("searchLanguage"))).selectByValue("fa");
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		
		
		System.out.println("Total values in dropdown are : "+values.size());
		
		
		
		for(WebElement element:values){
			
			System.out.println(element.getText());
			
		}
		
		System.out.println("------Printing total link from the page----------");
		
		WebElement block = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[12]"));
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		
		System.out.println("Total links are : "+links.size());
		
		
		
		for(WebElement element:links){
			
			System.out.println(element.getText());
			
		}
		
	}

}

