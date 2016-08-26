package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.SigninPage;

/**This test case is to check the login functionality
 * @author balajih
 *
 */
public class TC01_SigninPage extends com.esri.test.auto.wrappers.ESRIWrappers{
	 @BeforeClass
	  public void startTestCase() {
		 browserName="chrome";
		 dataSheetName="TC01_Signin";
		 testCaseName="TC01 Signin (POM)";
		 testDescription="Login to ESRI Application using POM";
	  }

	  @Test(dataProvider="fetchdata")
	  public void loginforSuccess(String username,String password) throws Throwable{
		  new SigninPage()
		  .enterUserName(username)
		  .enterPassword(password)
		  .clickSignin();
		
		  
	  }
	  


}
