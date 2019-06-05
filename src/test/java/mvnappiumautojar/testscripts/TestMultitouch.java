package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.offset.PointOption;

public class TestMultitouch {
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android");
		dc.setCapability("appPackage", "com.html5test.webview");		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PointOption pointOption = new PointOption().withCoordinates(345, 1475);		
		PointOption pointOption2 = new PointOption().withCoordinates(742, 895);
		PointOption pointOption3 = new PointOption().withCoordinates(345, 1475);
		
		Duration Duration;
		
		TouchAction action1 = new TouchAction(driver).tap(pointOption).waitAction();
		TouchAction action2 = new TouchAction(driver).tap(pointOption2).waitAction();
		TouchAction action3 = new TouchAction(driver).tap(pointOption3).waitAction();
		
//		TouchAction action2 = new TouchAction(driver).tap(742, 895).waitAction(2000);
//		TouchAction action3 = new TouchAction(driver).tap(925, 2105);

		new MultiTouchAction(driver).add(action1).add(action2).add(action3).perform();
		
		Thread.sleep(4000);
		driver.quit();
	}
}
