package listeners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NetworkFailure {

	@Test(retryAnalyzer = com.crm.listenersCode.NetworkRetry.class)
	public void searchProducts() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		assertEquals("hii","Hii");
	}
}
