package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.ImageSubPortalPermissionPage;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * @author balajih
 *
 */
public class TC03_ImageSubPortalPermissionPage extends ESRIWrappers {
	
	@BeforeClass
	public void beforeClass(){
		dataSheetName="ImageSubPortalPermission";
		 testCaseName="TC03 Image Sub Portal Permission Page (POM)";
		 testDescription="The Image Submission portal Permission Page is working good";
	}
	
	@Test(dataProvider="fetchdata")
	public void imageSubmissionPortalPermission(String p2Title) throws Throwable{
		new ImageSubPortalPermissionPage(driver, test)
		.verifyPermissiontitle(p2Title)
		.clickAgreementchkbox()
		.clickContinueBtn();
	}

}
