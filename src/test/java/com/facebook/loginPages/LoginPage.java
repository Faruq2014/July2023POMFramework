package com.facebook.loginPages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;



	/*
	 * public LoginPageFactoryInitElements(WebDriver driver, WebElement uName,
	 * WebElement password, WebElement loginButton) { super(); this.driver = driver;
	 * this.uName = uName; this.password = password; this.loginButton = loginButton;
	 * }
	 */
	
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//page factory class 
		//initElements method is initializing all the WebElement instance variables
	}
	

	public void userName1(String enterUserName) {
		driver.findElement(By.id("email")).sendKeys(enterUserName);
	}
	
	@FindBy(how=How.ID, using="email") public WebElement uName;
	
	public WebElement userName(String enterUserName) {
		uName.sendKeys(enterUserName);
		return uName;
	}
	
	public WebElement userName2(String enterUserName) {
		uName.sendKeys(enterUserName);
		return uName;
	}
	
	@FindBy(how=How.ID, using="pass") private WebElement password;
	//@FindBy is the annotation
	//how= is the formula
	//private WebElement password;= is an instance variable
	
	public WebElement enterPassword(String enterYourPassword) {
		password.sendKeys(enterYourPassword);
		return password;
	}
	
	@FindBy(how=How.XPATH, using="//button[starts-with(@id,'u_0_5')]")  private WebElement loginButton;
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
}
