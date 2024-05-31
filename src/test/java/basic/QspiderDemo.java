package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QspiderDemo {

	public static void main(String[] args)throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoapps.qspiders.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		
		Thread.sleep(2000);
		
		WebElement formValidation = driver.findElement(By.xpath("//section[text()='FormValidation']"));
		
		formValidation.click();
		
//		driver.findElement(By.name("requiredfield")).sendKeys("Hello");
//		
//		driver.findElement(By.name("minLength")).sendKeys("Shubh");
//		
//		driver.findElement(By.name("password")).sendKeys("Shubham@123");
//		
//		driver.findElement(By.name("maxLength")).sendKeys("Shubham");
//		
//		driver.findElement(By.name("confirmpass")).sendKeys("Shubham@123");
//		
//		driver.findElement(By.name("rangeLength")).sendKeys("Shubham Shejpure");
//		
//		driver.findElement(By.name("email")).sendKeys("shubhamshejpure@gmail.com");
//		
//		driver.findElement(By.name("minValue")).sendKeys("Shubham");
//		
//		driver.findElement(By.name("url")).sendKeys("Shubham");
		
		List<WebElement> textfield = driver.findElements(By.xpath("//div[@class='form-group p-[1.5] my-3']/div/input"));
		
		String value [] = {"shu","shu","shu","shu","shu","shu","shu","shu","shu","shu","shu","shu","shu","shu"};
		
		int i = 0 ;
		
		for (WebElement web : textfield) {
			web.sendKeys(value[i++]);
		}
	}
}
