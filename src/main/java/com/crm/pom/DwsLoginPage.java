package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsLoginPage {
	
	public DwsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public @FindBy(id="Email")
	WebElement username;
	public @FindBy(name="Password")
	WebElement password;
	public @FindBy(xpath="//input[@value='Log in']")
	WebElement login_button;
	
	public void username(String value) {
		username.sendKeys(value);
	}
	
	public void password(String value) {
		password.sendKeys(value);
	}
	
	public void login_button() {
		login_button.click();
	}
}
