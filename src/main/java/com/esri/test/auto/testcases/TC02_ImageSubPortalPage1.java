package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**This is the Testcase to test the Image submission portal
 * @author balajih
 *
 */
public class TC02_ImageSubPortalPage1 extends com.esri.test.auto.wrappers.ESRIWrappers {
	
	@BeforeClass
	public void startTestCase() {
		 browserName="chrome";
		 dataSheetName="TC02_ImageSubPortal";
		 testCaseName="TC02 Image submission Portal Page1 (POM)";
		 testDescription="The Image Submission portal is working good";
	}
	
	@Test(dataProvider="Fetchdata")
	public void imageSubmissionPortal(String pagetitle, String sectionTitle,String imgLabel, String secEvent){
		new verifyPageTitle(pagetitle).verifySectionTitle().verifyImagesLabel().selectEvent().radioBtn1Label().radioOption1().click();
	}
	
	

}
