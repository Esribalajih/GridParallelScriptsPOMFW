package com.esri.test.auto.testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.HomePage;
import com.esri.test.auto.pages.SigninPage;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This test case is to check the login functionality
 * @author balajih
 *
 */
public class IAM_SignInESRI_TC01  extends ESRIWrappers {
	@BeforeClass
		@Parameters({"browser"})
	  public void startTestCase(String browser) {
		 browserName=browser;
		 dataSheetName="IAM_SignInESRI_TC01";
		 testCaseName="IAM_SignInESRI_TC01 (POM)";
		 testDescription="Login to ESRI Application using ESRI Account";
	  }

	  @Test(dataProvider="fetchdata")
	  public void loginforSuccess(String username,String password,String userNm, String  userFullName, String email) throws Throwable{
		  new SigninPage()
		  .enterUserName(username)
		  .enterPassword(password)
		  .clickSignin()
//		   new HomePage()
		   .verifyLoggedUserName(userNm)
		   .clickLoggedUserName()
		   .verifyUserFullName(userFullName)
		   .verifyUserEmail(email)
		   .clickSignoutBtn()
		   .verifySignoutSuccess();
	  }
	  

}
