package testcases.care;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import screens.care.HomeScreen;
import screens.selendroid.SelendDroidTestScreen;

public class CareLoginTest extends TestBase {
	HomeScreen home;
	
	@BeforeTest
	public void init(){
	home = new HomeScreen(driver);
	}
	
	@Test(priority=1)
	public void validateButtons() throws InterruptedException{
		System.out.println(home.validateButtonCount()+" total buttons");
		Assert.assertEquals(4, home.validateButtonCount());
	}
	
	@Test(priority=2)
	public void SignUpWithEmail(){	
		home.signUpWithEmail().hireACareGiver();
	}	
}
