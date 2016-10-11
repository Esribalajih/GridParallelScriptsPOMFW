package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * @author balajih
 *
 */
public class ArcGISforDesktopFeaturesPage extends ESRIWrappers{
	
	public ArcGISforDesktopFeaturesPage() throws Throwable{
	if(!VerifyTitle("ArcGIS for Desktop | Key Features"));
	Reporter.reportStep("This is not a ArcGIS Desktop Features Page", "FAIL");
	}
	
	public ArcGISforDesktopFeaturesPage clickFeaturesTab() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.subMenuFeatureslink.xpath"));
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesHdr(String FHdr) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.featuresHeader.xpath"), FHdr);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesTopic2(String FTopic2) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.FTopic2.xpath"), FTopic2);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesTopic3(String FTopic3) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.FTopic3.xpath"), FTopic3);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyHdr(String KeyFHdr) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFHdr.xpath"), KeyFHdr);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic1(String KeyTopic1) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic1.xpath"), KeyTopic1);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic2(String KeyTopic2) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic2.xpath"), KeyTopic2);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic3(String KeyTopic3) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic3.xpath"), KeyTopic3);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic4(String KeyTopic4) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic4.xpath"), KeyTopic4);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic5(String KeyTopic5) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic5.xpath"), KeyTopic5);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic6(String KeyTopic6) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic6.xpath"), KeyTopic6);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic7(String KeyTopic7) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic7.xpath"), KeyTopic7);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesKeyTopic8(String KeyTopic8) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.KeyFTopic8.xpath"), KeyTopic8);
		return this;
	}
	
	public ArcGISforDesktopFeaturesPage verifyFeaturesMoreDetailsLink(String FmdLink) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.MDLink.xpath"), FmdLink);
		return this;
	}
	
	public WhatsNewArcGISPage clickFeaturesMoreDetailsLink() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.MDLink.xpath"));
		return new WhatsNewArcGISPage();
	}

}
