package step_definitions;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.bdd.learning.DriverLogic.DriverFactory;
import com.bdd.learning.Pages.AccountPage;
import com.bdd.learning.Pages.HomePage;
import com.bdd.learning.Pages.LoginPage;
import com.tutorialsninja.bdd.qa.Utilities.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public Properties dataprop;

	@Given("^User ([a-zA-Z]{1,}) to LoginPage$")
	public void user_navigates_to_loginpage(String navigationMode) {
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption(); 
		
	}

	@When("^User enters valid email (.+) into email textbox field$")
	public void user_enters_valid_email_into_email_textbox_field(String validEmailText) {
		loginpage.enterEmail(validEmailText);
	
	}

	@And("^User enters valid password (.+) into password textbox field$")
	public void user_enters_valid_password_into_password_textbox_field(String validPasswordText) {
		loginpage.enterPassword(validPasswordText);
		
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	
		accountpage = loginpage.clickOnLoginButton();
		}

	@Then("User is navigated to AccountPage")
	public void user_is_navigated_to_accountpage() {
		accountpage.validateDisplayStatusOfEditAccountInfoLink();
		
	}

	@When("User enters invalid email into email textbox field")
	public void user_enters_invalid_email_into_email_textbox_field() {
		loginpage.enterEmail(Util.emailWithDateTimeStamp());
	
	}

	@And("User enters invalid password {string} into password textbox field")
	public void user_enters_invalid_password_into_password_textbox_field(String invalidPasswordText) {
		loginpage.enterPassword(invalidPasswordText);
	
	}

	@Then("User gets warning message about credentials mismatch")
	public void user_gets_warning_message_about_credentials_mismatch() {
	
		String actualWarningMessage = loginpage.retrieveCredentialsMismatchWarningMessage();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
	
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}
	
}
