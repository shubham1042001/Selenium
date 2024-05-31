package datadriven;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
	@Test(dataProvider = "sender")
	public void receiver(String email, String pwd) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		//driver.findElement(By.xpath("//span[text()='Login']")).click();
		driver.close();

	}

	@DataProvider(name = "sender")
	public Object[][] sender() throws EncryptedDocumentException, IOException {
		/*
		 * Object [][]obj = new Object[2][2];
		 * 
		 * obj[0][0]="admin01@gmail.com"; obj[0][1]="admin01";
		 * obj[1][0]="admin02@gmail.com"; obj[1][1]="Admin02"; return obj;
		 */

		return DatautilityByExcel2.shopLogin();

	}

}
