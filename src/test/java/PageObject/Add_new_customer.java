package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_new_customer {
	
	 WebDriver ldriver;
	 
public Add_new_customer(WebDriver rdriver) {
	ldriver=rdriver;
	
PageFactory.initElements(rdriver, this);
	
}

@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
WebElement customer_menu;

@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
WebElement customer;

@FindBy(xpath="//a[@class='btn btn-primary']")
WebElement Addbtn;

@FindBy(id="Email")
WebElement Email;

@FindBy(id="Password")
WebElement Password;

@FindBy(id="FirstName")
WebElement FirstName;
	
@FindBy(id="LastName")
WebElement LastName;

@FindBy(id = "Gender_Male")
WebElement Male;

@FindBy(id = "Gender_Female")
WebElement Female;

@FindBy(xpath="//input[@id='DateOfBirth']")
WebElement DOB;

@FindBy(id="Company")
WebElement Company;

@FindBy(id="IsTaxExempt")
WebElement TaxExempt;

@FindBy(xpath="(//input[@type=\"search\"])[1]")
WebElement Newsletter;

@FindBy(xpath="(//input[@type=\"search\"])[2]")
WebElement customer_roles;

@FindBy(xpath="//select[@name='VendorId']")
WebElement Vendor;

@FindBy(xpath="//input[@id='Active']")
WebElement active;

@FindBy(xpath="//textarea[@id='AdminComment']")
WebElement comment;

@FindBy(xpath="//button[@name='save']")
WebElement save;


//functions for elements//

public String getpagetitle() {
	return ldriver.getTitle();
	
}

public void click_customer_menu()
{  
	customer_menu.click();
}

public void click_customer()
{  
	customer.click();
}

public void Add_button()
{  
	Addbtn.click();
}

public void Email(String email_address)
{  
	Email.sendKeys(email_address);
}


public void Password(String Pwd)
{  
	Password.sendKeys(Pwd);
}


public void First_name(String First_name)
{  
	FirstName.sendKeys(First_name);
}

public void Last_name(String Last_name)
{  
	LastName.sendKeys(Last_name);
}

public void gender(String gender)
{  
	if(gender.equals("Male"))
		Male.click();
	else if(gender.equals(Female))
		Female.click();
	else
		Male.click();
}


public void DOB(String DB)
{  
	DOB.sendKeys(DB);
}

public void Companyname(String company)
{  
	Company.sendKeys(company);
}


public void clicksave()
{  
	save.click();
}



}
