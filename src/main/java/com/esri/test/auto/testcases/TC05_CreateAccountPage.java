package com.esri.test.auto.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * @author balajih
 *
 */
public class TC05_CreateAccountPage extends ESRIWrappers{
	
	@BeforeClass
	public void startTestCase(){
		 dataSheetName="TC03_CreateAccountPage";
		 testCaseName="TC03 Create Account (POM)";
		 testDescription="Account Creation using POM";
	}
	@Test(dataProvider="fetchdata")
	public void createaccount()
	{
		
	}
}
