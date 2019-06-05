package screens.care;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GetStartedScreen extends ScreenBase{
	
	public GetStartedScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS), this);
	}

	@AndroidFindBy(id="com.care.android.careview:id/seeker_enrollment_layout")
	public WebElement hireACareGiver;
	
	public void hireACareGiver(){	
		hireACareGiver.click();
	}
	
	public void findACareJob(){}

}
