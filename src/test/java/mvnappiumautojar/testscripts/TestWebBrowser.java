package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestWebBrowser {
	
	public static AndroidDriver driver;
	
	
	public static void main(String args[]) throws MalformedURLException{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.name("q")).sendKeys("Hello Sagar from Appium!");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input")).sendKeys("Hello Sagar from Appium Using XPath!");
		driver.quit();
	}

}
