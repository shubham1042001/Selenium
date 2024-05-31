package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ShopperstackUtility {

	public void readData() throws EncryptedDocumentException, IOException {
		File path = new File("D://shopperstack.pmdx");
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		String email = sheet.getRow(0).getCell(0).toString();
		String password = sheet.getRow(0).getCell(1).toString();
	}
}
