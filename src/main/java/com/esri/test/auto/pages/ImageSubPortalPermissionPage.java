package com.esri.test.auto.pages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;
import com.relevantcodes.extentreports.ExtentTest;

/**This is the Image submission portal permission page
 * @author balajih
 *
 */
public class ImageSubPortalPermissionPage extends ESRIWrappers {
	
	public ImageSubPortalPermissionPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		if(!VerifyTitle("Copyright Permission and Release Form")){
			reportStep("This is not a Image Submission Permission Page", "FAIL");
		}
		
	}
		public ImageSubPortalPermissionPage verifyPermissiontitle(String pTitle)throws Throwable{
			try {
				VerifyTextbyXpath(prop.getProperty("imagesub.VerifyPage2Title.xpath"),pTitle);
			} catch (Exception e) {
				System.out.println(driver.getCurrentUrl());
				e.printStackTrace();
			}
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
			return new ImageSubPortalVerify(driver, test);
		}
		
		public ImageSubPortalPermissionPage clickBackBtn() throws Throwable{
			clickbyXpath(prop.getProperty("imagesub.Backbutton.xpath"));
			System.out.println("The Back button clicked successfully");
			return this;
		}
}

