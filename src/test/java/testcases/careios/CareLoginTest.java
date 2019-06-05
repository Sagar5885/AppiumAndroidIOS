package testcases.careios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import screens.careios.HomeScreen;
import screens.careios.TypeOfCareGiver;
import utility.TestUtil;

public class CareLoginTest extends TestBase{
	
	
	
	HomeScreen home;
	TypeOfCareGiver tc;
	
	@BeforeTest
	public void init(){
		
		home = new HomeScreen(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), home);

		tc = new TypeOfCareGiver(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), home);

	}
	
	
	
	@Test(dataProvider="getData")
	public void signUpEmailandSelectACareGiver(String headerText){
		
		
		TypeOfCareGiver tc = home.signUpWithEmail().hireACareGiver();
		tc.selectTypeOfCare();
		
	}
	
	
	@DataProvider
	public static Object[][] getData() {


		return TestUtil.getData("CareLoginTest");

	}

}
