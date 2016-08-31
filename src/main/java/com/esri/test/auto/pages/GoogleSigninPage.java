package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Sigin Page of ESRI Application
 * 
 * @author balajih
 *
 */
public class GoogleSigninPage extends ESRIWrappers {

	public GoogleSigninPage() throws Throwable {
		waitForPageLoad(5);
		System.out.println("Sign in - Google Accounts");
		if (!VerifyTitle("Sign in - Google Accounts")) {
			Reporter.reportStep("This is not a login page", "FAIL");
		}
	}

	// Enter the UserName
	public GoogleSigninPage enterUserName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			switchToWindow();
			System.out.println("Window switched");
			enterbyId(prop.getProperty("gleSignin.userName.id"), userdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	
	// Enter the UserName
		public GoogleSigninPage clickNextBtn() throws Throwable {
			waitForPageLoad(5);
			try {
				clickById(prop.getProperty("gleSignin.nextBtn.id"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		}
	
	// Enter the Password
	public GoogleSigninPage enterPassword(String pwd) throws Throwable {
		try {
			enterbyId(prop.getProperty("gleSignin.password.id"), pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	// Click Sign in button positive scenario
	public HomePage clickSignInBtn() throws Throwable {
		try {
			clickById(prop.getProperty("gleSignin.signInBtn.id"));
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
	}

	
	
	
}
