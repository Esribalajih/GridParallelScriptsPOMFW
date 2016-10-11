package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is Image submission portal page to verify the submission
 * @author balajih
 *
 */
public class ImageSubPortalVerify extends ESRIWrappers {

	public ImageSubPortalVerify() throws Throwable{
		if(!VerifyTitle("Image Submissions | Esri Events")){
			Reporter.reportStep("This is not a Image submission Verification page", "FAIL");
		}
	}

	public ImageSubPortalVerify verifyImagesubPortalTitle (String p3Title) throws Throwable{
		VerifyTextByXpath(prop.getProperty("imagesub.verifyPage3Title.xpath"),p3Title);
		System.out.println("The Title of the page verified successfully");
		return this;

	}

	public ImageSubPortalPermissionPage clickBackBtn() throws Throwable{
		clickByXpath(prop.getProperty("imagesub.Backbutton.xpath"));
		System.out.println("The Back button clicked successfully");
		return new ImageSubPortalPermissionPage();
		
	}
}
