package com.Puma_Pages;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.text.html.HTML.Attribute;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jxl.read.biff.BiffException;



public class Home_Page extends PageUtilities{

	public Home_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//ul[@class = 'digimeg-group digimeg-main-nav']/li")
	private List<WebElement> Megamenu;
	
	@FindBy(xpath = "//button[@title='Search'] ")
	private WebElement searchButton;
	
	public void MegaMenuMouseHoverFunctionality() throws IOException, InterruptedException
	{
		int size=Megamenu.size();
		System.out.println("MegaMenu length"+ size);
		for(int i=0; i<=Megamenu.size();i++)
		{
			
			mouseOver(Megamenu.get(i));
			Thread.sleep(1000);
			
		}
		
		
	}
	
	/*public void search()
	{
		FileInputStream fi = new FileInputStream("D:\\workspace\\aceturtle_Project\\src\\test\\java\\testdatatestdata.xls");
		
	}*/
	
		
}

	
	

