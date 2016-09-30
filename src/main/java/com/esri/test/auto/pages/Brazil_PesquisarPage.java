package com.esri.test.auto.pages;


import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 *  This is the Brazil ArcGIS Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_PesquisarPage extends ESRIWrappers {
	public Brazil_PesquisarPage() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("Pesquisar")) {
			Reporter.reportStep("This is not a Pesquisar (Brazil Search) page.", "FAIL");
		} else
			System.out.println("Brazil Pesquisar (Search) page Launched Successfully");
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
	public Brazil_PesquisarPage verifyResultsDisplaying() throws Throwable {
		try {
			checkElementIsDisplayed(prop.getProperty("disBrazilPes.FilterResults.xpath"));
			Reporter.reportStep("Results : "+getTextByXpath(prop.getProperty("disBrazilPes.FilterResults.xpath")), "PASS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	 

}
