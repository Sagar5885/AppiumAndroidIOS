package mvnappiumautojar.testscripts.saucelab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleSauceTest {
	
	public static final String sauceUserName = "sagardodia";
	public static final String sauceAccessKey = "c978dd02-e2ab-42e2-8bde-782300f73ccc";
	public static final String URL = "http://"+sauceUserName+":"+sauceAccessKey+"ondemand.saucelabs.com:80/wd/hub";
	public static String id;
	
	@Test
	public static void main() {
		System.setProperty("webdriver.chrome.driver", "/Users/sagardodia/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://saucelabs.github.io/training-test-page/");
	}
	
}
