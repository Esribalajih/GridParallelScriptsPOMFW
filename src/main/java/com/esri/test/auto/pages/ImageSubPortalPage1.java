package com.esri.test.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;
import com.relevantcodes.extentreports.ExtentTest;


/**This is the Image submission portal webpage1
 * @author balajih
 *
 */
public class ImageSubPortalPage1 extends ESRIWrappers {
	
	public ImageSubPortalPage1(RemoteWebDriver driver, ExtentTest test){
				this.driver=driver;
				this.test=test;
		if(!VerifyTitle("Image Submissions | Esri Events")){
			reportStep("This is not a Image Submission Page", "FAIL");
			
		}
	}
	
	public ImageSubPortalPage1 verifyPageTitle(String pTitle) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.pageTitle.xpath"),pTitle);
		System.out.println("The Title of the page verified successfully");
		return this;
		
	}
	
	public ImageSubPortalPage1 verifySectionTitle(String sTitle) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.sectionTitle.xpath"),sTitle);
		System.out.println("The Title of the Section verified successfully");
		return this;
	}
	
	public ImageSubPortalPage1 verifyConferenceLabel(String iLabel) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.verifyConferenceLabel.xpath"),iLabel);
		System.out.println("The Title of the Conference Label verified successfully");
		return this;
	}
	
	public ImageSubPortalPage1 selectEventClick() throws Throwable{
		clickbyXpath(prop.getProperty("imagesub.clickonSelectEvent.xpath"));
		waitForPageLoad(3);
		System.out.println("The Event got Clicked to select");
		return this;
	}
	
	public ImageSubPortalPage1 selectEvent(String sEvent) throws Throwable{
		selectbyXpathWithText(prop.getProperty("imagesub.selectEventdropdown.xpath"),sEvent);
		return this;
	}
	
	public ImageSubPortalPage1 radioBtn1Label(String rLbl1) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.Radiobuttonlabel1.xpath"),rLbl1);
//		System.out.println("The Title 'What type of files are you submitting?' verified successfully");
		return this;
	}
	
	public ImageSubPortalPage1 clickradioOption1 () throws Throwable {
		clickbyXpath(prop.getProperty("imagesub.RadioOption1.xpath"));
		System.out.println("The Images option clicked successfully");
		return this;
	}
	
	public ImageSubPortalPage1 clickradioOption2 () throws Throwable{
		clickbyXpath(prop.getProperty("imagesub.RadioOption2.xpath"));
		System.out.println("The Video option clicked successfully");
		return this;
	}
	
	public ImageSubPortalPage1 radioBtn2Label (String rBtn2) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.Radiobuttonlabel2.xpath"),rBtn2);
		System.out.println("The Title 'Are you a Federal Government Employee?' verified successfully");
		return this;
	}
	
	public ImageSubPortalPage1 clickradio2Option1 () throws Throwable {
		clickbyXpath(prop.getProperty("imagesub.Radiobutton1.xpath"));
		System.out.println("The Yes option clicked successfully");
		return this;
	}
	
	public ImageSubPortalPage1 clickradio2Option2 () throws Throwable{
		clickbyXpath(prop.getProperty("imagesub.Radiobutton2.xpath"));
		System.out.println("The No option clicked successfully");
		return this;
	}
	
	public ImageSubPortalPermissionPage getStartedBtn() throws Throwable{
		clickbyXpath(prop.getProperty("imagesub.Getstartedbutton.xpath"));
		System.out.println("The GetStarted button clicked successfully");
		return new ImageSubPortalPermissionPage(driver, test);
	}
}
