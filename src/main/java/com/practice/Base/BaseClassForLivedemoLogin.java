	package com.practice.Base;
	
	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Date;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.edge.EdgeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	
	public class BaseClassForLivedemoLogin {
	
		public static WebDriver driver;
	
		@Parameters("browser") //Parameterization from ml
		@BeforeTest
		public void setUp1(String browser) {
	
			switch (browser.toLowerCase()) {
	
			case "chrome":
				
				  ChromeOptions chromeOptions = new ChromeOptions();
				//  chromeOptions.addArguments("--headless");
				  chromeOptions.addArguments("--disable-gpu");
				  chromeOptions.addArguments("--window-size=1920,1080");
				 
				driver = new ChromeDriver(chromeOptions);
				break;
	
			case "firefox":
	
				FirefoxOptions fireOptions = new FirefoxOptions();
			//	fireOptions.addArguments("--headless");
				fireOptions.addArguments("--disable-gpu");
				fireOptions.addArguments("--window-size=1920,1080");
				driver = new FirefoxDriver(fireOptions);
				break;
	
			case "edge":
	
				EdgeOptions edgeOptions = new EdgeOptions();
	
				//edgeOptions.addArguments("--headless");
				edgeOptions.addArguments("--disable-gpu");
				edgeOptions.addArguments("--window-size=1920,1080");
				driver = new EdgeDriver(edgeOptions);
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		}
	
		@AfterTest
		public void teardown() {
			driver.quit();
		}
	
		public void screenshot(String fileName) {
	
			Date d = new Date();
	
			String currentDate = d.toString().replaceAll(":", "_");
	
			if (driver == null) {
	
				System.out.println("Ashraf null");
			}
	
			TakesScreenshot Ts = (TakesScreenshot) driver;
	
	
			File srcFile = Ts.getScreenshotAs(OutputType.FILE);
	
			File destFile = new File(".\\screenshots\\" + "_" + currentDate + "_" + fileName + "_screenshot.png");
	
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
	
				e.printStackTrace();
			}
			System.out.println("Screen shot generated successfully");
		}
	}
