package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the ArcGIS MainPage Page of IAM Application
 * 
 * @author Udhayasundar S
 *
 */
public class ArcGIS_MainPage extends ESRIWrappers {

	public ArcGIS_MainPage() throws Throwable {
		waitForPageLoad(15);
		System.out.println("ArcGIS | Main");
		if (!VerifyTitle("ArcGIS | Main")) {
			Reporter.reportStep("This is not a ArcGIS | Main page", "FAIL");
		}
	}

	// Click Sign in Link in ArcGIS Main Page
	public ArcGIS_SignInPage clickSignInLink() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("arcGISMain.SignInBtn.xpath"));
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ArcGIS_SignInPage();
	}

	
	
	
}
