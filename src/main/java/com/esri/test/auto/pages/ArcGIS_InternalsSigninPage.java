package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the ArcGIS Internals Signin Page of IAM Application
 * 
 * @author Udhayasundar S
 *
 */
public class ArcGIS_InternalsSigninPage extends ESRIWrappers {

	public ArcGIS_InternalsSigninPage() throws Throwable {
		waitForPageLoad(5);
		System.out.println("ArcGIS.com - For Internal Users Only");
		if (!VerifyTitle("ArcGIS.com - For Internal Users Only")) {
			Reporter.reportStep("This is not a ArcGIS.com - For Internal login page", "FAIL");
		}
	}

	// Enter the UserName
	public ArcGIS_InternalsSigninPage enterUserName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			enterbyId(prop.getProperty("arcGISInt.userName.id"), userdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Enter the Password
	public ArcGIS_InternalsSigninPage enterPassword(String pwd) throws Throwable {
		try {
			enterbyId(prop.getProperty("arcGISInt.password.id"), pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click Sign in button to login
	public ArcGIS_MainPage clickSignInBtn() throws Throwable {
		try {
			clickById(prop.getProperty("arcGISInt.signInBtn.id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArcGIS_MainPage();
	}

}
