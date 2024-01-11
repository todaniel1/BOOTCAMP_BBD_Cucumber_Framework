package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.learning.DriverLogic.DriverFactory;
import com.bdd.learning.Pages.AccountPage;
import com.bdd.learning.Pages.AddToCartPage;
import com.bdd.learning.Pages.HomePage;
import com.bdd.learning.Pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {

	private WebDriver driver;
	private HomePage homepage;
	private SearchPage searchpage;
	private AddToCartPage addToCartPage;
	
	 @Given("the User opens the application")
	public void the_user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchIcon();
		new AccountPage(driver);
		addToCartPage = new AddToCartPage(driver);
	}

	@When("User enters the valid product 'HP' in the search bar")
	public void user_enters_the_valid_product_hp_in_the_search_bar() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("H");
	}

	@And("User clicks on the Product search button")
	public void User_clicks_on_the_Product_search_button() {
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	}

	@Then("User sees valid product information in the SearchPage")
	public void user_sees_valid_product_information_in_the_search_page() {
		searchpage.verifyDisplayStatusOfValidProduct();
	}

	@When("User clicks on the product 'HP'")
	public void user_clicks_on_the_product_HP() throws Exception {
		driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
		Thread.sleep(2000);
	}

	@When("User clicks on the add to cart button")
	public void user_clicks_on_the_add_to_cart_button_for_hp() {
		addToCartPage.clickAddToCartConfirmation();
	}
	
	@Then("User should see the product added successfully to the cart message")
	   public void productAddedSuccessfullyMassage() {
	    String expectedSuccessMassage = "Success: You have added HP LP3065 to your shopping cart!";
	    String actualsuccessMassage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
	    System.out.println(actualsuccessMassage);
	    Assert.assertTrue(actualsuccessMassage.contains(expectedSuccessMassage));
	
	    //@Then("User should see the product added successfully to the cart message")
	//public void user_should_see_the_product_added_successfully_to_the_cart_message() {
		//homepage = new HomePage(driver);
		//searchpage = homepage.clickOnSearchIcon();
	}

	@And("User should receive a confirmation message")
	public void user_should_receive_a_confirmation_message() {
		searchpage.verifyDisplayStatusOfValidProduct();
	}
	
	}

