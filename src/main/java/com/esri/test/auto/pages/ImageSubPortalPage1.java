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
		return this;
		
	}
	
	public ImageSubPortalPage1 verifySectionTitle(String sTitle) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.sectionTitle.xpath"),sTitle);
		return this;
	}
	
	public ImageSubPortalPage1 verifyImagesLabel(String iLabel) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.verifyImagesLabel.xpath"),iLabel);
		return this;
	}
	
	public ImageSubPortalPage1 selectEvent(String sEvent) throws Throwable{
		selectbyXpathWithText(prop.getProperty("imagesub.selectEventdropdown.xpath"),sEvent);
		return this;
	}
	
	public ImageSubPortalPage1 radioBtn1Label(String rBtn1) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.Radiobuttonlabel1.xpath"),rBtn1);
		return this;
	}
	
	public ImageSubPortalPage1 radioOption1 (String rOpt1) throws Throwable {
		VerifyTextbyXpath(prop.getProperty("imagesub.RadioOption1.xpath"),rOpt1);
		return this;
	}
	
	public ImageSubPortalPage1 radioOption2 (String rOpt2) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.RadioOption2.xpath"),rOpt2);
		return this;
	}
	
	public ImageSubPortalPage1 radioBtn2Label (String rBtn2) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.Radiobuttonlabel2.xpath"),rBtn2);
		return this;
	}
	
	public ImageSubPortalPage1 radio2Option1 (String r2Opt1) throws Throwable {
		VerifyTextbyXpath(prop.getProperty("imagesub.Radiobutton1.xpath"),r2Opt1);
		return this;
	}
	
	public ImageSubPortalPage1 radio2Option2 (String r2Opt2) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.Radiobutton2.xpath"),r2Opt2);
		return this;
	}
	
	public ImageSubPortalPermissionPage getStartedBtn() throws Throwable{
		clickbyXpath(prop.getProperty("imagesub.Getstartedbutton.xpath"));
		return new ImageSubPortalPermissionPage();
	}
}
