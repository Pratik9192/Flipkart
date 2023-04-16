package pomModules;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveFromCart {


	
	@FindBy (xpath = "//div[text()='Remove']")
	private WebElement removeFromCart ;
	
	@FindBy (xpath = "//div[@class='_3dsJAO _24d-qY FhkMJZ']")
	private WebElement alertforRemove ;
	
	@FindBy (xpath = "//div[text()='Missing Cart items?']")
	private WebElement missingCartItems ;
	
	
	
	public RemoveFromCart (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnRemoveButton ()
	{
		removeFromCart.click();
	}
	
	public void alertClickOnRemove ()
	{
		alertforRemove.click();
	}
	
	public String getCartItems ()
	{
		String itemDetails = missingCartItems.getText();
		return itemDetails;
	}
	
}
