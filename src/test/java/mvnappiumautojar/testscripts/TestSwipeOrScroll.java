package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TestSwipeOrScroll {

	public static IOSDriver driver;

	public static void swipe(int x_start, int y_start, int x_stop, int y_stop, int duration) {

		new TouchAction(driver).press(PointOption.point(x_start, y_start))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
				.moveTo(PointOption.point(x_stop, y_stop)).release().perform();
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.UDID, "571e1c5acf8c4e0d47c6d146186d8749c8fab5b0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.3");

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.APP,
				"/Users/rahularora/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphoneos/IntegrationApp.app");

		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Scrolling")).click();

		WebElement tapElement = driver.findElement(MobileBy.AccessibilityId("TableView"));
		tapElement.click();

		System.out.println(driver.findElement(MobileBy.AccessibilityId("35")).isDisplayed());

		int i = 0;

		while (!driver.findElement(MobileBy.AccessibilityId("35")).isDisplayed()) {

			System.out.println("Swipe count : " + i);

			swipe(16, 715, 16, 143, 2);

			i++;
		}

		System.out.println(driver.findElement(MobileBy.AccessibilityId("35")).isDisplayed());

		i = 0;

		System.out.println(driver.findElement(MobileBy.AccessibilityId("1")).isDisplayed());

		while (!driver.findElement(MobileBy.AccessibilityId("1")).isDisplayed()) {

			System.out.println("Swipe count : " + i);

			swipe(16, 143, 16, 715, 2);

			i++;
		}
		
		System.out.println(driver.findElement(MobileBy.AccessibilityId("1")).isDisplayed());


		Thread.sleep(3000);
		driver.quit();
	}

}
