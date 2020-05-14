package msn.qa.testcases;

import msn.qa.base.TestBase;
import msn.qa.pages.Homepage;
import msn.qa.pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageTest extends TestBase
{
	Homepage homepage;
	Login loginpage;
	
	public HomepageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intiallize();
		homepage=new Homepage();
		loginpage=new Login();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	public void ValidatehomepagetitleTest()
	{
		String title=homepage.validatehomepagetitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test (priority=1)
	public void Validatehomepagetest()
	{
		String title=homepage.validateusertitle();
		System.out.println(title);
	}
	
	@Test (priority=2)
	public void ValidatecontactslinkTest()
	{
		homepage.Validatecontacts();
	}
	
	@Test (priority=3)
	public void ValidateTasklinkTest()
	{
		homepage.Validatetask();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
