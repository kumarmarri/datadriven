package maxpages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Puma_Pages.PageUtilities;

public class Shoppingcartpage extends PageUtilities {
	public Shoppingcartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "mobile-continue")
	private WebElement NextButton;

	@FindBy(id = "number")
	private WebElement numberfield;

	// WebDriver driver;
	@FindBy(xpath = "//a[@ class = 'increment_qty']")
	public WebElement qtyincrement;

	public void Shoppingcart() throws InterruptedException {
		System.out.println(" incrementing the quantity in shipping cartpage");
		qtyincrement.click();
		driver.findElement(By.xpath("//button[@class= 'action update done primary']")).click();
		Thread.sleep(3000);

		// Order total
		String value = driver.findElement(By.xpath("//tr[@class= 'grand totals']//strong/span")).getText();
		System.out.println("Order Total is " + value);

		// Home Delivery
		driver.findElement(By.xpath("//button[@class= 'bluebgbtn']")).click();
		Thread.sleep(3000);
		WebElement placeorder = driver.findElement(By.xpath("//button[@title= 'Proceed to Checkout']"));
		System.out.println("PlaceOrder Option is enable" + " " + placeorder.isEnabled());
		Thread.sleep(2000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", placeorder);
		Thread.sleep(5000);
		// NextButton.click();

	}

	public void verifyingusermobilenumber() throws InterruptedException, IOException {
		waitForAjaxCallToFinish();
		System.out.println("----------------------------------------------");
		
		//String parentWindowHandler = driver.getWindowHandle();
		
		System.out.println("***********Testing the field with Blank field***************");
		Thread.sleep(4000);
		NextButton.click();

		String validationmessage = driver
				.findElement(
						By.xpath("html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div[1]/form/div/div[2]/p"))
				.getText();
		System.out.println("Validation Message :"  +   validationmessage);
		screenshots();
		Thread.sleep(4000);
		System.out.println("*********************Testing the field with Invalid number***********************");
		numberfield.sendKeys("9800768");
		NextButton.click();
		/*String title=driver.getWindowHandle();
		System.out.println(title);*/
		screenshots();
		System.out.println("Validation Message for invalid mobile number:"  +   validationmessage);
		Thread.sleep(6000);
		System.out.println("Testing the field with valid number");
		numberfield.clear();
		numberfield.sendKeys("9700416127");
		NextButton.click();
		Thread.sleep(1000);
		
		//Do you want to Register POP UP
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);// switch to popup window
		
		//driver.findElement(By.xpath("//button[@class='yes-content action primary']")).click();
		
		driver.findElement(By.xpath("//button[@class='no-content action primary']")).click();
		                                          

		
		
		
	}
		
		
	

	}


