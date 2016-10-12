package com.esri.test.auto.pages;

import org.openqa.selenium.By;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Create Account Page of IAM Application
 * 
 * @author udhayasundar
 *
 */
public class CreateAccountPage extends ESRIWrappers {

	public CreateAccountPage() throws Throwable {
		waitForPageLoad(5);
		System.out.println("Esri Accounts");
		if (!VerifyTitle("Esri Accounts")) {
			Reporter.reportStep("This is not an ESRI account creating page", "FAIL");
		}
	}

	// Enter the First Name
	public CreateAccountPage enterFirstName(String userdata) throws Throwable {
		waitForPageLoad(5);
		try {
			enterbyId(prop.getProperty("createAcc.firstName.Id"), userdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	// Enter the Last Name
		public CreateAccountPage enterLastName(String userdata) throws Throwable {
			try {
				enterbyId(prop.getProperty("createAcc.lastName.Id"), userdata);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

	// Enter the Password
	public CreateAccountPage enterEmailAddr(String email) throws Throwable {
		try {
			enterbyId(prop.getProperty("createAcc.email.Id"), email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click create button
	public CreateAccountPage clickCreateAccountBtn() throws Throwable {
		try {
			clickById(prop.getProperty("createAcc.createAccBtn.Id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Verify the Success Message Email
	public CreateAccountPage verifySuccessMessageEmail(String fullName) throws Throwable{
		try {
			System.out.println("verify Full Message: "+ driver.findElement(By.xpath(prop.getProperty("createAcc.LoginSuccessmsg1.xpath"))).getText());
			System.out.println("verify Full Message: "+ driver.findElement(By.xpath(prop.getProperty("createAcc.LoginSuccessmsg2.xpath"))).getText());
			System.out.println("verify Full Message: "+ driver.findElement(By.id(prop.getProperty("createAcc.LoginSuccEmailLbl.id"))).getText());
			VerifyTextbyClassName(prop.getProperty("homePage.userEmailDropdown.className"),fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	// To Open outlook web app in browser
	public OutLookEmail launchOutLook(String URL) throws Throwable{
		openbrowser(URL);
		return new OutLookEmail();
	}
	
	
	
	
}
