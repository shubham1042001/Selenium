package parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Giftcard extends DemoWebShopBaseClass{

	@Test
	public void giftCard() throws EncryptedDocumentException, IOException, InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
		driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		File path = new File("D:\\Giftcard.pmdx");
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		String name = sheet.getRow(0).getCell(0).toString();
		String email = sheet.getRow(0).getCell(1).toString();
//		String quantity = sheet.getRow(0).getCell(2).toString();
		
		driver.findElement(By.id("giftcard_1_RecipientName")).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.id("addtocart_1_EnteredQuantity")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("addtocart_1_EnteredQuantity")).sendKeys("5");
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button-1")).click();
	}
}
