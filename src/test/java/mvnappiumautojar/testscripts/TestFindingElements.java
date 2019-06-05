package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestFindingElements {
	public static AndroidDriver driver;
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(MobileBy.xpath("//*[@content-desc='visibleButtonTestCD']")).click();
		
		driver.findElement(MobileBy.xpath("//android.widget.LinearLayout/android.widget.Button[contains(@text,'Display text')]")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}
