package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest extends BaseTest{
	

	
	@Test(priority = 1)
	public void validUsernamePassword() throws InterruptedException, AWTException
	{
		LoginPage lp= new LoginPage(driver);
		lp.loginPerform(" Cunex Inc.", "Thenewpasswordiscunex@362");
		Assert.assertEquals(lp.SucessfullyMessage(), "Dashboard", "Login fail ");
	}
	
	@Test (priority = 2)
	public void invalidUsernameValidPassword() throws InterruptedException, AWTException
	{		LoginPage lp= new LoginPage(driver);
		lp.loginPerform("fgdfdffd", "Thenewpasswordiscunex@362");
		Assert.assertEquals(lp.invalidusernameerrorMessageDisplyed(), "Invalid Credentials");
		
	}
		
	@Test(priority = 3)
	
	public void validUsernameinValidPassword() throws InterruptedException, AWTException
	{		LoginPage lp= new LoginPage(driver);
		lp.loginPerform("Cunex Inc.", "Thenewpasswor");
		Assert.assertEquals(lp.validusernameerrormessge(),"Username or Password incorrect");
		

}
	@Test(priority = 4)
	public void invalidUsernameInvalidPassword() throws InterruptedException, AWTException
	{
		LoginPage lp= new LoginPage(driver);
		lp.loginPerform("reyuuyuer", "Thenewpasswor");
		Assert.assertEquals(lp.invalidusernameerrorMessageDisplyed(), "Invalid Credentials");
	}
	
	}
	
