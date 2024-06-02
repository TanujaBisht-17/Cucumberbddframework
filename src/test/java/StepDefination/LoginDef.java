package StepDefination;
import org.testng.Assert;
import org.testng.asserts.*;

import PageObject.Add_new_customer;
import PageObject.LoginPage;
import PageObject.Search;
import Utilities.ReadConfig;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginDef extends Baseclass {
	//child of base class

	@Before //executed before start of each scenario
	public void SetUp() 
	{
		readConfig=new ReadConfig();
		log=LogManager.getLogger("LoginDef");
		
		String browser=readConfig.GetBrowser();
		
		switch(browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
			//WebDriverManager.chromedriver().setup();
			this.driver= new ChromeDriver(); 
			break;
			
		case "edge":
			System.out.println("New browser");
			System.out.println("Done");
           //System.setProperty("webdriver.edge.driver", "msedgedriver.exe"); 
			WebDriverManager.edgedriver().setup();
			this.driver=new EdgeDriver();
			break;
			
		case "firefox":
			//System.setProperty("webdriver.chrome.driver", "firefoxdriver.exe"); 
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver(); 
			break;
			
		default:
			driver=null;
			break;
	}

		driver.manage().window().maximize(); 
		log.info("setup1 executed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.manage().deleteAllCookies();	
	}

	//@Before("@Sanity")//if we need only for sanity features
	//public void before1() {
	//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
	//this.driver= new ChromeDriver(); 
	//driver.manage().window().maximize(); 
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	//driver.manage().deleteAllCookies();	
	//}

	//@BeforeStep(order=2)
	//public void beforestep() {
	// System.out.println("This will execute before each step...");
	//}

	//@BeforeStep(order=1) This will execute first
	//public void beforestep() {
	//System.out.println("This will execute before each step...");
	//}

	//@AfterStep
	//public void Afterstep() {
	// System.out.println("This will execute after each step...");
	//}


	@Given("User Launch chrome Browser")
	public void user_launch_chrome_browser() {

		loginpg=new LoginPage(driver);
		addnew = new Add_new_customer(driver);
		searchdata = new Search(driver);
		log.info("Launch chrome browser");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
		driver.get(URL);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("URL opened");
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

	@When("User clicks customers Menu")
	public void user_clicks_customers_menu() {
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
		//addnew.Email("test4@gmail.com");
		addnew.Email(GenerateEmailId()+"@gmail.com");//to avoid add new email id again and again
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

	//////////////////Search data into table/////////////////

	@When("User enters email")
	public void user_enters_email() {
		searchdata.emailaddress("james_pan@nopCommerce.com");

	}
	@When("User clicks search button")
	public void user_clicks_search_button() {
		searchdata.Click_Search_Button();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Then("User found email in search table")
	public void user_found_email_in_search_table() {
		String expectedEmail="james_pan@nopCommerce.com";
		if (searchdata.searchResultByEmail(expectedEmail)==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}			    
	}


	@When("User enters first name")
	public void user_enters_first_name() {
		searchdata.firstname("James");
	}
	@When("User enters Last name")
	public void user_enters_last_name() {
		searchdata.Lastname("Pan");
	}
	@Then("User found name in search table")
	public void user_found_name_in_search_table() {
		String expectedName="James Pan";
		if (searchdata.SearchByname(expectedName)==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}		

	}

	//@After//After completion of each execution
	//public void teardown(Scenario sc) throws IOException {
		//if(sc.isFailed()==true)
		//{		
			//use apache common io (use pom depndency)
			//String File_dest= "C:\\Users\\Tanuja\\Desktop\\Eclipse Folder\\CucumberFramework\\screenshot\\sc1.png";
			//TakesScreenshot scrshot=((TakesScreenshot)driver); 

			//File Src_File =scrshot.getScreenshotAs(OutputType.FILE);		 
			//File dest_sect=new File(File_dest); 
			//FileUtils.copyFile(Src_File, dest_sect);
		//}		
		//driver.quit();
	//}
}
