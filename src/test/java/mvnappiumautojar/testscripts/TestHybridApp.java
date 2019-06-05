package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestHybridApp {

	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium.log")));
		
		service.start();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android");
		dc.setCapability("appPackage", "com.html5test.webview");
		dc.setCapability("appActivity", "main.java.MainActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.html5test.webview:id/et")).clear();
		
		driver.findElement(By.id("com.html5test.webview:id/et")).sendKeys("http://google.com");
		
		driver.findElement(By.id("com.html5test.webview:id/go")).click();
		
		Thread.sleep(3000);
		Set<String> contextNames = driver.getContextHandles();
		Thread.sleep(3000);
		for(String context: contextNames){			
			System.out.println(context);
		}
		
		driver.context("WEBVIEW_com.html5test.webview");
		driver.findElement(By.id("lst-ib")).sendKeys("Inside webview !!!");
		
		
		Thread.sleep(3000);
		driver.quit();
		service.stop();
	}
}
