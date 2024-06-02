package StepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObject.Add_new_customer;
import PageObject.LoginPage;
import PageObject.Search;
import Utilities.ReadConfig;

import org.apache.logging.log4j.*;

public class Baseclass {
	public static WebDriver driver;
	public LoginPage loginpg;
	public Add_new_customer addnew;
	public Search searchdata;
	public static Logger log;
	public ReadConfig readConfig;
	
//generate unique email id	
public String GenerateEmailId() {
   return(RandomStringUtils.randomAlphabetic(5));
  }

public void  clickUsingJs(WebElement element,WebDriver ldriver ) {
	
	JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
	jsExecutor.executeScript("arguments[0].click();", element);
}


}
