package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Sigin Page of ESRI Application
 * 
 * @author balajih
 *
 */
public class FacebookSigninPage extends ESRIWrappers {

	public FacebookSigninPage() throws Throwable {
		waitForPageLoad(5);
		System.out.println("Log in to Facebook | Facebook");
		if (!VerifyTitle("Log in to Facebook | Facebook")) {
			Reporter.reportStep("This is not a login page", "FAIL");
		}
	}

	// Enter the UserName
	public FacebookSigninPage enterUserName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			switchToWindow();
			System.out.println("Window switched");
			enterbyId(prop.getProperty("fbSignin.userName.id"), userdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	// Enter the Password
	public FacebookSigninPage enterPassword(String pwd) throws Throwable {
		try {
			enterbyId(prop.getProperty("fbSignin.password.id"), pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	// Click Sign in button positive scenario
	public HomePage clickLoginBtn() throws Throwable {
		try {
			clickByName(prop.getProperty("fbSignin.loginBtn.name"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
	}

	
	
	
}
