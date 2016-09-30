package com.esri.test.auto.pages;

import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Facebook Signin Page of IAM Application
 * 
 * @author udhayasundar
 *
 */
public class FacebookSigninPage extends ESRIWrappers {

	public FacebookSigninPage() throws Throwable {
		waitForPageLoad(10);
		switchToWindow();
		/*
		 * if (VerifyTitle("Log in to Facebook | Facebook")||VerifyTitle(
		 * "Log into Facebook | Facebook")) { Reporter.reportStep(
		 * "Log into Facebook | Facebook - login page", "PASS"); } else{
		 * Reporter.reportStep("This is not a login page", "FAIL"); }
		 */
		System.out.println("Log into Facebook | Facebook");
	}

	// Enter the UserName
	public FacebookSigninPage enterUserName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			// switchToWindow();
			System.out.println("Window switched");
			enterbyId(prop.getProperty("fbSignin.userName.id"), userdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Enter the Password
	public FacebookSigninPage enterPassword(String pwd) throws Throwable {
		try {
			enterbyId(prop.getProperty("fbSignin.password.id"), pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click Sign in button
	public HomePage clickLoginBtn() throws Throwable {
		try {
			clickByName(prop.getProperty("fbSignin.loginBtn.name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HomePage();
	}

}
