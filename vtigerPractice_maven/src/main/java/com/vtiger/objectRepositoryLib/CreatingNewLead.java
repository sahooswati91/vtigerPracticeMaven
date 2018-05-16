package com.vtiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.WebdriverCommonLib;

public class CreatingNewLead extends WebdriverCommonLib {
	@FindBy(name="lastname") WebElement lastNameEdt;
	
	@FindBy(name="firstname") WebElement firstNameEdt;
	
	@FindBy(name="company") WebElement companyEdt;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	WebElement saveLeadBtn;
	
	public void createLead(String lastName,String firstName,String company)
	{
		lastNameEdt.sendKeys(lastName);
		firstNameEdt.sendKeys(firstName);
		companyEdt.sendKeys(company);
		saveLeadBtn.click();
	}

}
