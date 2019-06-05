package com.studio.test;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleIOSTest {
	
	@Test
	public void testSimpleTest() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X (12.2)");
		dc.setCapability(MobileCapabilityType.UDID, "7378B9D5-422F-4040-B514-17A8BE342E98");
		dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/BonusApp.app");
		
		AppiumDriver<MobileElement> appium = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		appium.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}
