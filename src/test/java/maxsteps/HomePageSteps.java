package maxsteps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Basestep;
import maxpages.HomePage;

public class HomePageSteps extends Basestep
{
	HomePage plppage;
	@BeforeMethod
	public void beforemethod()
	{
		plppage=PageFactory.initElements(driver,HomePage.class);
	}
	
	@Test
	public void globallinks() throws IOException, InterruptedException
	{
		plppage.CheckingMegaMenulinks();
		plppage.CheckingFooterLinks();
	}
	

}
