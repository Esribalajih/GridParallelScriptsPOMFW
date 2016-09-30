package com.esri.test.auto.pages;

import org.openqa.selenium.By;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Esri Accounts - Sign in Page of IAM Application
 * 
 * @author udhayaundar
 *
 */
public class SigninPage extends ESRIWrappers {

	public SigninPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("Esri Accounts")) {
			Reporter.reportStep("This is not a login page", "FAIL");
		}
	}

	// Enter the UserName
	public SigninPage enterUserName(String userdata) throws Throwable {
		switchToFrameByIndex(0);
		enterbyId(prop.getProperty("Signin.username.Id"), userdata);
		return this;
	}

	// Enter the Password
	public SigninPage enterPassword(String pwd) throws Throwable {
		enterbyId(prop.getProperty("Signin.password.Id"), pwd);
		return this;
	}

	// Click Sign in button positive scenario
	public HomePage clickSignin() throws Throwable {
		clickById(prop.getProperty("Signin.Signinbtn.Id"));
		return new HomePage();
	}
	
	// Click Sign in button positive scenario
		public MyEsriPage clickSigninMyEsri() throws Throwable {
			clickById(prop.getProperty("Signin.Signinbtn.Id"));
			return new MyEsriPage();
		}

	// Click Sign in button negative scenario
	public SigninPage clickSigninforFailure() throws Throwable {
		clickById(prop.getProperty("Signin.Signinbtn.Id"));
		return this;
	}

	// Click facebook Sign in button
	public FacebookSigninPage clickFacebooklink() throws Throwable {
		try {
			switchToFrameByIndex(0);
			clickById(prop.getProperty("Signin.loginFacebook.Id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FacebookSigninPage();
	}

	// Click google Sign in button
	public GoogleSigninPage clickGooglelink() throws Throwable {
		try {
			switchToFrameByIndex(0);
			clickById(prop.getProperty("Signin.loginGoogle.Id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GoogleSigninPage();
	}
	
	//click create account button
	public CreateAccountPage clickCreateAccount() throws Throwable{
		try {
			clickById(prop.getProperty("createAcc.menu.Id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CreateAccountPage();
	}
	
	// Verify the error message
	public SigninPage verifyErrorMessage(String errorMessage) throws Throwable{
		System.out.println("Error Message: "+driver.findElement(By.id(prop.getProperty("homePage.errorMessage.id"))).getText()+" status :"
				+ driver.findElement(By.id(prop.getProperty("homePage.errorMessage.id"))).getText().equalsIgnoreCase(errorMessage));
		VerifyTextbyId(prop.getProperty("homePage.errorMessage.id"), errorMessage);
		return this;
	}
	
}
