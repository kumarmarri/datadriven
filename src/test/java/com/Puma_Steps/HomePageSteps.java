package com.Puma_Steps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Puma_Pages.Home_Page;

import Base.Basestep;
import jxl.read.biff.BiffException;

public class HomePageSteps extends Basestep
{
	Home_Page hp;
	
	@BeforeMethod
	
	public void beforemethod()
	{
		hp= PageFactory.initElements(driver, Home_Page.class );
		
	}
	
	@Test (priority=0)
	
	public void checkmegamenumousehover() throws IOException, InterruptedException, BiffException
	{
		hp.MegaMenuMouseHoverFunctionality();
		
	}

}
