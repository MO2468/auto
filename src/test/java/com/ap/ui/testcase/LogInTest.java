package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class LogInTest extends TestBase{

	LoginPage loginPage;//object of the class i'm working on, to interact with the page, 
	//instead of calling the class every time
	HomePage homePage;
	
	public LogInTest() {
		super();
		//make connection and get the object from the parent class
	}
	
	@BeforeMethod 
	public void setUpdriver() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		
	}
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginPage.verifypageTitle();
		Assert.assertEquals(title, "My Store");
	}
	@Test(priority = 2)
	public void apLogoTest() {
		boolean value = loginPage.validateAPImage();
		Assert.assertTrue(value);
	}
	@Test(priority = 3)
	public void logInTest() {
		homePage.clickOnSignIn();
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}