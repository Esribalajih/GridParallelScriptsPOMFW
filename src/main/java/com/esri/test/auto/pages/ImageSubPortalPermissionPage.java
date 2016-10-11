package com.esri.test.auto.pages;

import org.apache.poi.util.SystemOutLogger;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is the Image submission portal permission page
 * @author balajih
 */
public class ImageSubPortalPermissionPage extends ESRIWrappers {
	
	public ImageSubPortalPermissionPage() throws Throwable {
		if(!VerifyTitle("Image Submissions | Esri Events")){
			Reporter.reportStep("This is not a Image Submission Permission Page", "FAIL");
		}
		
	}
		public ImageSubPortalPermissionPage verifyPermissiontitle(String pTitle)throws Throwable{
			try {
				VerifyTextByXpath(prop.getProperty("imagesub.VerifyPage2Title.xpath"),pTitle);
			} catch (Exception e) {
				System.out.println(driver.getCurrentUrl());
				e.printStackTrace();
			}
			System.out.println("The Title of the page verified successfully");
			return this;
		}
		public ImageSubPortalPermissionPage clickAgreementchkbox() throws Throwable{
			clickChkBoxByXpath(prop.getProperty("imagesub.CheckAgreement.xpath"));
			waitForPageLoad(3);
			System.out.println("The Agreement checkbox clicked successfully");
			return this;
		}
		
		public ImageSubPortalVerify clickContinueBtn() throws Throwable{
			clickByXpath(prop.getProperty("imagesub.Continuebutton.xpath"));
			System.out.println("The Continue button clicked successfully");
			return new ImageSubPortalVerify();
		}
		
		public ImageSubPortalPage clickBackBtn() throws Throwable{
			clickByXpath(prop.getProperty("imagesub.Backbutton.xpath"));
			System.out.println("The Back button clicked successfully");
			return new ImageSubPortalPage();
		}
}

