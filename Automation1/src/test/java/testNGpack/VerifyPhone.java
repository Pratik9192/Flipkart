package testNGpack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pomModules.Addtocart;
import pomModules.CostliestPhone;
import pomModules.FilterTheProducts;
import pomModules.ProductPage;
import pomModules.RemoveFromCart;
import pomModules.SearchPage;


	public class VerifyPhone extends Browser {
		public WebDriver driver ;
		
		
		private SearchPage searchpage  ;
		private FilterTheProducts filterproduct ;
		private  CostliestPhone costliestPhone ;
		private  ProductPage productPage ;
		private  Addtocart addtocart ;
		private   RemoveFromCart removeFromCart ;
		
		
	    
		@Parameters ("browser123")
		@BeforeTest
		public void launchBrowser (String browser) {
			
			
			if (browser.equals("chrome"))
	    	{
			    driver = openChromeBrowser();
	    	}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		@BeforeClass 
		public void createPOMobject ()
		{
			 searchpage = new SearchPage (driver);
			 filterproduct = new FilterTheProducts (driver);
			 costliestPhone = new CostliestPhone (driver);
			 productPage = new ProductPage (driver);
			 addtocart = new Addtocart (driver);
			 removeFromCart = new RemoveFromCart (driver);
			

		}
		@BeforeMethod
		public void searchPhone () {
			
			
			driver.get("https://www.flipkart.com/");
		    WebElement cancelButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		    cancelButton.click();
			    
		    searchpage = new SearchPage (driver);
		    searchpage.searchphone("phones");
		    searchpage.clickonSubmit ();
			    
		}
		
		@Test
		public void verifyTheProductOnFlipkart () throws InterruptedException {
			
			    filterproduct = new FilterTheProducts (driver);
			    Thread.sleep(2000);
			    filterproduct.minpriceofphone();
			    Thread.sleep(2000);
			    filterproduct.maxpriceofphone();
			    Thread.sleep(3000);
			    filterproduct.searchmobbrand();
			    Thread.sleep(2000);
			    filterproduct.checkboxofmimobile();
			    Thread.sleep(3000);
			    filterproduct.checkboxofram();
			    Thread.sleep(3000);
			    filterproduct.lowToHigh();
			    Thread.sleep(3000);
			    filterproduct.cheapest();
			    Thread.sleep(3000);
			    filterproduct.highToLow();
			    Thread.sleep(3000);
			   String actualphonedetails = filterproduct.costliestphone();
			   
			    Thread.sleep(3000);
			    filterproduct.costliestPrice();
			    
			    Thread.sleep(2000);
			    costliestPhone = new CostliestPhone (driver);
			    Thread.sleep(2000);
			    costliestPhone.firstPhone();
			    
			    ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
			    driver.switchTo().window(addr.get(1));
			    
			    productPage = new ProductPage (driver);
			    String details = productPage.AddtoCartButton();
			    
			    
			    Assert.assertEquals (details , "ADD TO CART");
			    Thread.sleep(3000);
			    addtocart = new Addtocart (driver);
			    addtocart.clickOnAddCartButton();
			    Thread.sleep(3000);
			    addtocart.clickOnCartButton();
			    Thread.sleep(3000);
			
			    String expectedmobiledetails = addtocart.getMobileDetails();
			    Thread.sleep(2000);
			    System.out.println(actualphonedetails);
			   
			    Assert.assertEquals(actualphonedetails, expectedmobiledetails);
			    
			    removeFromCart = new RemoveFromCart (driver);
			    removeFromCart.clickOnRemoveButton();
			    Thread.sleep(2000);
			    removeFromCart.alertClickOnRemove();
			    
			    String actualmessage = removeFromCart.getCartItems();
			    String expectedmessage =  "Missing Cart items?";
			    
			   Assert.assertEquals(actualmessage, expectedmessage);
		}
		
		
		@AfterMethod
		public void afterMethod () {
			
			System.out.println("logout");
		}
		
		@AfterClass
		public void afterClass () {
			 searchpage = null ;
			 filterproduct = null ;
			 costliestPhone = null ;
			 productPage = null ;
			 addtocart = null ;
			 removeFromCart = null ;
		}
		
		@AfterTest
		public void afterTest ()
		{
			driver.quit();
			driver = null;
			System.gc();
		}
		

}
