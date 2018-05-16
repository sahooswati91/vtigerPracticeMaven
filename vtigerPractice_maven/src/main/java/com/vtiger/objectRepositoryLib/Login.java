package com.vtiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(name="user_name") WebElement userNameEdt;
	@FindBy(name="user_password") WebElement userPasswordEdt;
	@FindBy(id="submitButton") WebElement logInButton;
	public void logIn(String userName,String password)
	{
		userNameEdt.sendKeys(userName);	
		userPasswordEdt.sendKeys(password);
		logInButton.click();
	}

}
