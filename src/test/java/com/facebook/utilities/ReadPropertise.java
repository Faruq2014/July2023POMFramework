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
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return (String) propertise.get("browser");
	}

	public String getUrl() {
		return (String) propertise.get("qaUrl");
	}

	public String getUserName() {
		return (String) propertise.get("userName");
	}

	public String getPassword() {
		return (String) propertise.get("password");
	}

	public static void main(String[] args) {
		ReadPropertise rp = new ReadPropertise();
		System.out.println(rp.getUrl());
	}
}
