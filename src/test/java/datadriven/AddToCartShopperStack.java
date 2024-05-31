package datadriven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddToCartShopperStack extends ShopperstackBaseClass {

	@Test
		public void addProduct() throws InterruptedException {
		
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		ac.moveToElement(men).build().perform();
		Thread.sleep(2000);
		WebElement tshirt = driver.findElement(By.xpath("//a[text()='T-shirts']"));
		tshirt.click();
		List<WebElement> addTocart = driver.findElements(By.xpath("//button[text()='add to cart']"));
		for (WebElement web : addTocart) {
			web.click();
			Thread.sleep(2000);
		}
	}
}

