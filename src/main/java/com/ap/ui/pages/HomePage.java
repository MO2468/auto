package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(css = "[class='login']")
	WebElement signInButton;
	
	@FindBy(id = "contact-link")
	WebElement ContactLink;
	
	@FindBy(id = "search_query_top")
	WebElement SearchInputbox;
	
	@FindBy(css = "[name ='submit_search']")
	WebElement SubmitSearch;
	
	@FindBy(css = "[class= 'logout']")
	WebElement LogOutButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public SearchPage searchProduct(String productName){
	
		SearchInputbox.sendKeys(productName);
		SubmitSearch.click();
		return new SearchPage();
	}
	public void clickOnSignIn() {
		signInButton.click();
	}
	public void clickOnContactLink() {
		ContactLink.click();
	}
	public void logOut() {
		LogOutButton.click();
	}
	
}
