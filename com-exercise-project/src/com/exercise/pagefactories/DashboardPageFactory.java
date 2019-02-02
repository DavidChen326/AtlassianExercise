package com.exercise.pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageFactory {

	WebDriver driver;
	
	//web elements
		@FindBy(id = "create-page-button")
		WebElement addPageButton;

		@FindBy(xpath = "//*[@id=\"create-dialog\"]/div/div[2]/button")
		WebElement createButton;
		
	//steps
		public void addNewPage() {
			addPageButton.click();
		}
		
		public void createPage() {
			createButton.click();
		}
	
	// constructor
		public DashboardPageFactory(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
}
