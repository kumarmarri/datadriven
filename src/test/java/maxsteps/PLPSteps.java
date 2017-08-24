package maxsteps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Basestep;
import maxpages.PLPPage;

public class PLPSteps extends Basestep
{
	PLPPage plppage;
	@BeforeMethod
	public void beforemethod()
	{
		plppage = PageFactory.initElements(driver, PLPPage.class);
		
	}
	
	@Test
	
	private void WomenCategory() throws InterruptedException, IOException
	{
		plppage.SelectingItemFromPLPPage();
	}
	

}
