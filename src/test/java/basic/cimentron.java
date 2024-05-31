package basic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class cimentron {

	@Test
	public void main() throws Exception {

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.cimatron.com/en");

		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		String scriptReturning = "";
		String scriptResult = (String) js.executeScript("return document.getElementsByTagName('body')[0].innerText");
		System.out.println("Text Inside:" + scriptResult);

		driver.quit();
	}
}
