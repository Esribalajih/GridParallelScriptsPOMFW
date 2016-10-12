package com.esri.test.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the Brazil Home Page of ESRI Distributor Application
 * 
 * @author Udhayasundar S
 *
 */
public class Brazil_HomePage extends ESRIWrappers {
	public Brazil_HomePage() throws Throwable {
		waitForPageLoad(5);
		if (!VerifyTitle("Imagem")) {
			Reporter.reportStep("This is not a Imagem (Brazil) Home page.", "FAIL");
		} else
			System.out.println("Brazil Home page Launched Successfully");
	}

	// click Produtos Tab
	public Brazil_HomePage clickProdutos() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.Produtoslink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Verify Produtos Tab list
	public Brazil_HomePage verifyProductosList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disBrazilHome.PltfrmArcGISlbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disBrazilHome.PltfrmArcGISlbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click industies Tab
	public Brazil_HomePage clickIndustries() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.industrieslink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify industies Tab list
	public Brazil_HomePage verifyIndustriesList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disBrazilHome.Educalbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disBrazilHome.Educalbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click suporte Tab
	public Brazil_HomePage clickSuporte() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.suportelink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify suporte Tab list
	public Brazil_HomePage verifySuporteList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disBrazilHome.suportelbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disBrazilHome.suportelbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click institucional Tab
	public Brazil_HomePage clickInstitucional() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.sobrelink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify institucional Tab list
	public Brazil_HomePage verifyInstitucionalList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disBrazilHome.sobrelbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disBrazilHome.sobrelbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click 5 Desafios Tab
	public Brazil_HomePage click5Desafios() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.desafios05link.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify 5 Desafios Tab list
	public Brazil_HomePage verify5DesafiosList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disBrazilHome.5Desafioslbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disBrazilHome.5Desafioslbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Contato Tab
	public Brazil_ContatoPage clickContato() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.contatolink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_ContatoPage();
	}

	// click Plataforma ArcGIS Link
	public Brazil_ArcGISPage clickPlataformaArcGIS() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.PlataformaArcGISlink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_ArcGISPage();
	}

	// click ArcGIS Desktop Link
	public Brazil_ArcGISDesktopPage clickArcGISDesktop() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.ArcGISDesktoplink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_ArcGISDesktopPage();
	}

	// click ArcGIS Online link
	public Brazil_ArcGISOnlinePage clickArcGISOnline() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.ArcGISOnlinelink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_ArcGISOnlinePage();
	}

	// click Location Analytics link
	public Brazil_LocationAnalyticsPage clickLocationAnalytics() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.LocationAnalyticslink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_LocationAnalyticsPage();
	}

	// click Desenvolvedores link
	public Brazil_ESRIDevNtwkPage clickDesenvolvedores() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.Desenvolvedoreslink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_ESRIDevNtwkPage();
	}

	// click search icon link
	public Brazil_PesquisarPage clickSearchIcon() throws Throwable {
		try {
			clickById(prop.getProperty("disBrazilHome.searchIcon.id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_PesquisarPage();
	}

	// enter the data to search text box
	public Brazil_HomePage enterSearchTextBox(String data) throws Throwable {
		try {
			enterbyId(prop.getProperty("disBrazilHome.searchTextBox.id"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Política de Privacidade footer icon link
	public Brazil_ContatoPage clickContatoFooterLink() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disBrazilHome.contatiFooterlink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Brazil_ContatoPage();
	}

	// click Política de Privacidade footer link
		public Brazil_PoliticadePrivacidadePage clickPolDePriFooterLink() throws Throwable {
			try {
				clickbyXpath(prop.getProperty("disBrazilHome.PoliticadePrivacidadeFooterlink.xpath"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Brazil_PoliticadePrivacidadePage();
		}
		
		
		// click Academia GIS footer link
		public Brazil_ArcGISOnlinePage clickAcademiaGISFooterLink() throws Throwable {
			try {
				clickbyXpath(prop.getProperty("disBrazilHome.AcademiaGISFooterlink.xpath"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Brazil_ArcGISOnlinePage();
		}
	
}
