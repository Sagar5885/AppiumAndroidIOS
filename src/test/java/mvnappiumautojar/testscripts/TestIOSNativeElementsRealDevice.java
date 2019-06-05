package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestIOSNativeElementsRealDevice {

public static IOSDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.UDID, "571e1c5acf8c4e0d47c6d146186d8749c8fab5b0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.3");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/rahularora/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphoneos/IntegrationApp.app");
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		System.out.println(driver.getDeviceTime());
		
		driver.lockDevice();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
