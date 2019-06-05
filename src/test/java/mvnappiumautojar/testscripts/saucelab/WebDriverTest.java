package mvnappiumautojar.testscripts.saucelab;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverTest {

	private WebDriver driver;
	public static final String sauceUserName = "sagardodia";
	public static final String sauceAccessKey = "c978dd02-e2ab-42e2-8bde-782300f73ccc";
	public static final String URL = "http://"+sauceUserName+":"+sauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub";
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "/Users/sagardodia/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
		capabilities.setCapability("platform", Platform.MAC);
		capabilities.setCapability("version", "70");
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		this.driver = new RemoteWebDriver(new URL(URL), capabilities);
	}
	
	@Test
	public void testGmail() {
		driver.get("http://www.gmail.com/");
		Assert.assertEquals("Gmail", driver.getTitle());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
