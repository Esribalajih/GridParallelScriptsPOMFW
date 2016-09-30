package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Google Signin Page of IAM Application
 * 
 * @author udhayasundar
 *
 */
public class GoogleSigninPage extends ESRIWrappers {

	public GoogleSigninPage() throws Throwable {
		waitForPageLoad(5);
		switchToWindow();
		if (!VerifyTitle("Sign in - Google Accounts")) {
			Reporter.reportStep("This is not a login page", "FAIL");
		}
		System.out.println("Sign in - Google Accounts");
	}

	// Enter the UserName
	public GoogleSigninPage enterUserName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			// switchToWindow();
			enterbyId(prop.getProperty("gleSignin.userName.id"), userdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click next button after entering the user name
	public GoogleSigninPage clickNextBtn() throws Throwable {
		waitForPageLoad(5);
		try {
			clickById(prop.getProperty("gleSignin.nextBtn.id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Enter the Password
	public GoogleSigninPage enterPassword(String pwd) throws Throwable {
		try {
			waitForPageLoad(3);
			enterbyId(prop.getProperty("gleSignin.password.id"), pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click Sign in button
	public HomePage clickSignInBtn() throws Throwable {
		try {
			clickById(prop.getProperty("gleSignin.signInBtn.id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HomePage();
	}

}
