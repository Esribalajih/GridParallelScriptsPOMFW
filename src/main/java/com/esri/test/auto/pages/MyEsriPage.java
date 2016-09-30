package com.esri.test.auto.pages;

import org.openqa.selenium.By;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the My Esri Page of IAM Application
 * 
 * @author udhayasundar
 *
 */
public class MyEsriPage extends ESRIWrappers {

	public MyEsriPage() throws Throwable {
		waitForPageLoad(10);
		/*if (!VerifyTitle("My Esri | Edit Contact Information")) {
			Reporter.reportStep("This is not a My ESRI page", "FAIL");
		} else*/
			System.out.println("My ESRI Launched Successfully");
	}

	// click My Profile Tab
	public MyEsriPage clickMyProfileTab() throws Throwable {
		try {
			waitForPageLoad(5);
			clickbyXpath(prop.getProperty("myEsri.myProfileTab.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Edit Contact Information link
	public MyEsriPage clickEditCntInfoLink() throws Throwable {
		try {
			waitForPageLoad(5);
			clickbyXpath(prop.getProperty("myEsri.editContInfo.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Enter the first Name
	public MyEsriPage enterFirstName(String firstName) throws Throwable {
		try {
			enterbyXpath(prop.getProperty("myEsri.firstName.xpath"), firstName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Enter the last Name
	public MyEsriPage enterLastName(String lastName) throws Throwable {
		try {
			enterbyXpath(prop.getProperty("myEsri.lastName.xpath"), lastName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Update button
	public MyEsriPage clickUpdateBtn() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("myEsri.updateBtn.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify the User Full Name
	public MyEsriPage verifyUserFullName(String fullName) throws Throwable {
		try {
			mouseHoverById(prop.getProperty("homepage.userName.id"));
			System.out.println("verify user Full name: " + driver
					.findElement(By.className(prop.getProperty("homePage.userNameDropdown.className"))).getText());
			VerifyTextbyClassName(prop.getProperty("homePage.userNameDropdown.className"), fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify the User Email
	public MyEsriPage verifyUserEmail(String fullName) throws Throwable {
		try {
			VerifyTextbyClassName(prop.getProperty("homePage.userEmailDropdown.className"), fullName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click sign out
	public MyEsriPage clickSignoutBtn() throws Throwable {
		try {
			System.out.println("verify Signout button: "
					+ driver.findElement(By.xpath(prop.getProperty("myEsri.signOutDropdown.xpath"))).getText());
			clickbyXpath(prop.getProperty("myEsri.signOutDropdown.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Verify the UserName
	public MyEsriPage verifyUserName(String userdata) throws Throwable {
		try {
			waitForPageLoad(5);
			verifyValuebyXpath(prop.getProperty("myEsri.signInUserNm.xpath"), userdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Verify the logged out perform success or not with user name: Sign in
	public MyEsriPage verifySignoutSuccess() throws Throwable {
		waitForPageLoad(10);
		verifyUserName("Sign In");
		return this;
	}

	// Verify the error message
	public MyEsriPage verifyErrorMessage(String errorMessage) throws Throwable {
		switchToFrameByID(prop.getProperty("homePage.errorMessageFrame.id"));
		waitForPageLoad(2);
		System.out.println(
				"Error Message: " + driver.findElement(By.id(prop.getProperty("homePage.errorMessage.id"))).getText()
						+ " status :" + driver.findElement(By.id(prop.getProperty("homePage.errorMessage.id")))
								.getText().equalsIgnoreCase(errorMessage));
		VerifyTextbyId(prop.getProperty("homePage.errorMessage.id"), errorMessage);
		return this;
	}

	
	// Verify thank you message
	public MyEsriPage verifySuccessUpdateMsg(String msg) throws Throwable {
		waitForPageLoad(2);
		verifyMessagebyId(prop.getProperty("myEsri.updateScuccessMessage.id"), msg);
		return this;
	}
	
	
	
	// Verify the UserName
		public MyEsriPage verifyLoggedUserName(String userdata) throws Throwable {
			try {
				waitForPageLoad(15);
				System.out.println("verify user name: "
						+ driver.findElement(By.xpath(prop.getProperty("myEsri.userName.xpath"))).getText());
				verifyValuebyXpath(prop.getProperty("myEsri.userName.xpath"), userdata);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		
		// Click the UserName
		public MyEsriPage clickLoggedUserName() throws Throwable {
			try {
				clickbyXpath(prop.getProperty("myEsri.userName.xpath"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

	
	
	
}
