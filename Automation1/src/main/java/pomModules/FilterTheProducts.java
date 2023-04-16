package pomModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FilterTheProducts {
	
	 
	 
	@FindBy (xpath = "//div[@class='_1YAKP4']//select")
	private WebElement minPriceBox;
	
	@FindBy (xpath = "(//select[@class='_2YxCDZ']) [2]")
	private WebElement maxPriceBox;
	
	@FindBy (xpath = "//input[@placeholder='Search Brand']")
	private WebElement searchmob ;
	
	@FindBy (xpath = "(//div[@class='_24_Dny'])[1]")
	private WebElement miphonecheckbox;
	
	@FindBy (xpath = "(//div[@class='_24_Dny'])[6]")
	private WebElement ram ;
	
	@FindBy (xpath = "//div[text()='Price -- Low to High']")
	private WebElement lowToHigh ;
	
	@FindBy (xpath = "(//div[@class='col col-7-12']/div)[1]")
	private WebElement cheapestPhone ;
	
	@FindBy (xpath = "(//div[@class='col col-5-12 nlI3QM']/div/div/div)[1]")
	private WebElement cheaperPrice ;
	
	@FindBy (xpath = "//div[text()='Price -- High to Low']")
	private WebElement highToLow ;
	
	@FindBy (xpath = "(//div[@class='col col-7-12']/div)[1]")
	private WebElement costierPhone ;
	
	@FindBy (xpath = "(//div[@class='col col-5-12 nlI3QM']/div/div/div)[1]")
	private WebElement costlierPrice ;
	
	
	public FilterTheProducts (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void minpriceofphone ()
	{
		minPriceBox.click();
		Select s = new Select (minPriceBox);
		s.selectByValue("15000");
	}
	
	public void maxpriceofphone ()
	{
		maxPriceBox.click();
		Select s = new Select (maxPriceBox);
		s.selectByValue("30000");
	}
	
	public void searchmobbrand ()
	{
		searchmob.click();
		searchmob.sendKeys("REDMI");
	}
    
	public void checkboxofmimobile ()
	{
		boolean result = miphonecheckbox.isSelected();
		if(result==true)
		{
			System.out.println("checkbox is selected");
		}
		else
		{
			System.out.println("checkbox is not selected");
			miphonecheckbox.click();
		}
		result = miphonecheckbox.isSelected();
		System.out.println(result);
	}
	
	public void checkboxofram ()
	{
		boolean result = ram.isSelected();
		if(result==true)
		{
			System.out.println("checkbox is selected");
		}
		else
		{
			System.out.println("checkbox is not selected");
			ram.click();
		}
		result = ram.isSelected();
		System.out.println(result);
	}
	
	
	
	public void lowToHigh ()
	{
		lowToHigh.click();
	}
	
	public void cheapest ()
	{
		String cheaperPhone = cheapestPhone.getText();
		System.out.println("Name of the cheapest phone is =" + cheaperPhone);
		
		String lowPrice = cheaperPrice.getText();
		System.out.println("Price of the cheapest phone is =" + lowPrice);
		
		
	}
	
	public void highToLow ()
	{
		highToLow.click();
	}
	
	public String costliestphone ()
	{
		String costliestPhone = costierPhone.getText();
		System.out.println("Name of the costliest phone is = " + costliestPhone);
		return costliestPhone ;
	}	
	
	public void costliestPrice ()
	{
		String highPrice = costlierPrice.getText();
		System.out.println("Price of the costliest phone is = " + highPrice);
	
	}
	

}
