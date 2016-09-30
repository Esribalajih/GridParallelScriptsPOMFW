package com.esri.test.auto.pages;


import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 *  This is the Brazil ArcGIS Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Finland_TukiPage extends ESRIWrappers {
	
	
	public Finland_TukiPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("Tuki")) {
			Reporter.reportStep("This is not a Tuki (finland support) page.", "FAIL");
		} else
			System.out.println("Finland Tuki (support) page Launched Successfully");
	}

	// click back button Tab
	public Finland_HomePage clickbsrBackBtn() throws Throwable {
		try {
			clickBrowserBackButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Finland_HomePage();
	}

	// verify Tuki label
		public Finland_TukiPage verifyTukilbl(String data) throws Throwable {
			try {
				verifyValuebyXpath(prop.getProperty("disFinlandHome.TukiLbl.xpath"), data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}


}
