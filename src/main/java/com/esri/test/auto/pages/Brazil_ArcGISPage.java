package com.esri.test.auto.pages;


import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 *  This is the Brazil ArcGIS Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_ArcGISPage extends ESRIWrappers {
	public Brazil_ArcGISPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("ArcGIS")) {
			Reporter.reportStep("This is not a  ArcGIS (Brazil) page.", "FAIL");
		} else
			System.out.println("Brazil  ArcGIS page Launched Successfully");
	}

	// click back button Tab
	public Brazil_HomePage clickbsrBackBtn() throws Throwable {
		try {
			clickBrowserBackButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_HomePage();
	}

	// click Produtos Tab
	public Brazil_ArcGISPage verifyArGISPage(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disBzlArcGIS.PlataformaTab.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	 

}
