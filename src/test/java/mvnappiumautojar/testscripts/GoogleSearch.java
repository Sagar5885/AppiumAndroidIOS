package mvnappiumautojar.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import mvnappiumautojar.session.BaseClass;

public class GoogleSearch extends BaseClass{

	@Test
	public void searchKey() {
		getDriver().findElement(By.name("q")).sendKeys("Sagar");
	}
}
