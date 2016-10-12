package com.esri.test.auto.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;
import com.relevantcodes.extentreports.ExtentTest;

/**This is Image submission portal page to verify the submission
 * @author balajih
 *
 */
public class ImageSubPortalVerify extends ESRIWrappers {
<<<<<<< HEAD
	
	public ImageSubPortalVerify(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!VerifyTitle("Do any of the images include identifiable people?")){
			reportStep("This is not a Image submission Verification page", "FAIL");
=======

	public ImageSubPortalVerify() throws Throwable{
		if(!VerifyTitle("Image Submissions | Esri Events")){
			Reporter.reportStep("This is not a Image submission Verification page", "FAIL");
>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto
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
