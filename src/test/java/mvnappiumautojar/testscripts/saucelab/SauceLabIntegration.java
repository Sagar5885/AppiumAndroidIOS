package mvnappiumautojar.testscripts.saucelab;

import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class SauceLabIntegration {

    private AppiumDriver driver;
	public static final String sauceUserName = "sagardodia";
	public static final String sauceAccessKey = "c978dd02-e2ab-42e2-8bde-782300f73ccc";
	public static final String URL = "http://"+sauceUserName+":"+sauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub";

    private List<Integer> values;

    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 10;

   

    @BeforeClass
    public void setUp() throws Exception {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.3");
//		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//        capabilities.setCapability("appiumVersion", "1.2.2");
//        capabilities.setCapability("app", "http://appium.s3.amazonaws.com/TestApp6.0.app.zip");

        capabilities.setCapability("app", "/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/BonusApp.app");
        
        this.driver = new IOSDriver(new URL(URL), capabilities);
      
        Thread.sleep(20000);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    private void populate() {
        //populate text fields with two random number
        List<WebElement> elems = driver.findElementsByClassName("UIATextField");
        Random random = new Random();
        for (WebElement elem : elems) {
            int rndNum = random.nextInt(MAXIMUM - MINIMUM + 1) + MINIMUM;
            elem.sendKeys(String.valueOf(rndNum));
            values.add(rndNum);
        }
    }

    @Test
    public void testUIComputation() throws Exception {

       /* // populate text fields with values
        populate();
        // trigger computation by using the button
        WebElement button = driver.findElementByClassName("UIAButton");
        button.click();
        // is sum equal ?
        WebElement texts = driver.findElementByClassName("UIAStaticText");
    */   // assertEquals(String.valueOf(values.get(0) + values.get(1)), texts.getText());
    }

    
}