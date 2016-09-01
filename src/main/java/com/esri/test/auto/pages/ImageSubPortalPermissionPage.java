package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is the Image submission portal permission page
 * @author balajih
 *
 */
public class ImageSubPortalPermissionPage extends ESRIWrappers {
	
	public ImageSubPortalPermissionPage() throws Throwable {
		if(!VerifyTitle("Copyright Permission and Release Form")){
			Reporter.reportStep("This is not a Image Submission Permission Page", "FAIL");
		}
		
	}
		public ImageSubPortalPermissionPage verifyPermissiontitle(String pTitle)throws Throwable{
			VerifyTextbyXpath(prop.getProperty("imagesub.VerifyPage2Title.xpath"),pTitle);
			System.out.println("The Title of the page verified successfully");
			return this;
		}
		public ImageSubPortalPermissionPage clickAgreementchkbox() throws Throwable{
			clickbyXpath(prop.getProperty("imagesub.CheckAgreement.xpath"));
			System.out.println("The Agreement checkbox clicked successfully");
			return this;
		}
		
		public ImageSubPortalVerify clickContinueBtn() throws Throwable{
			clickbyXpath(prop.getProperty("imagesub.Continuebutton.xpath"));
			System.out.println("The Continue button clicked successfully");
			return new ImageSubPortalVerify();
		}
		
		public ImageSubPortalPermissionPage clickBackBtn() throws Throwable{
			clickbyXpath(prop.getProperty("imagesub.Backbutton.xpath"));
			System.out.println("The Back button clicked successfully");
			return this;
		}
}

