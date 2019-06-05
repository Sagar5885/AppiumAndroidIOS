package mvnappiumautojar.testscripts.saucelab;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SauceIOSNative {
	public static AppiumDriver wd;
	public static final String sauceUserName = "sagardodia";
	public static final String sauceAccessKey = "c978dd02-e2ab-42e2-8bde-782300f73ccc";
	public static final String URL = "http://"+sauceUserName+":"+sauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//	    capabilities.setCapability("appiumVersion", "1.2.2");
	  
//	    File app = new File("/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/BonusApp.app");
//	    capabilities.setCapability("app", app);
	    
	    capabilities.setCapability("app", "sauce-storage:HintMD.zip");
	    
	    wd = new IOSDriver(new URL(URL), capabilities);
	    
	    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
//		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
//		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
//		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
	}
	 
}
