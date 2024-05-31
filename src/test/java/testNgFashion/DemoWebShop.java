package testNgFashion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoWebShop {
	@Parameters("url")
	@Test(groups = "smoke")
	public void demo(String url) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.close();
	}
}
