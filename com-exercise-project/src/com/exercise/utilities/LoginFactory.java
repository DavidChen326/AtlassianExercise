package com.exercise.utilities;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.exercise.pagefactories.LoginPageFactory;

public class LoginFactory {

	WebDriver driver;

	public void login() throws InterruptedException {
		driver.get("https://excerise.atlassian.net/wiki/");
		String username = "chenzheng0326@gmail.com";
		String password = decodePassword("IXpoZW5nY2hlbjMyNkV4ZXJjaXNl");

		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.logIn(username, password);
	}

	//decode encoded password
	public static String decodePassword(String password) {
		byte[] decodedPassword = Base64.decodeBase64(password);
		return new String(decodedPassword);
	}
	
	//constructor
	public LoginFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
