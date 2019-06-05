package mvnappiumautojar.testscripts.iossafaribrowser;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestCheckboxes {

	/**
	 * @param args
	 */
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
		
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		
		WebElement block = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		
		List<WebElement> checkboxes = block.findElements(By.name("sports"));
		
		
		System.out.println(checkboxes.get(1).getAttribute("checked"));
		
		System.out.println("Total checkboxes are : "+checkboxes.size());
		
		
		for(WebElement element:checkboxes){
			
			element.click();
			
		}
		
		System.out.println(checkboxes.get(1).getAttribute("checked"));
		
	}

}

