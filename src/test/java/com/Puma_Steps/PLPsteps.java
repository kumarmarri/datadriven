package com.Puma_Steps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Puma_Pages.LoginPage;
import com.Puma_Pages.PLP_Page;

import Base.Basestep;

public class PLPsteps extends Basestep
{

	PLP_Page plp;
	 @BeforeMethod
	  public void beforeMethod() throws Exception  {
		
	      plp = PageFactory.initElements(driver,PLP_Page.class);
	      
	  }
	 
	 
	 @Test
	 private void plppage() throws IOException, InterruptedException
	 {
		 System.out.print("i am in PLP page");
		 Thread.sleep(3000);
		 plp.Selecting_item_Based_on_Filters();
	 }
}
