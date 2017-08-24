package com.Puma_Pages;

//import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
//import utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.read.biff.BiffException;
import testdata.TestData;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PageUtilities {

	// public WebDriver driver= new DriverFactory().getDriver();
	public TestData addressDetails = new TestData();

	// public String path;
	// public TestDataProvider data = new
	// TestDataSelector().dataSheetSelector();
	protected static WebDriver driver;

	public PageUtilities(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//button[@class='action-close']/span")
	public WebElement overlayClose;

	@FindBy(id = "search")
	private WebElement searchTextBox;

	@FindBy(xpath = "//button[@title='Search'] ")
	private WebElement searchButton;

	protected void select(WebElement element, String visibleText) {
		elementHighlight(element);
		org.openqa.selenium.support.ui.Select selection = new org.openqa.selenium.support.ui.Select(element);
		selection.selectByVisibleText(visibleText);
	}

	protected void select(WebElement element, int index) {
		elementHighlight(element);
		org.openqa.selenium.support.ui.Select selection = new org.openqa.selenium.support.ui.Select(element);
		selection.selectByIndex(index);
	}

	public void type(WebElement element, String inputText) {
		element.clear();
		element.sendKeys(inputText);
		// ss();
		// elementHighlight(element);
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyPresenceOfElement(WebElement element) {
		try {
			if (element.isDisplayed())
				elementHighlight(element);
			return element.isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public boolean verifyWebelementEnable(WebElement element) {
		try {
			if (element.isEnabled())
				elementHighlight(element);

			return element.isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public boolean verifyAbsenceOfElement(WebElement element) {
		try {
			if (element.isDisplayed())
				return false;
			return (!element.isDisplayed());
		} catch (NoSuchElementException e) {
			return true;
		}

	}

	public void highlightAndClick(WebElement element) throws IOException {
		elementHighlight(element);
		// screenshot();
		// element.click();
		waitForPresenceOfElementAndClick(element);

	}

	public void waitForPresenceOfElementAndClick(WebElement element) {
		Wait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		elementHighlight(element);
		element.click();
	}

	public void waitForPresenceOfElement(WebElement element) {
		Wait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void closeEmailSubscriptionOverlayIfPresent() throws IOException, InterruptedException {
		if (verifyPresenceOfElement(overlayClose))
			highlightAndClick(overlayClose);

	}

	public void waitForAjaxCallToFinish() {

		try {
			if (driver instanceof JavascriptExecutor) {
				JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
				int i;
				while (true) {
					Boolean ajaxIsComplete = (Boolean) (jsDriver).executeScript("return jQuery.active == 0");
					if (ajaxIsComplete)
						break;
				}
				Thread.sleep(2000);
			}

			else {
				System.out.println("Web driver: " + driver + " cannot execute javascript");
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	protected void screenshots() throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			DateFormat dateFormat = new SimpleDateFormat("HH_mm_ssa yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();

			FileUtils.copyFile(src, new File("D:\\workspace\\aceturtle_Project\\screenshots"
					+ dateFormat.format(cal.getTime()) + System.currentTimeMillis() + "text.png"));

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	public void elementHighlight(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
		js.executeScript("arguments[0].style.border=''", element);
	}

	public void mouseOver(WebElement element) throws IOException, InterruptedException {
		Actions action = new Actions(driver);
		//System.out.println("i am in mouse over");
		elementHighlight(element);
		action.moveToElement(element).perform();
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
	}

	public void searchSKU(String string) {
		type(searchTextBox, string);
		searchButton.click();
	}

	public void searchKeyword(String keyword) {
		type(searchTextBox, keyword);
		searchButton.click();
	}

	public void waitTime(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean webdriverwait(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void navigateBack() {
		driver.navigate().back();
	}
	
	

	
	
	  

}
