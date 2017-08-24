package maxsteps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Basestep;
import maxpages.Shoppingcartpage;

public class Shoppingcartsteps extends Basestep {

	Shoppingcartpage sc;
	
	@BeforeMethod
	
	public void beforemethod()
	{
		sc = PageFactory.initElements(driver, Shoppingcartpage.class);
	}
	
	
	@Test
	public void shoppingcart() throws InterruptedException, IOException
	{
		sc.Shoppingcart();
		sc.verifyingusermobilenumber();
		
		
		
	}
	
}
