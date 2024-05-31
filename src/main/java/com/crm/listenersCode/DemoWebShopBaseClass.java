package com.crm.listenersCode;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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

import com.crm.reuseable.ReadFileUtility;

public class DemoWebShopBaseClass {

	public WebDriver driver ;
	Properties prop;
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		System.out.println("connect to the data base");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("The pre-condition for test runner");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		//open the browser
		driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//enter into the dws web page
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream("D:\\Eclipse\\com.crm.advance\\src\\test\\resources\\DemoWebShop\\LoginCredentials.properties");
//		prop.load(fis);
		String url=ReadFileUtility.readDataFromProperties("url");
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream("D:\\Eclipse\\com.crm.advance\\src\\test\\resources\\DemoWebShop\\LoginCredentials.properties");
//		prop.load(fis);
//		String username = prop.getProperty("username");
//		String password = prop.getProperty("password"); 
		String username = ReadFileUtility.readDataFromProperties("username");
		driver.findElement(By.id("Email")).sendKeys(username);
		String password = ReadFileUtility.readDataFromProperties("password");
		driver.findElement(By.id("Password")).sendKeys(password);
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
