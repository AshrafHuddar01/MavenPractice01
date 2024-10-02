package com.simple.Programes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.practice.Base.BaseClassForLivedemoLogin;
import com.practice.utility.MyDataProviderClass;
import com.practice.utility.MyListenerClass;



@Listeners(MyListenerClass.class)
public class TestCaseForScreenShotFailedTestCase extends BaseClassForLivedemoLogin{
 
	
	@Test (dataProvider = "loginData", dataProviderClass=MyDataProviderClass.class)
	public void Login1(String loginID, String Password) throws InterruptedException, IOException {
	Properties prop=new Properties();//properties file to read data from config.properties file
	
	FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
	
	prop.load(fis);
	
	driver.get(prop.getProperty("URL"));
	driver.findElement(By.id("loginId")).sendKeys(loginID);
	driver.findElement(By.id("password")).sendKeys(Password);
	String Text = driver.findElement(By.id("generatedCaptcha")).getText();
	driver.findElement(By.id("captchainput")).sendKeys(Text);
	driver.findElement(By.id("button")).click();
	String Expected_URL="https://livedemo.euniwizarde.com/login/validateLogin";
	String actual_URL=driver.getCurrentUrl();
	Assert.assertEquals(Expected_URL, actual_URL);
	Thread.sleep(3000);
	
	}
}
