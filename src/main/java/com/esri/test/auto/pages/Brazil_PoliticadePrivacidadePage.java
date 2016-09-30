package com.esri.test.auto.pages;


import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 *  This is the Brazil Politica de Privacidade Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_PoliticadePrivacidadePage extends ESRIWrappers {
	public Brazil_PoliticadePrivacidadePage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("Política de Privacidade")) {
			Reporter.reportStep("This is not a  Política de Privacidade (Brazil) page.", "FAIL");
		} else
			System.out.println("Brazil Política de Privacidade page Launched Successfully");
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

	// verify the Politica de Privacidade label
	public Brazil_PoliticadePrivacidadePage verifyPolDePriPage(String data) throws Throwable {
		try {
			verifyValuebyXpath(prop.getProperty("disBzlArcGIS.PoliticadePrivacidadeLbl.xpath"), data);
			System.out.println(getTextByXpath(prop.getProperty("disBzlArcGIS.PoliticadePrivacidadeLbl.xpath")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	 

}
