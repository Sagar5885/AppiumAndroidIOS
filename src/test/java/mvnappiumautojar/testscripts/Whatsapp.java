package mvnappiumautojar.testscripts;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Whatsapp {

	public static AndroidDriver driver;
	public static String appLocation= "C:\\Personal\\Personal_Learning\\appium_Learning\\all_apks";
	public static String appName="WhatsApp_2.11.378.apk";
	public static String devicename="Android";
	public static String ContactName="Way2Automation";

	public static void main(String[] args) throws MalformedURLException {
		
	
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName",devicename);
			capabilities.setCapability("platformVersion", "4.4.2");
			capabilities.setCapability("platformName","Android");
			capabilities.setCapability("appPackage", "com.whatsapp");
			capabilities.setCapability("appActivity", "com.whatsapp.Main");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		
			WebElement frameLayout = driver.findElement(By.id("android:id/action_bar_container"));
			List<WebElement> textView = frameLayout.findElements(By.className("android.widget.TextView"));
			System.out.println(textView.size());
			textView.get(1).click();
			
			driver.findElement(By.id("android:id/search_src_text")).sendKeys("Way2Automation");
			
			TouchAction action = new TouchAction((MobileDriver)driver);
			action.tap(new PointOption().withCoordinates(276, 224)).perform();
//			action.tap(276, 224).perform();
			
			
			driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("Hello");
			driver.findElement(By.id("com.whatsapp:id/send")).click();
			
			driver.findElement(By.id("com.whatsapp:id/camera_btn")).click();
			driver.findElement(By.id("com.whatsapp:id/shutter")).click();
			
			driver.findElement(By.id("com.whatsapp:id/caption")).sendKeys("New Image");
		
			//driver.sendKeyEvent(AndroidKeyCode.ENTER);
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			driver.findElement(By.id("com.whatsapp:id/ok")).click();
	}
	
}
