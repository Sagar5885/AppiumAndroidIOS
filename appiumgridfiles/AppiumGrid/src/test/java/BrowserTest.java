

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class BrowserTest {
	

	AndroidDriver driver;	
	
	public static String firstDeviceName="192.168.1.5:5555";//4.3 - chrome - Real Device
	public static String SecondDeviceName="3204d84f4c9c71dd";//4.4.2 - Chrome - Real Device
	
	@BeforeClass
	@Parameters({"port","deviceID"})
	public void startTime(String port1,String device_id) throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if(device_id.equalsIgnoreCase(firstDeviceName)){
			System.out.println(port1 + "-" + System.currentTimeMillis());
			System.out.println(device_id + "-" + System.currentTimeMillis());
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("deviceName",firstDeviceName);
			capabilities.setCapability("udid", firstDeviceName);
			capabilities.setCapability("platformVersion", "8.0");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		
		}else if(device_id.equalsIgnoreCase(SecondDeviceName)){
			System.out.println(port1 + "-" + System.currentTimeMillis());
			System.out.println(device_id + "-" + System.currentTimeMillis());
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("deviceName",SecondDeviceName);
			capabilities.setCapability("udid", SecondDeviceName);
			capabilities.setCapability("platformVersion", "8.1");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		
		}

		driver=new AndroidDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}


	@Test
	public void testcase() throws InterruptedException
	{
		
		driver.get("http://google.com/");
		System.out.println("URL Opened  :-"+driver.getSessionId());
		driver.findElement(By.name("q")).sendKeys("Hello Appium");
		//driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		

	}


@AfterClass
public void TearDown()
{
	driver.quit();
}

}
