package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.ImageSubPortalPage1;

/**This is the Testcase to test the Image submission portal
 * @author balajih
 *
 */
public class TC02_ImageSubPortalPage1 extends com.esri.test.auto.wrappers.ESRIWrappers {
	
	@BeforeClass
	public void startTestCase() {
		// browserName="chrome";
		 dataSheetName="ImageSubPortal";
		 testCaseName="TC02 Image submission Portal Page1 (POM)";
		 testDescription="The Image Submission portal is working good";
	}
	
	@Test(dataProvider="Fetchdata")
	public void imageSubmissionPortal(String pagetitle, String sectionTitle,String imgLabel, String secEvent, String rblbl, String rblbl2) throws Throwable{
		new ImageSubPortalPage1()
		.verifyPageTitle(pagetitle)
		.verifySectionTitle(sectionTitle)
		.verifyConferenceLabel(imgLabel)
		.selectEvent(secEvent)
		.radioBtn1Label(rblbl)
		.clickradioOption1()
		.radioBtn2Label(rblbl2)
		.clickradio2Option2()
		.getStartedBtn();
	}
	
	

}
