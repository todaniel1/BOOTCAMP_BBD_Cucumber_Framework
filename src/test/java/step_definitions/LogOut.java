package step_definitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.bdd.learning.DriverLogic.DriverFactory;
import com.bdd.learning.Pages.AccountPage;
import com.bdd.learning.Pages.HomePage;
import com.bdd.learning.Pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOut {
    private WebDriver driver;
    private HomePage homepage;
    private LoginPage loginpage;
    private AccountPage accountpage;
    private Properties dataprop;

    @Given("I am logged into the TutorialsNinja website with email {string} and password {string}")
    public void i_am_logged_into_the_tutorialsninja_website_with_email_and_password(String validEmail,
                                                                                     String validPassword) {
        // Logic to ensure the user is logged in
        driver = DriverFactory.getDriver();
        homepage = new HomePage(driver);
        homepage.clickOnMyAccount();
        homepage.selectLoginOption();
        loginpage = new LoginPage(driver);
        loginpage.enterEmail(validEmail);
        loginpage.enterPassword(validPassword);
        loginpage.clickOnLoginButton();
        accountpage = new AccountPage(driver);
        accountpage.validateDisplayStatusOfEditAccountInfoLink();
    }

    @When("I click on the logout option")
    public void i_click_on_the_logout_option() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @Then("I should be logged out of the system")
    public void i_should_be_logged_out_of_the_system() {
    	 
    	WebElement accountLogoutElement = driver.findElement(By.xpath("//h1[normalize-space()='Account Logout']"));
          Assert.assertTrue(accountLogoutElement.isDisplayed(), "Account Logout text is not displayed");
      }

     }



