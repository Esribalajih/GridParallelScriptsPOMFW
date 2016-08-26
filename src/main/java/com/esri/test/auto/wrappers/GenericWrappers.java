package com.esri.test.auto.wrappers;

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
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.esri.test.auto.utils.Reporter;

/**This method is to call the Grid Configurations
 * @author balajih
 *
 */
public class GenericWrappers {
	
	protected static RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandles,sHubUrl,sHubPort;
	private String primaryWindowHandle;
	private String ANY;
	
	public GenericWrappers(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./Config/config.properties")));
			sHubUrl=prop.getProperty("HUB");
			sHubPort=prop.getProperty("PORT");
			sUrl=prop.getProperty("ÜRL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**This method is to Invoke the Browser
	 * @author balajih
	 * @param browser
	 */
	public void invokeApp(String browser){
		boolean bReturn=false;
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(Platform.WINDOWS);
		//dc.setVersion(ANY);
		/*if (context.getCurrentXmlTest().getParameter("browser").equals("firefox")) { 
			  DesiredCapabilities capability = DesiredCapabilities.firefox();  
			        driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"),capability);
					driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					} 
					else if (context.getCurrentXmlTest().getParameter("browser").equals("chrome")){   
					DesiredCapabilities capability = DesiredCapabilities.chrome();
					driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"),capability);
					driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}
					else if (context.getCurrentXmlTest().getParameter("browser").equals("IE")) {   
					DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
					driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"),capability);  
			        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					}  
					else {                       
			        System.out.println("Not able to set Driver object");                
			        } */
			try {
				driver = new RemoteWebDriver(new URL("https://"+ sHubUrl +":"+ sHubPort +"/wd/hub"),dc);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(sUrl);
				
				primaryWindowHandle = driver.getWindowHandle();
				
					Reporter.reportStep("The Browser"+ browser +" launched Successfully", "PASS");
					bReturn=true;				

					Reporter.reportStep("The Browser"+ browser +" could not be launched Successfully", "FAIL");
				

					bReturn=false;
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
		prop.load(new FileInputStream(new File("D:/DEV/ESRI_TEST/com.esri.test.automation/src/test/resources/object.properties")));
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
				Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + idValue, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Reporter.reportStep("The data"+ data +" is not entered successfully in the field:" + idValue, "FAIL");
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
			Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + nameValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data"+ data +" is not entered successfully in the field:" + nameValue, "FAIL");
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
			Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + cnameValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data"+ data +" is not entered successfully in the field:" + cnameValue, "FAIL");
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
			Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + cssValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data"+ data +" is not entered successfully in the field:" + cssValue, "FAIL");
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
			Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + xpathValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The data"+ data +" is not entered successfully in the field:" + xpathValue, "FAIL");
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
		if(driver.getTitle().equalsIgnoreCase(title)){
			try {
				Reporter.reportStep("The title of the page"+title+" is matching successfully", "PASS");
				bReturn=true;
				
			} catch (Exception e) {
				Reporter.reportStep("The title of the page"+title+" is not matching successfully", "FAIL");
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
				Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + idValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data"+ data +" is not entered successfully in the field:" + idValue, "FAIL");
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
				Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + nameValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data"+ data +" is not entered successfully in the field:" + nameValue, "FAIL");
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
				Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + cnameValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data"+data +" is not entered successfully in the field:" + cnameValue, "FAIL");
					
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
				Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + cssValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data"+data +" is not entered successfully in the field:" + cssValue, "FAIL");
					
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
				Reporter.reportStep("The data"+ data +" is entered successfully in the field:" + xpathValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The data"+data +" is not entered successfully in the field:" + xpathValue, "FAIL");
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
				driver.findElement(By.id(idValue)).click();
				Reporter.reportStep("The button "+ idValue+" is clicked successfuly", "PASS");
				bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button "+ idValue+" is not clicked successfuly", "FAIL");
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
				driver.findElement(By.name(nameValue)).click();
				Reporter.reportStep("The button"+ nameValue+" is clicked successfuly", "PASS");
				bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button"+ nameValue+" is not clicked successfuly", "FAIL");
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
				driver.findElement(By.className(cnameValue)).click();
				Reporter.reportStep("The button"+ cnameValue+" is clicked successfuly", "PASS");
				bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button"+ cnameValue+" is not clicked successfuly", "FAIL");
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
				driver.findElement(By.cssSelector(cssValue)).click();
				Reporter.reportStep("The button"+ cssValue+" is clicked successfuly", "PASS");
				bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button"+ cssValue+" is not clicked successfuly", "FAIL");
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
				driver.findElement(By.xpath(xpathValue)).click();
				Reporter.reportStep("The button"+ xpathValue+" is clicked successfuly", "PASS");
				bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The button"+ xpathValue+" is not clicked successfuly", "FAIL");
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
				Reporter.reportStep("The element"+ linkTextValue+" is clicked successfuly", "PASS");
				bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The element"+ linkTextValue+" is not clicked successfuly", "FAIL");
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
				Reporter.reportStep("The element"+ partLinkTextValue+" is clicked successfuly", "PASS");
				bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The element"+ partLinkTextValue+" is not clicked successfuly", "FAIL");
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
			Reporter.reportStep("The element with "+ idValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ nameValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ cnameValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ cssValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ xpathValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ idValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ nameValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ cnameValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ cssValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The element with "+ xpathValue+" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value "+ data+" is not selected", "FAIL");
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
			Reporter.reportStep("The value in the Alert box"+data+" has been entered successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The value in the Alert box"+data+" has not been entered successfuly", "FAIL");
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
				Reporter.reportStep("The text in the Alert box"+data+" has been verified successfuly", "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			Reporter.reportStep("The text in the Alert box"+data+" has not been verified successfuly", "FAIL");
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
			Reporter.reportStep("The mouse hover to the"+idValue+" element is successful", "PASS");
			bReturn = true;
			
		} catch (Throwable e) {
			Reporter.reportStep("The mouse hover to the"+idValue+" element is not successful", "FAIL");
		}
		return bReturn;
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
