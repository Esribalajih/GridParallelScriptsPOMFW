package com.esri.test.auto.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public abstract class Reporter{

	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category;
	
	
	/*public static void reportStep(String desc, String status) {


		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(bw.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
		}

		// Write if it is successful or failure or information
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS, desc+test.
					addScreenCapture("./../reports/images/"+number+".jpg"));
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("./../reports/images/"+number+".jpg"));
			throw new RuntimeException("FAILED");
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	}*/
	public void reportStep(String desc, String status) {

		long snapNumber = 100000l;
		
		try {
			snapNumber= takeSnap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(desc);
		// Write if it is successful or failure or information
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS, desc+test.
					addScreenCapture("./images/"+snapNumber+".png"));
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("./images/"+snapNumber+".png"));
			throw new RuntimeException("FAILED");
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	}

	public abstract long takeSnap();

	public ExtentReports startResult(){
		extent = new ExtentReports("./reports/result.html", false);
		extent.loadConfig(new File("./extent-config.xml"));
		return extent;
	}

	public ExtentTest startTestCase(){
		test = extent.startTest(testCaseName, testDescription);
		return test;
		
	}

	public void stopTest(){
		extent.endTest(test);

	}

	public void endResult(){
		extent.flush();
	}


}
