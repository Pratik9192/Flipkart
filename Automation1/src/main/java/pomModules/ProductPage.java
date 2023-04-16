package pomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy (xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCartButton ;
	
	
	public ProductPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	

	public String AddtoCartButton ()
	{
		String phoneDetails = addToCartButton.getText();
		System.out.println("Verify the button : " + phoneDetails);
	    return phoneDetails ;
	}
	
}
