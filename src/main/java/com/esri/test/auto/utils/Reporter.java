/**
 * 
 */
package com.esri.test.auto.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**This program is to Capture Test Results along with Screenshots
 * @author balajih
 *
 */
public class Reporter extends com.esri.test.auto.wrappers.ESRIWrappers {
	
	private static ExtentTest test;
	private static ExtentReports extent;
	//private static String testCaseName;
	//private static String testDescription;
	
	public static void reportStep(String desc, String status) throws Throwable{
		
		 long number = (long) Math.floor(Math.random()* 900000000L) + 100000000L;
		 
		 try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			e.printStackTrace();
			
			if(status.toUpperCase().equals("PASS")){
				test.log(LogStatus.PASS, desc+test.addScreenCapture("./reports/images/"+number+".jpg"));
			}else if(status.toUpperCase().equals("FAIL")){
				test.log(LogStatus.FAIL, desc+test.addScreenCapture("./reports/images/"+number+".jpg"));
				throw new RuntimeException("FAILED");
			}else if(status.toUpperCase().equals("INFO")){
				test.log(LogStatus.INFO, desc);
			}
			
		} 
		 
	}
		 
		 public static void startResult(){
			 extent = new ExtentReports("./reports/results.html",false);
			 }
		 
		 public static void startTestCase(){
			 test = extent.startTest(testCaseName, testDescription);
		 }
		 
		 public static void endResult(){
			 extent.endTest(test);
			 extent.flush();
		 }
		 
}
