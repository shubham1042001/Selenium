package com.crm.reuseable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFileUtility {

	public static String readDataFromProperties(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Eclipse\\com.crm.advance\\src\\test\\resources\\DemoWebShop\\LoginCredentials.properties");
		prop.load(fis);
		String data = prop.getProperty(key);
		
		return data;
	}
	
	public static String readDataFromExcel(String s,int row,int cell) throws EncryptedDocumentException, IOException {
		File path = new File("D:\\Eclipse\\com.crm.advance\\src\\test\\resources\\DemoWebShop\\giftcard.pmdx");
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Sheet1");
		String data = sheet.getRow(row).getCell(cell).toString();
		
		
		return data ;
		
	}
	
}
