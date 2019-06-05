package testcases.selendroid;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import screens.selendroid.SelendDroidTestScreen;

public class SelendroidScreenTest extends TestBase {
	
	SelendDroidTestScreen sts;
	
	@BeforeTest
	public void init(){
	sts = new SelendDroidTestScreen(driver);
	}
	
	@Test(priority=1)
	public void typeData() throws InterruptedException{	
		sts.typeData("Appium Framework !!!");
	}
}
