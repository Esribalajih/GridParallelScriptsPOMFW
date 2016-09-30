package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Esri Staging SignIn Page of IAM Application
 * 
 * @author udhayasundar
 *
 */
public class Esri_Staging_SignIn extends ESRIWrappers {

	public Esri_Staging_SignIn() throws Throwable {
		waitForPageLoad(10); 
		if (!VerifyTitle("Esri Staging - Sign In")) {
			Reporter.reportStep("This is not a Esri Staging - Sign In page", "FAIL");
			System.out.println("This is not a Esri Staging - Sign In page");
		}
		System.out.println("Esri Staging - Sign In");
	}

	// Enter the UserName
	public Esri_Staging_SignIn enterUserName(String userdata) throws Throwable {
		//enterbyName(prop.getProperty("okta.userName.name"), userdata);
		enterbyId(prop.getProperty("okta.userName.id"), userdata);
		return this;
	}

	// Enter the Password
	public Esri_Staging_SignIn enterPassword(String pwd) throws Throwable {
		//enterbyName(prop.getProperty("okta.password.name"), pwd);
		enterbyId(prop.getProperty("okta.password.id"), pwd);
		return this;
	}

	// Click Sign in button
	public void clickSignin() throws Throwable {
		clickbyClassName(prop.getProperty("okta.signInBtn.class"));
//		return new CSAT_Staging();
	}
	
	// Click My ESRI Sign in button 
		public MyEsriPage clickSigninMyEsri() throws Throwable {
			clickById(prop.getProperty("Signin.Signinbtn.Id"));
			return new MyEsriPage();
		}

	// Click Sign in button negative scenario
	public Esri_Staging_SignIn clickSigninforFailure() throws Throwable {
		clickById(prop.getProperty("Signin.Signinbtn.Id"));
		return this;
	}

	// Click Facebook Sign in button
	public FacebookSigninPage clickFacebooklink() throws Throwable {
		try {
			switchToFrameByID(prop.getProperty("signin.loginFrame.Id"));
			clickById(prop.getProperty("Signin.loginFacebook.Id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FacebookSigninPage();
	}

	// Click Google Sign in button
	public GoogleSigninPage clickGooglelink() throws Throwable {
		try {
			switchToFrameByID(prop.getProperty("signin.loginFrame.Id"));
			clickById(prop.getProperty("Signin.loginGoogle.Id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GoogleSigninPage();
	}
	
	//Click to create account in ESRI	
	public CreateAccountPage clickCreateAccount() throws Throwable{
		try {
			clickById(prop.getProperty("createAcc.menu.Id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CreateAccountPage();
	}
	
	
}
