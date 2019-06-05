package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestNativeAppIOS {

	public static IOSDriver driver;
	public static AppiumDriverLocalService service;
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium.log")));
		
		service.start();
		
		DesiredCapabilities dc = new DesiredCapabilities();		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xʀ (12.2)");		
		//dc.setCapability(MobileCapabilityType.APP, "/Users/sagardodia/Downloads/HintMD.Beta.ipa");
		dc.setCapability(MobileCapabilityType.APP, "/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/BonusApp.app");
		dc.setCapability(MobileCapabilityType.UDID, "E11C009C-3D7B-4596-90EC-8D37EF68F7ED");
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		//Common for all
		Thread.sleep(3000);
		driver.quit();
		service.stop();
	}
}
