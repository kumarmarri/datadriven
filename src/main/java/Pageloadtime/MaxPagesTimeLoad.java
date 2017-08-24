package Pageloadtime;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MaxPagesTimeLoad 
{
	WebDriver driver = new FirefoxDriver();
	@Test(priority=0)
	public void openurl()
	{
		driver.get("http://104.155.211.236");

	}
	
	
	@Test(priority=1)
	public void Homepage()
	{  
		//Home page
		driver.findElement(By.xpath("html/body/div/main/div[3]/div/div[2]/div[1]/div[2]/a/img")).click();
		/*
		//click on women
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/nav/div[2]/ul/li[1]/a")).click();
				 
		//driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/nav/div[2]/ul/li[1]/a/span")).click();
*/		
		
		
	}
	
	@Test(priority=2)
	public void PLPPageLoadTime()
	{      //plp
		//click on women
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/nav/div[2]/ul/li[1]/a")).click();
		
		
	}
	
	
	@Test(priority=3)
	public void PDPPageLoadTime()
	{
		driver.findElement(By.xpath("html/body/div[1]/main/div[4]/div[1]/div[3]/ol/li[1]/div/a/span/span/img")).click();
		
	}
	
	
	
	

}
