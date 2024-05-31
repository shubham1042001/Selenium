package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	
	WebDriver driver ;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("connect to the data base");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("The pre-condition for test runner");
	}
	
	@BeforeClass
	public void beforeClass() {
		//open the browser
		driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//enter into the dws web page
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("admin01");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.className("ico-logout")).click();
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Post-condition for test runner");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("disconnect the data base");
	}
}
