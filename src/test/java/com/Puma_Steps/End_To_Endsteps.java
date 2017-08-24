package com.Puma_Steps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Puma_Pages.LoginPage;

import Base.Basestep;
import HappyPath.End_To_End;
import jxl.read.biff.BiffException;

public class End_To_Endsteps extends Basestep
{
	End_To_End co ;
	 @BeforeMethod
	  public void beforeMethod() throws Exception  {
		
		 co= PageFactory.initElements(driver,End_To_End.class);
	      
	  }
	
	
	/* @Test(priority=0)
  public void checkoutstep() throws Exception 
	  {
		  String ordernum = co.ProductCheckOut();
		   co.ProductCheckOut();
	 
	   
	  }*/
	 
	 @Test(priority=1)
	  public void checkout() throws Exception 
	  {
		 
		String ordernum =  co.ProductCheckOut();  
		co. OrderCancelFromRubiCon(ordernum);
		 co.OrderCancel_EmailVerification(ordernum);
	  }
	/* @Test(priority=2)
	 public void Emailverification() throws Exception, IOException, InterruptedException
	 {
		 co.OrderCancel_EmailVerification(ordernum);
	 }*/
	  
	  /*@Test(priority=2)
	  public void alert() throws InterruptedException
	  {
		 co.Handling_Alert();
		  
	  }*/
	 

		
	  
	  
	  

}
