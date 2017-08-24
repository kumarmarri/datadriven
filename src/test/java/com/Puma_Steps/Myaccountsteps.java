
package com.Puma_Steps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Puma_Pages.LoginPage;
import com.Puma_Pages.Myaccount;
import com.Puma_Pages.RegistrationPage;

import Base.Basestep;

public class Myaccountsteps extends Basestep
{
  Myaccount ma;
  //LoginPage lp;
	 @BeforeMethod
	  public void beforeMethod()   {
		System.out.println("inside my account before method"+ driver.toString());
	      ma = PageFactory.initElements(driver,Myaccount.class);
	      
	     // lp = PageFactory.initElements(driver,LoginPage.class);
	      
	  }
	 
	 
	 @Test (priority=0)
	 private void usermyaccount() throws IOException, InterruptedException
	 {
		 ma.UserNavigationDashBoard();
		
	 }
	 
	 @Test (priority=1)
	 private void useraccountinformation() throws IOException, InterruptedException
	 {
		 
		Thread.sleep(3000);
		 ma.UserNavigationToAccountInformation();
	 }
	 
	 
	
}
