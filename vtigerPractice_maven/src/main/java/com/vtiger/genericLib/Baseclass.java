package com.vtiger.genericLib;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.objectRepositoryLib.Common;
import com.vtiger.objectRepositoryLib.Login;


public class Baseclass {
	public static WebDriver driver;
	@BeforeClass
	public void configLaunchBrowser() throws Throwable
	{
		CommonUtils lib=new CommonUtils();
		Properties p=lib.getDataFromProperyFile();
		String pBrowser=p.getProperty("browser");
		if(pBrowser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(pBrowser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(pBrowser.equals("ie"))
		{
			System.setProperty("webdriver.ie.diver","./src/main/resources/IEDriverServer.exe");
		    driver=new InternetExplorerDriver();
		}
	}
	@BeforeMethod
	public void configLogin() throws Throwable
	{
		CommonUtils lib=new CommonUtils();
		Properties p=lib.getDataFromProperyFile();
		String urlForVtiger=p.getProperty("url");
		String adminName=p.getProperty("username");
		String passWord=p.getProperty("password");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlForVtiger);
		Login lgin=PageFactory.initElements(driver,Login.class);
		lgin.logIn(adminName, passWord);
		
	}
	@AfterMethod
	public void configCloseBrowser()
	{
		Common cn=PageFactory.initElements(driver, Common.class);
		cn.logout();
	}
	@AfterClass
	public void configLogout()
	{
		driver.close();
	}

}
