package com.exercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.exercise.pagefactories.LoginPageFactory;

public class LoginFactory {

	WebDriver driver;

	public void login() {
		driver.get("https://excerise.atlassian.net/wiki/");
		String username = "chenzheng0326@gmail.com";
		String password = "m4a1Zheng0326";

		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.logIn(username, password);
	}

	// constructor
	public LoginFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
