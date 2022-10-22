package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookLoginPage {
	@FindBy (xpath="//input[@type='text']")private WebElement name;
	@FindBy (xpath="//input[@name='lastname']")private WebElement lastname;
	@FindBy (xpath="//input[@name='reg_email__']")private WebElement email;
	@FindBy (xpath="//input[@name='reg_email_confirmation__']")private WebElement mail;
	@FindBy (xpath="//input[@name='reg_passwd__']")private WebElement password;
	@FindBy (xpath="//select[@id='day']")private WebElement day;
	@FindBy (xpath="//select[@id='month']")private WebElement month;
	@FindBy (xpath="//select[@id='year']")private WebElement year;
	@FindBy (xpath="(//input[@name='sex'])[2]")private WebElement male;
	@FindBy (xpath="//button[@type='submit']")private WebElement singup;
	@FindBy (xpath="//a[text()='Already have an account?']")private WebElement alradyacc;

public  FaceBookLoginPage(WebDriver driver ) {
	
	PageFactory.initElements(driver, this);
	
}
public void entername(String Name) {
	name.sendKeys(Name);
}
public void enterlastname(String Last) {
	lastname.sendKeys(Last);
}
public void enteremail(String Email) {
	email.sendKeys(Email);
}
public void enterremail(String Emmail) {
	mail.sendKeys(Emmail);
}
public void enterpassword(String Pass, WebDriver driver) {
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
	//wait.until(ExpectedConditions.visibilityOf(password));
	FluentWait<WebDriver> wait=new  FluentWait<WebDriver>(driver);
	wait.withTimeout(Duration.ofMillis(3000));
	wait.pollingEvery(Duration.ofMillis(100));
	wait.ignoring(Exception.class);
	wait.until(ExpectedConditions.visibilityOf(password));
	
	password.sendKeys(Pass);
}
public void selectday(String Day) {
	Select s= new Select(day);
	s.selectByVisibleText(Day);			
}
public void selectmonth(String Month) {
	Select s=new  Select (month);
	s.selectByVisibleText(Month);
}
public void selectyear(String Year) {
	Select s=new  Select (year);
	s.selectByVisibleText(Year);
}
public void clickmale() {
	male.click();   
}
public void singup() {
	singup.click();
}
 
}

	


