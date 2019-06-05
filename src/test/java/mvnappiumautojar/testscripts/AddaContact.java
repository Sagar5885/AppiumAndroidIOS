package mvnappiumautojar.testscripts;

import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AddaContact {
	public static AppiumDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilites = new DesiredCapabilities();
		
		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "GT-N7100");
		capabilites.setCapability("platformVersion", "4.4.3");
		capabilites.setCapability("platformName", "Android");
		
		capabilites.setCapability("appPackage", "com.android.contacts");
		capabilites.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
				
		WebElement frameLayout = driver.findElement(By.id("android:id/action_bar_container"));
		
		List<WebElement> actionBarTabs = frameLayout.findElements(By.className("android.app.ActionBar$Tab"));
		
		actionBarTabs.get(3).click();
		
		driver.findElement(By.id("com.android.contacts:id/create_button")).click();
		
		List<WebElement> editTxt = driver.findElements(By.className("android.widget.EditText"));
		
		editTxt.get(0).sendKeys("TestAppium1");
		editTxt.get(1).sendKeys("971111155");
		
		driver.findElement(By.id("com.android.contacts:id/menu_done")).click();
	}
}
