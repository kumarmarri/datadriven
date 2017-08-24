package maxpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import DataProvider.ExcelDataProvider;

public class TestData 

{ 
//@Test(dataProvider="DP")
	
	@Test(dataProvider = "DP", dataProviderClass=ExcelDataProvider.class)
public void h(String username,String password)
{
  WebDriver driver = new FirefoxDriver();
  driver.get("https://www.facebook.com/login/");
  
  driver.findElement(By.id("email")).sendKeys(username);
  driver.findElement(By.id("pass")).sendKeys(password);
  
  System.out.println("The value of username" + username);
  System.out.println("The value of password" + password);

}

}
