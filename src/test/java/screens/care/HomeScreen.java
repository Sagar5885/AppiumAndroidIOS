package screens.care;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
//import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase {
	
	
	@AndroidFindBys({
		@AndroidBy(id = "com.care.android.careview:id/linearLayout"),
		@AndroidBy(className = "android.widget.TextView")
	})
	public List<AndroidElement> signUpBtn;
	
	@AndroidBy(id="com.care.android.careview:id/sign_up_email")
	public WebElement signUpEmail;
	

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
//		PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS), this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public int validateButtonCount(){
		return signUpBtn.size();
	}
	
	public void signUpWithFacebook(){}
	
	
	public GetStartedScreen signUpWithEmail(){
		signUpEmail.click();
		return new GetStartedScreen(driver);
	}
	
	public void signInToMyAccount(){}

}
