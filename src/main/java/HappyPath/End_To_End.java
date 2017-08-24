package HappyPath;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Puma_Pages.PageUtilities;
import com.google.common.base.CharMatcher;

import jxl.read.biff.BiffException;
import testdata.TestData;

public class End_To_End extends PageUtilities {
	// public WebDriver driver;

	public End_To_End(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Virat Kohli Picks")
	private WebElement viratkolipicks;

	// clothins->Tees
	@FindBy(xpath = "html/body/div/div/div/div[4]/div[2]/div[2]/div[1]/div[1]/ul/li[3]/ul/li[1]/a")
	private WebElement Tees;

	// Place Order
	@FindBy(xpath = "//div[@id='checkout-review-submit']/button[@class='button btn-checkout opc-btn-checkout']")
	private WebElement placeorder;

	// Delivery Type
	@FindBy(xpath = "//input[@id='p_method_cashondelivery']")
	private WebElement COD;

	// Rubicon
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement RC_username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement RC_password;

	@FindBy(id = "login_button")
	private WebElement login;

	@FindBy(xpath = "html/body/div[1]/div/div[2]/aside/div/ul/li[2]/a")
	private WebElement cancle;

	@FindBy(id = "orderNo")
	private WebElement Ordernumber;

	@FindBy(id = "searchRma")
	private WebElement search;

	@FindBy(xpath = "//a[@class= 'cancelButton btn btn-danger btn-sm']")
	private WebElement CC_cancel;

	@FindBy(id = "reasonCC")
	private WebElement CC_cancel_Reason;

	@FindBy(id = "saveReason")
	private WebElement saveresion;

	@FindBy(id = "flashMessage")
	private String Ordercancellationmessage;

	// Email Verification
	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "next")
	private WebElement next;

	@FindBy(id = "Passwd")
	private WebElement password;

	@FindBy(id = "signIn")
	private WebElement signin;

	@FindBy(id = "gbqfq")
	private WebElement searchbar;

	@FindBy(id = "gbqfb")
	private WebElement searchicon;

	// shipping Address

	@FindBy(id = "billing:firstname")
	private WebElement firstname;
	@FindBy(id = "billing:lastname")
	private WebElement lastname;
	@FindBy(id = "billing:company")
	private WebElement companyname;
	@FindBy(id = "billing:email")
	private WebElement useremail;
	@FindBy(id = "billing:street1")
	private WebElement StreetAddress;
	@FindBy(id = "billing:city")
	private WebElement city;
	@FindBy(id = "billing:postcode")
	private WebElement pincode;
	@FindBy(id= "billing:country_id")
	private WebElement country;
	@FindBy(id = "billing:telephone")
	private WebElement TelephoneNumber;

