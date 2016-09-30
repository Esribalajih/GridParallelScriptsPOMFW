package com.esri.test.auto.wrappers;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.esri.test.auto.utils.Reporter;

/**This is the Generic Wrapper Methods called with in Pages and Test cases for Handling WebElements from the WebBrowser.
 * @author balajih
 *
 */
public class GenericWrappers {

	protected static RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandles,sHubUrl,sHubPort;
	private String primaryWindowHandle;
	private String ANY;
	/**This Contructor is used to load the configuration properties for Selenium Grid 2.0 
	 * 
	 */
	public GenericWrappers(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./Config/config.properties")));
			sHubUrl=prop.getProperty("HUB");
			sHubPort=prop.getProperty("PORT");
			sUrl=prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**This method is to Invoke the Browser
	 * @author balajih
	 * @param browser
	 * @throws Throwable 
	 * 
	 */
	public void invokeApp(String browser) throws Throwable{
		boolean bReturn=false;

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(Platform.WINDOWS);
		try {
			killAllDrivers();
			driver = new RemoteWebDriver(new URL("http://"+ sHubUrl +":"+ sHubPort +"/wd/hub"),dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();

			try {
				Reporter.reportStep("The Browser  "+ browser +" launched Successfully.", "PASS");
				bReturn=true;
			} catch (Exception e) {
				e.printStackTrace();


				Reporter.reportStep("The Browser  "+ browser +" could not be launched Successfully.", "FAIL");
				bReturn=false;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**This Method is to load Objects from the Object Property file
	 * @author balajih
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadObjects() throws FileNotFoundException, IOException{
		prop =new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/object.properties")));
	}

	/**This method will enter the value as text field using Id attribute to locate
	 * @author Balajih & udayasundar
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterbyId(String idValue,String data) throws Throwable {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}

	/**This method will enter the value as text field using Name attribute to locate
	 * @author Balajih & udayasundar
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterbyName(String nameValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}

	/**This method will enter the value as text field using ClassName attribute to locate
	 * @author Balajih & udayasundar
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterbyClassName(String cnameValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.className(cnameValue)).clear();
			driver.findElement(By.className(cnameValue)).sendKeys(data);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}
	/**This method will enter the value as text field using CssSelector attribute to locate
	 * @author Balajih & udayasundar
	 * @param cssValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean enterbyCssSelector(String cssValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.cssSelector(cssValue)).clear();
			driver.findElement(By.cssSelector(cssValue)).sendKeys(data);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}

	/**This method will enter the value as text field using Xpath attribute to locate
	 * @author Balajih & udayasundar
	 * @param xpathValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterbyXpath(String xpathValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}

	/**This method will verify the fetched title is matching or not.
	 * @author balajih
	 * @param title
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTitle(String title) throws Throwable {
		boolean bReturn=false;
		if(driver.getTitle().trim().equalsIgnoreCase(title)){
			try {
				Reporter.reportStep("The title of the page "+ title+" is matching successfully.", "PASS");
				bReturn=true;

			} catch (Exception e) {
				Reporter.reportStep("The title of the page "+ title+" is not matching successfully.", "FAIL");
				bReturn=false;
			}
		}
		return bReturn;
	}

	/**This method will verify the entered value in text field using Id attribute to locate
	 * @author balajih
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextbyId(String idValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			if(driver.findElement(By.id(idValue)).getText().equalsIgnoreCase(data)){
				Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}	
		return bReturn;
	}

	/**This method will verify the entered value in text field using Name attribute to locate
	 * @author balajih
	 * @param nameValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextbyName(String nameValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			if(driver.findElement(By.name(nameValue)).getText().equalsIgnoreCase(data)){
				Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}	
		return bReturn;
	}

	/**This method will verify the entered value in text field using Class Name attribute to locate
	 * @author balajih
	 * @param cnameValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextbyClassName(String cnameValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			if(driver.findElement(By.className(cnameValue)).getText().equalsIgnoreCase(data)){
				Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");

		}	
		return bReturn;
	}
	/**This method will verify the entered value in text field using CSS Selector attribute to locate
	 * @author balajih
	 * @param cssValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextbyCssSelector(String cssValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			if(driver.findElement(By.cssSelector(cssValue)).getText().equalsIgnoreCase(data)){
				Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");

		}	
		return bReturn;
	}
	/**This method will verify the entered value in text field using Xpath Value attribute to locate
	 * @author balajih
	 * @param xpathValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTextbyXpath(String xpathValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			if(driver.findElement(By.xpath(xpathValue)).getText().equalsIgnoreCase(data)){
				Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
				bReturn = true;
			}
			else Reporter.reportStep("The data "+ data +" which is not matching correctly.", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}	
		return bReturn;
	}
	/**This method will check the click of the buttons or links using the Id attribute to locate
	 * @author balajih
	 * @param idValue
	 * @return
	 * @throws Throwable 
	 */
	public boolean clickById(String idValue) throws Throwable{
		boolean bReturn = false;
		try {
			Reporter.reportStep("The button is clicked successfuly", "PASS");
			driver.findElement(By.id(idValue)).click();
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button is not clicked successfuly", "FAIL");
		}	
		return bReturn;
	}

	/**This method will check the click of the buttons or links using the Name attribute to locate
	 * @author balajih
	 * @param nameValue
	 * @return
	 * @throws Throwable 
	 */
	public boolean clickByName(String nameValue) throws Throwable{
		boolean bReturn = false;
		try {
			Reporter.reportStep("The button is clicked successfuly", "PASS");
			driver.findElement(By.name(nameValue)).click();
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button is not clicked successfuly", "FAIL");
		}	
		return bReturn;
	}

	/**This method will check the click of the buttons or links using the Class Name attribute to locate
	 * @author balajih
	 * @param cnameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean clickbyClassName(String cnameValue) throws Throwable{
		boolean bReturn = false;
		try {
			Reporter.reportStep("The button is clicked successfuly", "PASS");
			driver.findElement(By.className(cnameValue)).click();
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button is not clicked successfuly", "FAIL");
		}	
		return bReturn;
	}
	/**This method will check the click of the buttons or links using the CSS Selector attribute to locate
	 * @author balajih
	 * @param cssValue
	 * @return
	 * @throws Throwable
	 */
	public boolean clickbyCssSelector(String cssValue) throws Throwable{
		boolean bReturn = false;
		try {
			Reporter.reportStep("The button is clicked successfuly", "PASS");
			driver.findElement(By.cssSelector(cssValue)).click();
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button is not clicked successfuly", "FAIL");
		}	
		return bReturn;
	}
	/**This method will check the click of the buttons or links using the Xpath attribute to locate
	 * @author balajih
	 * @param xpathValue
	 * @return
	 * @throws Throwable
	 */
	public boolean clickbyXpath(String xpathValue) throws Throwable{
		boolean bReturn = false;
		try {
			Reporter.reportStep("The button is clicked successfuly", "PASS");
			driver.findElement(By.xpath(xpathValue)).click();
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button is not clicked successfuly", "FAIL");
		}	
		return bReturn;
	}
	/**This method will check the click of the link text attribute to locate
	 * @author balajih
	 * @param linkTextValue
	 * @return
	 * @throws Throwable
	 */
	public boolean clickbyLinkText(String linkTextValue) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.linkText(linkTextValue)).click();
			Reporter.reportStep("The Link is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Link is not clicked successfuly", "FAIL");
		}	
		return bReturn;
	}

	/**This method will check the click of the partial link text attribute to locate
	 * @author balajih
	 * @param partLinkTextValue
	 * @return
	 * @throws Throwable
	 */
	public boolean clickbyPartialLinkText(String partLinkTextValue) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.partialLinkText(partLinkTextValue)).click();
			Reporter.reportStep("The Link is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Link is not clicked successfuly", "FAIL");
		}	
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by Id attribute to locate
	 * @author balajih
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean selectByIdWithvalue(String idValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.id(idValue)));
			dropdown.selectByValue(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +"is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by Name attribute to locate
	 * @author balajih
	 * @param nameValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByNameWithValue(String nameValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.name(nameValue)));
			dropdown.selectByValue(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +"is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by Class Name attribute to locate
	 * @author balajih
	 * @param cnameValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectbyClassNamewithValue(String cnameValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.className(cnameValue)));
			dropdown.selectByValue(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by CSS Selector attribute to locate
	 * @author balajih
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean selectbyCssSelectorWithValue(String cssValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.cssSelector(cssValue)));
			dropdown.selectByValue(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by Xpath attribute to locate
	 * @author balajih
	 * @param xpathValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectbyXpathWithValue(String xpathValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
			dropdown.selectByValue(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}		
	/**This method is used to fetch the data from dropdown using select by visible text with Id attribute to locate
	 * @author balajih
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByIdWithText(String idValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.id(idValue)));
			dropdown.selectByVisibleText(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by visible text with Name attribute to locate
	 * @author balajih
	 * @param nameValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByNameWithText(String nameValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.name(nameValue)));
			dropdown.selectByVisibleText(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by visible text with Class Name attribute to locate
	 * @author balajih
	 * @param cnameValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectbyClassNamewithText(String cnameValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.className(cnameValue)));
			dropdown.selectByVisibleText(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by visible text with CSS Selector attribute to locate
	 * @author balajih
	 * @param cssValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectbyCssSelectorWithText(String cssValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.cssSelector(cssValue)));
			dropdown.selectByVisibleText(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to fetch the data from dropdown using select by visible text with Xpath attribute to locate
	 * @author balajih
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	public boolean selectbyXpathWithText(String xpathValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
			dropdown.selectByVisibleText(data);
			Reporter.reportStep("The element is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data +" is not selected", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to click OK button in Alert box
	 * @author balajih
	 * @return
	 * @throws Throwable
	 */
	public boolean clickOkAlertBox() throws Throwable {
		boolean bReturn = false;
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Reporter.reportStep("The Alert ok button is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Alert ok button has not been clicked", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to click CANCEL button in Alert box
	 * @author balajih
	 * @return
	 * @throws Throwable
	 */
	public boolean clickCancelAlertBox() throws Throwable {
		boolean bReturn = false;
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			Reporter.reportStep("The Alert Cancel button is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Alert Cancel button has not been clicked", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to enter the value in the Alert box
	 * @author balajih
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean enterValueAlertBox(String data) throws Throwable {
		boolean bReturn = false;
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(data);
			Reporter.reportStep("The value in the Alert box "+ data +" has been entered successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value in the Alert box "+ data +" has not been entered successfuly", "FAIL");
		}
		return bReturn;
	}
	/**This method is used to verify the text in the Alert box
	 * @author balajih
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTextAlertBox(String data) throws Throwable{
		boolean bReturn = false;
		try {
			Alert alert = driver.switchTo().alert();
			if(alert.getText().equalsIgnoreCase(data)){
				Reporter.reportStep("The text in the Alert box "+ data +" has been verified successfuly", "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The text in the Alert box "+ data +" has not been verified successfuly", "FAIL");
		}	
		return bReturn;
	}

	/**This method is used to Mouse hover on the element using ID element.
	 * @author balajih
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseHoverById(String idValue) throws Throwable{
		boolean bReturn=false;
		new Actions(driver).moveToElement(driver.findElement(By.id(idValue))).build().perform();
		try {
			Reporter.reportStep("The mouse hover to the element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the element is not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to switch the frame with id
	 *
	 * @author balajih & Udhay
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean switchToFrameByID(String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.switchTo().frame(driver.findElement(By.id(data)));
			Reporter.reportStep("Frame switched successfully", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("Frame not switched successfully", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to sleep for the given seconds
	 *
	 * @author balajih
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public void waitForPageLoad(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to switch the frame with id
	 *
	 * @author balajih
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public String switchToWindow() throws Throwable {
		// boolean bReturn = false;
		String currentWin = null;
		try {
			currentWin = driver.getWindowHandle();
			for (String newWindow : driver.getWindowHandles()) {
				driver.switchTo().window(newWindow);
			}
			// bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("Winodw not switched successfully", "FAIL");
		}
		return currentWin;
	}

	/**
	 * This method is used to open a new URL
	 * @author balajih
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean openbrowser(String URL) throws Throwable {
		boolean bReturn = false;
		try {
			driver.get(URL);
			waitForPageLoad(10);
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep(URL+" : not launched successfully", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the fetched title is matching or not using the partial title.
	 *
	 * @author balajih
	 * @param title
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTitleEndsWith(String title) throws Throwable {
		boolean bReturn = false;
		if (driver.getTitle().trim().endsWith(title)) {
			try {
				Reporter.reportStep("The title of the page" + title + " is matching successfully", "PASS");
				bReturn = true;

			} catch (Exception e) {
				Reporter.reportStep("The title of the page" + title + " is not matching successfully", "FAIL");
				bReturn = false;
			}
		}
		return bReturn;
	}

	/**
	 * This method will enter the value using ClassName attribute in I/O device
	 * @author Balajih & udayasundar
	 * @param cnameValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean enterkeysbyClassName(String cnameValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			driver.findElement(By.className(cnameValue)).sendKeys(Keys.ENTER);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will enter the value using Xpath attribute in I/O device
	 * @author Balajih
	 * @param xpathValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean enterkeysbyXpath(String xpathValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			driver.findElement(By.className(xpathValue)).sendKeys(Keys.ENTER);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will enter the value using ID attribute in I/O device
	 * @author Balajih
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean enterkeysbyID(String idValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			driver.findElement(By.className(idValue)).sendKeys(Keys.ENTER);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will enter the value by handling Browser Authentication using I/O device
	 *
	 * @author Balajih & udayasundar
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public void handlingBAuthUsingRobo(String uName, String pwd) {
		try{
			//wait - increase this wait period if required
			waitForPageLoad(5);

			//create robot for keyboard operations
			Robot rb = new Robot();

			//Enter user name by ctrl-v
			StringSelection username = new StringSelection(uName);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);

			//tab to password entry field
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			waitForPageLoad(2);

			//Enter password by ctrl-v
			StringSelection passwd = new StringSelection(pwd);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(passwd, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);

			//press enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);

			//wait
			waitForPageLoad(2);

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * This method will verify the Web Table using Xpath
	 * @author balajih
	 * @param xpathValue
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Throwable
	 */
	public String verifyTablecellValuebyXpath(String xpathValue, int rowNum, int colNum) throws Throwable {
		String value = null;
		try {
			value = driver.findElement(By.xpath(xpathValue+"/tr["+rowNum+"]/td["+colNum+"]")).getText();
		} catch (Exception e) {
		}
		return value;
	}

	public int getTableRowcountbyXpath(String xpathValue) throws Throwable {
		int rowCount=0;
		try {
			rowCount = (int) driver.findElements(By.xpath(xpathValue+"/tr")).size();
		} catch (Exception e) {
		}
		return rowCount;
	}

	public int getTableColcountbyXpath(String xpathValue) throws Throwable {
		int colCount=0;
		try {
			colCount = (int) driver.findElements(By.xpath(xpathValue+"/tr[1]/td")).size();
		} catch (Exception e) {
		}
		return colCount;
	}

	/*public WebDriver getdriver(){
            driver = (WebDriver)rdriver.get();
        return driver;
    }*/

	/**This Method is used to Kill the Browser drivers from task manager
	 * @author balajih
	 */
	public void killAllDrivers() {
		try {
			Process p =
					Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			try {
				p.waitFor();
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			p = Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe*");
			try {
				p.waitFor();
				Thread.sleep(3000);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**This method is to clear Cache & Cookies in a browser
	 * @author balajih & Udhaysundar
	 * @param browserName
	 * @param capabilities
	 */
	//
	public void clearCookies(String browserName, DesiredCapabilities capabilities){
		if(browserName.equalsIgnoreCase("firefox")||browserName.equalsIgnoreCase("Firefox")){
			driver.manage().deleteAllCookies();
		}
		else if(browserName.equalsIgnoreCase("IE")||browserName.equalsIgnoreCase("internet explorer")){
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		}
		else if(browserName.equalsIgnoreCase("chrome")||browserName.equalsIgnoreCase("Chrome")){
			driver.manage().deleteAllCookies();
		}
	}
	/**
	 * This method will Upload the File from windows into Browser.
	 * @author Mohamed
	 * @param location
	 * @param 
	 * @return

	 */
	public void uploadFile(String location) throws Throwable{
		try{
			//wait - increase this wait period if required
			waitForPageLoad(3);
			StringSelection stringSelection = new StringSelection(location);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_CONTROL);
			ro.keyPress(KeyEvent.VK_V);
			ro.keyRelease(KeyEvent.VK_V);
			ro.keyRelease(KeyEvent.VK_CONTROL);
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/**This method is to Switch to Default Content from nested windows
	 * @author balajih & Udhaysundar
	 * @return
	 */
	public boolean switchToDefaultContent(){
		boolean bReturn = false;
		try{
			driver.switchTo().defaultContent();
			bReturn = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}



	/**
	 * This method is used to Mouse hover on the element using xpath element.
	 * 
	 * @author Udhayasundar
	 * @param xpathValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseHoverByXpath(String xpathValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathValue))).build().perform();
			Reporter.reportStep("The mouse hover to the" + xpathValue + " element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the" + xpathValue + " element is not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to Mouse hover on the element using CSS element.
	 * 
	 * @author Udhayasundar
	 * @param cssValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseHoverByCSS(String cssValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssValue))).build().perform();
			Reporter.reportStep("The mouse hover to the" + cssValue + " element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the" + cssValue + " element is not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to Mouse hover on the element using class name element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseHoverByClassName(String classNameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.className(classNameValue))).build().perform();
			Reporter.reportStep("The mouse hover to the" + classNameValue + " element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the" + classNameValue + " element is not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to Mouse hover on the element using name element.
	 * 
	 * @author Udhayasundar
	 * @param nameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseHoverByName(String nameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.name(nameValue))).build().perform();
			Reporter.reportStep("The mouse hover to the" + nameValue + " element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the" + nameValue + " element is not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to Mouse hover on the element using LinkText element.
	 * 
	 * @author Udhayasundar
	 * @param linkTextValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseHoverByLinkText(String linkTextValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkTextValue))).build().perform();
			Reporter.reportStep("The mouse hover to the" + linkTextValue + " element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the" + linkTextValue + " element is not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to Mouse hover on the element using Partial Link Text element.
	 * 
	 * @author Udhayasundar
	 * @param pLinkTextValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseHoverByPLinkText(String pLinkTextValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.partialLinkText(pLinkTextValue))).build().perform();
			Reporter.reportStep("The mouse hover to the" + pLinkTextValue + " element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the" + pLinkTextValue + " element is not successful", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to fetch the data from dropdown using select by Id
	 * attribute to locate
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByIdWithindex(String idValue, int data) throws Throwable {
		boolean bReturn = false;
		try {
			Select dropdown = new Select(driver.findElement(By.id(idValue)));
			dropdown.selectByIndex(data);
			Reporter.reportStep("The element with " + idValue + " is selected with value" + data + " successfuly",
					"PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value " + data + " is not selected", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to click the element by mouse hover using ID element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseClickByID(String idValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.id(idValue))).click();
			Reporter.reportStep("The element clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element click was not successful", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to click the element by mouse hover using className element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseClickByClass(String classNameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.className(classNameValue))).click();
			Reporter.reportStep("The element clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element clicked was not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to click the element by mouse hover using ID element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actionClickByID(String idValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).click(driver.findElement(By.id(idValue)));
			Reporter.reportStep("The element clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element clicked was not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to click the element by mouse hover using className element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actionClickByClass(String classNameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).click(driver.findElement(By.className(classNameValue)));
			Reporter.reportStep("The element clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element clicked was not successful", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to context click the element by mouse hover using ID element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseCnxttClickById(String idValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.id(idValue))).contextClick();
			Reporter.reportStep("The element Context clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element Context clicked was not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to context click the element by mouse hover using ClassName element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mouseCnxttClickByClass(String classNameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.className(classNameValue))).contextClick();
			Reporter.reportStep("The element Context clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element Context clicked was not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to context click the element by mouse hover using id element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actioncnxtClickById(String idValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).contextClick(driver.findElement(By.id(idValue)));
			Reporter.reportStep("The element Context clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element Context clicked was not successful", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to context click the element by mouse hover using class element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actioncnxtClickByClass(String classNameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).contextClick(driver.findElement(By.className(classNameValue)));
			Reporter.reportStep("The element Context clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element Context clicked was not successful", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to double click the element by mouse hover using id element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actiondbleClickById(String idValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).doubleClick(driver.findElement(By.id(idValue)));
			Reporter.reportStep("The element double clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element double clicked was not successful", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to double click the element by mouse hover using class name element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actiondbleClickByClass(String classNameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).doubleClick(driver.findElement(By.className(classNameValue)));
			Reporter.reportStep("The element double clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element double clicked was not successful", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to double click the element by mouse hover using id element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mousedbleClickById(String idValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.id(idValue))).doubleClick();
			Reporter.reportStep("The element double clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element double clicked was not successful", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to double click the element by mouse hover using class name element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean mousedbleClickByclass(String classNameValue) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.className(classNameValue))).doubleClick();
			Reporter.reportStep("The element double clicked successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The element double clicked was not successful", "FAIL");
		}
		return bReturn;
	}



	/**
	 * This method is used to drag and drop the element by Mouse hover using ID element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean DragAndDropById(String source, String target) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).dragAndDrop(driver.findElement(By.id(source)), driver.findElement(By.id(target)));
			Reporter.reportStep("Drag and dropped successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("Drag and dropped was not performed successfully", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to drag and drop the element by Mouse hover using classname element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean DragAndDropByclass(String source, String target) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).dragAndDrop(driver.findElement(By.className(source)), driver.findElement(By.className(target)));
			Reporter.reportStep("Drag and dropped successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("Drag and dropped was not performed successfully", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to send the keys by Mouse hover on the element using ID element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actionMseSendKeysById(String idValue,String data) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.id(idValue))).sendKeys(data);
			Reporter.reportStep("The "+data+" entered successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The "+data+" not entered successfully", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to send the keys by Mouse hover on the element using className element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actionMseSendKeysByclass(String classNameValue,String data) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).moveToElement(driver.findElement(By.className(classNameValue))).sendKeys(data);
			Reporter.reportStep("The "+data+" entered successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The "+data+" not entered successfully", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to send the keys by Mouse hover on the element using ID element.
	 * 
	 * @author Udhayasundar
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actionSendKeysById(String idValue,String data) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).sendKeys(driver.findElement(By.id(idValue)),data);
			Reporter.reportStep("The "+data+" entered successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The "+data+" not entered successfully", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to send the keys by Mouse hover on the element using className element.
	 * 
	 * @author Udhayasundar
	 * @param classNameValue
	 * @return
	 * @throws Throwable
	 */
	public boolean actionSendKeysByclass(String classNameValue,String data) throws Throwable {
		boolean bReturn = false;
		try {
			new Actions(driver).sendKeys(driver.findElement(By.className(classNameValue)),data);
			Reporter.reportStep("The "+data+" entered successfully", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			Reporter.reportStep("The "+data+" not entered successfully", "FAIL");
		}
		return bReturn;
	}


	/**
	 * This method is used to switch the frame with index value
	 * 
	 * @author Udhayasundar
	 * @param indexValue
	 * @return
	 * @throws Throwable
	 */
	public boolean switchToFrameByIndex(int indexValue) throws Throwable {
		boolean bReturn = false;
		try {
			driver.switchTo().frame(indexValue);
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("Frame not switched successfully", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method is used to compare the value between the element and input data
	 * if new line exist it replace with space
	 * 
	 * @author Udhayasundar
	 * @param xpathValue, data
	 * @return
	 * @throws Throwable
	 */
	public boolean verifyValueWithNewLinebyXpath(String xpathValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			String lblValue = getTextByXpath(xpathValue).trim()
					.replace("\n", " ");
			if (lblValue.equalsIgnoreCase(data)) {
				Reporter.reportStep(lblValue + " label displaying successfully", "PASS");
				bReturn=true;
			} else {
				Reporter.reportStep(data + " label is not displayed", "FAIL");
				bReturn = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}

	/**
	 * This method is used to compare the value between the element and input data
	 * if new line exist it replace with space
	 * 
	 * @author Udhayasundar
	 * @param xpathValue, data
	 * @return
	 * @throws Throwable
	 */
	public boolean verifyValuebyXpath(String xpathValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			String lblValue = getTextByXpath(xpathValue).trim();
			if (lblValue.equalsIgnoreCase(data)) {
				Reporter.reportStep(lblValue + " label displaying successfully", "PASS");
				bReturn=true;
			} else {
				Reporter.reportStep(data + " label is not displayed", "FAIL");
				bReturn = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}
	/**
	 * This method will check the element is displaying or not using xpath
	 * 
	 * @author Udhayasundar
	 * @param xpathValue
	 * @return
	 * @throws Throwable
	 */
	public boolean checkElementIsDisplayed(String xpathValue) throws Throwable {
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(xpathValue)).isDisplayed();
			Reporter.reportStep("Element is present/ displayed on the screen", "PASS");
			bReturn = true;
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("Element is not present/ displayed on the screen", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will return the web element Text using xpath
	 * 
	 * @author Udhayasundar
	 * @param xpathValue
	 * @return
	 * @throws Throwable
	 */
	public String getTextByXpath(String xpathValue) throws Throwable {
		String textValue = null;
		try {
			textValue = driver.findElement(By.xpath(xpathValue)).getText();
			Reporter.reportStep("The Captured text is :"+ textValue, "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("The text is not captured", "FAIL");
		}
		return textValue;
	}

	/**
	 * This method will return the web element Text using ID
	 * 
	 * @author Balajih
	 * @param idValue
	 * @return
	 * @throws Throwable
	 */
	public String getTextByID(String idValue) throws Throwable {
		String textValue = null;
		try {
			textValue = driver.findElement(By.id(idValue)).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textValue;
	}

	/** This method is used to click the element using Java script
	 * @author udhayasundar
	 * @param xpathValue
	 * @return
	 * @throws Throwable
	 */
	public void clickbyJavaScript(String xpathValue) throws Throwable{

		WebElement element = driver.findElement(By.xpath(xpathValue));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}


	/** This method is used to compare the value between the element and input data
	 * @author udhayasundar
	 * @param idValue, data
	 * @return
	 * @throws Throwable
	 */
	public boolean verifyMessagebyId(String idValue, String data) throws Throwable {
		boolean bReturn = false;
		try {
			String lblValue = getTextByID(idValue).trim();
			if (lblValue.equalsIgnoreCase(data)) {
				Reporter.reportStep(lblValue + " message displaying successfully", "PASS");
				bReturn = true;
			} else {
				Reporter.reportStep(data + " message is not displayed", "FAIL");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}


	/** This method is used to get text value using LinkText
	 * @author Sivaprakash
	 * @throws Throwable
	 */
	public String getTextUsingLinkText(String linkText) throws Throwable {
		String textvalue = null;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
			textvalue = element.getText();
			Reporter.reportStep("received text value ", "PASS");
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.reportStep("text value is not received", "FAIL");
		}
		return textvalue;
	}

	/** This method is used to view the element using scrollbar
	 * @author Sivaprakash
	 * @throws Throwable
	 */

	public void scrollIntoViewbyId(String id) throws Throwable {
		try {

			WebElement element = driver.findElement(By.id(id));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Reporter.reportStep("The text value is received", "PASS");
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.reportStep("The text value is not received", "FAIL");
		}
	}


	/** This method is used to view the element using scrollbar
	 * @author Sivaprakash
	 * @throws Throwable
	 */


	public void scrollIntoViewbyXpath(String xpath) throws Throwable {
		try {

			WebElement element = driver.findElement(By.xpath(xpath));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.reportStep("text value is not received", "FAIL");
		}
	}

	/**This method is to click on the Browser Back button
	 * @author balajih
	 * @throws Throwable
	 */
	public void clickBrowserBackButton() throws Throwable{
		try {
			driver.navigate().back();
			Reporter.reportStep("Clicked Browser Back button successfully", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("Clicked Browser Back button un-successfully", "FAIL");
		}
	} 

	/**This method is to quit the current Browser opened for testing
	 * @author balajih
	 * @throws Throwable
	 */
	public void quitBrowser() throws Throwable{

		try {
			driver.quit();

		} catch (Throwable e) {
			Reporter.reportStep("The Browser" + driver.getCapabilities().getBrowserName()+ "could not be closed", "FAIL");
			e.printStackTrace();
		}
	}

}
