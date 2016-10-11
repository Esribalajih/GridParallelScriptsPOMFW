package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is a ArcGISDesktop Extensions Page
 * @author balajih
 *
 */
public class ArcGISforDesktopExtnPage extends ESRIWrappers{

	public ArcGISforDesktopExtnPage() throws Throwable {
		if(!VerifyTitle("ArcGIS for Desktop | Extensions"));
		Reporter.reportStep("This is not the ArcGISDesktop Extensions Page", "FAIL");
	}

	public ArcGISforDesktopExtnPage clickExtensionsTab() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.subMenuExtensionslink.xpath"));
		return this;
	}
	public ArcGISforDesktopExtnPage verifyExtenHeader(String data) throws Throwable {
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.extensionHeader.xpath"), data);
		return this;
	}

	public ArcGISforDesktopExtnPage clickShowAllLink() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.showhideAlllink.xpath"));
		return this;
	}

	public ArcGISforDesktopExtnPage clickHideAllLink() throws Throwable {
		clickByXpath(prop.getProperty("arcGISDesktopPage.showhideAlllink.xpath"));
		return this;
	}

	public ArcGISforDesktopExtnPage clickAdvAnalysPlus() throws Throwable {
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnAAplus.xpath"));
		return this;
	}

	public ArcGISforDesktopExtnPage clickAdvAnalysHdr() throws Throwable {
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnAAheader.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickAdvAnalysKeyBenefit() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnAAKeyBenheader.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickDataWFPlus() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.extndataandwfplus.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickDataWFHdr() throws Throwable {
		clickByXpath(prop.getProperty("arcGISDesktopPage.extndataandwfHdr.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickDataWFKeyBenefit() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnDFKeyBenHdr.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickIndustryFocusedPlus() throws Throwable {
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnIFplus.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickIndustryfocusedHdr() throws Throwable {
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnIndFocHdr.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickIndustryfocusedKeyBenefit() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnIFKeyBenHdr.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickNoCostAddonPlus() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnNCAplus.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickNoCostAddonHdr() throws Throwable {
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnNCAHdr.xpath"));
		return this;
	}
	
	public ArcGISforDesktopExtnPage clickNoCostAddonKeyBenefit() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.extnNCAKenBen.xpath"));
		return this;
	}

	public ArcGISforDesktopExtnPage clickArcGISforDesktopExtnPDF() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.arcGIDDesktopExtnPDF.xpath"));
		return this;
	}
}
