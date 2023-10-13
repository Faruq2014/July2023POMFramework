package com.facebook.listeners;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.facebook.base.BaseTest;
import com.facebook.loginPages.LoginPage;

public class FacebookListerner extends BaseTest implements ITestListener{
   // WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+">>>>"+result.getStatus());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+">>>>"+result.getStatus());
		
		
		//WebDriver driver=null;
		/*
		 * try { driver=(WebDriver)result.getTestClass().getRealClass()
		 * .getDeclaredField(result.getTestName()).get(result.getInstance()); } catch
		 * (IllegalArgumentException | IllegalAccessException | NoSuchFieldException |
		 * SecurityException e) {
		 * 
		 * e.printStackTrace(); }
		 
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String detFilePath=System.getProperty("user.dir")+"\\ScreenShots"+result.getName()+".png";
	try {
		FileUtils.copyFile(srcFile, new File(detFilePath));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	*/	
		
		
		//screenShot(driver,result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+">>>>"+result.getStatus());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+" Finished");
	}
	

}
