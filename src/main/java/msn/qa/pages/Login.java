package msn.qa.pages;

import msn.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends TestBase {
	
	
	@FindBy (name="email1")
	WebElement username;
	
	@FindBy (name="password1")
	WebElement password;
	
	@FindBy (xpath="//div[contains(text(),'Login')]")
	WebElement signin;
	
	public Login()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Homepage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		signin.click();
		return new Homepage();
	}
	
	

	public String Validatetitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
}
