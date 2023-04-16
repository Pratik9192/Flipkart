package pomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtocart {


	@FindBy (xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart ;
	
	@FindBy (xpath = "//span[text()='Cart']")
	private WebElement cartButton ;
	
	@FindBy (xpath = "//div[@class='_2-uG6-']")
	private WebElement redmiPhone ; 
	
	
	public Addtocart (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnAddCartButton ()
	{
		 addToCart.click();
	}
	
	public void clickOnCartButton ()
	{
		cartButton.click();
	}
	
	public String getMobileDetails ()
	{
		String text = redmiPhone.getText();
		return text ;
	}
	
}
