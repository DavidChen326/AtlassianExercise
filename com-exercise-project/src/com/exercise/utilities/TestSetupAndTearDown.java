package com.exercise.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSetupAndTearDown {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("Test Started...");
		String browserType = "firefox";
		driver = com.exercise.utilities.DriverFactory.open(browserType);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		System.out.println("Test Is Completed");
	}
}
