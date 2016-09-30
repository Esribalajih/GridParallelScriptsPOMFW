package com.esri.test.auto.pages;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the OutLook - Email Page of IAM Application
 * 
 * @author udhayaundar
 *
 */
public class OutLookEmail extends ESRIWrappers {
	
	public OutLookEmail() throws Throwable {
		waitForPageLoad(10);
		if(!VerifyTitleEndsWith(" - Outlook Web App")){
			Reporter.reportStep("This is not an OutLook Web App page", "FAIL");
			System.out.println("This is not an OutLook Web App page");
		}
		else System.out.println("OutLook Web App page Launched Successfully");
	}
	
	// login to outlook web app with user credentials
	public OutLookEmail(String uName, String pwd, String URL) throws Throwable {
		waitForPageLoad(10);
		openbrowser(URL);
		handlingBAuthUsingRobo(uName, pwd);
		waitForPageLoad(15);
		if(!VerifyTitleEndsWith(" - Outlook Web App")){
			Reporter.reportStep("This is not an OutLook Web App page", "FAIL");
			System.out.println("This is not an OutLook Web App page");
		}
		else System.out.println("OutLook Web App page Launched Successfully");
	}
	
	//Enter the search criteria message in Search Text box
	public OutLookEmail searchTextBox(String userdata) throws Throwable{
		try{
			waitForPageLoad(15);
			enterbyClassName(prop.getProperty("outLook.searchTextBox.className"), userdata);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
	
	//Click the account activate email
	public OutLookEmail clickEmail() throws Throwable{
		try {
			clickbyXpath(prop.getProperty("outLook.EsriAccountMail.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	//Click the Activate your account button in email
	public OutLookEmail clickActivateAccountBtn() throws Throwable{
		try {
			clickbyXpath(prop.getProperty("outLook.EsriActiveyourAccountBtn.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
}
