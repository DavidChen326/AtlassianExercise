package com.exercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exercise.pagefactories.DashboardPageFactory;
import com.exercise.pagefactories.NewPageFactory;
import com.exercise.utilities.LoginFactory;
import com.exercise.utilities.TestSetupAndTearDown;


public class CreateNewPageTest extends TestSetupAndTearDown {

	@Test
	public void loginTests() throws InterruptedException {
		LoginFactory loginFactory = new LoginFactory(driver);
		loginFactory.login();

		DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);

		dashboardPage.addNewPage();
		dashboardPage.createPage();
		
		NewPageFactory newPage = new NewPageFactory(driver);		
		
		//test 1
		try {
			Assert.assertEquals(newPage.getTitle(), "Add Page - Confluence");
		} catch (AssertionError ex) {
			System.out.println("Error: Failing to add a new page");
			throw ex;
		}
		
		newPage.typePageTitle();
		newPage.putRestrictionsOnPage();
		newPage.selectRestrictionType();
		newPage.saveRestrictions();
		newPage.publishNewPage();
		Thread.sleep(2000);
		
		//test 2
		try {
			Assert.assertEquals(driver.getTitle(), "An Example Page - Exercise Project - Confluence");
		} catch (AssertionError ex) {
			System.out.println("Error: Failing to create a new page");
			throw ex;
		}
	}
}