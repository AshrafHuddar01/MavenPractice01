package com.simple.Programes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser {
	
WebDriver driver =null;
	
@BeforeMethod
public void setUp() {
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://livedemo.euniwizarde.com");
	}

@Test
public void loginLivedemo() {
	String title=driver.getTitle();
	String currentURL=driver.getCurrentUrl();
	System.out.println(title+"----"+currentURL);
}	
	
@Test
public void loginLivedemoPropertiesFile() throws Exception {
	Properties properties;
	//File file=new File("./src/test/resources/config.properties");
	FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
	//System.out.println(file.exists());
	properties = new Properties();
	properties.load(fis);
	String SiteURL = properties.getProperty("URL");
	System.out.println(SiteURL);
    	

}

@AfterMethod
	public void terdown() {
		
	driver.close();
}

}
