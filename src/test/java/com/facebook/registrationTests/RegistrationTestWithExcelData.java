package com.facebook.registrationTests;

import org.testng.annotations.Test;

import com.facebook.base.BaseTest;
import com.facebook.registrationPages.RegistrationPage;
import com.facebook.utilities.ReadExcel;

public class RegistrationTestWithExcelData extends BaseTest{
	
	RegistrationPage rp;
	
	@Test(priority=1, groups="smoke")
	public void signUpTestForRahul() {
		String fileLocation = "src/test/resources/registration.xlsx";
		String sheetName = "Sheet1";
		ReadExcel re = new ReadExcel(fileLocation, sheetName);
		String fName = re.getStringData(1, 0);
		String lName = re.getStringData(1, 1);
		String email = re.getStringData(1, 2);
		String pass = re.getStringData(1, 4);
		String month = re.getStringData(1, 5);
		String day = re.getStringData(1, 6);
		rp= new RegistrationPage(driver);
		rp.createNewAccount();
		rp.firstNameField(fName);
		rp.lastNameField(lName);
		rp.emailField(email);
		rp.passwordField(pass);
		rp.monthDropDownField(month);
		rp.dayDropDownField(day);
		rp.yearDropDownField("1982");
		rp.radioButton("male");
	}
	
	//@Test(priority=2, groups="regression")
	public void signUpTestForIsrak() {
		rp= new RegistrationPage(driver);
		rp.createNewAccount();
		rp.firstNameField("Israk");
		rp.lastNameField("Molla");
		rp.emailField("rm@ymail.com");
		rp.passwordField("hjkjk");
		rp.monthDropDownField("Aug");
		rp.dayDropDownField("22");
		rp.yearDropDownField("1982");
		rp.radioButton("male");
	}
	
	

}
