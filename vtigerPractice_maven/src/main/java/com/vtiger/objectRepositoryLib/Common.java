package com.vtiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.WebdriverCommonLib;

public class Common extends WebdriverCommonLib {
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement logOutImg;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signOutText;
	public void logout()
	{
		WaitForElement(logOutImg);
		mouseMove(logOutImg);
		signOutText.click();
	}

}
