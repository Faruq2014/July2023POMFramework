package com.facebook.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.facebook.utilities.ReadPropertise;

public class BaseTest {
	protected WebDriver driver;
	ReadPropertise readPropertise;
	
	@BeforeMethod(groups = { "smoke", "regression" })

	public void openApplication() {
		readPropertise= new ReadPropertise();
		String browser = readPropertise.getUrl();
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
			System.out.println("chrome browser");
		}
		
		driver.get(readPropertise.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void closeApplication() {
		if (driver != null) {
			driver.quit();
		}
	}

}
