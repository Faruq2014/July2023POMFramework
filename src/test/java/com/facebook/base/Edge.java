package com.facebook.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Edge {
	protected WebDriver driver;
@Test
public void openEdge() {
	driver = new EdgeDriver();
	driver.get("https://www.facebook.com/");
}
}
