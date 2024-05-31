package datadriven;

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

public class ShopperstackBaseClass {
		
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
		public void beforeClass() throws InterruptedException {
			//open the browser
			driver = new ChromeDriver();
			//maximize the browser
			driver.manage().window().maximize();
			//implicitly wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			//enter into the dws web page
			driver.get("https://www.shoppersstack.com/");
			Thread.sleep(8000);
		}
		
		@BeforeMethod
		public void beforeMethod() throws InterruptedException {
			
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("Email")).sendKeys("shubhamshejpure@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("Shubham@123");
			driver.findElement(By.id("Login")).click();
			Thread.sleep(4000);
		}
		////button[@aria-controls='account-menu']
		@AfterMethod
		public void afterMethod() {
			driver.findElement(By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-bjoz8z']")).click();
			driver.findElement(By.xpath("//li[normalize-space(.)='Logout']")).click();
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
