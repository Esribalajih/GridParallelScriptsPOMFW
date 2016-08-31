package imageSubmissionPortalTestcases;

import org.testng.annotations.Test;

import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.GenericWrappers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ImageSubmissionDropdown extends GenericWrappers{
	
	protected String browserName;
	//protected static String testCaseName;
	//protected static String testDescription;
	@BeforeSuite
	 @Parameters("browser")
	public void beforeSuite() throws FileNotFoundException, IOException {
		Reporter.startResult();
		//loadObjects();
	 }
		
	 @BeforeClass
	   public void beforeClass() {
		// Reporter.startTestCase();
		 invokeApp(browserName);
	  }
	/* public void startTestCase() {
			 testCaseName="TC02 Image submission Portal Page (POM)";
			 testDescription="This is the Image Submission portal";
		}*/

	@Test(alwaysRun=true, threadPoolSize=3)
	public void ImageSubmissionPortaltest() throws InterruptedException {
		try {
			//driver.get("http://www.esri.com/events/image-submissions#/home");
		} catch (Exception e) {
			System.out.println("The exception occured"+e);
		}
		System.out.println("The Browser launched successfully");
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[1]/div[1]/h1"));
		System.out.println("The Title of the page verified successfully");
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/h2"));
		System.out.println("The Title of the Section verified successfully");
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/div[1]/label/span/span/span/select/option[3]")).click();
		System.out.println("The Event got selected");
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/div[2]/label/span/div/label[1]/input")).click();
		System.out.println("The Image radio button selected");
		System.out.println("The folowing label checked - Are you a Federal Government Employee?");
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/div[3]/label/span/div/label[2]/input")).click();
		System.out.println("The No radio button selected");
		driver.findElement(By.xpath(".//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/input")).click();
		System.out.println("The button 'Get Started' clicked successfully");
		Thread.sleep(100);
		driver.findElement(By.xpath(".//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div/h3"));
		System.out.println("Copyright Permission and Release Form - Title verified");
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div/label")).click();
		System.out.println("Copyright Permission and Release Form Agreement Clicked");
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[3]/div/div/input[2]")).click();
		System.out.println("The Continue button clicked successfully");
		Thread.sleep(100);
		driver.findElement(By.xpath("//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[1]/h3"));
		System.out.println("The title Matches");
	}
       
       @AfterSuite
       public void afterSuite() throws Throwable {
         	Reporter.endResult();
         	quitBrowser();

	
	
}
}
