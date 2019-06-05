package mvnappiumautojar.testscripts.saucelab;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SauceAndroidNative {
	public static AppiumDriver wd;
	public static final String sauceUserName = "sagardodia";
	public static final String sauceAccessKey = "c978dd02-e2ab-42e2-8bde-782300f73ccc";
	public static final String URL = "http://"+sauceUserName+":"+sauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
//	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
//	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	    
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    capabilities.setCapability("app", "sauce-storage:myApp.apk");
	    capabilities.setCapability("appPackage", "com.hintmd.patientapp");
	    capabilities.setCapability("appActivity", ".activities.MainActivity");
	    
	    wd = new AndroidDriver(new URL(URL), capabilities);
	    
	    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    		
		wd.findElement(By.id("login_digit_1_field")).sendKeys("4");
		wd.findElement(By.id("login_digit_2_field")).sendKeys("0");
		wd.findElement(By.id("login_digit_3_field")).sendKeys("8");
		wd.findElement(By.id("login_digit_4_field")).sendKeys("6");
		wd.findElement(By.id("login_digit_5_field")).sendKeys("7");
		wd.findElement(By.id("login_digit_6_field")).sendKeys("8");
		wd.findElement(By.id("login_digit_7_field")).sendKeys("3");
		wd.findElement(By.id("login_digit_8_field")).sendKeys("4");
		wd.findElement(By.id("login_digit_9_field")).sendKeys("9");
		wd.findElement(By.id("login_digit_10_field")).sendKeys("3");
		
	}	 
}
