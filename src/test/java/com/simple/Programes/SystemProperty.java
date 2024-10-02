package com.simple.Programes;

import java.util.Properties;

public class SystemProperty {

	public static void main(String[] args) {
	//	Properties properties =System.getProperties();
		//properties.list(System.out);
	
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("os.name"));
	    System.out.println(System.getProperty("java.version"));
	    System.out.println(System.getProperty("browser.version"));
	}
}
