package com.bdd.learning.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	public WebDriver driver;
	
	
	@FindBy(xpath = "//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")
	private WebElement accountCreatedSuccessMessage;
	
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDisplayStatusOfAccountSuccessMessage() {
		boolean displayStatus = accountCreatedSuccessMessage.isDisplayed();
		return displayStatus;
	}

}
