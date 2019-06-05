package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import screens.selendroid.SelendDroidTestScreen;
import utility.AppiumServer;
import utility.CommonUtils;
import utility.ExcelReader;

public class TestBase {

	public static AppiumDriver<MobileElement> driver;
	
	public static String loadPropertyFile = "Android_careapp.properties";
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/properties/testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {
			AppiumServer.start();
			log.debug("Appium server started");

			if (loadPropertyFile.startsWith("IOS")) {

				log.debug("Starting on IOS");
				/*
				 * CommonUtils.loadIOSConfigProp(loadPropertyFile);
				 * CommonUtils.setIOSCapabilities(); driver =
				 * CommonUtils.getIOSDriver();
				 */

			} else if (loadPropertyFile.startsWith("Android")) {

				log.debug("Starting on Android");
				CommonUtils.loadAndroidConfigProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
			}
		}
	}

	@AfterSuite
	public void tearDown() throws IOException {

		driver.quit();
		AppiumServer.stop();

	}

}
