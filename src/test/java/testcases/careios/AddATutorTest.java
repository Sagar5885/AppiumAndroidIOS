package testcases.careios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import screens.careios.CreateAccountScreen;
import utility.TestUtil;

public class AddATutorTest extends TestBase{
	
	CreateAccountScreen ca;
	@BeforeTest
	public void init(){
		ca = new CreateAccountScreen(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), ca);
	}
	
	
	@Test(dataProvider="getData")
	public void AddATutor(String email,String password,String firstName,String lastName,String birthDay) throws InterruptedException{
		Thread.sleep(5000);
		ca.addInformation(email, password, firstName, lastName);
	}
	
	@DataProvider
	public static Object[][] getData() {
		return TestUtil.getData("AddATutorTest");
	}
}
