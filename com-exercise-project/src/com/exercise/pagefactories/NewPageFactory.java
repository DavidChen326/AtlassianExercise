package com.exercise.pagefactories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		
		@FindBy(id = "s2id_page-restrictions-dialog-selector")
		WebElement restrictionsDropDown;
		
		@FindBy(id = "page-restrictions-dialog-save-button")
		WebElement saveRestrictionsButton;
		
		@FindBy(id = "rte-button-publish")
		WebElement publishButton;
		
	//steps
		public WebElement typePageTitle() {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement pageTitle = wait.until(ExpectedConditions.visibilityOf(pageTitleTextBox));
			return pageTitle;
		}
		
		public void putRestrictionsOnPage() {
			restrictionsButton.click();
		}
		
		public void selectRestrictionType() {
			
			//select second option from dropdown
			Actions act = new Actions(driver);
			act.click(restrictionsDropDown).build().perform();
			List<WebElement> options = driver.findElements(By.id("select2-drop"));
			for (WebElement option : options) {
				if ("Editing restricted".equals(option.getText()));
				option.click();
			}
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
