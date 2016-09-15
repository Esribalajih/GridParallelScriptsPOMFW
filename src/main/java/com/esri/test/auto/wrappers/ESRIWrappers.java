package com.esri.test.auto.wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.esri.test.auto.utils.DataInputProvider;
import com.esri.test.auto.utils.Reporter;
import com.relevantcodes.extentreports.ExtentTest;



public class ESRIWrappers extends GenericWrappers{
	
	protected String browserName;

	protected String dataSheetName;
/*	protected static String testCaseName;
	protected static String testDescription;*/
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		startResult();
		loadObjects();
	  }
	@Parameters("browser")
	 @BeforeMethod
	 	  public void beforeMethod(String browserName) {
		 startTestCase();
		 invokeApp(browserName);
	  }



   @DataProvider(name="fetchdata")
  public Object[][] getdata() throws Throwable {
	  return DataInputProvider.getSheet(dataSheetName);
    
  }
 
   
  @AfterClass(alwaysRun=true)
  public void afterMethod() throws Throwable {
	
	  endResult();
	  quitBrowser();
  }
  	
  @AfterMethod(alwaysRun=true)
  public void afterClass() throws Throwable {
	
	  stopTest();
	  quitBrowser();
  }
/*    @AfterSuite
  public void afterSuite() throws Throwable {
    	Reporter.endSuite();
    	
  }
*/
}
