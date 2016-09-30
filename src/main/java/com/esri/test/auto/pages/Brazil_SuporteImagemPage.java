package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Brazil Suporte Imagem Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_SuporteImagemPage extends ESRIWrappers {
	public Brazil_SuporteImagemPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("Suporte Imagem")) {
			Reporter.reportStep("This is not a Suporte Imagem (Brazil) page.", "FAIL");
		} else
			System.out.println("Brazil Suporte Imagem page Launched Successfully");
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
	public Brazil_SuporteImagemPage verifySuporteImagemlbl(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disBzlArcGIS.ArcGISDesktopLbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
