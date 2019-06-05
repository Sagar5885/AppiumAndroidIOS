package mvnappiumautojar.testscripts;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileDriverIOSTest {

	  private AppiumDriver driver;
	  public static AppiumDriverLocalService service;
	  
	  private List<Integer> values;
	  
	    private static final int MINIMUM = 0;
	    private static final int MAXIMUM = 10;
	    
	    private static Point getCenter(WebElement element) {

		      Point upperLeft = element.getLocation();
		      Dimension dimensions = element.getSize();
		      return new Point(upperLeft.getX() + dimensions.getWidth()/2, upperLeft.getY() + dimensions.getHeight()/2);
		    }

	  @BeforeTest
	  public void setup() throws Exception {
		  
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/logs/Appium.log")));
		
		service.start();
			
	    DesiredCapabilities dc = new DesiredCapabilities();
	    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Sagar’s iPhone (12.1)");		
		dc.setCapability(MobileCapabilityType.APP, "/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/TestApp.app");
	    dc.setCapability("udid","3cca4f92cad4cf28263fb3f5748582ff11afb2c7");
	   	dc.setCapability("automationName", "Appium");
	   	
//	   	DesiredCapabilities dc = new DesiredCapabilities();		
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xʀ (12.2)");		
//		dc.setCapability(MobileCapabilityType.APP, "/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/TestApp.app");
//		dc.setCapability(MobileCapabilityType.UDID, "E11C009C-3D7B-4596-90EC-8D37EF68F7ED");
	    
	    System.out.println("test previous");
	    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
	   // System.out.println("test");
	  }

	  @AfterTest
	  public void tearDown() throws Exception {
		  Thread.sleep(3000);
		  driver.quit();
		  service.stop();
	  }

	  @Test
	  public void resetTest() {
		//  driver.findElement(By.name("TextField1")).sendKeys("7");
          WebElement slider = driver.findElement(By.xpath("//UIASlider[1]"));
       //   assertEquals("50%", slider.getAttribute("value"));
          Point sliderLocation = getCenter(slider);
          System.out.println(sliderLocation);
          TouchAction touchAction = new TouchAction(driver);
          touchAction.press(new PointOption().withCoordinates(sliderLocation.getX(), sliderLocation.getY()))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			.moveTo(new PointOption().withCoordinates(sliderLocation.getX()+100, sliderLocation.getY()))
			.release()
			.perform();
          
          //driver.swipe(sliderLocation.getX(), sliderLocation.getY(), sliderLocation.getX()+100, sliderLocation.getY(), 1000);
          System.out.println(sliderLocation);
	  }
}
	