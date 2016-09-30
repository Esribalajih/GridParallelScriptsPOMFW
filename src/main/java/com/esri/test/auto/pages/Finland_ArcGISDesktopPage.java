package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 *  This is the Brazil ArcGIS Desktop Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Finland_ArcGISDesktopPage extends ESRIWrappers {
	public Finland_ArcGISDesktopPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("ArcGIS for Desktop")) {
			Reporter.reportStep("This is not a  ArcGIS for Desktop (Finland) page.", "FAIL");
		} else
			System.out.println("Finland ArcGIS for Desktop page Launched Successfully");
	}

	// click back button in browser
	public Finland_HomePage clickbsrBackBtn() throws Throwable {
		try {
			clickBrowserBackButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Finland_HomePage();
	}

	// verify ArcGIS desktop label
	public Finland_ArcGISDesktopPage verifyArcGISDesktoplbl(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disFinlandHome.ArcGISDesktopLbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
