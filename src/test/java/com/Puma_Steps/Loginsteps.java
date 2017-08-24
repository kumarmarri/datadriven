package com.Puma_Steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Puma_Pages.LoginPage;

import Base.Basestep;


public class Loginsteps extends Basestep
{ 
	LoginPage lp;
	 @BeforeMethod
	  public void beforeMethod() throws Exception  {
		
		 
	      lp = PageFactory.initElements(driver,LoginPage.class); 
	     
	  }
	 
	  @Test
	  public void UserLogin() throws Exception 
	  {
		  
		lp.Enter_Email_Password();
	 
	   
	  }
	  
	  
	  
	  
	  
	  
}
