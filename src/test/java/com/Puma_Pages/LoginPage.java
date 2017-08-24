package com.Puma_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends PageUtilities {
	public static   WebDriver driver;

	public LoginPage(WebDriver driver){
	    	super(driver);
	        PageFactory.initElements(driver, this);
	        this.driver=driver;
	    }	
	@FindBy(xpath = "//ul[@class='menu-utility-user']/li[5]/a")
	private WebElement SignIn;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement Email_Address;

	@FindBy(id = "pass")
	private WebElement Password;

	@FindBy(id = "send2")
	private WebElement Loginbutton;

	public void Enter_Email_Password() throws InterruptedException, IOException {
		highlightAndClick(SignIn);
		System.out.println("clicked on sign link");
		System.out.println(verifyPresenceOfElement(Password));
		System.out.println(verifyPresenceOfElement(Email_Address));
		Thread.sleep(10000);
		System.out.println("instnce :"+driver.toString());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('input-box')[1].children[0].value='m.kumarmarri@gmail.com'");
		Password.sendKeys("9700416127");
		Loginbutton.click();
		
	}
}
