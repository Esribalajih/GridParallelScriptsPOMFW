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

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.esri.test.auto.utils.Reporter;

/**This method is to call the Grid Configurations
 * @author balajih
 *
 */
public class GenericWrappers extends Reporter{

	protected RemoteWebDriver driver;
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
	 */
	public void invokeApp(String browser){
		boolean bReturn=false;

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(Platform.WINDOWS);
		//dc.setVersion(ANY);

		try {
			driver = new RemoteWebDriver(new URL("http://"+ sHubUrl +":"+ sHubPort +"/wd/hub"),dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();

			try {
				reportStep("The Browser"+ browser +" launched Successfully", "PASS");
				bReturn=true;
			} catch (Exception e) {
				e.printStackTrace();
				reportStep("The Browser"+ browser +" could not be launched Successfully", "FAIL");
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
		prop.load(new FileInputStream(new File("D:/Working_on_LT/Working_on_LT/com.esri.test.automation/src/test/resources/object.properties")));
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
			reportStep("The data"+ data +" is entered successfully in the field:" + idValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + idValue, "FAIL");
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
			reportStep("The data"+ data +" is entered successfully in the field:" + nameValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + nameValue, "FAIL");
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
			reportStep("The data"+ data +" is entered successfully in the field:" + cnameValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + cnameValue, "FAIL");
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
			reportStep("The data"+ data +" is entered successfully in the field:" + cssValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + cssValue, "FAIL");
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
			reportStep("The data"+ data +" is entered successfully in the field:" + xpathValue, "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + xpathValue, "FAIL");
		}
		return bReturn;
	}

	/**This method will verify the fetched title is matching or not.
	 * @author balajih
	 * @param title
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTitle(String title){
		boolean bReturn=false;
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase(title)){
			try {
				reportStep("The title of the page"+ title+" is matching successfully", "PASS");
				bReturn=true;

			} catch (Exception e) {
				reportStep("The title of the page"+ title+" is not matching successfully", "FAIL");
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
				reportStep("The data"+ data +" is entered successfully in the field:" + idValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + idValue, "FAIL");
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
				reportStep("The data"+ data +" is entered successfully in the field:" + nameValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + nameValue, "FAIL");
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
				reportStep("The data"+ data +" is entered successfully in the field:" + cnameValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + cnameValue, "FAIL");

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
				reportStep("The data"+ data +" is entered successfully in the field:" + cssValue, "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + cssValue, "FAIL");

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
			String text=driver.findElement(By.xpath(xpathValue)).getText();
			System.out.println(driver.findElement(By.xpath(xpathValue)).getText());
			if(data.trim().contains(text.trim())){
				reportStep("The data"+ data +" is entered successfully in the field:" + xpathValue, "PASS");
				bReturn = true;
			}
			else reportStep("The data"+ data +" is not entered successfully in the field:" + xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep("The data"+ data +" is not entered successfully in the field:" + xpathValue, "FAIL");
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
			reportStep("The button "+ idValue +" is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The button "+ idValue +" is not clicked successfuly", "FAIL");
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
			reportStep("The button"+ nameValue +" is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The button"+ nameValue +" is not clicked successfuly", "FAIL");
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
			reportStep("The button"+ cnameValue +" is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The button"+ cnameValue +" is not clicked successfuly", "FAIL");
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
			reportStep("The button"+ cssValue +" is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The button"+ cssValue +" is not clicked successfuly", "FAIL");
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
			reportStep("The button"+ xpathValue +" is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The button"+ xpathValue +" is not clicked successfuly", "FAIL");
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
			reportStep("The element"+ linkTextValue +" is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The element"+ linkTextValue +" is not clicked successfuly", "FAIL");
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
			reportStep("The element"+ partLinkTextValue +" is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The element"+ partLinkTextValue +" is not clicked successfuly", "FAIL");
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
			reportStep("The element with "+ idValue +"is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +"is not selected", "FAIL");
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
			reportStep("The element with "+ nameValue +"is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +"is not selected", "FAIL");
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
			reportStep("The element with "+ cnameValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The element with "+ cssValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The element with "+ xpathValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The element with "+ idValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The element with "+ nameValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The element with "+ cnameValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The element with "+ cssValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The element with "+ xpathValue +" is selected with value"+ data+" successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value "+ data +" is not selected", "FAIL");
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
			reportStep("The Alert ok button is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The Alert ok button has not been clicked", "FAIL");
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
			reportStep("The Alert Cancel button is clicked successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The Alert Cancel button has not been clicked", "FAIL");
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
			reportStep("The value in the Alert box"+ data +" has been entered successfuly", "PASS");
			bReturn = true;
		} catch (Exception e) {
			reportStep("The value in the Alert box"+ data +" has not been entered successfuly", "FAIL");
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
				reportStep("The text in the Alert box"+ data +" has been verified successfuly", "PASS");
				bReturn = true;
			}
		} catch (Exception e) {
			reportStep("The text in the Alert box"+ data +" has not been verified successfuly", "FAIL");
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
			reportStep("The mouse hover to the"+ idValue +" element is successful", "PASS");
			bReturn = true;

		} catch (Throwable e) {
			reportStep("The mouse hover to the"+ idValue +" element is not successful", "FAIL");
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
	public boolean switchToFrameByID(String data) throws Throwable {
		boolean bReturn = false;
		try {
			driver.switchTo().frame(driver.findElement(By.id(data)));
			bReturn = true;
		} catch (Exception e) {
			reportStep("Frame not switched successfully", "FAIL");
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
            reportStep("Winodw not switched successfully", "FAIL");
        }
        return currentWin;
    }

    /**
     * This method is used to open a new URL
     *
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
            reportStep(URL+" : not launched successfully", "FAIL");
        }
        return bReturn;
    }

    /**
     * This method will verify the fetched title is matching or not.
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
                reportStep("The title of the page" + title + " is matching successfully", "PASS");
                bReturn = true;

            } catch (Exception e) {
                reportStep("The title of the page" + title + " is not matching successfully", "FAIL");
                bReturn = false;
            }
        }
        return bReturn;
    }

    /**
     * This method will enter the value keyboard buttons
     *
     * @author Balajih & udayasundar
     * @param idValue
     * @param data
     * @return
     * @throws Throwable
     */
    public boolean enterkeysbyClassName(String cnameValue) throws Throwable {
    	boolean bReturn = false;
    	try {
    		driver.findElement(By.className(cnameValue)).sendKeys(Keys.ENTER);
    		// reportStep("The data "+ data +" is entered successfully
    		// in the field:" + cnameValue, "PASS");
    		bReturn = true;
    	} catch (Exception e) {
    		// reportStep("The data "+ data +" is not entered
    		// successfully in the field:" + cnameValue, "FAIL");
    	}
    	return bReturn;
    }

    public void enterBrowseruNamePwd(String uName, String pwd) {
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
     * This method will enter the value keyboard buttons
     *
     * @author Balajih & udayasundar
     * @param idValue
     * @param data
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

    //To kill browser drivers
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
if(browserName.equalsIgnoreCase("firefox")||browserName.equalsIgnoreCase("ff")){
            driver.manage().deleteAllCookies();
        }
        else if(browserName.equalsIgnoreCase("IE")||browserName.equalsIgnoreCase("internetexplorer")){
            capabilities = DesiredCapabilities.internetExplorer();
capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        }
        else if(browserName.equalsIgnoreCase("chrome")||browserName.equalsIgnoreCase("ch")){
            driver.manage().deleteAllCookies();
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

	/**This method is to quit the current Browser opened for testing
	 * @author balajih
	 * @throws Throwable
	 */
	public void quitBrowser() throws Throwable{

		try {
			driver.quit();

		} catch (Throwable e) {
			//reportStep("The Browser" + driver.getCapabilities().getBrowserName()+ "could not be closed", "FAIL");
			e.printStackTrace();
		}
	}
public long takeSnap() {
	 long number = (long) Math.floor(Math.random()* 900000000L) + 100000000L;
	 
	
		 try {
			File srcFile = driver.getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(srcFile, new File("./reports/images/"+number+".png"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return number;
		 
	
}
}
