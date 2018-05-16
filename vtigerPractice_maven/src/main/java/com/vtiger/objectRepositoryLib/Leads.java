package com.vtiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.WebdriverCommonLib;

public class Leads extends WebdriverCommonLib {
	@FindBy(xpath="//img[contains(@title,'Create Lead')]")
	WebElement createLeadLookup;
	public void createLead()
	{
		WaitForElement(createLeadLookup);
		createLeadLookup.click();
	}

}
