package mvnappiumautojar.testscripts.grid;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserTest {
	
	IOSDriver driver;	
	public static String firstDeviceName="571e1c5acf8c4e0d47c6d146186d8749c8fab5b0";//IphoneX
	public static String SecondDeviceName="7ae544323f497983cf0729bc81d5e6128342a125";//Iphone7Plus
	
	@BeforeClass
	@Parameters({"deviceID"})
	public void startTime(String device_id) throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if(device_id.equalsIgnoreCase(firstDeviceName)){
			System.out.println(device_id + "-" + System.currentTimeMillis());
			
			capabilities.setCapability("deviceName",firstDeviceName);
			capabilities.setCapability("udid", firstDeviceName);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.3");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			capabilities.setCapability("wdaLocalPort", 8200);
			capabilities.setCapability(MobileCapabilityType.APP,
					"/Users/rahularora/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphoneos/IntegrationApp.app");
			driver = new IOSDriver(new URL("http://127.0.0.1:10000/wd/hub"),capabilities);
		
		}else if(device_id.equalsIgnoreCase(SecondDeviceName)){
		
			System.out.println(device_id + "-" + System.currentTimeMillis());
			capabilities.setCapability("deviceName",SecondDeviceName);
			capabilities.setCapability("udid", SecondDeviceName);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 plus");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.2");
			capabilities.setCapability("wdaLocalPort", 8201);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");	
			capabilities.setCapability(MobileCapabilityType.APP,
					"/Users/rahularora/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphoneos/IntegrationApp.app");
			driver = new IOSDriver(new URL("http://127.0.0.1:10001/wd/hub"),capabilities);
			
			
		}

		//driver = new IOSDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}


	@Test
	public void testcase() throws InterruptedException
	{
		
		driver.findElement(MobileBy.AccessibilityId("Attributes")).click();

		WebElement switches = driver.findElement(By.className("XCUIElementTypeSwitch"));

		// Turn off the switch
		if (switches.getAttribute("value").equals("1")) {

			switches.click();
		}

		Thread.sleep(3000);

		// Turn on the switch
		if (switches.getAttribute("value").equals("0")) {

			switches.click();
		}

		Thread.sleep(3000);
		driver.quit();

	}


@AfterClass
public void TearDown()
{
	driver.quit();
}

}
