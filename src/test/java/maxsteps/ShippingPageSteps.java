package maxsteps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Basestep;
import DataProvider.ExcelDataProvider;
import maxpages.HomePage;
import maxpages.ShippingPage;


public class ShippingPageSteps extends Basestep
{
	ShippingPage sp;
	
	@BeforeMethod
	public void beforemethod()
	{
		sp=PageFactory.initElements(driver,ShippingPage.class);
	}
	
	//@Test(dataProvider = "shopping", dataProviderClass=ExcelDataProvider.class)
	@Test(dataProvider = "DP", dataProviderClass=ExcelDataProvider.class)
	public void Address(String email,String firstname, String lastname,String address,String pincode) throws IOException, InterruptedException
	{
		System.out.print("i am in shipping page");
		sp.UserShippingAddress( email, firstname,  lastname,address, pincode);
	}
	
	
	@Test
	public void review_payments() throws IOException
	{
		sp.Review_Paymentpage();
	}

}
