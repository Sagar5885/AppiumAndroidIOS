package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestNativeElements {
	
	public static AndroidDriver driver;
	
	public static boolean isElementPresent(String id){
			
			try{
			driver.findElement(By.id(id));
			return true;
			}catch(Throwable t){
				
				return false;
			}
		}

	public static AppiumDriverLocalService service;
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium.log")));
		
		service.start();
		
		//File app = new File(System.getProperty("user.dir")+"/apps/FastAdapter.apk");
		File app = new File(System.getProperty("user.dir") + "/apps/drag.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//TODO:
		
		if(driver.isDeviceLocked()){		
			driver.unlockDevice();
		}

		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Hello Appium !!!");
		driver.hideKeyboard();
		
		System.out.println(driver.findElements(By.className("android.widget.Button")).size());
		List<MobileElement> btn = driver.findElements(By.className("android.widget.Button"));
		for(MobileElement button:btn){
			if(button.getAttribute("text").contains("Display text view")){
				button.click();
			}
		}
		
		driver.openNotifications();
	
		if(isElementPresent("com.android.systemui:id/clear_button")){
			driver.findElement(By.id("com.android.systemui:id/clear_button")).click();
		}
		
		Thread.sleep(4000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.closeApp();
		driver.removeApp("io.selendroid.testapp");
		Thread.sleep(10000);
		
		System.out.println("Status of App installation : "+driver.isAppInstalled("io.selendroid.testapp"));
		Activity activity = new Activity("io.selendroid.testapp", ".HomeScreenActivity");
		if(!driver.isAppInstalled("io.selendroid.testapp")){
			driver.installApp("/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/selendroid-test-app-0.17.0.apk");
			driver.startActivity(activity); //switching the apps - selendroid test app, message app
		}
		
		Thread.sleep(3000);
		driver.quit();
		service.stop();
	}
}
