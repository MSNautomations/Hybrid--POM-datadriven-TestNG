package msn.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bsh.BshClassManager.Listener;
import msn.qa.base.TestBase;
import msn.qa.pages.Homepage;
import msn.qa.pages.Login;
import msn.qa.util.CustomListeners;

@Listeners(CustomListeners.class)
public class LoginTest extends TestBase
{
	Login loginpage;
	Homepage homepage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		intiallize();
		loginpage=new Login();
		
	}
	
	@Test
	public void ValidateLogintest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void Loginpagetitletest()
	{
		String title = loginpage.Validatetitle();
		System.out.println(title);
	}
	
	@AfterMethod()
	public void Teardown()
	{
		driver.quit();
		
	}
}
