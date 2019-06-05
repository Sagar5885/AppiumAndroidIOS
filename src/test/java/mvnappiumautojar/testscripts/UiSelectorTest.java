package mvnappiumautojar.testscripts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UiSelectorTest {
public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File app = new File("C:\\Users\\Selenium\\Downloads\\testingapp\\testingapp\\way2automation.apk");
		
		//C:\Users\Selenium\Downloads\com.facebook.katana.apk
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		  
	  
	       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	       
	    // driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	       
	       
	      // driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Display Popup Window')]")).click();
	       
	     //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Display Popup Window\")").click();
	       
	       
	    //   driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.CheckBox\").checked(true)").click();
	       
	     /*  
	      System.out.println(driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.Button\").index(1)").size());
	       
	      
	      WebElement button = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.Button\").index(1)").get(1);
	      button.click();*/
	      
	      WebDriverWait wait = new WebDriverWait(driver, 2L);
	      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("io.selendroid.testapp:id/visibleButtonTest"))).click();
	       
	      driver.quit();
	      
	}

}
