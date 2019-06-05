package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragandDrop {

public static AndroidDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\WAY2AUTOMATION\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		service.start();

		File app = new File(".\\app\\com.mobeta.android.demodslv.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
	
		List<WebElement> element = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));

		//Updated as per the latest 1.8.2 API
		new TouchAction((MobileDriver) driver).press(ElementOption.element(element.get(0))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(ElementOption.element(element.get(3))).release().perform();

		//Code from old API
		//new TouchAction((MobileDriver)driver).longPress((LongPressOptions) element.get(0)).moveTo((PointOption) element.get(3)).release().perform();
		service.stop();
	}
}