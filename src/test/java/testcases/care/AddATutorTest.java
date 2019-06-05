package testcases.care;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import screens.care.TypeOfCareJobScreen;

public class AddATutorTest extends TestBase {
	
	TypeOfCareJobScreen careJob;
	
	@BeforeTest
	public void init(){
		careJob = new TypeOfCareJobScreen(driver);
	}
	
	@Test(priority=1)
	public void validateButtons() throws InterruptedException{
		careJob.selectTypeOfCareJobAsTutor().createAccount("testing@test.com", "sdfsfsd", "Rahul", "Arora", "14/01/1985");
	}
}
