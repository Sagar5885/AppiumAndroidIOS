package mvnappiumautojar.testscripts.pagefactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageFactoryTest {

	public AndroidDriver driver;
	public File app = new File(System.getProperty("user.dir")+"/apps/selendroid-test-app-0.17.0.apk");
		
	@AndroidFindBy(id="io.selendroid.testapp:id/my_text_field")
	public WebElement textField; 
	@AndroidFindBy(id="io.selendroid.testapp:id/visibleButtonTest")
	public WebElement displayBtn; 
	@AndroidFindBy(id="io.selendroid.testapp:id/visibleTextView")
	public WebElement displayTxt; 
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> button;
	@AndroidFindBy(id="io.selendroid.testapp:id/buttonStartWebview")
	public WebElement imgBtn;
	
	@AndroidFindBys({
		@AndroidBy(id="android:id/content"),
		@AndroidBy(id="android:id/parentPanel"),
		@AndroidBy(id="android:id/customPanel"),
		@AndroidBy(id="android:id/custom"),
		@AndroidBy(uiAutomator="new UiSelector().testContains(\"iframes\")"),
		@AndroidBy(className="android.widget.ListView"),
		@AndroidBy(className="android.widget.TextView"),
		})
	public List<WebElement> cars;
	
	@BeforeTest
	public void setUp() throws MalformedURLException{
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("device", "Android");
	        capabilities.setCapability("deviceName", "Android");
//	        capabilities.setCapability("platformVersion", "4.4.2");
	        capabilities.setCapability("platformName","Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			
	       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	       driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	}
	
	@Test
	public void doTesting(){
//		PageFactory.initElements(new AppiumFieldDecorator(driver,20,TimeUnit.SECONDS), this);
		PageFactory.initElements(driver, this);
			
		textField.sendKeys("Rahul");
		displayBtn.click();
		System.out.println(displayTxt.getText());
		System.out.println("Total buttons are : "+button.size());
		imgBtn.click();
		System.out.println(driver.getPageSource());
		button.get(1).click();
		cars.get(1).click();
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();		
	}
}
