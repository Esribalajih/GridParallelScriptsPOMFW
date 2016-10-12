package com.esri.test.auto.pages;

import org.openqa.selenium.By;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the ArcGIS MainPage Page of IAM Application
 * 
 * @author Udhayasundar S
 *
 */
public class ArcGIS_OnlineSTGPage extends ESRIWrappers {

	public ArcGIS_OnlineSTGPage() throws Throwable {
		waitForPageLoad(15);
		System.out.println("ArcGIS Online");
		if (!VerifyTitle("ArcGIS Online")) {
			Reporter.reportStep("This is not a ArcGIS Online page", "FAIL");
		}
	}

	// Verify the UserName
		public ArcGIS_OnlineSTGPage verifyLoggedUserName(String userdata) throws Throwable {
			try {
				System.out.println("verify user name: "
						+ driver.findElement(By.xpath(prop.getProperty("arcGISOnlineStg.userName.xpath"))).getText());
				verifyValuebyXpath(prop.getProperty("arcGISOnlineStg.userName.xpath"), userdata);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		// Verify the default : Sign in UserName
		public ArcGIS_OnlineSTGPage verifyUserName(String userdata) throws Throwable {
			try {
				verifyValuebyXpath(prop.getProperty("arcGISOnlineStg.signInUserNm.xpath"), userdata);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		// Click the UserName
		public ArcGIS_OnlineSTGPage clickLoggedUserName() throws Throwable {
			try {
				clickbyXpath(prop.getProperty("arcGISOnlineStg.userName.xpath"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		// verify the logged UserFullName
		public ArcGIS_OnlineSTGPage verifyUserFullName(String fullName) throws Throwable {
			try {
				System.out.println("verify user Full name: " + driver
						.findElement(By.xpath(prop.getProperty("arcGISOnlineStg.userNameDropdown.xpath"))).getText());
				verifyValuebyXpath(prop.getProperty("arcGISOnlineStg.userNameDropdown.xpath"), fullName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}
	
		// click sign out button
		public ArcGIS_OnlineSTGPage clickSignoutBtn() throws Throwable {
			try {
				System.out.println("verify Signout button: "
						+ driver.findElement(By.xpath(prop.getProperty("arcGISOnlineStg.signOutDropdown.xpath"))).getText());
				clickbyXpath(prop.getProperty("arcGISOnlineStg.signOutDropdown.xpath"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		// Verify the logged out perform success or not with user name: Sign in
		public ArcGIS_OnlineSTGPage verifySignoutSuccess() throws Throwable {
			waitForPageLoad(10);
			verifyUserName("Sign In");
			return this;
		}
	
	
}
