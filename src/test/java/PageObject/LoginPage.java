package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;


	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id= "Email")
	WebElement email;

	@FindBy (id="Password")
	WebElement password;

	@FindBy (xpath="//button[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy (linkText="Logout")
	WebElement LogoutBtn;

	public void enterEmail(String email_address)
	{  
		email.clear();
		email.sendKeys(email_address);
	}

	public void enterpass(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clicklogin() 
	{
		LoginBtn.click();
	}
	
	public void clicklogout() 
	{
		LogoutBtn.click();
	}

}
