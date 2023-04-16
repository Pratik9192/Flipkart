package pomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy (xpath = "//input[@title='Search for products, brands and more']")
	private WebElement searchBox;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement submit;
	
	
	public SearchPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchphone (String phone)
	{
		searchBox.sendKeys(phone);
	}
	
	public void clickonSubmit ()
	{
		submit.click();
	}

}
