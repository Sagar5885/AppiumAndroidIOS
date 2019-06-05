package screens.careios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CreateAccountScreen extends ScreenBase {

	public CreateAccountScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		// TODO Auto-generated constructor stub
	}

	@iOSFindBy(xpath = "//XCUIElementTypeTextField[@value='Email']")
	public MobileElement em;
	@iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Password (must be at least 6 char)']")
	public MobileElement pass;
	@iOSFindBy(xpath = "//XCUIElementTypeTextField[@value='First Name']")
	public MobileElement fName;
	@iOSFindBy(xpath = "//XCUIElementTypeTextField[@value='Last Name']")
	public MobileElement lName;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField")
	public MobileElement dob;
	@iOSFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
	public MobileElement month;
	@iOSFindBy(xpath = "//XCUIElementTypePickerWheel[2]")
	public MobileElement day;
	@iOSFindBy(xpath = "//XCUIElementTypePickerWheel[3]")
	public MobileElement year;
	@iOSFindBy(accessibility = "Done")
	public MobileElement done;
	@iOSFindBy(accessibility = "NEXT")
	public MobileElement next;

	public void addInformation(String email, String password, String firstName, String lastName) {

		em.sendKeys(email);
		pass.sendKeys(password);
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		dob.click();
		hideKeyboard();
		month.setValue("January");
		day.setValue("14");
		year.setValue("1985");
		done.click();
		next.click();

	}

}
