package com.facebook.loginTests;

import java.util.Properties;

import org.testng.annotations.Test;

import com.facebook.base.BaseTest;
import com.facebook.loginPages.LoginPage;
import com.facebook.utilities.ReadPropertise;

public class LoginTest extends BaseTest{
	LoginPage lp;
	ReadPropertise readPropertise;
	
	@Test(priority=1, groups={"smoke","regression"})
	public void validLoginTest() {
		readPropertise= new ReadPropertise();
		lp = new LoginPage(driver);
		lp.userName(readPropertise.getUserName());
		lp.enterPassword(readPropertise.getPassword());
		lp.clickLoginButton();
	}
	
	
	@Test(priority=2,groups="regression")
	public void invalidLoginTest() {
	    lp = new LoginPage(driver);
		lp.userName("Asma");
		lp.enterPassword("asma123");
		lp.clickLoginButton();
	}
	
	@Test(priority=3, groups="regression")
	public void boundaryLoginTest() {
		lp = new LoginPage(driver);
		lp.userName("Asma");
		lp.enterPassword("asma123");
		lp.clickLoginButton();
	}
	

}
