package com.Puma_Pages;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageUtilities {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//ul[@class='menu-utility-user']/li[5]/a")
	private WebElement SignIn;
	@FindBy(xpath = "//button[contains(@title, 'Create an Account')]")
	private WebElement create_account;

	@FindBy(id = "firstname")
	private WebElement firstname;

	@FindBy(id = "lastname")
	private WebElement lastname;

	@FindBy(id = "email_address")
	private WebElement email;

	@FindBy(id = "mobile")
	private WebElement mobilenumber;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "confirmation")
	private WebElement confirm_Password;

	@FindBy(xpath = "//p[@class='back-link']/a")
	private WebElement Back;

	public boolean checking_The_functionality_of_BackLink() {
		SignIn.click();
		// verifyWebelementEnable(create_account);
		verifyPresenceOfElement(create_account);
		create_account.click();
		Back.click();
		if (verifyPresenceOfElement(SignIn) && create_account.isDisplayed()) {
			create_account.click();
			System.out.println("Functionality Passed");
			return true;
		} else {
			System.out.println("Functionality failed");
			return false;
		}

	}

	public void User_Account_Registration() {
		/*
		 * SignIn.click(); // verifyWebelementEnable(create_account);
		 * verifyPresenceOfElement(create_account); create_account.click();
		 */
		WebElement text = driver.findElement(By.id("firstname"));
		try {
			if (verifyPresenceOfElement(text)) {
				FileInputStream fi = new FileInputStream(
						"D:\\workspace\\aceturtle_Project\\src\\test\\java\\testdata\\testdata.xls");
				jxl.Workbook wb = jxl.Workbook.getWorkbook(fi);
				jxl.Sheet s = wb.getSheet("Registration");

				firstname.sendKeys(s.getCell(0, 0).getContents());
				lastname.sendKeys(s.getCell(0, 1).getContents());
				email.sendKeys(s.getCell(0, 2).getContents());
				mobilenumber.sendKeys(s.getCell(0, 3).getContents());
				verifyPresenceOfElement(password);
				password.sendKeys(s.getCell(0, 4).getContents());
				confirm_Password.sendKeys(s.getCell(0, 5).getContents());
				System.out.println(s.getCell(0, 3).getContents());
				screenshots();
				System.out.println("Data Entered in Fields");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("unable to find");
		}

	}
}