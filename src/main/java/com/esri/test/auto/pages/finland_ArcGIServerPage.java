package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 *  This is the Brazil ArcGIS Desktop Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class finland_ArcGIServerPage extends ESRIWrappers {
	public finland_ArcGIServerPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("ArcGIS for Server | GIS Web Server Software | Web Map Server")) {
			Reporter.reportStep("This is not a  ArcGIS for Server (Finland) page.", "FAIL");
		} else
			System.out.println("Finland ArcGIS for Server page Launched Successfully");
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
	public finland_ArcGIServerPage verifyArcGISforServerlbl(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disFinlandHome.ArcGISServerLbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
