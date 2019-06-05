package screens.careios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomeScreen extends ScreenBase {
	
	
	
	
	@iOSFindBy(accessibility="Sign up with Email")
	public WebElement signUpEmail;
	
	@iOSFindBy(accessibility="Sign Up with Facebook")
	public WebElement signUpFB;


	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	
	
	
	public GetStartedScreen signUpWithFacebook(){
		
		signUpFB.click();
		
		return new GetStartedScreen(driver);
	}
	
	
	public GetStartedScreen signUpWithEmail(){
		
		signUpEmail.click();
		
		return new GetStartedScreen(driver);
		//hideKeyboard();
	
	}
	
	
	public void signInToMyAccount(){
		
		
	}
	
	

}
