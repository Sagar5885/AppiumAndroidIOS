package screens.careios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class TypeOfCareGiver extends ScreenBase {
	
	
	@iOSFindBy(xpath="//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText")
	public WebElement tutor;
	
	
	
	public TypeOfCareGiver(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		// TODO Auto-generated constructor stub
	}

	

	
	/*public String getCareTypeHeader(){
		
		waitForElementPresent(10,"com.care.android.careview:id/providerServicesHeaderText");
		wait.until(ExpectedConditions.)
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.care.android.careview:id/providerServicesHeaderText")));
		
		return headerText.getText();
		
	}
	*/
	public void selectTypeOfCare(){
		
		tutor.click();
		
	}

}
