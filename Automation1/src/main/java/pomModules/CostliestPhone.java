package pomModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CostliestPhone {

	@FindBy (xpath = "(//div[@class='col col-7-12']/div)[1]")
	private WebElement firstPhoneWithCriteria ;
	
	
	public CostliestPhone (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void firstPhone ()
	{
	    firstPhoneWithCriteria.click();
	}



	
	
}
