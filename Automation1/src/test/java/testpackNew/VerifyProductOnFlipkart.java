package testpackNew;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomModules.Addtocart;
import pomModules.CostliestPhone;
import pomModules.FilterTheProducts;
import pomModules.ProductPage;
import pomModules.RemoveFromCart;
import pomModules.SearchPage;

public class VerifyProductOnFlipkart {

	public WebDriver driver ;
	@BeforeClass
	public void beforeClass () {
	     System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
	     ChromeOptions opt = new ChromeOptions ();
	     opt.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(opt);
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void beforeMethod () {
		
		driver.get("https://www.flipkart.com/");
		  WebElement cancelButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		    cancelButton.click();
		    
		    SearchPage searchpage = new SearchPage (driver);
		    searchpage.searchphone("phones");
		    searchpage.clickonSubmit ();
	}
	
	@Test
	public void addtocartFunctionality () throws InterruptedException {
		
		 FilterTheProducts filterproduct = new FilterTheProducts (driver);
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
		    CostliestPhone costliestPhone = new CostliestPhone (driver);
		    Thread.sleep(2000);
		    costliestPhone.firstPhone();
		    
		    ArrayList <String> addr = new ArrayList <String> (driver.getWindowHandles());
		    driver.switchTo().window(addr.get(1));
		    
		    ProductPage productPage = new ProductPage (driver);
		    String details = productPage.AddtoCartButton();
		    
		    
		    Assert.assertEquals (details , "ADD TO CART");
		    Thread.sleep(3000);
		    Addtocart addtocart = new Addtocart (driver);
		    addtocart.clickOnAddCartButton();
		    Thread.sleep(3000);
		    addtocart.clickOnCartButton();
		    Thread.sleep(3000);
		
		    String expectedmobiledetails = addtocart.getMobileDetails();
		    Thread.sleep(2000);
		    System.out.println(actualphonedetails);
		   
		    Assert.assertEquals(actualphonedetails, expectedmobiledetails);
		    
		    RemoveFromCart removeFromCart = new RemoveFromCart (driver);
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
	
		driver.quit();
		
	}
}
