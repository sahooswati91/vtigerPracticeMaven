package com.vtiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadInformations {
	@FindBy(id="dtlview_First Name") 
	WebElement leadFirstName;
	
	public WebElement getLeadFirstName() {
		return leadFirstName;
	}

	@FindBy(id="dtlview_Last Name")
	WebElement leadLastName;
	
	public WebElement getLeadLastName() {
		return leadLastName;
	}

	@FindBy(id="mouseArea_Company")
	WebElement companyName;

	public WebElement getCompanyName() {
		return companyName;
	}
	
	@FindBy(xpath="//span[contains(text(),'Lead Information')]")
	WebElement leadInfoMessage;

	public WebElement getLeadInfoMessage() {
		return leadInfoMessage;
	}
	
	
	
	

}
