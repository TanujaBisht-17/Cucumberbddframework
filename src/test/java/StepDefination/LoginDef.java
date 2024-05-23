package StepDefination;
import org.testng.Assert;
import org.testng.asserts.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.Add_new_customer;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginDef {

	public WebDriver driver;
	public LoginPage loginpg;
	public Add_new_customer addnew;

	@Given("User Launch chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		this.driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    driver.manage().deleteAllCookies();		
		loginpg=new LoginPage(driver);
		addnew = new Add_new_customer(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
	  driver.get(URL);
	}

	@When("User enters Email {string} and password {string}")
	public void user_enters_email_and_password(String emailadd, String passwrd) {
		loginpg.enterEmail(emailadd);
		loginpg.enterpass(passwrd);

	}

	@When("Click Login button")
	public void click_login_button() {
		loginpg.clicklogin();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) 
		{
			Assert.assertTrue(true);
		}

		else 
		{
			Assert.assertTrue(false);
		}

	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
		loginpg.clicklogout();

	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();

	}
	
	///////Add new customer////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actual_Title=addnew.getpagetitle();
		String expected_Title="Dashboard / nopCommerce administration";
		if(actual_Title.equals(expected_Title)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@When("User clicks customers Menu Item")
	public void user_clicks_customers_menu_item() {
		addnew.click_customer_menu();
	    
	}
	@When("customers menu item")
	public void customers_menu_item() {
		addnew.click_customer();
	    
	}
	@When("User click Add new button")
	public void user_click_add_new_button() {
		addnew.Add_button();
	    
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String Expected="Add a new customer / nopCommerce administration";
		String actual= addnew.getpagetitle();
		if(actual.equals(Expected)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}    
	}
	
	@When("User enter details in Add a new customer")
	public void user_enter_details_in_add_a_new_customer() {
		addnew.Email("test1@gmail.com");
		addnew.Password("test1");
		addnew.First_name("Tanuja");
		addnew.Last_name("Bisht");
		addnew.gender("Female");
		addnew.DOB("4/17/92");
		addnew.Companyname("Qualitest");
		
		
	   
	}
	@When("clicks Save button")
	public void clicks_save_button() {
		addnew.clicksave();
	    
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedmessage) {
		String BodyTag=driver.findElement(By.tagName("Body")).getText();
		if(BodyTag.contains(expectedmessage))
			
		Assert.assertTrue(true);
	else 
		Assert.assertTrue(false);   	 	
    }
}
