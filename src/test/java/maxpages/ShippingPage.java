
package maxpages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Puma_Pages.PageUtilities;

import DataProvider.ExcelDataProvider;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ShippingPage extends PageUtilities{

	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="customer-email")
	private WebElement useremail;
	
	@FindBy(xpath="//input[@class='input-text customer-firstname']")
	private WebElement userfirstname;
	
	@FindBy(xpath = "//input[@class='input-text customer-lastname']")
	private WebElement userlastname;
	
	@FindBy(xpath="html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input")
	private WebElement userAddress;
	
	@FindBy(xpath = "html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[6]/div/input")
	private WebElement postcode;
	
	@FindBy(xpath= "html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button")
	private WebElement nextbutton;
	
	//Review& Payment page Auth codes
	
	@FindBy(id="csr-id")
	private WebElement authcode1;
	
	@FindBy(id="recipt")
	private WebElement authcode2;
	
	@FindBy(id="cardpayId-placeOrder")
	private WebElement placeorder;
	
	
	public void UserShippingAddress(String email,String firstname, String lastname,String address,String pincode) throws InterruptedException, IOException
	{
	//public void UserShippingAddress() {
	 System.out.print("i am in shopping page");
	  // Sheet sheet = null;
	   useremail.sendKeys(email);
	   Thread.sleep(3000);
	   userfirstname.clear();
	   userfirstname.sendKeys(firstname);
	   Thread.sleep(3000);
	   userlastname.clear();
	   userlastname.sendKeys(lastname);
	   Thread.sleep(3000);
	   userAddress.sendKeys(address);
	   Thread.sleep(3000);
	   postcode.clear();
	   postcode.sendKeys(pincode);
	   waitForAjaxCallToFinish();
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
	   executor.executeScript("arguments[0].click();",  nextbutton);
	   screenshots();
	   //nextbutton.click();
	   	
	}
	
	
	public void Review_Paymentpage() throws IOException
	{
		try
		{
		//Entering  Auth Code
				String subWindowHandler = null;
				Set<String> handles = driver.getWindowHandles(); 
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
				{
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler);// switch to popup window
				authcode1.clear();
				authcode1.sendKeys("4232");
				driver.findElement(By.xpath("//input[@type='button'] ")).click();
				authcode2.sendKeys("4232");
				driver.findElement(By.xpath("//input[@type='button'] ")).click();
				placeorder.click();
				
				
		
		}
		finally
		{
			screenshots();
		}
	
				
				
				
				                                          
	}
	

}
