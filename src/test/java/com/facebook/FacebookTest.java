package com.facebook;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookTest {
    WebDriver driver;
    
    @Test
    public void facebookAppTest() {
    	driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		System.out.println("Facebook title is : " +driver.getTitle());
		driver.quit();
    }
}
