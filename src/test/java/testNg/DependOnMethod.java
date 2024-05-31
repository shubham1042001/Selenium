package testNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependOnMethod {

	@Test(priority = 3)
	public void createAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chennaisuperkings.com/");
		driver.close();
		System.out.println("Account is created");
	}
	@Test(priority = 0,dependsOnMethods ="createAccount" )
	public void modifyAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalchallengers.com/");
		driver.close();
		System.out.println("Account has been modified");
	}
	@Test(priority = 2,dependsOnMethods = "createAccount")
	public void deleteAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.close();
		System.out.println("Account has been deleted....");
	}
	
}
