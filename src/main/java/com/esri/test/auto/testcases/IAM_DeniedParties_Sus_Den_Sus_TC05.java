package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.ArcGIS_InternalsSigninPage;
import com.esri.test.auto.pages.ArcGIS_MainPage;
import com.esri.test.auto.pages.CSAT_Staging;
import com.esri.test.auto.pages.HomePage;
import com.esri.test.auto.pages.OktaEsriSigninPage;
import com.esri.test.auto.pages.OutLookEmail;
import com.esri.test.auto.pages.SigninPage;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This test case is to check the login functionality
 * 
 * @author balajih
 *
 */
public class IAM_DeniedParties_Sus_Den_Sus_TC05 extends ESRIWrappers {
	@BeforeClass
	@Parameters({ "browser" })
	public void startTestCase(String browser) {
		browserName = browser;
		dataSheetName = "IAM_DeniedParties_Sus_Den_Sus_TC05";
		testCaseName = "IAM_DeniedParties_Sus_Den_Sus_TC05";
		testDescription = "Denied Parties - Existing Account - Suspect > Denied > Suspect - using POM";
	}

	@Test(dataProvider = "fetchdata")
	public void loginforSuccess(String CSATURL, String CSATUserName, String CSATPassword, String CsatCleared, String CsatDenied, 
			String CsatSuspect, String ArcGISURL, String ArcGISUserName, String ArcGISPassword, String ArcGISErrorMessage
			, String ESRiAcctURL, String EsriAcctUsername, String EsriAcctpassword, String firstName, String lastName, 
			String changeFirstName, String changeLastName, String esriEmail, String organization, 
			String MyEsriErrorMessage, String MyEsriUpdateSuccMsg) throws Throwable {
		
		openbrowser(ESRiAcctURL);
		  new SigninPage()
		 .enterUserName(EsriAcctUsername) 
		 .enterPassword(EsriAcctpassword)
		 .clickSigninMyEsri() 
		 .clickMyProfileTab() 
		 .clickEditCntInfoLink()
		 .enterFirstName(changeFirstName) 
		 .enterLastName(changeLastName)
		 .clickUpdateBtn() 
		 .verifySuccessUpdateMsg(MyEsriUpdateSuccMsg)
		 .verifyLoggedUserName(firstName)
		 .clickLoggedUserName()
		 .clickSignoutBtn()
		 .verifySignoutSuccess();
		 		 
		new CSAT_Staging(CSATUserName, CSATPassword, CSATURL)
				// .enterUserName(EsriAcctUsername)
				// .enterFirstName(changeFirstName)
				// .enterLastName(changeLastName)
				.enterEmail(esriEmail)
				// .enterOrganization(organization)
				.clickSearchBtn()
				.verifyDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization)
				.verifyAndChangeDPStatusCl_Sus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization);
							
		
		openbrowser(ESRiAcctURL);
		new SigninPage().enterUserName(EsriAcctUsername).enterPassword(EsriAcctpassword).clickSigninforFailure()
				.verifyErrorMessage(MyEsriErrorMessage);

		openbrowser(ArcGISURL);
		new ArcGIS_InternalsSigninPage()
		.enterUserName(ArcGISUserName)
		.enterPassword(ArcGISPassword)
		.clickSignInBtn()
		.clickSignInLink()
		.enterUserName(EsriAcctUsername)
		.enterPassword(EsriAcctpassword)
		.clickSignInBtn()
		.verifyErrorMsg(ArcGISErrorMessage);

		openbrowser(CSATURL);
		new CSAT_Staging()
		// .enterUserName(EsriAcctUsername)
		// .enterFirstName(changeFirstName)
		// .enterLastName(changeLastName)
		.enterEmail(esriEmail)
		// .enterOrganization(organization)
		.clickSearchBtn()
		.verifyDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization)
		.clickDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization, CsatSuspect)
		.verifySuspectDPStatus(CsatSuspect)
		.changeDPStatus(CsatSuspect, CsatDenied)
		.clickSaveChangesBtn()
		.clickbsrBackBtn()
		.enterEmail(esriEmail)
		.clickSearchBtn()
		.verifyDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization);
		
		openbrowser(ESRiAcctURL);
		new SigninPage().enterUserName(EsriAcctUsername).enterPassword(EsriAcctpassword).clickSigninforFailure()
				.verifyErrorMessage(MyEsriErrorMessage);

		openbrowser(ArcGISURL);
		new ArcGIS_MainPage()
		.clickSignInLink()
		.enterUserName(EsriAcctUsername)
		.enterPassword(EsriAcctpassword)
		.clickSignInBtn()
		.verifyErrorMsg(ArcGISErrorMessage);
		
		
		openbrowser(CSATURL);
		new CSAT_Staging()
		// .enterUserName(EsriAcctUsername)
		// .enterFirstName(changeFirstName)
		// .enterLastName(changeLastName)
		.enterEmail(esriEmail)
		// .enterOrganization(organization)
		.clickSearchBtn()
		.verifyDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization)
		.clickDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization, CsatDenied)
		.verifySuspectDPStatus(CsatDenied)
		.changeDPStatus(CsatDenied, CsatSuspect)
		.clickSaveChangesBtn()
		.clickbsrBackBtn()
		.enterEmail(esriEmail)
		.clickSearchBtn()
		.verifyDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization);
		
		openbrowser(ESRiAcctURL);
		new SigninPage().enterUserName(EsriAcctUsername).enterPassword(EsriAcctpassword).clickSigninforFailure()
				.verifyErrorMessage(MyEsriErrorMessage);

		openbrowser(ArcGISURL);
		new ArcGIS_MainPage()
		.clickSignInLink()
		.enterUserName(EsriAcctUsername)
		.enterPassword(EsriAcctpassword)
		.clickSignInBtn()
		.verifyErrorMsg(ArcGISErrorMessage);
		
		
		
		openbrowser(CSATURL);
		new CSAT_Staging()
		// .enterUserName(EsriAcctUsername)
		// .enterFirstName(changeFirstName)
		// .enterLastName(changeLastName)
		.enterEmail(esriEmail)
		// .enterOrganization(organization)
		.clickSearchBtn()
		.verifyDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization)
		.clickDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization, CsatSuspect)
		.verifySuspectDPStatus(CsatSuspect)
		.changeDPStatus(CsatSuspect, CsatCleared)
		.clickSaveChangesBtn()
		.clickbsrBackBtn()
		.enterEmail(esriEmail)
		.clickSearchBtn()
		.verifyDPStatus(EsriAcctUsername, changeFirstName, changeLastName, esriEmail, organization);
		
		
		  openbrowser(ESRiAcctURL);
		  new SigninPage()
		 .enterUserName(EsriAcctUsername) 
		 .enterPassword(EsriAcctpassword)
		 .clickSigninMyEsri() 
		 .clickMyProfileTab() 
		 .clickEditCntInfoLink()
		 .enterFirstName(firstName) 
		 .enterLastName(lastName)
		 .clickUpdateBtn() 
		 .verifySuccessUpdateMsg(MyEsriUpdateSuccMsg)
		 .verifyLoggedUserName(changeFirstName)
		 .clickLoggedUserName()
		 .clickSignoutBtn()
		 .verifySignoutSuccess();
		
	}

}
