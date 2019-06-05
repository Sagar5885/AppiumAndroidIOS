package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestDialingNumbers {

	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
	public static boolean isElementPresent(String id){
		
		try{
		driver.findElement(By.id(id));
		return true;
		}catch(Throwable t){
			
			return false;
		}
	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium.log")));
		
		service.start();
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.findElement(By.id("com.android.contacts:id/two")).click();
		driver.findElement(By.id("com.android.contacts:id/three")).click();
		driver.findElement(By.id("com.android.contacts:id/five")).click();
		driver.findElement(By.id("com.android.contacts:id/two")).click();
		driver.findElement(By.id("com.android.contacts:id/four")).click();
		driver.findElement(By.id("com.android.contacts:id/seven")).click();
		driver.findElement(By.id("com.android.contacts:id/dialButton")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
		service.stop();
	
}
	
}
