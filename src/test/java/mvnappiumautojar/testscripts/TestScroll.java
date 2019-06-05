package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestScroll {

	public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");

		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		
		//driver.scrollTo("");
		
		String text = "Fire";
		MobileElement ele = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/list\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))");
		
		//Left to Right swipe
		//driver.swipe(ele.getLocation().x+200, ele.getLocation().y, ele.getLocation().x+1100, ele.getLocation().y, 5000);
		
		
		//Right to Left swipe
		//driver.swipe(ele.getLocation().x+900, ele.getLocation().y, ele.getLocation().x+200, ele.getLocation().y, 5000);
				
		
		Thread.sleep(4000);
		driver.quit();

	}

}
