package basic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoWebShopTask1 extends BaseClass {

	@Test
	public void giftCard() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
	}
}
