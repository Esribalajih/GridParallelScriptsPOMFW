package com.esri.test.auto.pages;

import org.apache.poi.util.SystemOutLogger;
<<<<<<< HEAD
import org.openqa.selenium.remote.RemoteWebDriver;
=======
>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;
import com.relevantcodes.extentreports.ExtentTest;

/**This is the Image submission portal permission page
 * @author balajih
 */
public class ImageSubPortalPermissionPage extends ESRIWrappers {
	
<<<<<<< HEAD
	public ImageSubPortalPermissionPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		if(!VerifyTitle("Copyright Permission and Release Form")){
			reportStep("This is not a Image Submission Permission Page", "FAIL");
=======
	public ImageSubPortalPermissionPage() throws Throwable {
		if(!VerifyTitle("Image Submissions | Esri Events")){
			Reporter.reportStep("This is not a Image Submission Permission Page", "FAIL");
>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto
		}
		
	}
		public ImageSubPortalPermissionPage verifyPermissiontitle(String pTitle)throws Throwable{
			try {
<<<<<<< HEAD
				VerifyTextbyXpath(prop.getProperty("imagesub.VerifyPage2Title.xpath"),pTitle);
=======
				VerifyTextByXpath(prop.getProperty("imagesub.VerifyPage2Title.xpath"),pTitle);
>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto
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
			return new ImageSubPortalVerify(driver, test);
		}
		
		public ImageSubPortalPage clickBackBtn() throws Throwable{
			clickByXpath(prop.getProperty("imagesub.Backbutton.xpath"));
			System.out.println("The Back button clicked successfully");
			return new ImageSubPortalPage();
		}
}

