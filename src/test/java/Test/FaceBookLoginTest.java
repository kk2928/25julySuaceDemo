package Test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.FaceBookLoginPage;
import utility.ExtentReport;
import utility.Page;
import utility.Parametrization;
import utility.Screenshot;
@Listeners(utility.Listeners.class)
public class FaceBookLoginTest extends Page {
	//WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void createReport() {
		report=ExtentReport.getReport();
	}
	@BeforeMethod
	public void openChrome() {
		driver =Browser.openChromeBrowser();
	}
	@Test
	public void ValidLogPage() throws EncryptedDocumentException, IOException {
		test=report.createTest("ValidLogPage");//extents repot
	
	FaceBookLoginPage facebookSingUppage = new FaceBookLoginPage(driver);
	
	facebookSingUppage.entername("Karunya");
	facebookSingUppage.enterlastname("Kharade");
	facebookSingUppage.enteremail("karunyakharade@gmail.com");
	facebookSingUppage.enterremail("karunyakharade@gmail.com");
	
	facebookSingUppage.enterpassword(Parametrization.getExcelDta(0, 0,"Sheet1"),driver);
	
	facebookSingUppage.selectday("2");
	facebookSingUppage.selectmonth("Feb");
	facebookSingUppage.selectyear("2021");
	facebookSingUppage.clickmale(); 
	facebookSingUppage.singup();
	//Screenshot.takescreenshot(driver, "fblog");
}
	@Test
	public void Singupp() {
		
		test=report.createTest("Singupp");
		
		FaceBookLoginPage facebookSingUppage = new FaceBookLoginPage(driver);
		facebookSingUppage.singup();
	}
	@Test
	public void selectmo() {
		
		test=report.createTest("selectmo");
		FaceBookLoginPage facebookSingUppage = new FaceBookLoginPage(driver);
		facebookSingUppage.clickmale();
	}
	
	@AfterMethod
	public void captureResult(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, result.getName());
			}
		else if (result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, result.getName());
			}
		else {
			test.log(Status.SKIP, result.getName());
			
		}
	}
	
	@AfterTest
	public void flushResults() {
		report.flush();
	}
	
} 