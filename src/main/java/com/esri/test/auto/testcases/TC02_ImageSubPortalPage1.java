package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.ImageSubPortalPage1;
import com.esri.test.auto.pages.ImageSubPortalPermissionPage;
import com.esri.test.auto.pages.ImageSubPortalVerify;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is the Testcase to test the Image submission portal
 * @author balajih
 *
 */
public class TC02_ImageSubPortalPage1 extends ESRIWrappers {
	@Parameters({"browser"})
	@BeforeClass
	public void TestCase() {
		// browserName="chrome";
		 dataSheetName="ImageSubPortal";
		 testCaseName="TC02 Image submission Portal Page1 (POM)";
		 testDescription="The Image Submission portal is working good";
	}
	
	@Test(dataProvider="fetchdata")
	public void imageSubmissionPortal(String pagetitle, String sectionTitle,String imgLabel, String secEvent, String rblbl, String rblbl2, String p2Title, String p3Title) throws Throwable{
		new ImageSubPortalPage1(driver, test)
		.verifyPageTitle(pagetitle)
		.verifySectionTitle(sectionTitle)
		.verifyConferenceLabel(imgLabel)
		.selectEvent(secEvent)
		.radioBtn1Label(rblbl)
		.clickradioOption1()
		.radioBtn2Label(rblbl2)
		.clickradio2Option2()
		.getStartedBtn()		
		.verifyPermissiontitle(p2Title)
		.clickAgreementchkbox()
		.clickContinueBtn()
		.verifyImagesubPortalTitle(p3Title);
	}
}
