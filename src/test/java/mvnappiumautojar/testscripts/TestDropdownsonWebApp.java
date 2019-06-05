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
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestDropdownsonWebApp {

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
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("http://wikipedia.org");		
		//driver.manage().deleteAllCookies();
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		select.selectByValue("hi");
		//select.getOptions();

		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		System.out.println(values.size());
		
		for(WebElement value: values){	
			System.out.println(value.getAttribute("lang"));
		}
		
		System.out.println("----Printing links-------");
		WebElement block = driver.findElement(By.cssSelector(".other-projects"));
		List<WebElement> links = block.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement link: links){
			System.out.println(link.getAttribute("href")+"----"+link.getText());
		}
		
		Thread.sleep(3000);
		driver.quit();
		service.stop();
	}
}
