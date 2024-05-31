package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DemoWebShopTask3 extends BaseClass{

	@Test
	public void search() {
		driver.findElement(By.id("small-searchterms")).sendKeys("iphone",Keys.ENTER);
	}
}
