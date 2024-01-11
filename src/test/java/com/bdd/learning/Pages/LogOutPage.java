package com.bdd.learning.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    public WebDriver driver;
   

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logOut;

    @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
    private WebElement logOffFromAccountInfoLink;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoggedOut() {
        return logOut;
    }

   
    public boolean validateDisplayMessageOfLogOffFromAccountInfoLink() {
        return logOffFromAccountInfoLink.isDisplayed();
    }


		
		
	
	 
	}



	

	 
	



