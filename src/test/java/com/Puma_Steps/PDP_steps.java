package com.Puma_Steps;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Puma_Pages.LoginPage;
import com.Puma_Pages.Myaccount;
import com.Puma_Pages.PDP_Page;

import Base.Basestep;

public class PDP_steps extends Basestep
{
	PDP_Page pdp;
    
	 @BeforeMethod
	  public void beforeMethod()   {
		System.out.println("inside my account before method"+ driver.toString());
	     pdp = PageFactory.initElements(driver,PDP_Page.class);
	     
	  }
	 
	 @Test
	 public void quantitychange() throws InterruptedException
	 {
		 pdp.Selectingitemsize();
	 }

}
