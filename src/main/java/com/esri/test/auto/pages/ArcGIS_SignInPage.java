package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the ArcGIS SignIn Page of IAM Application
 * 
 * @author Udhayasundar S
 *
 */
public class ArcGIS_SignInPage extends ESRIWrappers {

	public ArcGIS_SignInPage() throws Throwable {
		waitForPageLoad(10);
		System.out.println("ArcGIS - Sign In");
		if (!VerifyTitle("ArcGIS - Sign In")) {
			Reporter.reportStep("This is not a ArcGIS - Sign In page", "FAIL");
		}
	}

	// Enter the UserName
	public ArcGIS_SignInPage enterUserName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			switchToFrameByID(prop.getProperty("arcGISSignIn.signInFrame.id"));
			enterbyId(prop.getProperty("arcGISSignIn.userName.id"), userdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	
	// Enter the Password
	public ArcGIS_SignInPage enterPassword(String pwd) throws Throwable {
		try {
			enterbyId(prop.getProperty("arcGISSignIn.password.id"), pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click Sign in button positive scenario
	public ArcGIS_SignInPage clickSignInBtn() throws Throwable {
		try {
			clickById(prop.getProperty("arcGISSignIn.signInBtn.id"));
			} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	
	public ArcGIS_SignInPage verifyErrorMsg(String message) throws Throwable{
		try{
			waitForPageLoad(2);
			switchToDefaultContent();
			waitForPageLoad(2);
			verifyValuebyXpath(prop.getProperty("arcGISSignIn.signInErrorMsg.xpath"), message);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
	
	public ArcGIS_OnlineSTGPage clickSignInToArcGIS_OnlinePage() throws Throwable {
		try {
			clickById(prop.getProperty("arcGISSignIn.signInBtn.id"));
			} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArcGIS_OnlineSTGPage();
	}
}
