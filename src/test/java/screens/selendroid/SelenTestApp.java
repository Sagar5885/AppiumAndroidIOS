package screens.selendroid;

import java.util.concurrent.TimeUnit;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SelenTestApp {

	public static void main(String[] args) throws Exception {


		SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
		
		WebDriver driver = new SelendroidDriver(capa);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		driver.findElement(By.id("my_text_field")).sendKeys("Hello Selendroid!!!");
		driver.findElement(By.id("visibleButtonTest")).click();
		Assert.assertEquals("Text is sometimes displayed", driver.findElement(By.id("visibleTextView")).getText());
		
		driver.findElement(By.id("buttonStartWebView")).click();
		
		driver.switchTo().window("WEBVIEW");
		
		System.out.println(driver.getPageSource());
		driver.findElement(By.id("name_input")).clear();
		driver.findElement(By.id("name_input")).sendKeys("I am Raman");
		driver.switchTo().window("NATIVE_APP");
		driver.findElement(By.id("spinner_webdriver_test_data")).click();
		
		
		
	}

}
