package mvnappiumautojar.testscripts.iossafaribrowser;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCaptureScreenshot {

public static AppiumDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName", "iPhone Simulator");
	        capabilities.setCapability("platformName", "iOS");
	        capabilities.setCapability("platformVersion", "7.1");
	        capabilities.setCapability("browserName", "safari");
	        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
	                capabilities);
	        
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		driver.get("http://www.way2automation.com");
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
         File scrFile = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE); 
         FileUtils.copyFile(scrFile, new File("error.jpg"), true);
	}
}
