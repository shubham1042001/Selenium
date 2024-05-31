package parameter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OpenLinks extends DemoWebShopBaseClass {

	@Test
	public void openLinks() throws InterruptedException {
		
		Actions ac = new Actions(driver);
		
		ac.keyDown(Keys.PAGE_DOWN).build().perform();
		
		ac.keyDown(Keys.PAGE_DOWN).build().perform();
		
		Thread.sleep(2000);
		
		List<WebElement> link = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		
		Thread.sleep(2000);
		
		for (WebElement web : link) {
			System.out.println(web.getText());
			String rss = "RSS";
			
			if (web.getText().equals(rss)) {
				ac.keyDown(Keys.CONTROL).build().perform();
				web.click();
			}
			else {
				web.click();
			}
		}
		
		ArrayList<String> allWindows = new ArrayList<>(driver.getWindowHandles());
		 
		String parentWindow = driver.getWindowHandle();
		 
		for (String windowHandle : allWindows) {
	            if (!windowHandle.equals(parentWindow)) {
	                driver.switchTo().window(windowHandle);
	                driver.close();
	                System.out.println("Closed child window: " + windowHandle);
	            }
		}
		
		driver.switchTo().window(parentWindow);
	}
	
}
