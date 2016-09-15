/**
 * 
 */
package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.ImageSubPortalVerify;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * @author balajih
 *
 */
public class TC04_ImageSubPortalVerify extends ESRIWrappers {
	
	@BeforeClass
	public void beforeClass(){
		dataSheetName="ImageSubPortalVerify";
		 testCaseName="TC04 Image Sub Portal Verify Page (POM)";
		 testDescription="The Image Submission portal Verify Page is working good";
	}
	
	@Test(dataProvider="fetchdata")
	public void imageSubmissionPortalVerify(String p3Title) throws Throwable{
		new ImageSubPortalVerify(driver, test)
		.verifyImagesubPortalTitle(p3Title);
	}

}
