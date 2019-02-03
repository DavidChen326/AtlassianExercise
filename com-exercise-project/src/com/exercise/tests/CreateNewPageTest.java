package com.exercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exercise.pagefactories.DashboardPageFactory;
import com.exercise.pagefactories.NewPageFactory;
import com.exercise.utilities.LoginFactory;
import com.exercise.utilities.RandomStringGenerator;
import com.exercise.utilities.TestSetupAndTearDown;

public class CreateNewPageTest extends TestSetupAndTearDown {
			
		@Test
		public void CreateNewPageTests() throws InterruptedException {
			LoginFactory loginFactory = new LoginFactory(driver);
			loginFactory.login();
	
			DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);
	
			dashboardPage.addNewPage();
			dashboardPage.createPage();
				
			NewPageFactory newPage = new NewPageFactory(driver);
			
			RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
			PageTitle pageTitle = new PageTitle ("Test Page " + randomStringGenerator.randomString(5));
			String newPageTitle = pageTitle.pageTitle;
			//test 1
			try {
				Assert.assertEquals(driver.getTitle(), "Add Page - Confluence");
			} catch (AssertionError ex) {
				System.out.println("Error: Failing to add a new page");
				throw ex;
			}
			
			newPage.typePageTitle().sendKeys(newPageTitle);
			newPage.putRestrictionsOnPage();
			newPage.selectRestrictionType();
			newPage.saveRestrictions();
			Thread.sleep(2000);
			newPage.publishNewPage();

			//test 2
			try {
				Assert.assertEquals(driver.getTitle(), newPageTitle + " - Exercise Project - Confluence");
			} catch (AssertionError ex) {
				System.out.println("Error: Failing to create a new page");
				throw ex;
			}
		}
		
		//debts constructor
				public class PageTitle{
					public String pageTitle;
					public PageTitle (String title) {
						pageTitle = title;
					}
				}
	}