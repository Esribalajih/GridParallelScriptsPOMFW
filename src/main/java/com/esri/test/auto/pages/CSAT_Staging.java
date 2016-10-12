package com.esri.test.auto.pages;


import org.openqa.selenium.By;
import com.esri.test.auto.utils.Reporter;
import com.esri.test.auto.wrappers.ESRIWrappers;

/**
 * This is the CSAT Staging Page of IAM Application
 * 
 * @author udhayasundar
 *
 */
public class CSAT_Staging extends ESRIWrappers {
	
	public CSAT_Staging() throws Throwable {
		waitForPageLoad(15);
		if (!VerifyTitle("CSAT")) {
			Reporter.reportStep("This is not a CSAT Application page", "FAIL");
		}
	}

	// To login CSAT application page with user name & password	
	public CSAT_Staging(String uName, String pwd,String URL) throws Throwable {
		openbrowser(URL);
		handlingBAuthUsingRobo(uName, pwd);
		/*new Esri_Staging_SignIn()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickSignin();*/
		waitForPageLoad(10);
		if (!VerifyTitle("CSAT")) {
			Reporter.reportStep("This is not a CSAT Application page", "FAIL");
		}
	}

	// Enter the UserName
	public CSAT_Staging enterUserName(String userdata) throws Throwable {
		enterbyId(prop.getProperty("csat.username.Id"), userdata);
		return this;
	}

	// Enter the firstName
	public CSAT_Staging enterFirstName(String firstName) throws Throwable {
		enterbyId(prop.getProperty("csat.firstName.Id"), firstName);
		return this;
	}

	// Enter the LastName
	public CSAT_Staging enterLastName(String lastName) throws Throwable {
		enterbyId(prop.getProperty("csat.LastName.Id"), lastName);
		return this;
	}

	// Enter the email
	public CSAT_Staging enterEmail(String email) throws Throwable {
		enterbyId(prop.getProperty("csat.email.Id"), email);
		return this;
	}

	// Enter the Organization
	public CSAT_Staging enterOrganization(String org) throws Throwable {
		enterbyId(prop.getProperty("csat.organization.Id"), org);
		return this;
	}

	// Enter the number of records
	public CSAT_Staging enterNoOfRecords(String noOfRec) throws Throwable {
		enterbyId(prop.getProperty("csat.numberOfRec.Id"), noOfRec);
		return this;
	}

	// Click Search button
	public CSAT_Staging clickSearchBtn() throws Throwable {
		clickById(prop.getProperty("csat.searchbox.Id"));
		return this;
	}

	// Click Clear button
	public CSAT_Staging clickClearBtn() throws Throwable {
		clickbyClassName(prop.getProperty("csat.clearBtn.class"));
		return this;
	}
	
