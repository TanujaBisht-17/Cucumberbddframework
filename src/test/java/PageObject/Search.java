package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefination.Baseclass;

public class Search extends Baseclass{

	WebDriver ldriver;

	public Search(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}	

	@FindBy (id="SearchEmail")
	WebElement emailAdd;

	@FindBy (id="search-customers")
	WebElement searchbtn;

	@FindBy (id="customers-grid")
	WebElement searchResult;

	@FindBy (xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tablerow;

	@FindBy (xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tablecol;

	@FindBy (id="SearchFirstName")
	WebElement firstname;

	@FindBy (id="SearchLastName")
	WebElement Lastname;



	public void  emailaddress(String email) {
		//emailAdd.sendKeys(email);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
	    jsExecutor.executeScript("arguments[0].value = arguments[1];", emailAdd, email);
	}

	public void  Click_Search_Button() {
		clickUsingJs(searchbtn,ldriver); 
	}

	public boolean searchResultByEmail(String email)
	{
		boolean found =false; 

		int row_Size=tablerow.size();
		//int col_Size=tablecol.size();

		for(int i=1;i<=row_Size;i++) //to iterate rows of grid
		{  
			WebElement Email= ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" +i +"]/td[2]"));
			String actual_Email =Email.getText();


			if(actual_Email.equals(email)) 
				found= true;		 		  
		}

		return found;
	}


	public void  firstname(String fname) {
		firstname.sendKeys(fname);  
	}

	public void  Lastname(String Lname) {
		Lastname.sendKeys(Lname);  
	}

	public boolean SearchByname(String name)
	{  
		boolean found =false; 
		int row_Size=tablerow.size();
		//int col_Size=tablecol.size();

		//to iterate rows of grid
		for(int i=1;i<=row_Size;i++) 
		{
			WebElement Name= ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" +i +"]/td[3]"));
			String actual_Name =Name.getText();
			if(actual_Name.equals(name))
			{
				found=true;
				break;
			}	 
		}  
		return found;
	}	

}
