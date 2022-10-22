package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	 public static WebDriver openChromeBrowser()  {
			

	//System.setProperty("webdriver.chrome.driver", "C:\\Software\\chromedriver_win32\\chromedriver.exe");
		 
		WebDriverManager.chromedriver().setup(); // not requred above line
	
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disble notification");
	//options.addArguments("--headless"); // withoutwebpage show result
	
	 WebDriver driver = new ChromeDriver(options);
	 
	 driver.navigate().to("https://en-gb.facebook.com/reg/");
	 
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return driver;

}
}