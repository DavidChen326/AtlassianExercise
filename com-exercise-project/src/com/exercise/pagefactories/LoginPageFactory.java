package com.exercise.pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	WebDriver driver;
	
	//web elements
		@FindBy(id = "username")
		WebElement usernameTextBox;
	
		@FindBy(id = "login-submit")
		WebElement loginButton;
		
		@FindBy(id = "password")
		WebElement passwordTextBox;



	//steps
		public void setUserName(String username) {
			usernameTextBox.sendKeys(username);
		}
	
		public void clickSubmit() {
			loginButton.click();
		}
		
		public void setPassword(String password) {
			passwordTextBox.sendKeys(password);
		}


	// actions
		public void logIn(String username, String password) {
			setUserName(username);
			clickSubmit();
			setPassword(password);
			clickSubmit();
		}

	// constructor
		public LoginPageFactory(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
}

