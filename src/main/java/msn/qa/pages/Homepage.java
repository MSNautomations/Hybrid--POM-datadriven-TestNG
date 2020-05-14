package msn.qa.pages;

import msn.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase
{	
	@FindBy (xpath="//span[contains(text(),'MSN SHK')]")
	WebElement usertitle;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactstablink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasktablink;
	
	@FindBy(name="id")
	WebElement selectcontacts;
	
	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}

	public void Validatecontacts()
	{
		contactstablink.click();
	}
	
	public void Validatetask()
	{
		tasktablink.click();
	}
	
	public String validatehomepagetitle()
	{
		return driver.getTitle();
	}

	
	public String validateusertitle()
	{
		return usertitle.getText();
	}
	
}
