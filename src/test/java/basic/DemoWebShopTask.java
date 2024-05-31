package basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoWebShopTask extends BaseClass {

	@Test
	public void add() {
		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
			
		List <WebElement> addCart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
			
		for (WebElement web : addCart) {
			web.click();
		}
	}
}
