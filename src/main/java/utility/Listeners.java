package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Page implements ITestListener {
	
	public void onTestSuccess (ITestResult result) {
		//System.out.println("Test is succesful"+result.getName());
		
	}
	public void onTestFailure(ITestResult result) {
		//System.out.println("Test is failed"+result.getName());
		try {
			Screenshot.takescreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped"+result.getName());
	}
	public void onTestStart(ITestResult result) {
		System.out.println("Test is Started"+result.getName());
	}
	

 }
