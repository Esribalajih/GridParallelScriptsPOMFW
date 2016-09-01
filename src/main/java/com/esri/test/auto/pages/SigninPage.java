package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is the Sigin Page of ESRI Application
 * @author balajih
 *
 */
public class SigninPage extends ESRIWrappers{

	public SigninPage() throws Throwable {
		if(!VerifyTitle("Esri Accounts")){
			Reporter.reportStep("This is not a login page", "FAIL");
		}
	}
	
	//Enter the UserName
	public SigninPage enterUserName(String userdata) throws Throwable{
		enterbyId(prop.getProperty("Signin.username.Id"),userdata);
		return this;
	}
	
	//Enter the Password
	public SigninPage enterPassword(String pwd) throws Throwable{
		enterbyId(prop.getProperty("Signin.password.Id"),pwd);
		return this;
	}
	
	//Click Sign in button positive scenario
	public HomePage clickSignin() throws Throwable{
		clickById(prop.getProperty("Signin.Signinbtn.Id"));
		return new HomePage();
	}
	
	//Click Sign in button negative scenario
		public SigninPage clickSigninforFailure() throws Throwable{
			clickById(prop.getProperty("Signin.Signinbtn.Id"));
			return this;
		}
		// Click facebook Sign in button
		public FacebookSigninPage clickFacebooklink() throws Throwable {
			try {
				switchToFrameByID(prop.getProperty("signin.loginFrame.Id"));
				clickById(prop.getProperty("Signin.loginFacebook.Id"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new FacebookSigninPage();
		}

		// Click google Sign in button
		public GoogleSigninPage clickGooglelink() throws Throwable {
			try {
				switchToFrameByID(prop.getProperty("signin.loginFrame.Id"));
				clickById(prop.getProperty("Signin.loginGoogle.Id"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new GoogleSigninPage();
		}
		
		public CreateAccountPage clickCreateAccount() throws Throwable{
			try {
				clickById(prop.getProperty("createAcc.menu.Id"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new CreateAccountPage();
		}
		
}
