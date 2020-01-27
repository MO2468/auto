package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;


public class ProductDetailsPage extends TestBase {

	//Lubna
	@FindBy(css="[title=T-shirts]")
	WebElement tshirts;
	
	@FindBy(css="[title='replace-2x img-responsive']")
	WebElement image;
	
	@FindBy(css = "[title='Add to my wishlist]")
	WebElement addToWishListButton;
	///Lubna
	
	@FindBy(id = "quantity_wanted")
	WebElement quantityInput;//
	
	@FindBy(id = "group_1")
	WebElement sizedropdown;//
	
	@FindBy(css = "[name = 'Submit']")
	WebElement AddCart;//AddCartButton
	
	@FindBy(css ="[id = 'wishlist_button']")
	WebElement addWishList;
	
	@FindBy(css = "[class = 'fancybox-error']")
	WebElement addWishListMsg;//
	
	@FindBy(css = "[class = 'fancybox-item fancybox-close']")
	WebElement addWishListMsgCloseButton;//
	
	@FindBy (css = "[title = 'Proceed to checkout']")
	WebElement proceedCheckout;//
	
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	public void VerifyAddWishListMsg(){
		Assert.assertEquals(addWishListMsg, "Added to your wishlist.");
		addWishListMsgCloseButton.click();
	}
	
	public ProductDetailsPage selectProductcolor(String color){
		/*
		 * creating a CSS locator for different color, which will be given in the excel file
		 * when using this method repeatedly, we need return this
		 * if i pass another parameter it should perform the method agian with the different method 
		 */
		String locator = "[name ='"+color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	
	/*public ProductDetailsPage selectQuality(CharSequence[] quantity){
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;//when there will repeatable steps in your script
		
	}*/
	
	public ProductDetailsPage selectQuantity(String quantity){
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;
	}
	
	public ProductDetailsPage selectSize(String size){
		Select select = new Select(sizedropdown);
		select.selectByVisibleText(size);
		return this;
		
	}
	
	public ProductDetailsPage ClickAddCart(){
		AddCart.click();
		return this;
	}
	
	public ProductDetailsPage clickAddWishListButton(){
		addToWishListButton.click();
		return this; //goes back to main class
	}	
	public OrderSummaryPage  proceedCheckout(){
		proceedCheckout.click();
		return new OrderSummaryPage();
		
	}
	
}
