package listeners;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.listenersCode.DemoWebShopBaseClass;
import com.crm.reuseable.ReadFileUtility;
@Listeners(com.crm.listenersCode.DwsLogin.class)
public class GiftCard extends DemoWebShopBaseClass {

	@Test
	public void giftCard() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
		driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
//		File path = new File("D:\\Eclipse\\com.crm.advance\\src\\test\\resources\\DemoWebShop\\giftcard.pmdx");
//		FileInputStream fis = new FileInputStream(path);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("Sheet1");
//		String name = sheet.getRow(0).getCell(0).toString();
//		String email = sheet.getRow(0).getCell(1).toString();
//		
		String name1 =ReadFileUtility.readDataFromExcel("Sheet1",0,0);
		
		driver.findElement(By.id("giftcard_1_RecipientName")).sendKeys(name1);
		Thread.sleep(2000);
		String email1 =ReadFileUtility.readDataFromExcel("Sheet1",0,1);
		driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys(email1);
		Thread.sleep(2000);
		driver.findElement(By.id("addtocart_1_EnteredQuantity")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("addtocart_1_EnteredQuantity")).sendKeys("3");
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button-1")).click();
	}
	
}
