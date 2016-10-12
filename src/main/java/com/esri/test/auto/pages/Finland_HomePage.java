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
public class Finland_HomePage extends ESRIWrappers {
	
	public Finland_HomePage() throws Throwable {
		waitForPageLoad(10);
		if (!VerifyTitle("Esri Finland - Paikkatieto")) {
			Reporter.reportStep("This is not a Esri Finland - Paikkatieto (Finland) Home page.", "FAIL");
		} else
			System.out.println("Esri Finland - Paikkatieto Home page Launched Successfully");
	}

	// click Toimialat Tab
	public Finland_HomePage clickToimialat() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.Toimialatlink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Verify Toimialat Tab list
	public Finland_HomePage verifyToimialatList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disFinlandHome.Liiketoimintalbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disFinlandHome.Liiketoimintalbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Tuotteet Tab
	public Finland_HomePage clickTuotteet() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.Tuotteetlink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify Tuotteet Tab list
	public Finland_HomePage verifyTuotteetList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disFinlandHome.ArcGISPailbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disFinlandHome.ArcGISPailbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Palvelut & Tuki Tab
	public Finland_HomePage clickPalvelut_Tuki() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.PalvelutTukilink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify Palvelut & Tuki Tab list
	public Finland_HomePage verifyPalvelut_TukiList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disFinlandHome.Palvelutlbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disFinlandHome.Palvelutlbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click TutustuMeihin Tab
	public Finland_HomePage clickTutustuMeihin() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.Tutustumeihinlink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify TutustuMeihin Tab list
	public Finland_HomePage verifyTutustuMeihinList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disFinlandHome.EsriFinlandOylbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disFinlandHome.EsriFinlandOylbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Rekrytointi Tab
	public Finland_HomePage clickRekrytointi() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.Rekrytointilink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// verify Rekrytointi Tab list
	public Finland_HomePage verifyRekrytointiList(String data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(prop.getProperty("disFinlandHome.Rekrytointilbl.xpath"))));
			verifyValuebyXpath(prop.getProperty("disFinlandHome.Rekrytointilbl.xpath"), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// click Käyttäjille Tab
	public Finland_HomePage clickKäyttäjille() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.Kayttajillelink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	// verify Käyttäjille Tab list
		public Finland_HomePage verifyKäyttäjilleList(String data) throws Throwable {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(prop.getProperty("disFinlandHome.KayttajilleLbl.xpath"))));
				verifyValuebyXpath(prop.getProperty("disFinlandHome.KayttajilleLbl.xpath"), data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		
	// click ArcGIS-paikkatietoalusta Link
	public Finland_ArcGISPlatformPage clickArcGISPaikkatietoalustaLink() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.ArcGISPaikkatietoalustalink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Finland_ArcGISPlatformPage();
	}
	
	
	// click ArcGIS Online link
		public Finland_ArcGISOnlinePage clickArcGISOnline() throws Throwable {
			try {
				clickbyXpath(prop.getProperty("disFinlandHome.ArcGISOnlinelink.xpath"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Finland_ArcGISOnlinePage();
		}

	// click ArcGIS Desktop Link
	public Finland_ArcGISDesktopPage clickArcGISForDesktop() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.ArcGISforDesktoplink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Finland_ArcGISDesktopPage();
	}

	

	// click ArcGIS For Server link
	public finland_ArcGIServerPage clickArcGISForServer() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.ArcGISforServerlink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new finland_ArcGIServerPage();
	}

	// click ArcGIS for Developers link
	public Finland_ArcGISDeveloperPage clickArcGISforDevelopers() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.ArcGISforDeveloperslink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Finland_ArcGISDeveloperPage();
	}
	
	// click GEOSECMA for ArcGIS link
		public Finland_GEOSEMAArcGISPage clickGEOSECMAforArcGISlink() throws Throwable {
			try {
				clickbyXpath(prop.getProperty("disFinlandHome.GEOSECMAforArcGISlink.xpath"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Finland_GEOSEMAArcGISPage();
		}
		
	
	// click Ota YhteyttA footer icon link
	public Finland_YhteystiedotPage clickOtaYhteyttAFooterlink() throws Throwable {
		try {
			clickbyXpath(prop.getProperty("disFinlandHome.OtaYhteyttAFooterlink.xpath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Finland_YhteystiedotPage();
	}

		
}
