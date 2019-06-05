package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FlipboardSwips {

public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName","Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage", "flipboard.app");
		capabilities.setCapability("appActivity", "flipboard.activities.LaunchActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		List<WebElement> wbs = driver.findElements(By.id("flipboard.app:id/coverStoryContainer"));
		wbs.get(0).click();
		
		TouchAction touchAction = new TouchAction(driver);
		for(int i=0;i<3;i++) {
			touchAction.press(new PointOption().withCoordinates(420, 1264))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			.moveTo(new PointOption().withCoordinates(420, 758))
			.release()
			.perform();
		}
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		//All bellow is deprecated swipe, sendkeyEvent and equivalent to above touchAction and pressKey
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		
		clickLayout(0);
		swipeSendKeyEventWithNewTouchActionAndPressKeyAsObject();
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		clickLayout(1);
		swipeSendKeyEventWithNewTouchActionAndPressKeyAsObject();
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		
		clickLayout(2);
		swipeSendKeyEventWithNewTouchActionAndPressKeyAsObject();
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		
		clickLayout(3);
		swipeSendKeyEventWithNewTouchActionAndPressKeyAsObject();
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.swipe(420, 1264, 420, 758, 1000);
//		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		
}
	public static void clickLayout(int x){
		WebElement flipboard =driver.findElement(By.id("flipboard.app:id/tilesContainer"));
		List<WebElement> frameLayout = flipboard.findElements(By.className("android.widget.FrameLayout"));
		frameLayout.get(x).click();
	}
	
	public static void swipeSendKeyEventWithNewTouchActionAndPressKeyAsObject() {
		TouchAction touchAction = new TouchAction(driver);
		for(int i=0;i<3;i++) {
			touchAction.press(new PointOption().withCoordinates(420, 1264))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			.moveTo(new PointOption().withCoordinates(420, 758))
			.release()
			.perform();
		}
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
}