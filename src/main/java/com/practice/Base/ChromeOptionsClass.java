package com.practice.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
	
	    options.addArguments("--start-maximized");  // Start Chrome maximized
        options.addArguments("--disable-infobars");  // Disable "Chrome is being controlled..." infobar
        options.addArguments("--incognito");  // Open Chrome in incognito mode
       // options.addArguments("--headless");  // Run Chrome in headless mode (no UI)
		WebDriver driver = new ChromeDriver(options);

		//driver.manage().window().maximize();
		driver.get("https://www.javatpoint.com/how-to-compare-two-objects-in-java");

	}

}