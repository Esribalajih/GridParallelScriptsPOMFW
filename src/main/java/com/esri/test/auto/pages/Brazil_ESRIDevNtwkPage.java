package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Brazil ArcGIS Online Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_ESRIDevNtwkPage extends ESRIWrappers {
	public Brazil_ESRIDevNtwkPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("Esri Developer Network")) {
			Reporter.reportStep("This is not a 	Esri Developer Network (Brazil) page.", "FAIL");
		} else
			System.out.println("Brazil Esri Developer Network page Launched Successfully");
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

	// verify Esri Developer Network label
	public Brazil_ESRIDevNtwkPage verifyEsriDevNtwklbl(String data) throws Throwable {
		try {
			verifyValueWithNewLinebyXpath(prop.getProperty("disBzlArcGIS.EsriDevNetworkLbl.xpath"),data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
