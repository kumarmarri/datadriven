package maxpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Puma_Pages.PageUtilities;

public class PDPPage extends PageUtilities {

	@SuppressWarnings("static-access")
	public PDPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class= 'swatch-attribute color']/div[@class = 'swatch-attribute-options clearfix']/div[1]")
	public WebElement itemcolor;

	@FindBy(xpath = "//div[@class='swatch-attribute size']/div[@class= 'swatch-attribute-options clearfix']/div[1]")
	public WebElement itemsize;

	@FindBy(xpath = "//a[@ class = 'increment_qty']")
	public WebElement qtyincrement;

	@FindBy(xpath = "//a[@ class = 'decrement_qty']")
	public WebElement qtydecrement;

	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	public WebElement Addtocart;

	@FindBy(xpath = "html/body/div[1]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li/div/div/div[2]/div[2]/input")
	public WebElement quantity;

	@FindBy(xpath = "//a[@ class = 'action showcart']")
	public WebElement minicart;

	@FindBy(id = "top-cart-btn-checkout")
	private WebElement checkout;

	@FindBy(id = "mobile-continue")

	private WebElement NextButton;

/*	public void SelectingItemvalues() throws InterruptedException {
		Thread.sleep(5000);
		itemcolor.click();
		itemsize.click();

	}*/

	public void verifyingQtyIncrementAndDecrement() throws InterruptedException

	{
		try
		{
		// Increasing Quantity By 10
		System.out.println("Incrementing value by 10");
		for (int i = 1; i <= 9; i++) {
			qtyincrement.click();
			System.out.println("Quantity incrementing by" + i);
			Thread.sleep(1000);
		}

		System.out.println("decrementing value by 10");
		for (int i = 1; i <= 10; i--) {
			qtydecrement.click();
			System.out.println("Quantity decrementing by" + i);
			Thread.sleep(2000);
		}
		
	}catch(Exception e)
		{
		  System.out.println(e.getMessage());
		}
	}
	
	
	void addingItemToCart()
	{
		
		
		
	}

	
}
