package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is a ArcGis Desktop System Requirement Page
 * @author balajih
 * 
 */
public class ArcGISforDesktopSysRePage extends ESRIWrappers {
	
	public ArcGISforDesktopSysRePage() throws Throwable{
		if(!VerifyTitle("ArcGIS for Desktop | System Requirements"));
		Reporter.reportStep("This is not a ArcGIS Desktop System Requirement Page", "FAIL");		
	}
	
	public ArcGISforDesktopSysRePage clickSystemRequirementTab() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.sysreqHeader.xpath"));
		return this;
	}
	
	public ArcGISforDesktopSysRePage verifySysReqHdr(String data) throws Throwable{
		VerifyTextByXpath(prop.getProperty("arcGISDesktopPage.sysreqHeader.xpath"), data);
		return this;
	}
	
	public ArcGISforDesktopSysRePage clickArcmapSysReqPDF() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.arcMapSysReqDwnload.xpath"));
		return this;
	}
	public ArcGISforDesktopSysRePage clickArcGISProSysReqPDF() throws Throwable{
		clickByXpath(prop.getProperty("arcGISDesktopPage.arcGISProSysReqDwnload.xpath"));
		return this;
	}

}
