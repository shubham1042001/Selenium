package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataForLoop {

	@Test
	public void readFor() throws EncryptedDocumentException, IOException {
		// file upload with path
		File path = new File("D:\\Login.pmdx");
		//create fileinputstream
		FileInputStream fis = new FileInputStream(path);
		//create workbook 
		Workbook wb = WorkbookFactory.create(fis);
		//create sheet provide sheet name
		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				String s1 = sheet.getRow(i).getCell(j).toString();
				System.out.println(s1);
			}
		}
	}
}
