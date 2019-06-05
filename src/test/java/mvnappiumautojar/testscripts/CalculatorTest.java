package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
	
	
	public static AppiumDriver driver;
	public WebElement frameLayout;
	
	
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		
DesiredCapabilities capabilites = new DesiredCapabilities();
		
		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "GT-N7100");
		capabilites.setCapability("platformVersion", "4.4.3");
		capabilites.setCapability("platformName", "Android");
		
		capabilites.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		capabilites.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		frameLayout = driver.findElement(By.className("android.widget.FrameLayout"));
		
		
			
	}
	
	@Test(priority = 1)
	public void add(){
		
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		String text = frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
		//System.out.println(text);
		
		String calc[] = text.split(". Editing.");
		//System.out.println(calc[0]);
		
			String actual_num[] = calc[0].split("=");
			System.out.println(actual_num[1]);
			
			Assert.assertEquals(actual_num[1], "12");
	
	}
	
	
	@Test(priority = 2)
	public void sub(){
		
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		String text = frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();

		String calc[] = text.split(". Editing.");
		//System.out.println(calc[0]);
		
			String actual_num[] = calc[0].split("=");
			System.out.println(actual_num[1]);
			Assert.assertEquals(actual_num[1], "2");
	}
	
	@Test(priority = 3)
	public void mult(){
		
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_mul")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		String text = frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();

		String calc[] = text.split(". Editing.");
		//System.out.println(calc[0]);
		
			String actual_num[] = calc[0].split("=");
			System.out.println(actual_num[1]);
	
			Assert.assertEquals(actual_num[1], "12");
		
	}
	
	@Test(priority = 4)
	public void div(){
		
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_div")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
		frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		String text = frameLayout.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();

		String calc[] = text.split(". Editing.");
		//System.out.println(calc[0]);
	
		String actual_num[] = calc[0].split("=");
		System.out.println(actual_num[1]);
		Assert.assertEquals(actual_num[1], "1");
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}

}
