package com.vtiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.WebdriverCommonLib;

public class Home extends WebdriverCommonLib {
	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
	WebElement leadLink;
	public void navigateToLeadLink()
	{
		WaitForElement(leadLink);
		leadLink.click();
	}

}
