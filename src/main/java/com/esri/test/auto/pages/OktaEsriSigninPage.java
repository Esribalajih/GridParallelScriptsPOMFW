package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Esri Staging - Sign In Page of IAM Application
 * 
 * @author udhayasundar
 *
 */
public class OktaEsriSigninPage extends ESRIWrappers {

	public OktaEsriSigninPage() throws Throwable {
		waitForPageLoad(10);
		System.out.println("Esri Staging - Sign In");
		if (!VerifyTitle("Esri Staging - Sign In")) {
			Reporter.reportStep("This is not a login page", "FAIL");
		}
	}

	// Enter the UserName
	public OktaEsriSigninPage enterUserName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			enterbyName(prop.getProperty("okta.userName.name"), userdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

		
	// Enter the Password
	public OktaEsriSigninPage enterPassword(String pwd) throws Throwable {
		try {
			enterbyName(prop.getProperty("okta.password.name"), pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click Sign in button positive scenario and navigate to Home page
	public HomePage clickEsriSignInBtn() throws Throwable {
		try {
			clickbyClassName(prop.getProperty("okta.signInBtn.class"));
			} catch (Exception e) {
			e.printStackTrace();
		}
		return new HomePage();
	}

	// Click Sign in button positive scenario and navigate to CSAT Application
	public CSAT_Staging clickEsriSignInBtnCSAT() throws Throwable {
		try {
			clickbyClassName(prop.getProperty("okta.signInBtn.class"));
			} catch (Exception e) {
			e.printStackTrace();
		}
		return new CSAT_Staging();
	}
	
	
}
