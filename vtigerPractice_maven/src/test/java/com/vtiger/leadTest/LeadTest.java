package com.vtiger.leadTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericLib.Baseclass;
import com.vtiger.genericLib.CommonUtils;
import com.vtiger.objectRepositoryLib.CreatingNewLead;
import com.vtiger.objectRepositoryLib.Home;
import com.vtiger.objectRepositoryLib.LeadInformations;
import com.vtiger.objectRepositoryLib.Leads;

public class LeadTest extends Baseclass {
	@Test
	public void createLeadTest() throws Throwable
	{
		Reporter.log("=======create lead with name and company========",true);
//		get data from excelsheet
	    Reporter.log("=====step2:get data from excel sheet=====",true);
		CommonUtils lib=new CommonUtils();
		String expectedFirstName=lib.getDataFromExcel("Sheet1",1,1);
		String expectedLastName=lib.getDataFromExcel("Sheet1",1,2);
		String expectedCompanyName=lib.getDataFromExcel("Sheet1",1,3);
		String expectedStringInfoMessage=lib.getDataFromExcel("Sheet1",1,4);
//		navigate to lead
		Reporter.log("=====step3:navigate to lead=====",true);
		Home home=PageFactory.initElements(driver, Home.class);
		home.navigateToLeadLink();
//		navigate create new lead
		Reporter.log("=====step4:navigate to create new lead=====",true);
		Leads lead=PageFactory.initElements(driver,Leads.class);
		lead.createLead();
//		create new lead 
		Reporter.log("=====step5:create new lead=====",true);
		CreatingNewLead createLead=PageFactory.initElements(driver,CreatingNewLead.class );
		createLead.createLead(expectedLastName, expectedFirstName, expectedCompanyName);
//	    verify lead info
		Reporter.log("=====step6:verify lead info=====", true);
		LeadInformations leadInfo=PageFactory.initElements(driver,LeadInformations.class);
		String actualFirstName=leadInfo.getLeadFirstName().getText();
		String actualLastName=leadInfo.getLeadLastName().getText();
		String actualCompanyName=leadInfo.getCompanyName().getText();
		String actualStringInfoMessage=leadInfo.getLeadInfoMessage().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualFirstName.trim(), expectedFirstName.trim());
		s.assertEquals(actualLastName.trim(), expectedLastName.trim());
		s.assertEquals(actualCompanyName.trim(), expectedCompanyName.trim());
		s.assertAll();
		Assert.assertTrue(actualStringInfoMessage.contains(expectedStringInfoMessage));
		Reporter.log("lead created successfully======pass",true);
		
		//new line 
		
	}

}
