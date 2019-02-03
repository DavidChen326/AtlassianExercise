package com.exercise.pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPageFactory {

	WebDriver driver;
	
	//web elements
		@FindBy(id = "create-page-button")
		WebElement addPageButton;

		@FindBy(xpath = "/html/body/div[3]/div/div[2]/button")
		WebElement createButton;
		
	//steps
		public void addNewPage() {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement addNewPageButton = wait.until(ExpectedConditions.visibilityOf(addPageButton));
			addNewPageButton.click();
		}
		
		public void createPage() throws InterruptedException {
			Thread.sleep(3000);
			createButton.click();
		}
		
		public void waitForNewPage() {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(addPageButton));
		}
	
	// constructor
		public DashboardPageFactory(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
}
