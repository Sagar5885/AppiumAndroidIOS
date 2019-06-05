package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class TestDragAndDrop {

	public static AndroidDriver driver;
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
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability("app", app.getAbsolutePath());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		String text = "Tibet China";
//		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")").click();
//		
//		driver.findElement(By.id("com.mikepenz.fastadapter.app:id/item_add")).click();
//		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.mikepenz.fastadapter.app:id/item_image_description")));
		
		String text = "Basic";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")").click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.mobeta.android.demodslv:id/text")));
		
		
		System.out.println(driver.getPageSource());
		
		MobileElement draggable = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Brad')]/preceding-sibling::android.widget.ImageView"));
		MobileElement droppable = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Kurt')]/preceding-sibling::android.widget.ImageView"));
		
		Map<String, Object> result = new HashMap<>();
		result.put("draggable", draggable);
		result.put("droppable", droppable);
		
		PointOption pointOption = new PointOption();
		pointOption.build().putAll(result);
		
		
		TouchAction action = new TouchAction(driver);
		action.tap(pointOption).perform();
//		action.longPress(draggable).moveTo(droppable).release().perform();
		
//		//TODO: These is how touch action works now above way is depricated
//		TouchAction touchAction = new TouchAction(driver);
//		touchAction.tap(PointOption.point(1280, 1013)).perform();
		
		Thread.sleep(3000);
		driver.quit();
		service.stop();
	}
}
