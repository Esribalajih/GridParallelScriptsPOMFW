package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.esri.test.auto.pages.Brazil_HomePage;
import com.esri.test.auto.pages.Brazil_SuporteImagemPage;
import com.esri.test.auto.pages.Finland_HomePage;
import com.esri.test.auto.pages.Finland_TukiPage;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This test case is to check the login functionality
 * 
 * @author balajih
 *
 */
public class Dist_Finland_TC02 extends ESRIWrappers {
	@BeforeClass
	@Parameters({ "browser" })
	public void startTestCase(String browser) {
		browserName = browser;
		dataSheetName = "Dist_Finland_TC02";
		testCaseName = "Dist_Finland_TC02 (POM)";
		testDescription = "Distributor Finland Test cases validating happy path";
	}

	@Test(dataProvider = "fetchdata")
	public void loginforSuccess(String FinlandHomeURL, String FinlandSupportURL, String Toimialat, String Tuotteet, String Palvelut_Tuki, String TutustuMeihin, String Rekrytointi, String Kayttajille, String ArcGISPlatform, String ArcGISOnline
			, String ArcGISDesktop, String ArcGISServer, String ArcGISDevelopers, String GEOSECMAArcGIS, String EsriFinlandOy, String Tuki) throws Throwable {
		
		openbrowser(FinlandHomeURL);
		new Finland_HomePage()
		/*.clickToimialat()
		.verifyToimialatList(Toimialat)
		.clickTuotteet()
		.verifyTuotteetList(Tuotteet)
		.clickPalvelut_Tuki()
		.verifyPalvelut_TukiList(Palvelut_Tuki)
		.clickTutustuMeihin()
		.verifyTutustuMeihinList(TutustuMeihin)
		.clickRekrytointi()
		.verifyRekrytointiList(Rekrytointi)
		.clickKäyttäjille()
		.verifyKäyttäjilleList(Kayttajille)
		.clickArcGISPaikkatietoalustaLink()
		.verifyArcGISPlatformlbl(ArcGISPlatform)
		.clickbsrBackBtn()
		.clickArcGISOnline()
		.verifyArcGISOnlinelbl(ArcGISOnline)
		.clickbsrBackBtn()
		.clickArcGISForDesktop()
		.verifyArcGISDesktoplbl(ArcGISDesktop)
		.clickbsrBackBtn()
		.clickArcGISForServer()
		.verifyArcGISforServerlbl(ArcGISServer)
		.clickbsrBackBtn()*/
		.clickArcGISforDevelopers()
		.verifyArcGISDeveloperlbl(ArcGISDevelopers)
		.clickbsrBackBtn()
		.clickGEOSECMAforArcGISlink()
		.verifyGEOSEMAArcGISlbl(GEOSECMAArcGIS)
		.clickbsrBackBtn()
		.clickOtaYhteyttAFooterlink()
		.verifyEsriFinlandOylbl(EsriFinlandOy);
		
		
		openbrowser(FinlandSupportURL);
		new Finland_TukiPage()
		.verifyTukilbl(Tuki);
	}

}
