package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.esri.test.auto.pages.Brazil_HomePage;
import com.esri.test.auto.pages.Brazil_SuporteImagemPage;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This test case is to check the login functionality
 * 
 * @author balajih
 *
 */
public class Dist_Brazil_TC01 extends ESRIWrappers {
	@BeforeClass
	@Parameters({ "browser" })
	public void startTestCase(String browser) {
		browserName = browser;
		dataSheetName = "Dist_Brazil_TC01";
		testCaseName = "Dist_Brazil_TC01 (POM)";
		testDescription = "Distributor Brazil Test cases validating happy path";
	}

	@Test(dataProvider = "fetchdata")
	public void loginforSuccess(String BrazilHomeURL, String Produtos, String Industrias, String Suporte,
			String Institucional, String Desafios, String ContatoLabel, String PlataformaArcGIS, String ArcGISDesktop,
			String ArcGISOnline, String LocationAnalytics, String EsriDevNetwork, String Searchbox,
			String PoliticadePrivacidade, String SuporteImagem, String BrazilSupportURL) throws Throwable {
		openbrowser(BrazilHomeURL);
		new Brazil_HomePage().clickProdutos().verifyProductosList(Produtos).clickIndustries()
				.verifyIndustriesList(Industrias).clickSuporte().verifySuporteList(Suporte).clickInstitucional()
				.verifyInstitucionalList(Institucional).click5Desafios().verify5DesafiosList(Desafios).clickContato()
				.verifyContatoPage(ContatoLabel).clickbsrBackBtn().clickPlataformaArcGIS()
				.verifyArGISPage(PlataformaArcGIS).clickbsrBackBtn().clickArcGISDesktop()
				.verifyArcGISDesktoplbl(ArcGISDesktop).clickbsrBackBtn().clickArcGISOnline()
				.verifyArcGISOnlinelbl(ArcGISOnline).clickbsrBackBtn().clickLocationAnalytics()
				.verifyLocAnalyticslbl(LocationAnalytics).clickbsrBackBtn().clickDesenvolvedores()
				.verifyEsriDevNtwklbl(EsriDevNetwork).clickbsrBackBtn().enterSearchTextBox(Searchbox).clickSearchIcon()
				.verifyResultsDisplaying().clickbsrBackBtn().clickContatoFooterLink().verifyContatoPage(ContatoLabel)
				.clickbsrBackBtn().clickPolDePriFooterLink().verifyPolDePriPage(PoliticadePrivacidade)
				.clickbsrBackBtn();
		/*
		 * .clickAcademiaGISFooterLink() .verifyArcGISOnlinelbl(ArcGISOnline)
		 * .clickbsrBackBtn();
		 */

		openbrowser(BrazilSupportURL);
		new Brazil_SuporteImagemPage().verifySuporteImagemlbl(SuporteImagem);

	}

}
