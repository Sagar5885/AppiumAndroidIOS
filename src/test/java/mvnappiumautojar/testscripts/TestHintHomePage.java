package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.offset.PointOption;

public class TestHintHomePage {

	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium.log")));
		
		service.start();
		
		//File app = new File(System.getProperty("user.dir") + "/apps/HintMDPatientApp.apk");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		//dc.setCapability("app", app.getAbsolutePath());
		dc.setCapability("appPackage", "com.hintmd.patientapp");
		dc.setCapability("appActivity", ".activities.MainActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String text = "Let's Get Connected!";
		Boolean b = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")").isDisplayed();
		if(b.equals(true)) {
			System.out.println("This line is present on home page: "+text);
		}
		
		//TODO: NOT WORKING NEED TO FIGUER IT OUT WHY?
//		driver.findElement(By.id("login_digit_1_field")).sendKeys("4");
//		driver.findElement(By.id("login_digit_2_field")).sendKeys("0");
//		driver.findElement(By.id("login_digit_3_field")).sendKeys("8");
//		driver.findElement(By.id("login_digit_4_field")).sendKeys("6");
//		driver.findElement(By.id("login_digit_5_field")).sendKeys("7");
//		driver.findElement(By.id("login_digit_6_field")).sendKeys("8");
//		driver.findElement(By.id("login_digit_7_field")).sendKeys("3");
//		driver.findElement(By.id("login_digit_8_field")).sendKeys("4");
//		driver.findElement(By.id("login_digit_9_field")).sendKeys("9");
//		driver.findElement(By.id("login_digit_10_field")).sendKeys("3");
				
		TouchAction action1 = new TouchAction(driver).longPress(new PointOption().withCoordinates(200, 1752));//4
		TouchAction action2 = new TouchAction(driver).longPress(new PointOption().withCoordinates(500, 1975));//0
		TouchAction action3 = new TouchAction(driver).longPress(new PointOption().withCoordinates(500, 1875));//8
		TouchAction action4 = new TouchAction(driver).longPress(new PointOption().withCoordinates(200, 1550));//1
		TouchAction action5 = new TouchAction(driver).longPress(new PointOption().withCoordinates(900, 1875));//9
		
		MultiTouchAction multiTouch = new MultiTouchAction(driver);
		multiTouch.add(action1);
		multiTouch.perform();
		
		MultiTouchAction multiTouch2 = new MultiTouchAction(driver);
		multiTouch2.add(action2);
		multiTouch2.perform();
		
		MultiTouchAction multiTouch3 = new MultiTouchAction(driver);
		multiTouch3.add(action3);
		multiTouch3.perform();
		
		MultiTouchAction multiTouch4 = new MultiTouchAction(driver);
		multiTouch4.add(action4);
		multiTouch4.perform();
		
		MultiTouchAction multiTouch5 = new MultiTouchAction(driver);
		multiTouch5.add(new TouchAction(driver).longPress(new PointOption().withCoordinates(200, 1550)));
		multiTouch5.perform();
		
		MultiTouchAction multiTouch6 = new MultiTouchAction(driver);
		multiTouch6.add(new TouchAction(driver).longPress(new PointOption().withCoordinates(200, 1550)));
		multiTouch6.perform();
		
		MultiTouchAction multiTouch7 = new MultiTouchAction(driver);
		multiTouch7.add(action5);
		multiTouch7.perform();
		
		MultiTouchAction multiTouch8 = new MultiTouchAction(driver);
		multiTouch8.add(new TouchAction(driver).longPress(new PointOption().withCoordinates(900, 1875)));
		multiTouch8.perform();
		
		MultiTouchAction multiTouch9 = new MultiTouchAction(driver);
		multiTouch9.add(new TouchAction(driver).longPress(new PointOption().withCoordinates(900, 1875)));
		multiTouch9.perform();
		
		MultiTouchAction multiTouch10 = new MultiTouchAction(driver);
		multiTouch10.add(new TouchAction(driver).longPress(new PointOption().withCoordinates(900, 1875)));
		multiTouch10.perform();
				
		//TODO: NOT WORKING NEED TO FIGUER OUT WHY?
		new MultiTouchAction(driver).add(action1).add(action2).add(action3).add(action4).add(action4).add(action4)
		.add(action5).add(action5).add(action5).add(action5).perform();
		
		Thread.sleep(1000);
		
		Boolean b1 = driver.findElement(By.id("com.hintmd.patientapp:id/login_send_button")).isDisplayed();
		if(b1.equals(true)) {
			System.out.println("After enter phone no SEND Button Appear!");
		}
		
		Thread.sleep(2000);
		driver.quit();
		service.stop();
	}
}
