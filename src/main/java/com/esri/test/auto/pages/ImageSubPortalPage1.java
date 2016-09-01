package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is the Image submission portal webpage1
 * @author balajih
 *
 */
public class ImageSubPortalPage1 extends ESRIWrappers {
	
	public ImageSubPortalPage1() throws Throwable {
		if(!VerifyTitle("CALL FOR IMAGES")){
			Reporter.reportStep("This is not a Image Submission Page", "FAIL");
			
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
	
	public ImageSubPortalPage1 selectEvent(String sEvent) throws Throwable{
		selectbyXpathWithText(prop.getProperty("imagesub.selectEventdropdown.xpath"),sEvent);
		System.out.println("The Event got selected");
		return this;
	}
	
	public ImageSubPortalPage1 radioBtn1Label(String rLbl1) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.Radiobuttonlabel1.xpath"),rLbl1);
		System.out.println("The Title 'What type of files are you submitting?' verified successfully");
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
		return new ImageSubPortalPermissionPage();
	}
}
