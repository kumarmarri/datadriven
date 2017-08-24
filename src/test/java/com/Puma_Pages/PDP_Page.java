package com.Puma_Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PDP_Page extends PageUtilities {

	public PDP_Page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='product-size-click-btn']")
	private WebElement sizedropdown;

	@FindBy(xpath = "html/body/div[1]/div/div/div[4]/div/div[2]/div[2]/div[1]/form/div[3]/div[6]/dl/dd[1]/div/ul/li[2]/a")
	private WebElement itemcolor;
	
	@FindBy(xpath="//div[@class='product-size-click-btn']")
	private WebElement dropdown; 
	
	
	@FindBy(xpath="//span[@id='180~73']")
	private WebElement size;

	@FindBy(xpath = "//p[@class='special-price']/span[2]")
	private WebElement itemunitprice;
	
	@FindBy(xpath="//a[@title='8']")
	private WebElement itemsize;

	@FindBy(xpath= "html/body/div/div/div[1]/div[4]/div/div[1]/div/div[2]/div[1]/div[2]/div/table/tfoot/tr[3]/td[2]/strong/span")
   private WebElement grandtotal;
	
	@FindBy(xpath="//button[@class='button btn-cart']")
	private WebElement addtocart;
     
	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	private WebElement proceedcheckout;
	
	public void Selectingitemsize() throws InterruptedException
	{
		try 
		{
		Thread.sleep(8000);
		System.out.print("i am method");
		//itemcolor.click();
		/*sizedropdown.click();
		itemsize.click();*/
		boolean enabled = dropdown.isEnabled();
		System.out.println(enabled);
		String attribute = dropdown.getAttribute("class");
		System.out.println(attribute);
		dropdown.click();
		size.click();
		//new Select(driver.findElement(By.xpath("//div[@class='product-size-click-btn']"))).selectByValue("8");
		String UnitPrice = itemunitprice.getText();
		System.out.printf("Item unti price is : %s\n", UnitPrice);
		
		addtocart.click();
		//String Grandtotal = grandtotal.getText();
		/*System.out.printf("Grand total : %s\n", Grandtotal);
		 if(!(UnitPrice == Grandtotal) )
		 {
			 System.out.println(" untiprice and  grandttotal matched");
			 return false;
			
		 }else
		 {
			 System.out.println("untiprice and  grandttotal Not matched");
			 proceedcheckout.click();
		       return true;
			 
		 }*/
		}catch(Exception e)
		{
		  System.out.println("Failed to select size");
		}
	}
}

