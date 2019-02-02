package com.exercise.pagefactories;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPageFactory {

	
	WebDriver driver;
	
	//web elements
		@FindBy(id = "content-title")
		WebElement pageTitleTextBox;

		@FindBy(id = "rte-button-restrictions")
		WebElement restrictionsButton;
		
		@FindBy(id = "select2-drop-mask")
		WebElement restrictionsDropDown;
		
		@FindBy(id = "page-restrictions-dialog-save-button")
		WebElement saveRestrictionsButton;
		
		@FindBy(id = "rte-button-publish")
		WebElement publishButton;
		
	//steps
		public String getTitle() {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement pageTitle = wait.until(ExpectedConditions.visibilityOf(pageTitleTextBox));
			return pageTitle.toString();
		}

		public void typePageTitle() {
			pageTitleTextBox.sendKeys("An Example Page");
		}
		
		public void putRestrictionsOnPage() {
			restrictionsButton.click();
		}
		
		public void selectRestrictionType() {
			restrictionsDropDown.click();
			restrictionsDropDown.sendKeys(Keys.ARROW_DOWN);
			restrictionsDropDown.sendKeys(Keys.ENTER);
		}
		
		public void saveRestrictions() {
			saveRestrictionsButton.click();
		}
	
		public void publishNewPage() {
			publishButton.click();
		}
		
	// constructor
		public NewPageFactory(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

}
