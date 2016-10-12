package com.esri.test.auto.wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;

<<<<<<< HEAD
import org.testng.annotations.AfterClass;
=======
>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto
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
<<<<<<< HEAD
	
=======

>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto
	protected String browserName;
<<<<<<< HEAD

	protected String dataSheetName;
/*	protected static String testCaseName;
	protected static String testDescription;*/
	
=======
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;

>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		startResult();
		loadObjects();
<<<<<<< HEAD
	  }
	@Parameters("browser")
	 @BeforeMethod
	 	  public void beforeMethod(String browserName) {
		 startTestCase();
		 invokeApp(browserName);
	  }


=======
	}
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browserName) throws Throwable {
		Reporter.startTestCase();
		invokeApp(browserName);
	}
>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto

<<<<<<< HEAD
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
=======
	@DataProvider(name="fetchdata")
	public Object[][] getdata() throws Throwable {
		return DataInputProvider.getSheet(dataSheetName);
	}
	
	@AfterMethod
	public void afterMethod() throws Throwable {
		Reporter.endResult();
		quitBrowser();
	}

	@AfterSuite
	public void afterSuite() throws Throwable {
		Reporter.endSuite();

	}

>>>>>>> branch 'master' of https://github.com/Esribalajih/ESRI-SEL-Auto
}
