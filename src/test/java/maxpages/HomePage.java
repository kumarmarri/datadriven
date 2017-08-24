package maxpages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Puma_Pages.PageUtilities;



public class HomePage extends PageUtilities
{
	@SuppressWarnings("static-access")
	public HomePage (WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@class='sizecontent']/button[2]")
	public static WebElement Browse;
	
	@FindBy(xpath= "//div[@id='om']/ul/li")
	private WebElement Megamenu;
	
	@FindAll({@FindBy(xpath = "//div[@id='om']/ul//li[contains(@class,'menu-dropdown-icon')]" )})
	  private java.util.List<WebElement> categoryLinks;
	
	@FindAll({@FindBy(xpath= "//div[@class= 'widget block block-static-block']/ul")})
	
	private java.util.List<WebElement> Footerlinks;
	
	@FindBy(className= "logo")
	private WebElement logo;




public WebElement CheckingMegaMenulinks() throws IOException, InterruptedException
{
	Browse.click();
	
	//clickOnCategoryLinkInHeader
	for(int i=0;i<categoryLinks.size();i++)
	{
		System.out.print(categoryLinks.size());
	      mouseOver(categoryLinks.get(i) );
	      categoryLinks.get(i).click();
	      navigateBack();
	      
	}
	
	return Browse;
		
}

public void CheckingFooterLinks() throws IOException, InterruptedException
{
	for(int i=1; i<Footerlinks.size(); i++)
	{
		System.out.println(Footerlinks.size());
		
		if(Footerlinks.get(i).isDisplayed())
  		{
  			Footerlinks.get(i).click();
  			
  			Thread.sleep(1000);
  		

  		}
		
	}
	
	
}




}
