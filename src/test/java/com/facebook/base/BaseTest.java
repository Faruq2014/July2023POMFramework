package com.facebook.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
	
	 String browser="edge";
	
	@BeforeMethod(groups={"smoke","regression"})
	public void openApplication() {
		if (browser.equalsIgnoreCase("chrome")) {
			chrome();
		}else if(browser.equalsIgnoreCase("edge")) {
			edge();
		}else {System.out.println("wrong browser");}
	}
	
	
	
	public WebDriver chrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		return driver;
	}
	
	public WebDriver edge() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		return driver;
	}
	
   @AfterMethod(groups={"smoke","regression"})
	public void closeApplication() {
		if (driver !=null ) {
			driver.quit();
		}
	}

}