	//verify the Dp status with user name,  first Name, Last Name, email and Organization
	public CSAT_Staging verifyDPStatus(String username,String fName, String lName, String email, String org) throws Throwable{
		waitForPageLoad(15);
		int rowCount = getTableRowcountbyXpath(prop.getProperty("csat.userAccTableSize.xpath"));
		if(rowCount>0){
			for(int rowcnt=1;rowcnt<=rowCount;rowcnt++){
				//UserName td = 2, first Name =3 lastName=4 org=5 email=6 status 17 dp status = 18
				/*System.out.println(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 3)
						+" "+username	+" "+verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 4)
						+" "+fName	+" "+verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 5)
						+" "+ lName	+" "+verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 6) 
						+" "+ org   +" "+verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 7)+" "+ email);*/
				if(username.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 3))
						&& fName.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 4))
						&& lName.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 5))
						&& org.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 6)) 
						&& email.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 7))){  
					Reporter.reportStep("Dp Status :" + verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 18) + " for userName : "+username, "PASS");
					break;
				}
			}
		}
		return this;
	}
	
	public CSAT_Staging clickDPStatus(String username,String fName, String lName, String email, String org,String status) throws Throwable{
		int rowCount = getTableRowcountbyXpath(prop.getProperty("csat.userAccTableSize.xpath"));
		String dpStatus = null;
		if(rowCount>0){
			for(int rowcnt=1;rowcnt<=rowCount;rowcnt++){
				//UserName td = 2, first Name =3 lastName=4 org=5 email=6 status 17 dp status = 18
				if(username.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 3))
						&& fName.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 4))
						&& lName.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 5))
						&& org.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 6)) 
						&& email.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 7))){  
						dpStatus = verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 18).trim();
					if(dpStatus.equalsIgnoreCase(status)){
						clickbyXpath(prop.getProperty("csat.userAccTableSize.xpath")+"/tr["+rowcnt+"]/td[18]/a");						
						break;
					}
				}
			}
		}
		return this;
	}
	
	
	public CSAT_Staging verifySuspectDPStatus(String status) throws Throwable{
			waitForPageLoad(15);
			int rowCount = getTableRowcountbyXpath(prop.getProperty("csat.suspectTableSize.xpath"));
			if(rowCount>0){
				for(int rowcnt=1;rowcnt<=rowCount;rowcnt++){
					if(status.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.suspectTableSize.xpath"),rowcnt, 6))){  
						Reporter.reportStep("Dp Status :" + verifyTablecellValuebyXpath(prop.getProperty("csat.suspectTableSize.xpath"),rowcnt, 6), "PASS");
					}
				}
			}
			return this;
		}
		
		public CSAT_Staging changeDPStatus(String fromStatus, String toStatus ) throws Throwable{
			waitForPageLoad(3);
			int rowCount = getTableRowcountbyXpath(prop.getProperty("csat.suspectTableSize.xpath"));
			if(rowCount>0){
				for(int rowcnt=1;rowcnt<=rowCount;rowcnt++){
					System.out.println("Dp Status: " +fromStatus+"  "+verifyTablecellValuebyXpath(prop.getProperty("csat.suspectTableSize.xpath"),rowcnt, 6));
					if(fromStatus.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.suspectTableSize.xpath"),rowcnt, 6))){  
										
						clickbyJavaScript(prop.getProperty("csat.suspectTableSize.xpath")+"/tr["+rowcnt+"]/td[6]");
						waitForPageLoad(2);
						clickbyXpath(prop.getProperty("csat.suspectTableSize.xpath")+"/tr["+rowcnt+"]/td[6]/span[1]/span[1]/span[1]");
//						mouseClickByXpath(prop.getProperty("csat.suspectTableSize.xpath")+"/tr["+rowcnt+"]/td[6]");
//			     	    mouseClickByXpath(prop.getProperty("csat.suspectTableSize.xpath")+"/tr["+rowcnt+"]/td[6]");
//						mouseClickByXpath(prop.getProperty("csat.suspectTableSize.xpath")+"/tr["+rowcnt+"]/td[6]/span[1]/span[1]/span[1]");
						waitForPageLoad(2);
						int dropdownSize =  (int) driver.findElements(By.xpath(prop.getProperty("csat.dpStatusdrpdwnSize.xpath"))).size();
						System.out.println(dropdownSize);
						for(int rcnt=1;rcnt<=dropdownSize;rcnt++){
							if(toStatus.equalsIgnoreCase(getTextByXpath(prop.getProperty("csat.dpStatusdrpdwnvalue.xpath")+"/li["+rcnt+"]"))){
								System.out.println(getTextByXpath(prop.getProperty("csat.dpStatusdrpdwnvalue.xpath")+"/li["+rcnt+"]"));
								clickbyXpath(prop.getProperty("csat.dpStatusdrpdwnvalue.xpath")+"/li["+rcnt+"]");
								break;
							}
						}
						Reporter.reportStep("Dp Status :" + verifyTablecellValuebyXpath(prop.getProperty("csat.suspectTableSize.xpath"),rowcnt, 6), "PASS");
					}
				}
			}
			return this;
		}

		// Click save changes button
		public CSAT_Staging clickSaveChangesBtn() throws Throwable {
			clickbyXpath(prop.getProperty("csat.saveChangesBtn.xpath"));
			return this;
		}
		
		// Click Clear button
		public CSAT_Staging clickProfilesBtn() throws Throwable {
			clickbyXpath(prop.getProperty("csat.profilesBtn.xpath"));
			return this;
		}
		
		
		// click back button in browser
		public CSAT_Staging clickbsrBackBtn() throws Throwable {
			try {
				clickBrowserBackButton();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}
		
		public CSAT_Staging verifyAndChangeDPStatusCl_Sus(String username,String fName, String lName, String email, String org) throws Throwable{
			int rowCount = getTableRowcountbyXpath(prop.getProperty("csat.userAccTableSize.xpath"));
			String dpStatus = null;
			if(rowCount>0){
				for(int rowcnt=1;rowcnt<=rowCount;rowcnt++){
					//UserName td = 2, first Name =3 lastName=4 org=5 email=6 status 17 dp status = 18
					if(username.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 3))
							&& fName.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 4))
							&& lName.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 5))
							&& org.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 6)) 
							&& email.equalsIgnoreCase(verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 7))){  
							dpStatus = verifyTablecellValuebyXpath(prop.getProperty("csat.userAccTableSize.xpath"),rowcnt, 18).trim();
						if(dpStatus.equalsIgnoreCase("Cleared")){
							clickbyXpath(prop.getProperty("csat.userAccTableSize.xpath")+"/tr["+rowcnt+"]/td[18]/a");
							waitForPageLoad(10);
							changeDPStatus("Cleared","Suspect");
							clickSaveChangesBtn();
							clickbsrBackBtn();
							break;
						}
					}
				}
			}
			return this;
		}
		
}
