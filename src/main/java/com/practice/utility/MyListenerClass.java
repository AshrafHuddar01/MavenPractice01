package com.practice.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.practice.Base.BaseClassForLivedemoLogin;


public class MyListenerClass extends BaseClassForLivedemoLogin implements ITestListener{

	public void onTestFailure(ITestResult result) {
		screenshot(result.getMethod().getMethodName());  //This method is of base class screenshot
	}

}
