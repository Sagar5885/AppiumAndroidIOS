package screens.care;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TypeOfCareJobScreen extends ScreenBase{
	
	@AndroidFindBy(uiAutomator ="new UiSelector().text(\"Tutor\")")
	public WebElement tutor;

	public TypeOfCareJobScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public CreateAccountScreen selectTypeOfCareJobAsTutor() {
		tutor.click();
		return new CreateAccountScreen(driver);
	}
}
