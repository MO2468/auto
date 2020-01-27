package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.ProductDetailsPage;
import com.ap.ui.pages.SearchPage;

public class AddWishListTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;
	
	
	public AddWishListTest() {
		super();
		}

	@BeforeMethod
	public void setUpdriver(){
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		}
	@Test
	public void testAddProductToWishList(){
		String product = "";
		homePage.clickOnSignIn();
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
		//search product
		searchPage = homePage.searchProduct(product);
		String header = searchPage.getHeader();
		
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		//add product to the wish list
		productDetailsPage.clickAddWishListButton();
		productDetailsPage.VerifyAddWishListMsg();
				
			}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
