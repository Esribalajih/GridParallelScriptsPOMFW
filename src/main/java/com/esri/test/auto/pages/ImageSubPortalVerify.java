package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This is Image submission portal page to verify the submission
 * @author balajih
 *
 */
public class ImageSubPortalVerify extends ESRIWrappers {
	
	public ImageSubPortalVerify() throws Throwable{
		if(!VerifyTitle("Do any of the images include identifiable people?")){
			Reporter.reportStep("This is not a Image submission Verification page", "FAIL");
		}
	}
	
	public ImageSubPortalVerify verifyImagesubPortalTitle (String p3Title) throws Throwable{
		VerifyTextbyXpath(prop.getProperty("imagesub.verifyPage3Title.xpath"),p3Title);
		return this;
		
	}

}
