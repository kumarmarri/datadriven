package com.Puma_Pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;



@SuppressWarnings("unused")
public class Myaccount extends PageUtilities
{
	WebDriver driver;
	public Myaccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		 this.driver=driver;
		
	}
	
	
	
	
	@FindBy(xpath="//li[@id='login-menu']/a")
 	private WebElement Myaccount;
	
	@FindBy(xpath="//div[@class='page-title']/h1")
	private WebElement Myaccount_Dashboard;
	
	@FindBy(partialLinkText = "Customer Service")
	private WebElement Customer_Service;
	
	@FindBy(xpath= "//div[@class='block-content']/ul/li[1]/a")
	private WebElement AccountDashboard;
	
	@FindBy(xpath = "html/body/div/div/div/div[1]/div/div/ul/li[3]/div/ul/li[2]/a" )
	private WebElement AccountDashboard1; // From mouseOver
	
	@FindBy(className="page-title")
	private WebElement Dashboardtitle;
	
	//user Account information
	@FindBy(xpath="//div[@class='block-content']/ul/li[2]/a")
	private WebElement AccountInformation;
	
	@FindBy(className = "page-title")
	private WebElement AccountInformationPageTitle;
	
	@FindBy(id="firstname")
	private WebElement firstname;
	
	@FindBy(id="lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[contains(@id, 'email') and contains(@title, 'Email Address')]")
	private WebElement email;
	
	@FindBy(id="mobile")
	private WebElement mobile_number;
	
	@FindBy(xpath="//td[@class='a-center view last']/span/a[1]")
	private WebElement vieworder;
	
	@FindBy(xpath = "//p[@class='back-link']/a")
	private WebElement Backlink;
	
	@FindBy(xpath = "//a[@class='link-reorder']")
	private WebElement Reorder;
	
	@FindBy(xpath = "//a[@class='link-print']")
	private WebElement print;
	
	
	
	/*public void Enter_Email_Password() throws InterruptedException, IOException {
		highlightAndClick(SignIn);
		System.out.println("clicked on sign link");
		System.out.println(verifyPresenceOfElement(Password));
		System.out.println(verifyPresenceOfElement(Email_Address));
		Thread.sleep(10000);
		System.out.println("instnce :"+driver.toString());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('input-box')[1].children[0].value='kumarreddy.marri@gmail.com'");
		Password.sendKeys("kumar127");
		Loginbutton.click();
		
	}
	*/
	public void UserNavigationDashBoard() throws IOException, InterruptedException
	{
		mouseOver(Myaccount);
		AccountDashboard1.click();
		AccountDashboard.click();
		String pagename = Dashboardtitle.getText();
		System.out.println(pagename);
		Assert.assertEquals("MY DASHBOARD",pagename);
		System.out.printf("User landed on DashBoard page \n");
		Thread.sleep(3000);
		
		String text = driver.findElement(By.xpath("html/body/div/div/div/div[4]/div/div[2]/div/div/div[3]/div/h2")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "RECENT ORDERS");
		vieworder.click();
		String ordernumber = driver.findElement(By.xpath("//div[@class='page-title title-buttons']/h1")).getText();
		System.out.println(ordernumber);
		 /*Reorder.click();
		 driver.navigate().back();
		 Thread.sleep(8000);
		 //print.click();
		//Backlink.click();	
*/		
		
		
	}
	public void UserNavigationToAccountInformation() throws InterruptedException 
	{
		try
		{
			//driver.navigate().back();
			System.out.println("Exceuting user account information in try block");
			System.out.print(AccountInformation.isEnabled());
			AccountInformation.click();
			String accountinformationpagetitle = AccountInformationPageTitle.getText();
			System.out.printf(accountinformationpagetitle);
			Assert.assertEquals("EDIT ACCOUNT INFORMATION",accountinformationpagetitle);
			System.out.println(" User lansded on Edit Account Information page");
			
			/* Editing user information*/
			
			type(firstname, addressDetails.firstName);
			type(lastname, addressDetails.lastName);
			System.out.println( email.isEnabled());
			type(email, addressDetails.email);
			type(mobile_number, addressDetails.phone);
			
			driver.findElement(By.xpath("//button[contains(@title, 'Save')]")).click();
			
			
		}catch(Exception e)
		{
			System.out.println("In catch block not  executed user account script ");
			System.out.println(e.getMessage());
		}
		
	
			//System.out.println("Executing  Account information in Finalblock");
			
			
			
		}
	
	
	
		
			
	}

