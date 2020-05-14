package msn.qa.pages;

import msn.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase
{
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newcontactbutton;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailaddress;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement Savecontact;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactstablink;
	
	@FindBy(xpath="//div/div/div[@class='ui header item mb5 light-black']")
	WebElement Contactpagetitle;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
		
	public void Newcontact()
	{
		newcontactbutton.click();
	}
	
	public void Addnewcontact(String fname, String lname, String email)
	{
		newcontactbutton.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		emailaddress.sendKeys(email);
		Savecontact.click();
	}

	public String Validatecontactspagetitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
}
