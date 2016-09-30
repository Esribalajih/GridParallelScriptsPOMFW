package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;
/**This is a ArcGISDesktop Main Page
 * @author balajih
 *
 */
public class ArcGISforDesktopMainPage extends ESRIWrappers{
	
	
	public ArcGISforDesktopMainPage() throws Throwable{
		if(!VerifyTitle("ArcGIS for Desktop"));
		Reporter.reportStep("This is not a ArcGISDesktop Main Page", "FAIL");
	}
	
	public ArcGISforDesktopMainPage clickMainTab() throws Throwable{
		clickbyXpath(prop.getProperty("arcGISDesktopPage.subMenuMainlink.xpath"));
		return this;
	}
	
	public ArcGISforDesktopMainPage verifyMainHeader(String mainHdr) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("arcGISDesktopPage.mainHeader.xpath"), mainHdr);
		return this;
	}
	
	public ArcGISforDesktopMainPage verifyMainTopic2(String Mtopic2) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("arcGISDesktopPage.MTopic2.xpath"), Mtopic2);
		return this;
	}
	
	public ArcGISforDesktopMainPage verifyMainTopic3(String Mtopic3) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("arcGISDesktopPage.MTopic3.xpath"),Mtopic3);
		return this;
	}
	
	public ArcGISforDesktopMainPage verifyMainTopic4(String Mtopic4) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("arcGISDesktopPage.MTopic4.xpath"), Mtopic4);
		return this;
	}
	
	public ArcGISforDesktopMainPage verifyMainTopic5(String Mtopic5) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("arcGISDesktopPage.MTopic5.xpath"), Mtopic5);
		return this;
	}
	
	public ArcGISforDesktopMainPage verifyMainTopic6(String Mtopic6) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("arcGISDesktopPage.MTopic6.xpath"), Mtopic6);
		return this;
	}
	
	public ArcGISforDesktopFreeTrialPage clickFreeTrialLink() throws Throwable{
		clickbyXpath(prop.getProperty("arcGISDesktopPage.FreeTrial.xpath"));
		return new ArcGISforDesktopFreeTrialPage();
	}
	
	public ArcGISforDesktopFeaturesPage clickFeaturesTab() throws Throwable {
		clickbyXpath(prop.getProperty("arcGISDesktopPage.subMenuFeatureslink.xpath"));
		return new ArcGISforDesktopFeaturesPage();
	}
}
