package datadriven;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcel {

	@Test
	public void readData() throws EncryptedDocumentException,Exception{
		// file upload with path
		File path = new File("D:\\Login.pmdx");
		//create fileinputstream
		FileInputStream fis = new FileInputStream(path);
		//create workbook 
		Workbook wb = WorkbookFactory.create(fis);
		//create sheet provide sheet name
		Sheet sheet = wb.getSheet("Sheet1");
		//fetch the data from sheet
		String gmail = sheet.getRow(0).getCell(0).toString();
		System.out.println(gmail);
	}
}
