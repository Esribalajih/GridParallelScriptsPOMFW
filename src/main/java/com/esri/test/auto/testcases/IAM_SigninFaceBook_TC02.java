package com.esri.test.auto.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.test.auto.pages.FacebookSigninPage;
import com.esri.test.auto.pages.HomePage;
import com.esri.test.auto.pages.SigninPage;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**This test case is to check the login functionality
 * @author balajih
 *
 */
public class IAM_SigninFaceBook_TC02  extends ESRIWrappers {
	@BeforeClass
	@Parameters({"browser"})
	  public void startTestCase(String browser) {
		 browserName=browser;
		 System.out.println("Browser: " + browser);
		 dataSheetName="IAM_SigninFaceBook_TC02";
		 testCaseName="IAM_SigninFaceBook_TC02 (POM)";
		 testDescription="Login ESRI Application using Facebook Account";
	  }

	  @Test(dataProvider="fetchdata")
	  public void loginforSuccess(String username,String password,String firstname, String fullname,String email) throws Throwable{
		  new SigninPage()
		  .clickFacebooklink()
		  .enterUserName(username)
		  .enterPassword(password)
		  .clickLoginBtn()
		  .verifyLoggedUserName(firstname)
		  .clickLoggedUserName()
		  .verifyUserFullName(fullname)
		  .verifyUserEmail(email)
		  .clickSignoutBtn()
		  .verifySignoutSuccess();
		  
	  }
	  

}
