package datadriven;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditProfileShopperstack extends ShopperstackBaseClass{

	@Test
	public void editProfile() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-bjoz8z']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[normalize-space(.)='My Profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Edit Profile')]")).click();
		driver.findElement(By.xpath("//div[@role='dialog']")).clear();
//		WebElement first = driver.findElement(By.id("First Name"));
//		first.clear();
//		WebElement last = driver.findElement(By.id("Last Name"));
//		last.clear();
//		WebElement phno = driver.findElement(By.id("Phone Number"));
//		phno.clear();
//		WebElement date = driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']"));
//		
	}
}
