package com.vtiger.genericLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebdriverCommonLib {
	public void WaitForElement(WebElement element)
	{
		int wait=0;
		while(wait<40)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable t)
			{
				try
				{
					Thread.sleep(1000);
					wait++;
				}
				catch(InterruptedException i)
				{
					
				}
			}
		}
	}
	public void mouseMove(WebElement wb)
	{
		Actions act=new Actions(Baseclass.driver);
		act.moveToElement(wb).perform();
	}

}
