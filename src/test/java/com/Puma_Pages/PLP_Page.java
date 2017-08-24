package com.Puma_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PLP_Page extends PageUtilities {

	public PLP_Page(WebDriver driver) {    
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText="Virat Kohli Picks")
	private WebElement viratkolipicks;
	
	//clothins->Tees
	@FindBy(xpath="//li[@class='current_parent']//li[1]/a")
    private WebElement Tees;
	
	@FindBy(id="product-collection-image-20322")
	private WebElement product;


public void Selecting_item_Based_on_Filters() throws IOException, InterruptedException
{
	
	WebElement men = driver.findElement(By.xpath("//ul[@class='digimeg-group digimeg-main-nav']/li[1]/a"));
	
	//mouseOvering on Megamenu L1 category and  clicking on L3 category item
	mouseOver(men);
	viratkolipicks.click();
	driver.findElement(By.xpath("html/body/div[1]/div/div/div[4]/div[2]/div[2]/div[2]/div/ul/li[1]/a[1]/img")).click();
	//webdriverwait(Tees);
	//Tees.click();
	/*WebElement value =driver.findElement(By.xpath("//img[contains(@title,'Black')]"));
	System.out.println(value);
	product.click();*/
	//driver.findElement(By.id("")).click();
	
}




}
