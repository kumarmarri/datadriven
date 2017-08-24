package maxsteps;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Basestep;
import maxpages.PDPPage;

public class PDPPageSteps extends Basestep {
	PDPPage pdppage;

	@BeforeMethod

	protected void beforemethod() {
		pdppage = PageFactory.initElements(driver, PDPPage.class);
	}

	@Test(priority=0)

	private void pdpexecutionmethods() throws InterruptedException {
		//pdppage.SelectingItemvalues();
		pdppage.verifyingQtyIncrementAndDecrement();
		//pdppage.Shoppingcart();

	}
}

	
