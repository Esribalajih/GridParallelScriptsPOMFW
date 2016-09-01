package com.esri.test.auto.wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.esri.test.auto.utils.DataInputProvider;
import com.esri.test.auto.utils.Reporter;

public class ESRIWrappers extends com.esri.test.auto.wrappers.GenericWrappers{
	
	protected String browserName;
	public String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		Reporter.startResult();
		loadObjects();
	 }
		
	 @BeforeMethod
	  public void beforeMethod() {
		 Reporter.startTestCase();
		 try {
			invokeApp(browserName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	  }

   @DataProvider(name="fetchdata")
  public Object[][] getdata() throws Throwable {
	 // System.out.println(DataInputProvider.getSheet(dataSheetName));
   return DataInputProvider.getSheet(dataSheetName);
  }
 
  @AfterMethod
  public void afterMethod() {
	  
  }

    @AfterSuite
  public void afterSuite() throws Throwable {
    	Reporter.endResult();
    	quitBrowser();
  }
}
