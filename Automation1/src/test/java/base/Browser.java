package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Browser {

	
	public static WebDriver openChromeBrowser ()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/browser/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
		   
		WebDriver driver = new ChromeDriver(options);
	    return driver ;
	    
	}
	

}
