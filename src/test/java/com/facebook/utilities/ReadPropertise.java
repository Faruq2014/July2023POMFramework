package com.facebook.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertise {
	Properties propertise;

	public ReadPropertise() {
		propertise = new Properties();

		try {
			FileInputStream fis = new FileInputStream("src/test/resources/test.properties");
			propertise.load(fis);
		} catch (IOException e) {
	        System.out.println("Error loading properties file: " + e.getMessage());
		}
	}

	public String getBrowser() {
		return propertise.getProperty("browser");
		
	}

	public String getUrl() {
		 return propertise.getProperty("qaUrl");
	}

	public String getUserName() {
	return propertise.getProperty("userName");
	}

	public String getPassword() {
		return propertise.getProperty("password");
	}

	public static void main(String[] args) {
		ReadPropertise rp = new ReadPropertise();
		System.out.println(rp.getBrowser());
	}
}
