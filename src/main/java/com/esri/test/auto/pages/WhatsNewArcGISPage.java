/**
 * 
 */
package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * @author balajih
 *
 */
public class WhatsNewArcGISPage extends ESRIWrappers{

	public WhatsNewArcGISPage() throws Throwable{
		if(!VerifyTitle("ArcGIS Platform | What's New")){
			Reporter.reportStep("This is not a Whats New ArcGIS Page", "FAIL");
		}
	}
	//Click Browser Back button to Navigate back to Previous Screen
	public ArcGISforDesktopFeaturesPage clickBrowBackButton() throws Throwable{
		clickBrowserBackButton();
		return new ArcGISforDesktopFeaturesPage() ;
		
	}
	
	
}
