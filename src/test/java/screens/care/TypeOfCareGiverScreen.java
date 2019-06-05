package screens.care;

import org.openqa.selenium.support.PageFactory;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TypeOfCareGiverScreen extends ScreenBase {
	
	public TypeOfCareGiverScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void selectTypeOfCare(String care){
	}

}
