package com.facebook.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.facebook.utilities.ReadPropertise;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	ReadPropertise readPropertise;
	
	@BeforeMethod(groups = { "smoke", "regression" })

	public void openApplication() {
		readPropertise= new ReadPropertise();
		String browser = readPropertise.getBrowser();
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
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
	
	public void webElementScreenShot(WebElement user, String screenShotName) {
		File SrcFile=user.getScreenshotAs(OutputType.FILE);
		long time=System.currentTimeMillis();
		String fileWithPath="screenShot/"+time+screenShotName+".png";
		File DestFile=new File(fileWithPath);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	
	public void screenShot(String screenShotName) {
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		long time=System.currentTimeMillis();
		String detFilePath=System.getProperty("user.dir")+"\\ScreenShots\\"+"test"+".png";
		String fileWithPath="screenShot/"+time+screenShotName+".png";	
		File DestFile=new File(detFilePath);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

}
