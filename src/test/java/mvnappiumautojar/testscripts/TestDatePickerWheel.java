package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestDatePickerWheel {

public static IOSDriver driver;

	
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
		driver.findElement(MobileBy.AccessibilityId("Attributes")).click();

		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("order", "next");
		param.put("offset", 0.15);
		param.put("element", driver.findElement(By.xpath("//XCUIElementTypePickerWheel[1]")));
		driver.executeScript("mobile: selectPickerWheelValue", param);
	
		
		
		System.out.println(driver.findElement(By.xpath("//XCUIElementTypePickerWheel[1]")).getAttribute("value"));
		//driver.findElement(By.xpath("//XCUIElementTypePickerWheel[1]")).sendKeys("Thu, 27 Dec");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[2]")).sendKeys("7");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[3]")).sendKeys("20");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[4]")).sendKeys("AM");
		
		Thread.sleep(3000);
		driver.quit();
	}

}
