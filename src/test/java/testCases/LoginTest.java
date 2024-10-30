package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest extends BaseTest{
	private LoginPage loginpage;
	

	
	@Test(priority = 1)
	public void validUsernamePassword() throws InterruptedException, AWTException
	{
		loginpage= new LoginPage(driver);
		loginpage.loginPerform(" Cunex Inc.", "Thenewpasswordiscunex@362");
		Assert.assertEquals(loginpage.SucessfullyMessage(), "Dashboard", "Login fail ");
	}
	
	@Test (priority = 2)
	public void invalidUsernameValidPassword() throws InterruptedException, AWTException
	{	loginpage= new LoginPage(driver);
		loginpage.loginPerform("fgdfdffd", "Thenewpasswordiscunex@362");
		Assert.assertEquals(loginpage.invalidusernameerrorMessageDisplyed(), "Invalid Credentials");
		
	}
		
	@Test(priority = 3)
	
	public void validUsernameinValidPassword() throws InterruptedException, AWTException
	{	loginpage= new LoginPage(driver);
		loginpage.loginPerform("Cunex Inc.", "Thenewpasswor");
		Assert.assertEquals(loginpage.validusernameerrormessge(),"Username or Password incorrect");
		

}
	@Test(priority = 4)
	public void invalidUsernameInvalidPassword() throws InterruptedException, AWTException
	{
		loginpage= new LoginPage(driver);
		loginpage.loginPerform("reyuuyuer", "Thenewpasswor");
		Assert.assertEquals(loginpage.invalidusernameerrorMessageDisplyed(), "Invalid Credentials");
	}
	
	}
	
