package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
public static void takescreenshot (WebDriver driver , String name ) throws IOException {
		
		
		TakesScreenshot s = ((TakesScreenshot)driver);
		
		
		File source = s.getScreenshotAs(OutputType.FILE);
		
  File destination = new File ("C:\\Users\\karunyakuntal\\eclipse-workspace\\Facebook\\Screenshot\\"+name+".png");
		
  FileHandler.copy(source, destination);
  
}
}



