package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Brazil ArcGIS Online Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_ArcGISOnlinePage extends ESRIWrappers {
	public Brazil_ArcGISOnlinePage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("ArcGIS Online")) {
			Reporter.reportStep("This is not a ArcGIS Online (Brazil) page.", "FAIL");
		} else
			System.out.println("Brazil ArcGIS Online  page Launched Successfully");
	}

	// click back button in browser
	public Brazil_HomePage clickbsrBackBtn() throws Throwable {
		try {
			clickBrowserBackButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_HomePage();
	}

	// verify ArcGIS online label
	public Brazil_ArcGISOnlinePage verifyArcGISOnlinelbl(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disBzlArcGIS.ArcGISDesktopLbl.xpath"), data);
			System.out.println(getTextByXpath(prop.getProperty("disBzlArcGIS.ArcGISDesktopLbl.xpath")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