	public String ProductCheckOut() throws IOException, InterruptedException, BiffException {
		// mouseOvering on Megamenu L1 category and clicking on L3 category item
		WebElement men = driver.findElement(By.xpath("//ul[@class='digimeg-group digimeg-main-nav']/li[1]/a"));
		mouseOver(men);
		viratkolipicks.click();

		// Filtering the Product
		driver.findElement(By.xpath("html/body/div/div/div/div[4]/div[2]/div[2]/div[1]/div[1]/ul/li[3]/a")).click();
		webdriverwait(Tees);
		Tees.click();
		WebElement value = driver.findElement(By.xpath("//img[contains(@title,'Black')]"));
		System.out.println(value);

		// selecting the product After Filtering
		driver.findElement(By.id("product-collection-image-20322")).click();

		driver.findElement(By.xpath("//div[@class='product-size-click-btn']")).click();
		driver.findElement(By
				.xpath("html/body/div[1]/div/div/div[4]/div/div[2]/div[2]/div[1]/form/div[3]/div[6]/dl/dd[2]/div[2]/div[1]/div/div[2]/ul/li[1]/a/span[1]"))
				.click();
		driver.findElement(By.xpath("//button[@class='button btn-cart']")).click();
		driver.findElement(By.xpath("//button[@class='button btn-proceed-checkout btn-checkout']")).click();

		// Filling Shipping Details
		type(firstname, addressDetails.firstName);
		type(lastname, addressDetails.lastName);
		type(companyname, addressDetails.company);
		type(useremail, addressDetails.email);
		type(StreetAddress, addressDetails.street);
		type(city, addressDetails.city);
		type(pincode, addressDetails.pincode);
		new Select(driver.findElement(By.id("billing:region_id"))).selectByVisibleText("Karnataka");
		type(TelephoneNumber, addressDetails.phone);
		COD.click();
		System.out.println(verifyWebelementEnable(placeorder));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('checkout-review-submit').children[1].click()");
		Thread.sleep(30000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String ordernumber = (String) js1
				.executeScript("return document.getElementsByClassName('col-main')[0].children[4].innerHTML;");
		System.out.println(ordernumber);

		String num = ordernumber.replaceAll("[^0-9]", "");
		System.out.println(num);
		return num;

	}
	/*
	 * FileInputStream fi = new
	 * FileInputStream("D:\\workspace\\aceturtle_Project\\testdata.xls");
	 * jxl.Workbook wb = jxl.Workbook.getWorkbook(fi); jxl.Sheet s =
	 * wb.getSheet("pincodes"); 
	 * for(int i=100;i<15000;i++) {
	 * driver.findElement(By.id("billing:postcode")).sendKeys(s.getCell(0,i).getContents());
	 * driver.findElement(By.id("billing:telephone")).sendKeys("8989898989");
	 * Thread.sleep(5000);
	 *  WebElement placeorder=driver.findElement(By.xpath("//button[@id='giftvoucher_add']"));
	 * if(verifyWebelementEnable(placeorder)) {
	 * 
	 * System.out.println("Button Enable For Pincode"+ s.getCell(0,i).getContents());
	 * driver.findElement(By.id("billing:postcode")).clear();
	 * driver.findElement(By.id("billing:telephone")).clear();
	 * Thread.sleep(4000);
	  }
	 * else {
	 *  System.out.println("Button not Enable For Pincode"+ s.getCell(0,i).getContents());
	 * driver.findElement(By.id("billing:postcode")).clear();
	 * driver.findElement(By.id("billing:telephone")).clear(); } }
	 */

	// Navigating to Rubicon to cancle order
	public void OrderCancelFromRubiCon(String Ordernum) throws IOException, Exception {

		// navigating to Rubicon site
		// driver.navigate().to("http://rubicon.aceturtle.in/");
		// RC_username.sendKeys("testuser");
		// Entering password
		// RC_password.sendKeys("Ace@123");
		// Thread.sleep(30000);
		driver.navigate().to("http://rubicon2.aceturtle.in/Rubicon2-staging/");
		// Enter User name
		RC_username.sendKeys("stagingtest");
		// Entering password
		RC_password.sendKeys("stagingtest");
		// clicking on login
		login.click();
		// clicking on cancel option
		cancle.click();

		Ordernumber.sendKeys(Ordernum);
		// searching for order
		search.click();
		// selecting the reason for cancel
		new Select(driver.findElement(By.xpath("//select[starts-with(@id, 'reason')]")))
				.selectByValue("Customer requested to cancel the order");
		// hiting on cancel button
		Thread.sleep(4000);
		CC_cancel.click();
		Thread.sleep(4000);
		// Shifting control to Alert Box
		driver.switchTo().alert().accept();
		// System.out.println("order has been canceled");
		Thread.sleep(4000);
		String OrderCancelmessage = driver.findElement(By.xpath("//div[@class='success']")).getText();
		System.out.println(OrderCancelmessage);
		Thread.sleep(3000);
		screenshots();
	}

	public void OrderCancel_EmailVerification(String Ordernum) throws BiffException, IOException, InterruptedException {
		Thread.sleep(3000);
		driver.navigate().to("https://www.gmail.com");
		email.sendKeys("testaceturtle@gmail.com");
		next.click();
		password.sendKeys("aceturtle1234");
		signin.click();
		Thread.sleep(3000);
		searchbar.sendKeys(Ordernum + " " + "has been");
		searchicon.click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//div[@role='main']//table//tbody//tr//td")).click();
			screenshots();
		} catch (Exception e) 
		{
			System.out.println("Checking in Spam for mail");
			searchbar.clear();
			searchbar.sendKeys("in:spam" + Ordernum);
			searchicon.click();
			driver.findElement(By.xpath("//div[@role='main']//table//tbody//tr//td")).click();
			System.out.println(e.getMessage());
		}
	}
}
