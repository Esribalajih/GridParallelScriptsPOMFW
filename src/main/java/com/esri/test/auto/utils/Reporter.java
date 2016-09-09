/**
 * 
 */
package com.esri.test.auto.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
	
	
	public static void reportStep(String desc, String status) throws Throwable{
		
		 long number = (long) Math.floor(Math.random()* 900000000L) + 10000000L;
		 try {
			 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
			if(status.toUpperCase().equals("PASS")){
				test.log(LogStatus.PASS, desc+test.addScreenCapture("./images/"+number+".jpg"));
			}else if(status.toUpperCase().equals("FAIL")){
				test.log(LogStatus.FAIL, desc+test.addScreenCapture("./images/"+number+".jpg"));
				//throw new RuntimeException("FAILED");
			}else if(status.toUpperCase().equals("INFO")){
				test.log(LogStatus.INFO, desc);
			}
	}
		 
		 public static void startResult(){
			 extent = new ExtentReports("./reports/results.html",true);
			// extent.loadConfig(new File("./extent-config.xml"));
			 }
		 
		 public static void startTestCase(){
			 test = extent.startTest(testCaseName);
		 }
		 
		 public static void endResult(){
			 extent.endTest(test);
		}
		 
		 public static void endSuite(){
			 extent.flush();
			 extent.close();
		 }
		 
}
