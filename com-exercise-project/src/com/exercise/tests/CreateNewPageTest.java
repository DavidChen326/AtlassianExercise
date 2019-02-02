package com.exercise.tests;

import org.testng.annotations.Test;

import com.exercise.utilities.LoginFactory;
import com.exercise.utilities.TestSetupAndTearDown;


public class CreateNewPageTest extends TestSetupAndTearDown {

	@Test
	public void loginTests() throws InterruptedException {
		LoginFactory loginFactory = new LoginFactory(driver);
		loginFactory.login();

		Thread.sleep(5000);
	}
}