package com.bdd.learning.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartConfirmationButton;

	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickAddToCart() {
		addToCartButton.click();
	}

	public void clickAddToCartConfirmation() {
		addToCartConfirmationButton.click();
	}
}
