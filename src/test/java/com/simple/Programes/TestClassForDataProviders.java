package com.simple.Programes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.utility.MyDataProviderClass;

public class TestClassForDataProviders {


	WebDriver driver =null;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test (dataProvider = "loginData", dataProviderClass =MyDataProviderClass.class)
	public void setUp(String loginID, String Password) {

		driver.get("https://livedemo.euniwizarde.com");
		driver.findElement(By.id("loginId")).sendKeys(loginID);
		driver.findElement(By.id("password")).sendKeys(Password);
		String Text = driver.findElement(By.id("generatedCaptcha")).getText();
		driver.findElement(By.id("captchainput")).sendKeys(Text);
		driver.findElement(By.id("button")).click();
		String expected_URL="https://livedemo.euniwizarde.com/login/validateLogin";
		String actual_URL=driver.getCurrentUrl();
		Assert.assertEquals(expected_URL, actual_URL);
		System.out.println(actual_URL);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
