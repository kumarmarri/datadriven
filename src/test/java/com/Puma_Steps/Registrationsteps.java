package com.Puma_Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Puma_Pages.LoginPage;
import com.Puma_Pages.RegistrationPage;

import Base.Basestep;


public class Registrationsteps extends Basestep
{

	RegistrationPage rp;
	 @BeforeMethod
	  public void beforeMethod()   {
		
	      rp = PageFactory.initElements(driver,RegistrationPage.class);
	      
	    /*Driver.Initialize();
		 driver = Driver.Instance;
		Driver.Instance.navigate().to(Configuration.url.baseurl);
	      */
	  }
	 
	 @Test(priority =0)
	 private void Backlink()
	 {
		rp. checking_The_functionality_of_BackLink();
	 }
	
	 @Test(priority=1)
	 private void userregistration()
	 {
		 rp.User_Account_Registration();
	 }
	 
}
