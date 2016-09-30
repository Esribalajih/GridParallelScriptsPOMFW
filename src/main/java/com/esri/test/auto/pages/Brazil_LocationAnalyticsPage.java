package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Brazil ArcGIS Online Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_LocationAnalyticsPage extends ESRIWrappers {
	public Brazil_LocationAnalyticsPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("Location Analytics")) {
			Reporter.reportStep("This is not a Location Analytics (Brazil) page.", "FAIL");
		} else
			System.out.println("Brazil Location Analytics page Launched Successfully");
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

	// verify Location Analytics label
	public Brazil_LocationAnalyticsPage verifyLocAnalyticslbl(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disBzlArcGIS.LocationAnalyticsLbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
