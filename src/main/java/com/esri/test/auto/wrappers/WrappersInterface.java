/**
 * 
 */
package com.esri.test.auto.wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;

/**This is a Wrappers Interfaces used for Generic Wrappers Methods
 * @author balajih
 *
 */
public interface WrappersInterface {
	
	
	
	public void invokeApp(String browser);
	
	/**This Method is to load Objects from the Object Property file
	 * @author balajih
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadObjects();
	
	/**This method will enter the value as text field using Id attribute to locate
	 * @author Balajih
	 * @param idValue - name of the webelement
	 * @param data - The data to be sent to the Webelement.
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterById(String idValue,String data) throws Throwable;
	
	/**This method will enter the value as text field using Name attribute to locate
	 * @author Balajih
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the Webelement.
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterByName(String nameValue,String data) throws Throwable;
	
	/**This method will enter the value as text field using ClassName attribute to locate
	 * @author Balajih
	 * @param cnameValue - name of the webelement
	 * @param data - The data to be sent to the Webelement.
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterByClassName(String cnameValue,String data) throws Throwable;
	
	/**This method will enter the value as text field using CssSelector attribute to locate
	 * @author Balajih
	 * @param cssValue - name of the webelement
	 * @param data - The data to be sent to the Webelement.
	 * @return
	 * @throws Throwable
	 */
	public boolean enterByCssSelector(String cssValue,String data) throws Throwable;
	
	/**This method will enter the value as text field using Xpath attribute to locate
	 * @author Balajih
	 * @param xpathValue - name of the webelement
	 * @param data - The data to be sent to the Webelement.
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterByXpath(String xpathValue,String data) throws Throwable;
	
	/**This method will enter the value as text field using tagname attribute to locate
	 * @author Balajih 
	 * @param tagValue - name of the webelement
	 * @param data - The data to be sent to the Webelement.
	 * @return
	 * @throws Throwable 
	 */
	public boolean enterByTagname(String tagValue,String data) throws Throwable;
	
	/**This method will verify the fetched title is matching or not.
	 * @author balajih
	 * @param title
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTitle(String title) throws Throwable;
	
	/**This method will verify the entered value in text field using Id attribute to locate
	 * @author balajih
	 * @param idValue - name of the webelement
	 * @param data - The data to be sent to the Webelement.
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextById(String idValue,String data) throws Throwable;
	
	/**This method will verify the entered value in text field using Name attribute to locate
	 * @author balajih
	 * @param nameValue - name of the webelement
	 * @param data - The Data to be sent to the WebElement
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextByName(String nameValue,String data) throws Throwable;
	
	/**This method will verify the entered value in text field using Class Name attribute to locate
	 * @author balajih
	 * @param cnameValue - name of the webelement
	 * @param data - The Data to be sent to the WebElement
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextByClassName(String cnameValue,String data) throws Throwable;
	
	/**This method will verify the entered value in text field using CSS Selector attribute to locate
	 * @author balajih
	 * @param cssValue - name of the webelement
	 * @param data - The Data to be sent to the WebElement
	 * @return
	 * @throws Throwable 
	 */
	public boolean VerifyTextByCssSelector(String cssValue,String data) throws Throwable;
	
	/**This method will verify the entered value in text field using Xpath Value attribute to locate
	 * @author balajih
	 * @param xpathValue - name of the webelement
	 * @param data - The Data to be sent to the WebElement
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTextByXpath(String xpathValue,String data) throws Throwable;
	
	/**This method will verify the entered value in text field using tagName attribute to locate
	 * @author balajih
	 * @param tagValue - name of the webelement
	 * @param data - The Data to be sent to the WebElement
	 * @return
	 * @throws Throwable
	 */
	public boolean VerifyTextBytagName(String tagValue,String data) throws Throwable;
	
	/**This method will check the click of the buttons or links using the Id attribute to locate
	 * @author balajih
	 * @param idValue - name of the webelement
	 * @return
	 * @throws Throwable 
	 */
	public boolean clickById(String idValue) throws Throwable;
	
	/**This method will check the click of the buttons or links using the Name attribute to locate
	 * @author balajih
	 * @param nameValue - name of the webelement
	 * @return
	 * @throws Throwable 
	 */
	public boolean clickByName(String nameValue) throws Throwable;
	
	/**This method will check the click of the buttons or links using the Class Name attribute to locate
	 * @author balajih
	 * @param cnameValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickByClassName(String cnameValue) throws Throwable;
	
	/**This method will check the click of the buttons or links using the CSS Selector attribute to locate
	 * @author balajih
	 * @param cssValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickByCssSelector(String cssValue) throws Throwable;
	
	/**This method will check the click of the buttons or links using the Xpath attribute to locate
	 * @author balajih
	 * @param xpathValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickByXpath(String xpathValue) throws Throwable;
	
	/**This method will check the click of the link text attribute to locate
	 * @author balajih
	 * @param linkTextValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickByLinkText(String linkTextValue) throws Throwable;
	
	/**This method will check the click of the partial link text attribute to locate
	 * @author balajih
	 * @param partLinkTextValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickByPartialLinkText(String partLinkTextValue) throws Throwable;
	
	/**This method will check the click of the partial link text attribute to locate
	 * @author balajih
	 * @param tagNameValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickBytagName(String tagNameValue) throws Throwable;
	
	/**This method will check the click of the check box using the Xpath attribute to locate
	 * @author balajih
	 * @param xpathValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickChkBoxByXpath(String xpathValue) throws Throwable;
	
	/**This method will check the click of the check box using the Xpath attribute to locate
	 * @author balajih
	 * @param xpathValue - name of the webelement
	 * @return
	 * @throws Throwable
	 */
	public boolean clickRadioBtnByXpath(String xpathValue) throws Throwable;
	
	/**This method is used to fetch the data from dropdown using select By Id attribute to locate
	 * @author balajih
	 * @param idValue - name of the webelement
	 * @param data - The Data to be sent to the WebElement
	 * @return
	 * @throws Throwable 
	 */
	public boolean selectByIdWithvalue(String idValue, String data) throws Throwable;
	
	/**This method is used to fetch the data from dropdown using select By Name attribute to locate
	 * @author balajih
	 * @param nameValue - name of the webelement
	 * @param data - The Data to be sent to the WebElement
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByNameWithValue(String nameValue, String data) throws Throwable;
}
