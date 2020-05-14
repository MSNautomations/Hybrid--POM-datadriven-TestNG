package msn.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import msn.qa.base.TestBase;
import msn.qa.pages.ContactsPage;
import msn.qa.pages.Homepage;
import msn.qa.pages.Login;
import msn.qa.util.Testutil;

public class ContactspageTest extends TestBase
{
	Login loginpage;
	Homepage homepage;
	ContactsPage contactpage;
	Testutil testutil;
	String sheetName="Login";
	public ContactspageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intiallize();
		loginpage=new Login();
		homepage=new Homepage();
		contactpage=new ContactsPage();
		testutil=new Testutil();
		
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.Validatecontacts();
	}
	
	
	//@Test(priority=1)
	public void ValidatecontactspagetitleTest()
	{
		homepage.Validatecontacts();
		String title=contactpage.Validatecontactspagetitle();
		Assert.assertEquals(title, "Contact");
	}
	
	@Test (priority=5)
	public void SelectcontactTest() throws InterruptedException
	{
		
		homepage.Validatecontacts();
		Actions act=new Actions(driver);
		WebElement target;
		target=driver.findElement(By.xpath("//td[contains(text(),'msn B shk')]/parent::tr//div[@class='ui fitted read-only checkbox']"));
		act.moveToElement(target).click().build().perform();
		//driver.findElement(By.xpath("//td[contains(text(),'msn B shk')]/parent::tr//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	//@Test(priority=2)
	public void ClickOnNewContactTest()
	{
		contactpage.Newcontact();
	}
	
	@DataProvider
	public Object[][] getcontactdata() throws IOException
	{
		Object[][] data=testutil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getcontactdata")
	public void ValidateAddnewContactTest(String fname,String lname, String email) 	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		contactpage.Addnewcontact(fname,lname,email);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
}
