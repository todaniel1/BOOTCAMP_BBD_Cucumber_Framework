package step_definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.bdd.learning.DriverLogic.DriverFactory;
import com.bdd.learning.Pages.HomePage;
import com.bdd.learning.Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {
	
	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();	
	}

	@When("User enters the valid product {string}")
	public void user_enters_the_valid_product(String validProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(validProductText);
	 }
			
	@Given("User clicks on the search button")
	public void user_clicks_on_the_search_button() {
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchIcon();
	 	}

	@Then("User gets valid product info display in SearchPage")
	public void user_gets_valid_product_info_display_in_search_page() {
			searchpage.verifyDisplayStatusOfValidProduct();
		  
	}
	
	@When("User enters the invalid product {string}")
	public void user_enters_the_invalid_product(String invalidProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(invalidProductText);
			}

	@Then("User gets warning message")
	public void user_gets_warning_message() {
		searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct());
	}

}
