package com.facebook.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(how = How.XPATH, using = "//a[starts-with(@id,'u_0_0_')]")
	private WebElement newAccount;

	public void createNewAccount() {
		newAccount.click();
	}

	@FindBy(how = How.NAME, using = "firstname")
	private WebElement firstName;

	public WebElement firstNameField(String enterFirstName) {
		firstName.sendKeys(enterFirstName);
		return firstName;
	}
	
	@FindBy(how = How.NAME, using = "lastname")
	private WebElement lastName;

	public WebElement lastNameField(String enterLastName) {
		lastName.sendKeys(enterLastName);
		return lastName;
	}
	
	@FindBy(how = How.NAME, using = "reg_email__")
	private WebElement email;
	public WebElement emailField(String enterEmail) {
		email.sendKeys(enterEmail);
		return email;
	}
	
	@FindBy(how=How.NAME, using="reg_passwd__") private WebElement password;
	public WebElement passwordField(String EnterYourPassword) {		
		password.sendKeys(EnterYourPassword);
		return password;
	}
	
	@FindBy(how=How.ID, using="month") private WebElement bitrthMonth;
	public WebElement monthDropDownField(int enterYourBirthMonth) {
		Select select = new Select(bitrthMonth);
		select.selectByIndex(enterYourBirthMonth);
		return bitrthMonth;
		
	}
	
	@FindBy(how=How.ID, using="day") private WebElement bitrthDay;
	public WebElement dayDropDownField(int enterYourBirthDay) {
		Select select = new Select(bitrthDay);
		select.selectByIndex(enterYourBirthDay);
		return bitrthDay;
		
	}
	
	@FindBy(how=How.ID, using="year") private WebElement bitrthYear;
	public WebElement yearDropDownField(String enterYourBirthYear) {
		Select select = new Select(bitrthYear);
		select.selectByVisibleText(enterYourBirthYear);
		return bitrthYear;
		
	}
	
	@FindBy(how=How.XPATH, using="(//*[@class='_58mt'])[1]") private WebElement female;
	@FindBy(how=How.XPATH, using="(//*[@class='_58mt'])[2]") private WebElement male;
	@FindBy(how=How.XPATH, using="(//*[@class='_58mt'])[3]") private WebElement custom;
	public WebElement radioButton(String enterGender) {
		
		if (enterGender.equalsIgnoreCase("female")) {
			female.click();
		}else if (enterGender.equalsIgnoreCase("male")) {
			male.click();
		} else {
			custom.click();
		}
	
		return male;
	}
	
	@FindBy(how=How.NAME, using="websubmit")private WebElement signUp;
	public void signupButton() {
		signUp.click();
	}

}
