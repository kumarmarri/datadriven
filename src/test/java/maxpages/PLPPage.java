package maxpages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Puma_Pages.PageUtilities;

public class PLPPage extends PageUtilities {

	//WebDriver driver;
	@SuppressWarnings("static-access")
	public PLPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@class='sizecontent']/button[2]")
	public static WebElement Browse;

	@FindBy(xpath = "//li[@class='menu-dropdown-icon']//a[@class='level-top' and contains(span ,'Girls')]")
	private WebElement Girlscategory;
	
	/*@FindBy(xpath = "//*[@class='product-image-photo']")
	private WebElement selectingitem;*/
	
	@FindBy(xpath = "html/body/div[1]/main/div[4]/div[1]/div[3]/ol/li[2]/div/a/span/span/img")
	private WebElement selectingitem;

	
/* Selecting an Item form Womens category */	
public void SelectingItemFromPLPPage() throws InterruptedException, IOException
{
	Browse.click();
	Girlscategory.click();
	
	System.out.println("selected item from PLP page");
	
	//Scrolling page Down
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	//Thread.sleep(2000);
	
	//Selecting Item
	screenshots();
	selectingitem.click();
	
	
}
}
