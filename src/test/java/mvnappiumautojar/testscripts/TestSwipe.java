package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TestSwipe {

	public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");

		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Shoes");

		driver.pressKeyCode(AndroidKeyCode.ENTER);

		List<MobileElement> names = driver.findElements(By.id("in.amazon.mShop.android.shopping:id/item_title"));

		try {
			while (true) {

				for (MobileElement name : names) {

					if (name.getText().startsWith("Columbus")) {

						name.click();
						break;
					}

				}

				//driver.swipe(500, 1900, 500, 200, 5000);
				//TODO:
				/***
				 * (new TouchAction(driver))
                .press(PointOption.point(fromX, fromY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(offsetX, offsetY))
                .release()
                .perform();
				 */
			}
		} catch (Throwable t) {

		}

		Thread.sleep(4000);
		driver.quit();
	}
}
