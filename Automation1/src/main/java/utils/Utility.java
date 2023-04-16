package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	 public static WebDriver driver ;
		public static void captureScreenshot (WebDriver driver , String methodName) throws IOException
		{   
		   
			TakesScreenshot t = (TakesScreenshot) driver ;
			
			DateTimeFormatter DTF = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			LocalDateTime DT = LocalDateTime.now();
			
			File source = t.getScreenshotAs(OutputType.FILE);
			File destination = new File ("test-output/failedScreenshot/Test" + methodName + DTF.format (DT) + ".jpg");
			FileHandler.copy(source, destination);
		
			
	    }

}
