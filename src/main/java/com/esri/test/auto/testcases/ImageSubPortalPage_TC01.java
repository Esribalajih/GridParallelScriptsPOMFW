package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.ImageSubPortalPage;
import com.esri.test.auto.pages.ImageSubPortalPermissionPage;
import com.esri.test.auto.pages.ImageSubPortalVerify;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is the Testcase to test the Image submission portal
 * @author balajih
 *
 */
public class ImageSubPortalPage_TC01 extends ESRIWrappers {
	@Parameters({"browser"})
	@BeforeClass
	public void startTestCase() {
		dataSheetName="ImageSubPortal";
		testCaseName="Image submission Portal Page_TC01";
		testDescription="This is the Image Submission Portal module - Positive Test scenario";
	}

	@Test(dataProvider="fetchdata")
	public void imageSubmissionPortal(String ISPUrl, String pagetitle, String sectionTitle,String imgLabel, String secEvent, String rblbl, String rblbl2, String p2Title, String p3Title) throws Throwable{
		openbrowser(ISPUrl);
		new ImageSubPortalPage()
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
