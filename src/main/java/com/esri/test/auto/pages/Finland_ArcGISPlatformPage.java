package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 *  This is the Brazil ArcGIS Desktop Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Finland_ArcGISPlatformPage extends ESRIWrappers {
	public Finland_ArcGISPlatformPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("ArcGIS Platform | Platform")) {
			Reporter.reportStep("This is not a ArcGIS Platform | Platform (finland) page.", "FAIL");
		} else
			System.out.println("Finland ArcGIS Platform | Platform page Launched Successfully");
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
	public Finland_ArcGISPlatformPage verifyArcGISPlatformlbl(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disFinlandHome.ArcGISPlatformLbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
