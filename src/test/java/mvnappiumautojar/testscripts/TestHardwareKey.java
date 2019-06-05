package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestHardwareKey {
	
	public static AndroidDriver driver;
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(1000);
		
		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).click();
		
//		driver.pressKey(new KeyEvent(AndroidKey.A));
//		driver.pressKey(new KeyEvent(AndroidKey.P));
//		driver.pressKey(new KeyEvent(AndroidKey.P));
//		driver.pressKey(new KeyEvent(AndroidKey.I));
//		driver.pressKey(new KeyEvent(AndroidKey.U));
//		driver.pressKey(new KeyEvent(AndroidKey.M));
		
		Actions action = new Actions(driver);
		action.sendKeys("Appium").perform();
		
//		driver.longPressKey(new KeyEvent(AndroidKey.HOME));
		
//		driver.toggleWifi();
//		Thread.sleep(3000);
//		try {
//		driver.toggleAirplaneMode();
//		}catch(Throwable t) {
//			
//			System.out.println("Airplane mode active");
//		}
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}
