package com.practice.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class MyDataProviderClass {
	
	@DataProvider (name="loginData")
	
	public Object[][] getData() throws Exception{
		
		File file = new File("./src/test/resources/LivedemoLoginData.xlsx");
	
	    FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook WorkBook=new XSSFWorkbook(fis);
		XSSFSheet sheet = WorkBook.getSheetAt(0);
		int rows=sheet.getPhysicalNumberOfRows();
		int columns=sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows-1][columns];
		
		for(int i=0; i<rows-1;i++)
		{
			for (int j=0;j<columns;j++)
			{
				DataFormatter DF=new DataFormatter();
				data[i][j]=DF.formatCellValue(sheet.getRow(i+1).getCell(j));//.getStringCellValue());
			}
		}
		
		WorkBook.close();
		fis.close();
		
		
	   return data;
	}

}
