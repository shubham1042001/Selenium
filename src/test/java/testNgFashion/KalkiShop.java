package testNgFashion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KalkiShop {
	@Parameters("url")
	@Test(groups = "smoke")
	public void ajio(String url) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.close();
	}
}
